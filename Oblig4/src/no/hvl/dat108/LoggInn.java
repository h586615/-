package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objekt.Deltager;
import objekt.DeltagerDAO;

/**
 * Servlet implementation class LoggInn
 */
@WebServlet("/Logginn")
public class LoggInn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getParameter("feilmelding");

		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);

		String bruker = request.getParameter("mobil");
		if (deltagerDAO.hentBruker(bruker) != null) {
			sesjon.setAttribute("deltager", deltagerDAO.hentBruker(bruker));
		}

		response.sendRedirect("Deltagerliste");

	}

}
