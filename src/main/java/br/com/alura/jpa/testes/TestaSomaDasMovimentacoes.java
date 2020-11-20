package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;

public class TestaSomaDasMovimentacoes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
//		String jpql = "select avg(m.valor) from Movimentacao m";
		
		//Passando o EntityManager para o Dao por meio de parâmetro no construtor.
		//Utilização de 2 padrões de projeto:
		//- Injeção de Dependência (CDI).
		//- Inversão de Controle (IOC).
		BigDecimal somaDasMovimentacoes = new MovimentacaoDAO(em).getSomaDasMovimentacoes();
//		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
//		Double mediaDasMovimentacoes = query.getSingleResult();
		
		System.out.println("A soma das movimentações é: " + somaDasMovimentacoes);
//		System.out.println("A média das movimentações é: " + mediaDasMovimentacoes);
	}
}
