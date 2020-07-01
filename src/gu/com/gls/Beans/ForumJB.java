package gu.com.gls.Beans;

public class ForumJB {
	private int id;
	private String Titulo,Pergunta,Resposta;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	
	
	public String getPergunta() {
		return Pergunta;
	}
	public void setPergunta(String pergunta) {
		Pergunta = pergunta;
	}
	
	
	public String getResposta() {
		return Resposta;
	}
	public void setResposta(String resposta) {
		Resposta = resposta;
	}

}
