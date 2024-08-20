package ui.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String especie;
	private Date dataNascimento;
	private String sexo;
	private String raca;
	private double peso;
	private String alergias;
	private String vacinas;
	private int id_tutor;

	private Pets() {

	}

	public Pets(Integer id, String nome, String especie, Date dataNascimento, String sexo, String raca, double peso,
			String alergias, String vacinas, int id_tutor) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.raca = raca;
		this.peso = peso;
		this.alergias = alergias;
		this.vacinas = vacinas;
		this.id_tutor = id_tutor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getVacinas() {
		return vacinas;
	}

	public void setVacinas(String vacinas) {
		this.vacinas = vacinas;
	}

	public int getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(int id_tutor) {
		this.id_tutor = id_tutor;
	}

	@Override
	public String toString() {
		return "Pets [id=" + id + ", nome=" + nome + ", especie=" + especie + ", dataNascimento=" + dataNascimento
				+ ", sexo=" + sexo + ", raca=" + raca + ", peso=" + peso + ", alergias=" + alergias + ", vacinas="
				+ vacinas + ", id_tutor=" + id_tutor + "]";
	}

}
