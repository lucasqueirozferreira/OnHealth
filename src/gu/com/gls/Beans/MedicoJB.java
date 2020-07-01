package gu.com.gls.Beans;

import java.util.Calendar;

public class MedicoJB {
	private static String crm;
	private static String nome;
	private static Calendar nascimento;
	private static String especialidade;
	private static String tel;
	private static String email;
	private static String senha;
	private static int idade;
	
	public String getCrm() {
		return this.crm;
	}
	
	public void setCrm(String novoCrm) {
		this.crm = novoCrm;
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
	
	public String getEspecialidade() {
		return this.especialidade;
	}
	
	public void setEspecialidade(String novaEspecialidade) {
		this.especialidade = novaEspecialidade;
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
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
