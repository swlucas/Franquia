package model;

import java.util.Random;


import dao.UsuarioDAO;
import util.SendEmail;

public class Franqueado {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private String email;
	
	
	public Franqueado() {
	
	}
	
	public Franqueado(String nome, String cpf, String telefone, String endereco, String email) {
		super();
		this.id = gerarId();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		/*
		String senha = gerarSenha();
		System.out.println(gerarId());
		Usuario usuario = new Usuario(email,senha,2,gerarId());
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inserir(usuario);
		
		try {
			SendEmail sendEmail = new SendEmail();
			sendEmail.sendLoginSenha(nome,email,senha);
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
	}
	
	
	
	private Integer gerarId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Integer id = usuarioDAO.totalUsuarios();
		for (int i = usuarioDAO.totalUsuarios(); i <= usuarioDAO.totalUsuarios(); i++) {
			id++;
		}
				return id;
	}

	private String gerarSenha() {
		Random random = new Random();
		
		String preFixo = "Restaurant";
		String senha = preFixo + random.nextInt(99999);
		return senha;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
