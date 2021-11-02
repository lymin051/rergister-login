package tw.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.login.dao.LoginDao;
import tw.login.model.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LoginDao loginDao = new LoginDao();
   
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		HttpSession session = request.getSession();
		
		if(loginDao.login(username , password)) {
			//登入成功
			//儲存用戶訊息
			session.setAttribute("user", username);
			session.setAttribute("game", username);
			//重定向到success.jsp
			response.sendRedirect(request.getContextPath() + "/success.jsp");
		}else {
			//登入失敗
			//儲存提示訊息到request
			request.setAttribute("login_error", "您的用戶名或密碼輸入錯誤,請再試一次!!");
			//轉法到登入頁面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
