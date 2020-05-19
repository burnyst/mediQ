package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import model.QnaRequest;
import model.Qnamodel;

public class QnaupdateController implements CommandHandler {

	//View지정
	private static final String FORM_VIEW = "/view/cs/qna/qnaupdate.jsp";
	private QnaUpdateService qnaaction = new QnaUpdateService();
	
	@Override
	public String process(HttpServletRequest request, 
						  HttpServletResponse response) throws Exception {
		System.out.println("qnaupdatecontroller진입성공");

		//GET방식으로  요청이 들어오면
		if(request.getMethod().equalsIgnoreCase("GET")) { 		
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
	}
	
	//GET방식으로  요청이 들어오면  폼을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("qnaupdatecontroller의 processForm()호출");
		return FORM_VIEW ;
	}
	
	
	//POST방식으로 요청이 들어오면  질문 등록을 진행
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("qnaupdatecontroller의 processSubmit()호출");
		
		Map<String,Boolean>errors = new HashMap<>();
		request.setAttribute("errors",errors);
		//할일
		// 파일 업로드를 하기 위해서 cos.jar 추가 및 객체 생성
        MultipartRequest multi = null;
        // 업로드 될 파일의 최대 사이즈 (10메가)
        int sizeLimit = 10 * 1024 * 1024;
 
        // 파일이 업로드될 실제 tomcat 폴더의 경로 (WebContent 기준)
        @SuppressWarnings("deprecation")
		String savePath = request.getSession().getServletContext().getRealPath("/upload");

        // 
        try{
            multi=new MultipartRequest(
                    request
                    , savePath
                    , sizeLimit
                    , "UTF-8"
                    , new DefaultFileRenamePolicy()); 
 
         }catch (Exception e) {
                e.printStackTrace();
         } 
         
        //파일 이름 저장
        String image= multi.getFilesystemName("image");

		//1.요청파라미터 받기
		String title = multi.getParameter("title");
		String category = multi.getParameter("category");
		int qpublic =(Integer.parseInt(multi.getParameter("qpublic")));
		String question=multi.getParameter("question");

		//	HttpSession session = request.getSession();
		//User user = (User)session.getAttribute("AUTHUSER");
		
		//2.비즈니스로직(<->Service<->DAO<->DB)
		//글등록
		QnaRequest qnaReq = createQnaRequest(title,category,qpublic,question,image);
		qnaReq.validate(errors);
		
		//유효성검사를 불통하여 글등록폼으로 이동
				if( !errors.isEmpty() ) {
					return FORM_VIEW;
				}
		//★db에 insert성공시의  해당글번호가 newSn에 리턴 //나의 데이터 필드명은 sn이다.
		int newSn = 
				qnaaction.update(qnaReq); 
		//3.Model(Request, session)
				request.setAttribute("newSn", newSn);
		//4.View
		  return "qnalist.do";
}

	private QnaRequest createQnaRequest(String title, String category, int qpublic, String question,String image) {
		return new QnaRequest(title,category,qpublic,question,image);

	}
	}
