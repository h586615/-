package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import objekt.Passord;
import objekt.Deltager;
import objekt.DeltagerDAO;

//import static no.hvl.dat108.URLMappings.*;

/**
 * Servlet implementation class PaameldingsSkjema
 */

@WebServlet("/Paameldingskjema")
public class PaameldingsSkjema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String nyttPassord = request.getParameter("passord");
		String kjonn = request.getParameter("kjonn");
		Passord hashetPassord = Passord.lagPassord("nyttPassord");
		Deltager nyDeltaker = new Deltager(fornavn, etternavn, mobil, kjonn, hashetPassord);

		if (deltagerDAO.hentBruker(mobil) == null) {
			deltagerDAO.lagreNyBruker(nyDeltaker);

			request.setAttribute("fornavn", fornavn);
			request.setAttribute("etternavn", etternavn);
			request.setAttribute("mobil", mobil);
			request.setAttribute("kjonn", kjonn);

			HttpSession sesjon = request.getSession(false);

			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession();
			sesjon.setMaxInactiveInterval(60);
		}
		request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
	}

}
