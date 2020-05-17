package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

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
		//ArrayList<Restaurant> listetest = new ArrayList<Restaurant>();
		//listetest.add(new Restaurant("namee", "addree", "spee",  null));
		//listetest.add(new Restaurant("namee2", "addree2", "spee2",  null));
		request.setAttribute("liste", Annuaire.getInstance().getListeDeResto());
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/annuaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
