package business;

import javax.persistence.EntityManager;
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
	
	public static void inserirTutor(Tutores tutor) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaveterinaria");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(tutor);
		em.getTransaction().commit();
		em.close();
		emf.close();
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
}
