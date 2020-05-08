package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

//p540
//Controller역할을 하는  Servlet파일이 하는 일은
//요청을 분석하는 일이다
//이 클래스에서는  요청을 분석하여 담당 컨트롤러파일로 연결시켜주는 일을 한다
//요청의 내용은  http://ip주소:포트번호/컨텍스트패스/~~?cmd=요청내용&~~~ 에서
//cmd파라미터의 값을 받아와야 한다

/*참고 p529 
	이렇게 읽어들인 cmd파라미터의 값에 따라 각 명령어에 해당하는 클래스를 호출하게 된다.
	=>이 때 각 명령어에 해당하는 로직처리코드를 별도 클래스로 작성하는 패턴을 
	command pattern이라고 한다 */
public class ControllerUsingURI extends HttpServlet {

    // <커맨드, 핸들러인스턴스> 매핑 정보 저장
    private Map<String, CommandHandler> commandHandlerMap = 
    		new HashMap<>();

    //최초 요청시 단 한번만 호출되는 함수로서
    //공통적인 값 설정시에 사용된다
    public void init() throws ServletException {
    	//configFile 초기화 파라미터의 값을 읽어온다
        String configFile = getInitParameter("configFile");
        
        //map방식으로 처리되는 자바의 Properties클래스를 이용
        Properties prop = new Properties();
        
        //설정파일이 어디있는지 경로를 구한다
        String configFilePath = getServletContext().getRealPath(configFile);
        
        //설정파일로부터 매핑정보를 읽어와 Properties객체에 저장한다
        try (FileReader fis = new FileReader(configFilePath)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        }
        
        //Properties에 저장된 각 프로퍼터의 키값에 대해 반복적인 작업을 수행
        Iterator keyIter = prop.keySet().iterator();
        while (keyIter.hasNext()) {
        	//1.command변수에  command이름으로 프로퍼티명을 저장한다 
            String command = (String) keyIter.next();
            //2.위에서구한 command변수에 저장된 프로퍼티명을 이용하여
            //Properties에서 값을 가져와  handlerClassName변수에 저장한다
            String handlerClassName = prop.getProperty(command);
            try {
            	//handlerClassName변수에 저장된 값을  실제클래스파일에서 찾는다
                Class<?> handlerClass = Class.forName(handlerClassName);
                //찾은 클래스파일이 동작할 수 있도록 객체를 생성한다
                CommandHandler handlerInstance = 
                        (CommandHandler) handlerClass.newInstance();
                //생성한 객체를 commandHandlerMap에 누적시킨다
                //map에 데이터를 추가할 때는
                //맵.put(키값,value)
                //여기에서는  맵.put(클라이언트의요청내용, 핸들러클래스명)
                commandHandlerMap.put(command, handlerInstance);
            } catch (ClassNotFoundException | InstantiationException 
            		| IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    //get방식 요청시 호출되는 서비스함수
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    //Post방식 요청시 호출되는 서비스함수
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    	
    	//클라이언트가 요청한 명령어를 구한다
    	//request.getRequestURI()를 이용하여 전체URI를 구하고
		String command = request.getRequestURI();
		//전체URI에서 ContextPath를 제거한다
		if (command.indexOf(request.getContextPath()) == 0) {
			//순수한 요청URI만을 가져와
			//스트링.substring(시작idx,끝idx):대상문자열에서 시작인덱스부터 끝인덱스-1
			//"abcdef".substring(0,3)=>a,b,c
			command = command.substring(request.getContextPath().length());
		}
		
		//commandHandlerMap에서  해당키값에 따른
		//담당 컨트롤러파일을 가져와 handler변수에 저장한다
        CommandHandler handler = commandHandlerMap.get(command);
        
        if (handler == null) {//담당handler가 없는 경우
            handler = new NullHandler(); //
        }
        
        //담당handler가 있는 경우에는 
        String viewPage = null;
        try {//담당handler의 process()함수를 호출하고
        	//process()가 리턴해주는  String타입의 viewPage를 받는다
        	//viewPage변수에 저장된 문자열이
        	//user에게 보여지는 view가 되어진다
            viewPage = handler.process(request, response);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        
        //view페이지로 forwading하기
        if (viewPage != null) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
        }
    }
}




