package ui.entities;

import java.io.Serializable;

public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private double valorConsulta;
	private int quantidade;

	public Consulta(Integer id, String nome, double valorConsulta, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.valorConsulta = valorConsulta;
		this.quantidade = quantidade;
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

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}