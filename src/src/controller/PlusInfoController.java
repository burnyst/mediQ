package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InfoRequest;

public class PlusInfoController implements CommandHandler{

	private static final String FORM_VIEW = "/view/product/Plusinfo.jsp";
	private PlusInfoService plusService = new PlusInfoService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("controller진입성공");

		//GET방식으로  요청이 들어오면
		if(req.getMethod().equalsIgnoreCase("GET")) { 		
			return processForm(req,res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			return processSubmit(req,res);
		}else { 
			//405에러
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("PlusInfocontroller의 processSubmit()호출");
		
		Map<String,Boolean>errors = new HashMap<>();
		req.setAttribute("errors",errors);
		//할일
		String itemSeq = req.getParameter("ITEM_SEQ");
		String entpName = req.getParameter("ENTP_NAME");
		String itemName = req.getParameter("ITEM_NAME");
		String itemPermitDate = req.getParameter("ITEM_PERMIT_DATE");
		String nbDocData = req.getParameter("NB_DOC_DATA");
		String cancelDate = req.getParameter("CANCEL_DATE");
		String eeDocData = req.getParameter("EE_DOC_DATA");
		String etcOtcCode = req.getParameter("ETC_OTC_CODE");
		String udDocData = req.getParameter("UD_DOC_DATA");
		String changeDate = req.getParameter("CHANGE_DATE");
		String classNo = req.getParameter("CLASS_NO");
		String chart = req.getParameter("CHART");
		String packUnit = req.getParameter("PACK_UNIT");
		

		InfoRequest plusReq = PlusRequest(itemSeq,entpName,itemName,itemPermitDate,
				nbDocData,cancelDate,eeDocData,etcOtcCode,udDocData,changeDate,classNo,chart
				,packUnit);
		
		
	if(!errors.isEmpty()) {
		return FORM_VIEW;
	}
	
	String plusitemname = plusService.plus(plusReq);
	req.setAttribute("plusitemname", plusitemname); //세션값 : plusitemname
	
	return "infolist.do";
}

	private model.InfoRequest PlusRequest(String itemSeq, String itemName, String entpName, String itemPermitDate,
			String nbDocData, String cancelDate, String eeDocData, String etcOtcCode, String udDocData,
			String changeDate, String classNo, String chart, String packUnit) {
		
		return new InfoRequest(itemSeq,itemName,entpName,itemPermitDate,nbDocData,
				cancelDate,eeDocData,etcOtcCode,udDocData,changeDate,classNo,chart,packUnit);
	}

		
	}
