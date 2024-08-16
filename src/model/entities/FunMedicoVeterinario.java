package model.entities;

public class FunMedicoVeterinario extends Funcionarios{
	private String crm ;

	public FunMedicoVeterinario(int id, String nome, String cpf, char sexo, String contato, String endereco, String crm) {
		super(id, nome, cpf, sexo, contato, endereco);
		this.setCrm(crm);
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
}
