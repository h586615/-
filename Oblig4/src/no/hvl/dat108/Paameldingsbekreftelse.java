package no.hvl.dat108;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objekt.Deltager;
import objekt.DeltagerDAO;

/**
 * Servlet implementation class Paameldingsbekrefelse
 */
@WebServlet("/Paameldingsbekreftelse")
public class Paameldingsbekreftelse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// if (request.getSession(false) == null ||
		// request.getSession(false).getAttribute("deltager") == null) {
		// response.sendRedirect("paamelding");
		// } else {
		if (request.getSession(false) == null) {
			response.sendRedirect("Paamelding");
		}
		request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
	}

}
