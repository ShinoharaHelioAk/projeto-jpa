package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		//Torna a transação para o state: Managed
		
		Conta conta = new Conta();
		//conta.setTitular("Juliano");
		//conta.setTitular("Leonardo");
		//conta.setTitular("Reinaldo");
		conta.setTitular("Márcia");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da conta do(a) " + conta.getTitular() + ": " + conta.getId());
		
		//State: Detached
		conta.setSaldo(500.0);
		
		em2.getTransaction().begin();
		//Linha abaixo: torna uma linha com state: Detached para o state Managed.
		em2.merge(conta);
		em2.getTransaction().commit();
	}
}
