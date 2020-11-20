package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//String jpql = "select c from Conta c";
		//String jpql = "select c from Conta c join fetch c.movimentacoes";
		//String jpql = "select c from Conta c left join fetch c.movimentacoes";
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = query.getResultList();
		System.out.println("-----------------------------------------------");
		for (Conta conta : contas) {
			System.out.println("ID da Conta: " + conta.getId());
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Ag�ncia: " + conta.getAgencia());
			System.out.println("N�mero: " + conta.getNumero());
			System.out.println("Quantidade de Movimenta��es: " + conta.getMovimentacoes().size());
			System.out.println("Movimenta��es: " + conta.getMovimentacoes());
			System.out.println("-----------------------------------------------");
		}
	}
}
