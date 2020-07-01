package gu.com.gls.Beans;

import java.util.Calendar;

public class PacienteJB {
	private static String cpf;
	private static String nome;
	private static Calendar nascimento;
	private static String rg;
	private static String sexo;
	private static String tel;
	private static String email;
	private static String end;
	private static String senha;
	private static int idade;
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String novoCpf) {
		this.cpf = novoCpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public Calendar getNascimento() {
		return this.nascimento;
	}
	
	public void setNascimento(Calendar novoNascimento) {
		this.nascimento = novoNascimento;
	}
	
	public String getRg() {
		return this.rg;
	}
	
	public void setRg(String novoRg) {
		this.rg = novoRg;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	public void setSexo(String novoSexo) {
		this.sexo = novoSexo;
	}
	
	public String getTel() {
		return this.tel;
	}
	
	public void setTel(String novoTel) {
		this.tel = novoTel;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}
	
	public String getEnd() {
		return this.end;
	}
	
	public void setEnd(String novoEnd) {
		this.end = novoEnd;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int novaIdade) {
		this.idade = novaIdade;
	}
}
