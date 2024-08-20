package ui.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tutores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String sexo;
	private String email;
	private String estado;
	private String cidade;
	private String telefone;
	private int numeroCasa;
	private Date dataNascimento;
	private String cep;
	private String bairro;
	private String rua;

	private Tutores() {

	}

	public Tutores(Integer id, String nome, String cpf, String sexo, String email, String estado, String cidade,
			String telefone, int numeroCasa, Date dataNascimento, String cep, String bairro, String rua) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.estado = estado;
		this.cidade = cidade;
		this.telefone = telefone;
		this.numeroCasa = numeroCasa;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Override
	public String toString() {
		return "Tutores [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", email=" + email
				+ ", estado=" + estado + ", cidade=" + cidade + ", telefone=" + telefone + ", numeroCasa=" + numeroCasa
				+ ", dataNascimento=" + dataNascimento + ", cep=" + cep + ", bairro=" + bairro + ", rua=" + rua + "]";
	}

}
