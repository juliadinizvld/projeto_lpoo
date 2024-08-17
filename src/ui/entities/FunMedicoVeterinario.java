package ui.entities;

public class FunMedicoVeterinario extends Funcionarios{
	private String crm ;

	public FunMedicoVeterinario(String nome, String cpf, Enum sexo, String contato, String rua, String cidade, String bairro,
			int numeroCasa, String cep) {
		super(nome, cpf, sexo, contato, rua, cidade, bairro, numeroCasa, cep);
		this.setCrm(crm);
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
}
