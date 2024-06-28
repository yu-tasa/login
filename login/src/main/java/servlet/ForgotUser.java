package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.NewUserLogic;
import model.UserRegister;

/**
 * Servlet implementation class ForgotUser
 */
@WebServlet("/ForgotUser")
public class ForgotUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/forgotUser.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");

		//新規登録できるのかの確認
		UserRegister ur = new UserRegister(userId, pass, name);
		NewUserLogic nul = new NewUserLogic();
		boolean result = nul.execute(ur);

		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		session.setAttribute("pass", pass);
		session.setAttribute("name", name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/newUserConfirm.jsp");
		dispatcher.forward(request, response);
	}

}
