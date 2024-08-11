package Model;

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
}
