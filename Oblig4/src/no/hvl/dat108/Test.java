package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objekt.Deltager;
import objekt.DeltagerDAO;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DeltagerDAO deltagerDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Deltager> deltagere = deltagerDAO.hentAlleDeltagere();
		
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		
		deltagere.forEach(out::println);
	}


}
