package ui.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "medicos_veterinarios")
public class FuncionarioMedicoVeterinario extends Funcionarios implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String rua;
	private String cidade;
	private String estado;
	private String bairro;
	@Column(name = "numero_casa")
	private int numeroCasa;
	private String cep;
	private String crm;

	private FuncionarioMedicoVeterinario() {

	}

	public FuncionarioMedicoVeterinario(Integer id, String nome, String cpf, String sexo, String telefone, String rua,
			String cidade, String estado, String bairro, int numeroCasa, String cep, String crm) {
		super(id, nome, cpf, sexo, telefone, rua, cidade, estado, bairro, numeroCasa, cep);
		this.crm = crm;
	}

}
