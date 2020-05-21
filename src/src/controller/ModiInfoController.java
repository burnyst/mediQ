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
	
		@Override
		public String process(HttpServletRequest request,HttpServletResponse response) throws Exception {
			System.out.println("ModiInfoController진입성공");

			//GET방식으로  요청이 들어오면
			if(request.getMethod().equalsIgnoreCase("GET")) {
				System.out.println("ModiInfoController의 method방식="+request.getMethod());
				return processForm(request,response);
			}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
				System.out.println("ModiInfoController의 method방식="+request.getMethod());
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
			
			System.out.println("processSubmit sn="+itemName);
			
			//	HttpSession session = request.getSession();
			//User user = (User)session.getAttribute("AUTHUSER");
			
			
			InfoModel im = new InfoModel(itemSeq,itemName,entpName,itemPermitDate,nbDocData,
					cancelDate,eeDocData,etcOtcCode,udDocData,changeDate,
					classNo,chart,packUnit);
			System.out.println("updateREq="+im);
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
			modiService.modify(im);
			System.out.println("im="+im);//Service와 맞추어 주어야함
			request.setAttribute("updateReq", im);
			System.out.println("im2="+im);
			return "infolist.do";

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
		 
			
			
			
			

			InfoModel infomodel = modiService.modiSelect(itemName);
			
			System.out.println("infomodel="+infomodel);
			
		
			InfoModel im = new InfoModel(
					infomodel.getItemSeq(),infomodel.getItemName(),infomodel.getEntpName(),infomodel.getItemPermitDate(),infomodel.getNbDocData(),
					infomodel.getCancelDate(),infomodel.getEeDocData(),infomodel.getEtcOtcCode(),infomodel.getUdDocData(),infomodel.getChangeDate(),
					infomodel.getClassNo(),infomodel.getChart(),infomodel.getPackUnit());
			
			
			System.out.println("im2="+im);
			
			request.setAttribute("updateReq",infomodel);
	
			return FORM_VIEW;

			
		
		}
}