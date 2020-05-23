package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Annuaire;
import com.models.Restaurant;

/**
 * Servlet qui gere l'ajout d'un resto
 */
public class ServletAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String message;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjouter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", message);
		message="";
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		String specialite= request.getParameter("specialite");
		try {
			Annuaire.getInstance().addResto(new Restaurant(nom, adresse, specialite));
			message = " Succes : le resto est ajouté !";
		} catch (IllegalArgumentException e) {
			message = e.getMessage();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajouter.jsp").forward(request, response);
	}

}
