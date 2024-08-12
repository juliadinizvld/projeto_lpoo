package model.entities;

public class Funcionarios {

	private int id;
	private String nome;
	private String cpf;
	private String sexo;
	private String funcao;
	private String especialidade;
	private String crm;
	private String contato;
	private String endereco;

	public Funcionarios (int id, String nome, String cpf, String sexo, String funcao, String especialidade, String crm, String contato, String endereco) {
        this.id = id;
		this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.funcao = funcao;
        this.especialidade = especialidade;
        this.crm = crm;
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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
