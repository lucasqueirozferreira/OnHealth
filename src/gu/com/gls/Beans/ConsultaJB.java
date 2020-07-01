package gu.com.gls.Beans;

import java.sql.Date;

public class ConsultaJB {
	private int cod;
	private String nome;
	private Date dataExame;
	private Date dataResultado;
	private String resultado;
	private String paciente;
	private String medico;
	private String link;
	private String confirm;
	
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
	
	public Date getDataE() {
		return this.dataExame;
	}
	
	public void setDataE(Date novaData) {
		this.dataExame = novaData;
	}
	
	public Date getDataR() {
		return this.dataResultado;
	}
	
	public void setDataR(Date novaData) {
		this.dataResultado = novaData;
	}
	
	public String getResultado() {
		return this.resultado;
	}
	
	public void setResultado(String novoResultado) {
		this.resultado = novoResultado;
	}
	
	public String getPaciente() {
		return this.paciente;
	}
	
	public void setPaciente(String novoPaciente) {
		this.paciente = novoPaciente;
	}
	
	public String getMedico() {
		return this.medico;
	}
	
	public void setMedico(String novoMedico) {
		this.medico = novoMedico;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String novoLink) {
		this.link = novoLink;
	}

	public String getConfirm() {
		return this.confirm;
	}

	public void setConfirm(String novoConfirm) {
		this.confirm = novoConfirm;
	}
}
