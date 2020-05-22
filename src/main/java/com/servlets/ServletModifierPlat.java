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
 * Servlet implementation class ServletModifierPlat
 */
public class ServletModifierPlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierPlat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_plat = Integer.parseInt(request.getParameter("id_plat"));
		int id_resto = Integer.parseInt(request.getParameter("id_resto"));
		System.out.println("idp::"+id_plat+"   idr::"+id_resto);
		Annuaire.getInstance().actialiserListeDeResto();
		Plat plat = Annuaire.getInstance().getRestoById(id_resto).getPlatById(id_plat);
		request.setAttribute("id_resto", id_resto);
		request.setAttribute("plat", plat);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifier_plat.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_resto = Integer.parseInt(request.getParameter("id_resto"));
		
		if(request.getParameter("enregistrer_plat") != null) {
			int enregistrer_plat = Integer.parseInt(request.getParameter("enregistrer_plat"));
			String nom = request.getParameter("nom");
			String type = request.getParameter("type");
			double prix = Double.parseDouble(request.getParameter("prix"));
			String description= request.getParameter("description");
			
			Annuaire.getInstance().getRestoById(id_resto)
			.modifPlat(new Plat(enregistrer_plat, id_resto, nom, prix, type, description));
		}
		
		String urlRed = "/AnnuaireRestaurant/restaurant?id="+id_resto;
		response.sendRedirect(urlRed);
	}

}
