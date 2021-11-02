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
			//�n�J���\
			//�x�s�Τ�T��
			session.setAttribute("user", username);
			session.setAttribute("game", username);
			//���w�V��success.jsp
			response.sendRedirect(request.getContextPath() + "/success.jsp");
		}else {
			//�n�J����
			//�x�s���ܰT����request
			request.setAttribute("login_error", "�z���Τ�W�αK�X��J���~,�ЦA�դ@��!!");
			//��k��n�J����
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
