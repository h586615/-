package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objekt.Deltager;
import objekt.DeltagerDAO;

/**
 * Servlet implementation class DeltagerListe
 */
@WebServlet("/Deltagerliste")
public class DeltagerListe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sessionMobil = "98674553";

		HttpSession sesjon = request.getSession(false);
		Deltager deltager = (Deltager) sesjon.getAttribute("deltager");

		if (sessionMobil != null) {

			List<Deltager> deltagere = deltagerDAO.hentAlleDeltagere();

			deltagere.sort(Comparator.comparing(Deltager::getFornavn));

			request.getSession().setAttribute("deltagerliste", deltagere);
			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Deltagerliste");

	}

}
