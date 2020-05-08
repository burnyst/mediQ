package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이 인터페이스는 Handler클래스에 공통적으로 선언해야하는 함수명을 정의하였다.
public interface CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
}
