package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Franqueado;
import util.Conexao;

public class FranqueadoDAO {

	private Conexao conexao;

	public FranqueadoDAO() {
		this.conexao = Conexao.getConexao();
	}

	public void inserir(Franqueado franqueado) {

		try {

			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("insert into franqueados (FRANQUEADOS_ID,FRANQUEADOS_NOME,FRANQUEADOS_CPF,FRANQUEADOS_TELEFONE,FRANQUEADOS_ENDERECO,FRANQUEADOS_EMAIL) values (?,?,?,?,?,?);");
			ps.setInt(1, franqueado.getId());
			ps.setString(2, franqueado.getNome());
			ps.setString(3, franqueado.getCpf());
			ps.setString(4, franqueado.getTelefone());
			ps.setString(5, franqueado.getEndereco());
			ps.setString(6, franqueado.getEmail());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		PreparedStatement ps;
		try {
			ps = conexao.getConnection().prepareStatement("DELETE FRANQUEADOS FROM ETAPA_GRUPO_ENSINO ege INNER JOIN #Aux temp ON temp.ID_GRUPO_ENSINO = ege.ID_GRUPO_ENSINO");
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Franqueado franqueado) {
		try {
			
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("update Franqueados set franqueados_nome=?,franqueados_cpf = ?, franqueados_telefone = ?,franqueados_email = ?,franqueados_endereco = ? where franqueados_id =? ");
			ps.setString(1, franqueado.getNome());
			ps.setString(2, franqueado.getCpf());
			ps.setString(3, franqueado.getTelefone());
			ps.setString(4,franqueado.getEmail());
			ps.setString(5,franqueado.getEndereco());
			ps.setInt(6, franqueado.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<Franqueado> listar() {
		Statement stmt;
		List<Franqueado> franqueado = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select FRANQUEADOS_ID,FRANQUEADOS_NOME,FRANQUEADOS_CPF,FRANQUEADOS_TELEFONE,FRANQUEADOS_ENDERECO,FRANQUEADOS_EMAIL from FRANQUEADOS ORDER BY franqueados_id;;");
			while (rs.next()) {
				Franqueado f = new Franqueado();
				f.setId(rs.getInt("FRANQUEADOS_ID"));
				f.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setCpf(rs.getString("FRANQUEADOS_CPF"));
				f.setTelefone(rs.getString("FRANQUEADOS_TELEFONE"));
				f.setEndereco(rs.getString("FRANQUEADOS_ENDERECO"));
				f.setEmail(rs.getString("FRANQUEADOS_EMAIL"));
				franqueado.add(f);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return franqueado;

	}

	public Integer totalFranqueados() {
		PreparedStatement ps;
		Integer value = null;
		try {
			ps = conexao.getConnection().prepareStatement("select count(FRANQUEADOS_ID) from FRANQUEADOS");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				value = rs.getInt(1);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public Franqueado getByID(int id) {
		Franqueado f = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("select FRANQUEADOS_ID,FRANQUEADOS_NOME,FRANQUEADOS_CPF,FRANQUEADOS_TELEFONE,FRANQUEADOS_ENDERECO,FRANQUEADOS_EMAIL from FRANQUEADOS where FRANQUEADOS_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = new Franqueado();
				f.setId(rs.getInt("FRANQUEADOS_ID"));
				f.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setCpf(rs.getString("FRANQUEADOS_CPF"));
				f.setTelefone(rs.getString("FRANQUEADOS_TELEFONE"));
				f.setEndereco(rs.getString("FRANQUEADOS_ENDERECO"));
				f.setEmail(rs.getString("FRANQUEADOS_EMAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	public Franqueado getByEmail(String email) {
		Franqueado f = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("select FRANQUEADOS_ID,FRANQUEADOS_NOME,FRANQUEADOS_CPF,FRANQUEADOS_TELEFONE,FRANQUEADOS_ENDERECO,FRANQUEADOS_EMAIL from FRANQUEADOS where FRANQUEADOS_EMAIL=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = new Franqueado();
				f.setId(rs.getInt("FRANQUEADOS_ID"));
				f.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setCpf(rs.getString("FRANQUEADOS_CPF"));
				f.setTelefone(rs.getString("FRANQUEADOS_TELEFONE"));
				f.setEndereco(rs.getString("FRANQUEADOS_ENDERECO"));
				f.setEmail(rs.getString("FRANQUEADOS_EMAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public Franqueado getByCpf(String cpf) {
		Franqueado f = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("select FRANQUEADOS_ID,FRANQUEADOS_NOME,FRANQUEADOS_CPF,FRANQUEADOS_TELEFONE,FRANQUEADOS_ENDERECO,FRANQUEADOS_EMAIL from FRANQUEADOS where FRANQUEADOS_CPF=?");
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = new Franqueado();
				f.setId(rs.getInt("FRANQUEADOS_ID"));
				f.setNome(rs.getString("FRANQUEADOS_NOME"));
				f.setCpf(rs.getString("FRANQUEADOS_CPF"));
				f.setTelefone(rs.getString("FRANQUEADOS_TELEFONE"));
				f.setEndereco(rs.getString("FRANQUEADOS_ENDERECO"));
				f.setEmail(rs.getString("FRANQUEADOS_EMAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

}
