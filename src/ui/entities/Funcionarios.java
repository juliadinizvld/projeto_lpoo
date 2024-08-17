package ui.entities;

public abstract class Funcionarios {

	private String nome;
	private String cpf;
	private Enum sexo;
	private String contato;
	private String rua;
	private String cidade;
	private String bairro;
	private int numeroCasa;
	private String cep;

	public Funcionarios(String nome, String cpf, Enum sexo, String contato, String rua, String cidade, String bairro,
			int numeroCasa, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.contato = contato;
		this.rua = rua;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numeroCasa = numeroCasa;
		this.cep = cep;
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

	public Enum getSexo() {
		return sexo;
	}

	public void setSexo(Enum sexo) {
		this.sexo = sexo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
