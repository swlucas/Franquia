package model;

public class Mesas {

	private Integer id;

	private String identificacao;
	private String andar;
	private Franquias franquia;
	private Tipo tipo;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public Franquias getFranquia() {
		return franquia;
	}

	public void setFranquia(Franquias franquia) {
		this.franquia = franquia;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
