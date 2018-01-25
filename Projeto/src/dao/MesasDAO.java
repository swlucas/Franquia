package dao;

import util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Franqueado;
import model.Franquias;
import model.Mesas;
import model.Tipo;
public class MesasDAO {
	
	private Conexao conexao;
	
	public MesasDAO(){
		this.conexao = Conexao.getConexao();
	}
	
	public List<Mesas> listar(){
		List<Mesas> mesas = new ArrayList<>();
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("select MESAS_ID, MESAS_IDENTIFICACAO, MESAS_ANDAR, FRANQUIA_ID, FRANQUIAS_NOME, TIPO_ID, TIPOS_NOME from mesas INNER JOIN TIPOS ON TIPOS_ID = TIPO_ID INNER JOIN FRANQUIAS ON FRANQUIAS_ID = FRANQUIA_ID;");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Mesas me = new Mesas();
				me.setId(rs.getInt("MESAS_ID"));
				me.setIdentificacao(rs.getString("MESAS_IDENTIFICACAO"));
				me.setAndar(rs.getString("MESAS_ANDAR"));
				
				Franquias franquia = new Franquias();
				franquia.setId(rs.getInt("FRANQUIA_ID"));
				franquia.setNome(rs.getString("FRANQUIAS_NOME"));
				me.setFranquia(franquia);
				
				Tipo tipo = new Tipo();
				tipo.setId(rs.getInt("TIPO_ID"));
				tipo.setNome(rs.getString("TIPOS_NOME"));
				me.setTipo(tipo);
				mesas.add(me);
;			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mesas;
	}
	
	public void inserir(Mesas mesas) {
		try {

			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("insert into Mesas (MESAS_IDENTIFICACAO,MESAS_ANDAR,TIPO_ID,FRANQUIA_ID) values (?,?,?,?);");
			ps.setString(1, mesas.getIdentificacao());
			ps.setString(2, mesas.getAndar());
			ps.setInt(3, mesas.getTipo().getId());
			ps.setInt(4, mesas.getFranquia().getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Integer totalMesas(){
		PreparedStatement ps;
		Integer value = null;
		try {
			ps = conexao.getConnection().prepareStatement("select count(MESAS_ID) from MESAS");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				value = rs.getInt(1);
			}
			ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return value;
			
	}
	
	public Mesas getByID(int id) {
		Mesas me = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("select MESAS_ID,MESAS_IDENTIFICACAO,MESAS_ANDAR,FRANQUIA_ID,TIPO_ID from mesas where MESAS_ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				me = new Mesas();
				me.setId(rs.getInt("MESAS_ID"));
				me.setIdentificacao(rs.getString("MESAS_IDENTIFICACAO"));
				me.setAndar(rs.getString("MESAS_ANDAR"));
				
				Franquias franquia = new Franquias();
				franquia.setId(rs.getInt("FRANQUIA_ID"));
				me.setFranquia(franquia);
				
				Tipo tipo = new Tipo();
				tipo.setId(rs.getInt("TIPO_ID"));
				me.setTipo(tipo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return me;
	}
	
	public void close() {
		conexao.closeConnection();
	}
}
