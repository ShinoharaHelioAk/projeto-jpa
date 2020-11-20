package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		Movimentacao movimento = new Movimentacao();
		movimento.setDescricao("Viagem à SP");
		movimento.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimento.setData(LocalDateTime.now());
		movimento.setValor(new BigDecimal(300.0));
		movimento.setCategorias(Arrays.asList(categoria, categoria2));
		movimento.setConta(conta);
		
		Movimentacao movimento2 = new Movimentacao();
		movimento2.setDescricao("Viagem à RJ");
		movimento2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimento2.setData(LocalDateTime.now());
		movimento2.setValor(new BigDecimal(400.0));
		movimento2.setCategorias(Arrays.asList(categoria, categoria2));
		movimento2.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		
		em.persist(movimento);
		em.persist(movimento2);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
