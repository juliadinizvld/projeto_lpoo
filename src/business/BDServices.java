package business;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

	public static void inserirPet(Pets pet) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pet);
		em.getTransaction().commit();
		em.close();
		emf.close();
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
	
	  public static List<Produtos> consultarProdutosPorNome(String nome) {
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
	        EntityManager em = emf.createEntityManager();
	        TypedQuery<Produtos> query = em.createQuery(
	            "SELECT p FROM Produtos p WHERE p.nome LIKE :nome", Produtos.class
	        );
	        query.setParameter("nome", "%" + nome + "%");
	        List<Produtos> produtos = query.getResultList();
	        em.close();
	        return produtos;
	    }
	  
	   public static Produtos consultarProdutoPorId(int id) {
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
	        EntityManager em = emf.createEntityManager();
	        Produtos produto = em.find(Produtos.class, id);
	        em.close();
	        return produto;
	    }
}
