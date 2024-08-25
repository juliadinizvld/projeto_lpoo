package business;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

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

	public static Funcionarios consultarFuncionario(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Funcionarios funcionario = em.find(Funcionarios.class, id);
		emf.close();
		em.close();
		return funcionario;
	}

	public static Pets consultarPet(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		Pets pet = em.find(Pets.class, id);
		emf.close();
		em.close();
		return pet;
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
