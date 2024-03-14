package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavajdbcjpahibernate.HibernateUtil;

/*Criando o DAO generico*/
public class DaoGeneric<T> {

	private EntityManager entityManager = HibernateUtil.getEntityManager(); // pega o em

	/* Cria uma nova entidade */
	public void salvar(T entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin(); // inicia
		entityManager.persist(entidade);
		transaction.commit();
	}

	public T pesquisar(T entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);

		T t = (T) entityManager.find(entidade.getClass(), id);

		return t;
	}
	
	public T pesquisar(Long id, Class entidade) {
				
		T t = (T) entityManager.find(entidade, id);
		
		return t;
	}

}
