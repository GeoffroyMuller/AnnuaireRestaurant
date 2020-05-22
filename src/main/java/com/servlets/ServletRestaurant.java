package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Annuaire;
import com.models.Plat;
import com.models.Restaurant;

/**
 * Servlet implementation class ServletRestaurant
 */
public class ServletRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRestaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Restaurant resto = Annuaire.getInstance().getRestoById(Integer.parseInt(id));
		request.setAttribute("resto", resto);
		request.setAttribute("liste_plat", resto.getListeDePlats());
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/restaurant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if(request.getParameter("supprimer") != null) {
			int id_plat = Integer.parseInt(request.getParameter("supprimer"));
			Annuaire.getInstance().getRestoById(id).delPlatId(id_plat);
		}
		if(request.getParameter("ajouter") != null) {
			if(!request.getParameter("prix").isEmpty()) {
				String nom = request.getParameter("nom");
				String type = request.getParameter("type");

				double prix = Double.parseDouble(request.getParameter("prix"));
				String description= request.getParameter("description");
				Annuaire.getInstance().getRestoById(id).addPlat(new Plat(id, nom, prix, type, description));
			}
		}
		String urlRed = "/AnnuaireRestaurant/restaurant?id="+id;
		response.sendRedirect(urlRed);
		return;

	}

}
