package gu.com.gls.Beans;


public class ConvenioJB {
	private int cod;
	private String nome;
	private String planos;
	private int tel;
	private String email;
	private String licenca;
	
	public int getCod() {
		return this.cod;
	}
	
	public void setCod(int novoCod) {
		this.cod = novoCod;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String getPlanos() {
		return this.planos;
	}
	
	public void setPlanos(String novoPlano) {
		this.planos = novoPlano;
	}
	
	public int getTel() {
		return this.tel;
	}
	
	public void setTel(int novoTel) {
		this.tel = novoTel;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}
	
	public String getLicenca() {
		return this.licenca;
	}
	
	public void setLicenca(String novaLicenca) {
		this.licenca = novaLicenca;
	}
}
