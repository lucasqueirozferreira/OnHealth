package gu.com.gls.Beans;

public class Pac_MedicoJB {
	private int id;
	private String paciente;
	private int medico;
	private int qtdPaciente;
	private int qtdMedico;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int novoId) {
		this.id = novoId;
	}
	
	public String getPaciente() {
		return this.paciente;
	}
	
	public void setPaciente(String novoPaciente) {
		this.paciente = novoPaciente;
	}
	
	public int getMedico() {
		return this.medico;
	}
	
	public void setMedico(int novoMedico) {
		this.medico = novoMedico;
	}
	
	public int getQtdPaciente() {
		return this.qtdPaciente;
	}
	
	public void setQtdPaciente(int novaQuantidade) {
		this.qtdPaciente = novaQuantidade;
	}
	
	public int getQtdMedico() {
		return this.qtdMedico;
	}
	
	public void setQtdMedico(int novaQuantidade) {
		this.qtdMedico = novaQuantidade;
	}
}
