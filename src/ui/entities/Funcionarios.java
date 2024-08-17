package ui.entities;

public abstract class Funcionarios {

	private String nome;
	private String cpf;
	private Enum sexo;
	private String telefone;
	private String rua;
	private String cidade;
	private String estado;
	private String bairro;
	private int numeroCasa;
	private String cep;

	public Funcionarios(String nome, String cpf, Enum sexo, String telefone, String rua, String cidade, String estado,
			String bairro, int numeroCasa, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.telefone = telefone;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
