package ui.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicosVeterinarios implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int idade;
	private String telefone;
	private String cpf;
	private String sexo;
	private String cep;
	private int numeroCasa;
	private String rua;
	private String bairro;
	private String estado;
	private String cidade;
	private String rmv;

	protected MedicosVeterinarios() {
	}

	public MedicosVeterinarios(Integer id, String nome, int idade, String telefone, String cpf, String sexo, String cep,
			int numeroCasa, String rua, String bairro, String estado, String cidade, String crmv) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.cpf = cpf;
		this.sexo = sexo;
		this.cep = cep;
		this.numeroCasa = numeroCasa;
		this.rua = rua;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.rmv = crmv;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRmv() {
		return rmv;
	}

	public void setRmv(String rmv) {
		this.rmv = rmv;
	}

	@Override
	public String toString() {
		return "MedicosVeterinarios [id=" + id + ", nome=" + nome + ", idade=" + idade + ", telefone=" + telefone
				+ ", cpf=" + cpf + ", sexo=" + sexo + ", cep=" + cep + ", numeroCasa=" + numeroCasa + ", rua=" + rua
				+ ", bairro=" + bairro + ", estado=" + estado + ", cidade=" + cidade + ", rmv=" + rmv + "]";
	}

}
