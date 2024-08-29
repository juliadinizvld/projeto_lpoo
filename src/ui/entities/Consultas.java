package ui.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consultas implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataConsulta;
	private String nomeMedico;
	private String descricao;
	private String medicacao;
	private int id_pet;

	private Consultas() {

	}

	public Consultas(Integer id, Date dataConsulta, String nomeMedico, String descricao, String medicacao, int id_pet) {
		super();
		this.id = id;
		this.dataConsulta = dataConsulta;
		this.nomeMedico = nomeMedico;
		this.descricao = descricao;
		this.medicacao = medicacao;
		this.id_pet = id_pet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMedicacao() {
		return medicacao;
	}

	public void setMedicacao(String medicacao) {
		this.medicacao = medicacao;
	}

	public int getId_pet() {
		return id_pet;
	}

	public void setId_pet(int id_pet) {
		this.id_pet = id_pet;
	}

}
