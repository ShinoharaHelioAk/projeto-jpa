package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//em.find(...) -> Retorna uma entidade no estado Managed.
		Movimentacao movimentacao = em.find(Movimentacao.class, 4L);
		
		Conta conta = movimentacao.getConta();
		int quantidadeDeMovimentacoes = conta.getMovimentacoes().size();
		
		System.out.println("Quantidade de movimentações: " + quantidadeDeMovimentacoes);
		System.out.println("Titular da Conta: " + conta.getTitular());
	}
}
