package ui.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FuncionarioAtendente extends Funcionarios implements Serializable {
	private static final long serialVersionUID = 1L;

	private FuncionarioAtendente() {

	}

	public FuncionarioAtendente(Integer id, String nome, String cpf, String sexo, String telefone, String rua,
			String cidade, String estado, String bairro, int numeroCasa, String cep) {
		super(id, nome, cpf, sexo, telefone, rua, cidade, estado, bairro, numeroCasa, cep);
	}

}
