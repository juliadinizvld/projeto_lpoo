package ui.entities;

public class Pet {

	private int id;
	private String nome;
	private String especie;
	private String raca;
	private double peso;
	private Tutor tutor;
	public char sexo;
	public double idade;
	public String vacinas;

	public Pet(int id, String nome, String especie, String raca, double peso, Tutor tutor, char sexo, double idade,
			String vacinas) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.peso = peso;
		this.tutor = tutor;
		this.sexo = sexo;
		this.idade = idade;
		this.vacinas = vacinas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getIdade() {
		return idade;
	}

	public void setIdade(double idade) {
		this.idade = idade;
	}

	public String getVacinas() {
		return vacinas;
	}

	public void setVacinas(String vacinas) {
		this.vacinas = vacinas;
	}

}
