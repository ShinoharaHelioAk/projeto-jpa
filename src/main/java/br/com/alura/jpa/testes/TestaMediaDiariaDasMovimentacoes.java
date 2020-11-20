package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.util.Util;

public class TestaMediaDiariaDasMovimentacoes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDAO(em).getMediaDiariaDasMovimentacoes();
		for (MediaComData resultado : mediaDasMovimentacoes) {
//			System.out.println("A média das movimentações do dia " + resultado[1] + "/" + resultado[2] + "/" + resultado[3] + " é: " + resultado[0]);
//			System.out.printf("A média das movimentações do dia %s/%s/%s é de: R$ %.2f\n", 
//					(resultado[1].toString().length() < 2 ? "0"+resultado[1] : resultado[1]), 
//					(resultado[2].toString().length() < 2 ? "0"+resultado[2] : resultado[2]), 
//					resultado[3], 
//					resultado[0]);
			System.out.printf("A média das movimentações do dia %s/%s/%s é de: R$ %.2f\n", 
					(resultado.getDia().toString().length() < 2 ? Util.formataNumero(resultado.getDia(), "0") : resultado.getDia()),
					(resultado.getMes().toString().length() < 2 ? Util.formataNumero(resultado.getMes(), "0") : resultado.getMes()),
					resultado.getAno(),
					resultado.getValor());
		}
		
	}
}
