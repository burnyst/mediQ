package controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Faq;
import model.InfoModel;
import model.ModiRequest;

public class ModiInfoController implements CommandHandler {


	//View지정
	private static final String FORM_VIEW = "/view/product/modiinfo.jsp";
	
	private	ModiInfoService modiService = new ModiInfoService();
	private	InfodetailService readService = new InfodetailService();
	
		@Override
		public String process(HttpServletRequest request,HttpServletResponse response) throws Exception {
			System.out.println("ModiInfoController진입성공");

			//GET방식으로  요청이 들어오면
			if(request.getMethod().equalsIgnoreCase("GET")) {
				System.out.println("FaqUpdate의 method방식="+request.getMethod());
				return processForm(request,response);
			}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
				System.out.println("FaqUpdate의 method방식="+request.getMethod());
				return processSubmit(request,response);
			}else {
				//405에러
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
				return   null;
			}
		}
		
		//GET방식으로  요청이 들어오면  폼을 보여주기

		
		//POST방식으로 요청이 들어오면  등록을 진행
		private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("ModiInfocontroller의 processSubmit()호출");
			

			//할일
			//1.요청파라미터 받기
			String itemSeq = request.getParameter("itemSeq");
			String itemName = request.getParameter("itemName");
			String entpName = request.getParameter("entpName");
			String itemPermitDate = request.getParameter("itemPermitDate");
			String nbDocData = request.getParameter("nbDocData");
			String cancelDate = request.getParameter("cancelDate");
			String eeDocData = request.getParameter("eeDocData");
			String etcOtcCode = request.getParameter("etcOtcCode");
			String udDocData = request.getParameter("udDocData");
			String changeDate = request.getParameter("changeDate");
			String classNo = request.getParameter("classNo");
			String chart = request.getParameter("chart");
			String packUnit = request.getParameter("packUnit");
			
			//	HttpSession session = request.getSession();
			//User user = (User)session.getAttribute("AUTHUSER");
			ModiRequest updateReq = new ModiRequest(
					itemSeq,itemName,entpName,itemPermitDate,nbDocData,
					cancelDate,eeDocData,etcOtcCode,udDocData,changeDate,
					classNo,chart,packUnit);
			
			//HttpSession session = request.getSession();

			
		
			//에러가 존재하면 수정폼으로 이동	
			
			
			//2.비즈니스로직(<->Service<->DAO<->DB)
			
			Map<String,Boolean>errors = new HashMap<>();
			request.setAttribute("errors",errors);
			if(!errors.isEmpty()) {
			return FORM_VIEW;
			}
			
			
			//P670 84
			//★db에 insert성공시의  해당글번호가 isq에 리턴 //나의 데이터 필드명은 item_Seq이다.

			request.setAttribute("updateReq", updateReq);
		
			try {
				modiService.update(updateReq);
				return "/infolist.do";
			}catch(FaqNotFoundException e) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}catch(PermissionDeniedException e) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			
	
	}
		

		private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException{
			System.out.println("InfoUpdateController-수정처리processForm()");
			//파라미터받기
			String itemSeq = request.getParameter("itemSeq");
			String itemName = request.getParameter("itemName");
			String entpName = request.getParameter("entpName");
			String itemPermitDate = request.getParameter("itemPermitDate");
			String nbDocData = request.getParameter("nbDocData");
			String cancelDate = request.getParameter("cancelDate");
			String eeDocData = request.getParameter("eeDocData");
			String etcOtcCode = request.getParameter("etcOtcCode");
			String udDocData = request.getParameter("udDocData");
			String changeDate = request.getParameter("changeDate");
			String classNo = request.getParameter("classNo");
			String chart = request.getParameter("chart");
			String packUnit = request.getParameter("packUnit");
			
			System.out.println("process form sn=");

			/* InfoModel infomodel = readService.getInfo(); */
			
			ModiRequest updateReq = new ModiRequest(
					itemSeq,itemName,entpName,itemPermitDate,nbDocData,
					cancelDate,eeDocData,etcOtcCode,udDocData,changeDate,
					classNo,chart,packUnit);
			
			request.setAttribute("updateReq",updateReq);
			return FORM_VIEW;

			
		
		}
}