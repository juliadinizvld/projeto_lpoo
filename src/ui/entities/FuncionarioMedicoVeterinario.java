package ui.entities;

public class FuncionarioMedicoVeterinario extends Funcionarios {
	private String crm;

	public FuncionarioMedicoVeterinario(String nome, String cpf, Enum sexo, String contato, String rua, String cidade,
			String bairro, int numeroCasa, String cep, String crm) {
		super(nome, cpf, sexo, contato, rua, cidade, bairro, numeroCasa, cep);
		this.crm = crm;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
}
