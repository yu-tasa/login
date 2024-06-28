package servlet;

import java.io.IOException;

import dao.AccountsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);  		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		//ログイン処理の実行
		Login login = new Login(userId, pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		AccountsDAO aDao = new AccountsDAO();
		
		//ログイン処理の成否によって処理を分岐
		if(result) {	//ログイン成功時
			String name = aDao.findByLogin(login).getName();
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);
		}else {
			//リダイレクト
			 //response.sendRedirect("LoginServlet");
			 request.setAttribute("errorMessage", "ユーザー名またはパスワードが正しく入力されていません");
	         request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}
		
		
	}

}
