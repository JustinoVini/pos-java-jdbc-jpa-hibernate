package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavajdbcjpahibernate.HibernateUtil;

/*Criando o DAO generico*/
@SuppressWarnings("unchecked")
public class DaoGeneric<T> {

	private EntityManager entityManager = HibernateUtil.getEntityManager(); // pega o em

	/* Cria uma nova entidade */
	public void salvar(T entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin(); // inicia
		entityManager.persist(entidade);
		transaction.commit();
	}

	/* Salva ou atualiza */
	public T updateMerge(T entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin(); // inicia
		T entidadeSalva = entityManager.merge(entidade); // salva se não existir, ou atualiza se existir
		transaction.commit();

		return entidadeSalva;
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

	public void deletarPorId(T entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager
				.createNativeQuery(
						"delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id =" + id)
				.executeUpdate(); // executa

		transaction.commit();

	}

	public List<T> listar(Class<T> entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		List<T> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();

		return lista;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
