package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		
		//State: Transient
		//N�o possui id
		//Poss�vel condidato ao state Managed
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(123123);
		conta.setNumero(12387128);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Transient -> Managed
		//Sincroniza��o autom�tica ao banco.
		em.persist(conta);
		System.out.println("ID da conta do Almiro: "+conta.getId());
		
		//Managed -> Removed
		//Remove a transa��o do contexto do JPA.
		//Faz o delete pelo JPA.
		//A entidade j� foi Managed e portanto possui ID.
		//Diferente do Detached, uma entidade Removed n�o possui registro no banco.
		em.remove(conta);
		
		em.getTransaction().commit();
	}

}
