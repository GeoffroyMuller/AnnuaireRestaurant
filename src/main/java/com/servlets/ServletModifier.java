package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Annuaire;
import com.models.Restaurant;

/**
 * Servlet implementation class ServletModifier
 */
public class ServletModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModifier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String red = request.getParameter("red");
		Restaurant resto = Annuaire.getInstance().getRestoById(Integer.parseInt(id));
		request.setAttribute("resto", resto);
		request.setAttribute("red", red);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		String specialite= request.getParameter("specialite");
		Annuaire.getInstance().modifResto(new Restaurant(Integer.parseInt(id), nom, adresse, specialite));
		//this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifier.jsp").forward(request, response);

		String urlRed="/AnnuaireRestaurant/annuaire";
		if (request.getParameter("red") != null) {
			if (request.getParameter("red").equals("restaurant")) {
				urlRed = "/AnnuaireRestaurant/restaurant?id="+id;
			}
		}
		response.sendRedirect(urlRed);
		return;
	}

}
