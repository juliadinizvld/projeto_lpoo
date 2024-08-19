package business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ui.entities.FuncionarioMedicoVeterinario;
import ui.entities.Funcionarios;
import ui.entities.Produtos;

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
}
