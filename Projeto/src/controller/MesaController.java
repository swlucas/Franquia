package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FranquiaDAO;
import dao.MesasDAO;
import dao.TipoDAO;
import model.Franquias;
import model.Mesas;
import model.Tipo;

@WebServlet("/mesas")
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			FranquiaDAO dao = new FranquiaDAO();
			request.setAttribute("lista", dao.listar());
			TipoDAO tipoDao = new TipoDAO();
			request.setAttribute("listaTipo", tipoDao.listar());
			request.getRequestDispatcher("mesaform.jsp").forward(request, response);
		}else {
			MesasDAO dao = new MesasDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("mesalist.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identificacao = request.getParameter("identificacao");
		String andar = request.getParameter("andar");
		String franquiaID = request.getParameter("franquia");
		String tipoID = request.getParameter("tipo");
		
		Mesas mesa = new Mesas();
		mesa.setIdentificacao(identificacao);
		mesa.setAndar(andar);
		FranquiaDAO franquiaDAO = new FranquiaDAO();
		int ida = Integer.parseInt(franquiaID);
		Franquias f = franquiaDAO.getByID(ida);
		mesa.setFranquia(f);

		int id_tipo = Integer.parseInt(tipoID);
		TipoDAO tipoDAO = new TipoDAO();
		Tipo tipo = tipoDAO.getByID(id_tipo);
		mesa.setTipo(tipo);
		MesasDAO dao = new MesasDAO();
		dao.inserir(mesa);
		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("mesalist.jsp").forward(request, response);;
	}

}
