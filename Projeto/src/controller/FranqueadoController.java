package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FranqueadoDAO;
import dao.UsuarioDAO;
import model.Franqueado;
import model.Usuario;

/**
 * Servlet implementation class FranqueadoController
 */
@WebServlet("/franqueado")
public class FranqueadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			request.getRequestDispatcher("franqueado.jsp").forward(request, response);
			return;
		}
		
		FranqueadoDAO franqueadoDAO = new FranqueadoDAO();
		
		if (q != null && q.equals("editar")) {
			String id = request.getParameter("id");
			Franqueado franqueado = franqueadoDAO.getByID(Integer.parseInt(id)); 
			request.setAttribute("franqueadolista", franqueadoDAO.listar());
			request.setAttribute("franqueado", franqueado);
			request.getRequestDispatcher("franqueado.jsp").forward(request, response);
			return;
		}

		
		if (q != null && q.equals("excluir")) {
				String id = request.getParameter("id");
				franqueadoDAO.delete(Integer.parseInt(id));
		}
			request.setAttribute("lista", franqueadoDAO.listar());
			request.getRequestDispatcher("franqueadolist.jsp").forward(request, response);
		
			
			
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id, nome, cpf, telefone, endereco, email;
		
		id = request.getParameter("id");
		nome = request.getParameter("nome");
		cpf = request.getParameter("cpf");
		telefone = request.getParameter("telefone");
		endereco = request.getParameter("endereco");
		email = request.getParameter("email");
		
		
		FranqueadoDAO franqueadoDAO = new FranqueadoDAO();
		
		
		
		if(id!= null && !id.isEmpty()) {
			Franqueado franqueado = new Franqueado(nome,cpf,telefone,endereco,email);
			franqueado.setId(Integer.parseInt(id));
			franqueadoDAO.update(franqueado);
		}else if(franqueadoDAO.getByEmail(email) != null || franqueadoDAO.getByCpf(cpf) != null) {
			request.setAttribute("franqueadoExistente", "E-mail Já cadastrado!");
			request.getRequestDispatcher("franqueado.jsp").forward(request, response);
		}else {
			Usuario usuario = new Usuario(nome,cpf,telefone,endereco,email);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.inserir(usuario);
			
		}
		
		
		
		
		request.setAttribute("lista", franqueadoDAO.listar());
		request.getRequestDispatcher("franqueadolist.jsp").forward(request, response);
	}

}
