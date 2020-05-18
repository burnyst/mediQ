package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandHandler;

//p.622
//비밀번호변경 요청에 따라 자도응로 호출되는 컨트롤러
public class ChangePasswordController implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

}
