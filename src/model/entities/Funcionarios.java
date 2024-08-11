package model.entities;

public abstract  class Funcionarios {

	private int id;
	private String nome;
	private String cpf;
	private char sexo;
	private String contato;
	private String endereco;

	public Funcionarios (int id, String nome, String cpf, char sexo, String contato, String endereco) {
        this.id = id;
		this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.contato= contato;
        this.endereco = endereco;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
