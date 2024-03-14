package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavajdbcjpahibernate.HibernateUtil;

/*Criando o DAO generico*/
public class DaoGeneric<T> {

	private EntityManager entityManager = HibernateUtil.getEntityManager(); // pega o em
	
	public void salvar(T entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin(); // inicia
		entityManager.persist(entidade);
		transaction.commit();
	}
	
}
