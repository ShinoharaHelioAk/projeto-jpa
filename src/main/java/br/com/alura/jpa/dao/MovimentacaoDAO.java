package br.com.alura.jpa.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class MovimentacaoDAO {
	private EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void atualizaTipoMovimentacaoTabela() {
		this.em.getTransaction().begin();
		
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaUpdate<Movimentacao> update = builder.createCriteriaUpdate(Movimentacao.class);
		Root<Movimentacao> root = update.from(Movimentacao.class);
		
		update.set(root.get("tipoMovimentacao"), TipoMovimentacao.SAIDA);
		
		Query query = em.createQuery(update);
		query.executeUpdate();
		
		this.em.getTransaction().commit();
		this.em.close();
	}

	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {
//		String sql = "select m from Movimentacao m";
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		Predicate predicate = null;
		if (dia != null) {
//			sql += "where day(data) = :pDia";
			predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
			predicates.add(predicate);
		}

		if (mes != null) {
			predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
			predicates.add(predicate);
		}
//		if (mes != null && sql.contains("where")) {
//			sql += "and month(data) = :pMes";
//		} else {
//			sql += "where month(data) = :pMes";
//		}

		if (ano != null) {
			predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
			predicates.add(predicate);
		}
//		if (ano != null && sql.contains("where")) {
//			sql += "and year(data) = :pAno";
//		} else {
//			sql += "where year(data) = :pAno";
//		}
		
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));

		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);

		return typedQuery.getResultList();
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {
//		String jpql = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data), year(m.data)) "
//				+ "from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

//		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);

		return query.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {
		String jpql = "select sum(m.valor) from Movimentacao m";
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);

		return query.getSingleResult();
	}
}
