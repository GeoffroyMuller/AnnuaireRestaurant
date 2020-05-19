package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Annuaire;
import com.models.Restaurant;

/**
 * Servlet implementation class ServletAnnuaire
 */
public class ServletAnnuaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAnnuaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Annuaire.getInstance().actialiserListeDeResto();
		request.setAttribute("liste", Annuaire.getInstance().getListeDeResto());
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/annuaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("supprimer") != null) {
            	Annuaire.getInstance().delRestoId(Integer.parseInt(""+request.getParameter("supprimer")));
            	Annuaire.getInstance().actialiserListeDeResto();
        		List<Restaurant> listeResto = Annuaire.getInstance().getListeDeResto();
        		request.setAttribute("liste", listeResto);
        }
		if (request.getParameter("button_chercher") != null) {
        		String nom = request.getParameter("nom");
        		String specialite = request.getParameter("specialite");
        		List<Restaurant> listeResto = Annuaire.getInstance().getRestoByNomEtSpe(nom, specialite);
        		request.setAttribute("liste", listeResto);
        }

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/annuaire.jsp").forward(request, response);
	}

}
