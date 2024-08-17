package ui.entities;

import java.time.LocalDate;

public class Tutor {
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String sexo;
	private String email;
	private String cep;
	private String rua;
	private String bairro;
	private int numeroCasa;
	private String estado;
	private String cidade;
	private String telefone;

	public Tutor(String nome, String cpf, LocalDate dataNascimento, String sexo, String email, String cep, String rua,
			String bairro, String estado, int numeroCasa, String cidade, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.estado = estado;
		this.numeroCasa = numeroCasa;
		this.cidade = cidade;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numeroCasa;
	}

	public void setNumero(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
