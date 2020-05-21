package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.QnaRequest;
import model.Qnamodel;

public class QnamanageupdateController implements CommandHandler {

	private static final String FORM_VIEW = "/view/cs/qna/manageqnaupdate.jsp";
	
	private QnaManageUpdateService qnamanageaction = new QnaManageUpdateService();
	
	private QnaDetailService qnadetailservice = new QnaDetailService();
	@Override
	public String process(HttpServletRequest request, 
						  HttpServletResponse response) throws Exception {
		System.out.println("qnamanageupdatecontroller진입성공");
		
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

		//POST방식으로 요청이 들어오면  답변 등록을 진행
		private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("qnaManageupdateController의 processSubmit()호출");
			
			//1.요청파라미터 받기
			int sn= Integer.parseInt(request.getParameter("no")); 
			String answer=request.getParameter("answer");
			System.out.println("답변 sn+ answer= "+sn+"/"+answer);
			
			//2.비즈니스로직(<->Service<->DAO<->DB)
			QnaRequest qnareqa = 
					new QnaRequest(sn,answer);
			//3.Model
			request.setAttribute("qnareqa ", qnareqa );
			
			//4.View
			qnamanageaction.updateAnswer(qnareqa);
			return  "qnalist.do";		
		}

		//GET방식 폼 보여주기
		private String processForm(HttpServletRequest request, 
				HttpServletResponse response) throws IOException {
			int sn= Integer.parseInt(request.getParameter("no")); 
			
			Qnamodel qm = qnadetailservice.getQna(sn, false);
			request.setAttribute("qm",qm);
			
			return FORM_VIEW;
		}

}
