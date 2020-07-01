package gu.com.gls.Beans;


public class StatusJB {
	private int id;
	private String descricao;
	private int exame;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int novoId) {
		this.id = novoId;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String novaDescricao) {
		this.descricao = novaDescricao;
	}
	
	public int getExame() {
		return this.exame;
	}
	
	public void setExame(int novoExame) {
		this.exame = novoExame;
	}
}
