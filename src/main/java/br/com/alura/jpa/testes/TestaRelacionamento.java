package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setAgencia(54321);
		conta.setNumero(12345);
		conta.setSaldo(1000.0);
		conta.setTitular("Leonardo");
		
		Movimentacao movimento = new Movimentacao();
		movimento.setData(LocalDateTime.now());
		movimento.setDescricao("Churrascaria");
		movimento.setValor(new BigDecimal(200.0));
		movimento.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		//movimento.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimento);
		em.getTransaction().commit();
		em.close();
	}
}
