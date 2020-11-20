package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacoesFiltradasPorDateCriteria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		List<Movimentacao> movimentacoesFiltradasPorData = dao.getMovimentacoesFiltradasPorData(null, null, null);
		System.out.println("-----------------------");
		movimentacoesFiltradasPorData.forEach(movimentacao -> {
			System.out.println("Descrição -> " + movimentacao.getDescricao());
			System.out.println("Valor -> " + movimentacao.getValor());
			System.out.println("-----------------------");
		});
	}

}
