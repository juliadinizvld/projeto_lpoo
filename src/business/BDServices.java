package business;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ui.entities.Consultas;
import ui.entities.Funcionarios;
import ui.entities.MedicosVeterinarios;
import ui.entities.Pets;
import ui.entities.Produtos;
import ui.entities.Tutores;

public class BDServices {
	public static void inserirProduto(Produtos produto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void inserirFuncionario(Funcionarios funcionario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void inserirMedicoVeterinario(MedicosVeterinarios medico) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(medico);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static int inserirTutor(Tutores tutor) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(tutor);
		int id = tutor.getId();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return id;
	}

	public static void atualizarTutor(int id, String nome, String cpf, String sexo, String email, String estado,
			String cidade, String telefone, int numeroCasa, Date dataFormatada, String cep, String bairro, String rua) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Tutores tutor = em.find(Tutores.class, id);
		tutor.setNome(nome);
		tutor.setCpf(cpf);
		tutor.setSexo(sexo);
		tutor.setEmail(email);
		tutor.setEstado(estado);
		tutor.setCidade(cidade);
		tutor.setTelefone(telefone);
		tutor.setNumeroCasa(numeroCasa);
		tutor.setDataNascimento(dataFormatada);
		tutor.setCep(cep);
		tutor.setBairro(bairro);
		tutor.setRua(rua);
		em.persist(tutor);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void atualizarProduto(int id, String tipo, String nome, int quantidade, double valor) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Produtos produto = em.find(Produtos.class, id);
		produto.setTipo(tipo);
		produto.setNome(nome);
		produto.setQuantidade(quantidade);
		produto.setValor(valor);
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void atualizarPet(int id, String nome, String especie, Date dataNascimento, String sexo, String raca,
			double peso, String alergias, String vacinas) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pets pet = em.find(Pets.class, id);
		pet.setNome(nome);
		pet.setEspecie(especie);
		pet.setDataNascimento(dataNascimento);
		pet.setSexo(sexo);
		pet.setRaca(raca);
		pet.setPeso(peso);
		pet.setAlergias(alergias);
		pet.setVacinas(vacinas);
		em.persist(pet);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void atualizarFuncionario(int id, String nome, int idade, String telefone, String cpf,
			String tipoFuncionario, String sexo, String cep, int numeroCasa, String rua, String bairro, String estado,
			String cidade) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Funcionarios funcionario = em.find(Funcionarios.class, id);
		funcionario.setNome(nome);
		funcionario.setIdade(idade);
		funcionario.setTelefone(telefone);
		funcionario.setCpf(cpf);
		funcionario.setTipoFuncionario(tipoFuncionario);
		funcionario.setSexo(sexo);
		funcionario.setCep(cep);
		funcionario.setNumeroCasa(numeroCasa);
		funcionario.setRua(rua);
		funcionario.setBairro(bairro);
		funcionario.setEstado(estado);
		funcionario.setCidade(cidade);
		em.persist(funcionario);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void atualizarMedico(int id, String nome, int idade, String telefone, String cpf, String sexo,
			String cep, int numeroCasa, String rua, String bairro, String estado, String cidade, String rmv) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		MedicosVeterinarios medico = em.find(MedicosVeterinarios.class, id);
		medico.setNome(nome);
		medico.setIdade(idade);
		medico.setTelefone(telefone);
		medico.setCpf(cpf);
		medico.setSexo(sexo);
		medico.setCep(cep);
		medico.setNumeroCasa(numeroCasa);
		medico.setRua(rua);
		medico.setBairro(bairro);
		medico.setEstado(estado);
		medico.setCidade(cidade);
		medico.setRmv(rmv);
		em.persist(medico);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static int inserirPet(Pets pet) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pet);
		int id = pet.getId();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return id;
	}

	public static int inserirConsulta(Consultas consulta) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(consulta);
		int id = consulta.getId();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return id;
	}

	public static Funcionarios consultarFuncionario(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Funcionarios funcionario = em.find(Funcionarios.class, id);
		emf.close();
		em.close();
		return funcionario;
	}

	public static MedicosVeterinarios consultarMedico(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		MedicosVeterinarios medico = em.find(MedicosVeterinarios.class, id);
		emf.close();
		em.close();
		return medico;
	}

	public static Pets consultarPet(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Pets pet = em.find(Pets.class, id);
		emf.close();
		em.close();
		return pet;
	}

	public static Consultas consultarConsulta(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Consultas consulta = em.find(Consultas.class, id);
		emf.close();
		em.close();
		return consulta;
	}

	public static Tutores consultarTutor(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Tutores tutor = em.find(Tutores.class, id);
		emf.close();
		em.close();
		return tutor;
	}

	public static Produtos consultarProduto(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Produtos produto = em.find(Produtos.class, id);
		em.close();
		return produto;
	}

	public static void removerProduto(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Produtos produto = em.find(Produtos.class, id);
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void removerFuncionario(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Funcionarios funcionario = em.find(Funcionarios.class, id);
		em.getTransaction().begin();
		em.remove(funcionario);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void removerMedico(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		MedicosVeterinarios medico = em.find(MedicosVeterinarios.class, id);
		em.getTransaction().begin();
		em.remove(medico);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void removerTutor(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Tutores tutor = em.find(Tutores.class, id);
		em.getTransaction().begin();
		em.remove(tutor);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void removerPet(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Pets pet = em.find(Pets.class, id);
		em.getTransaction().begin();
		em.remove(pet);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
