package posjavajdbcjpahibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	public static EntityManagerFactory factory = null;

	static { // chama direto
		init();
	}

	private static void init() {
		try {

			/* Vai ler uma unica vez */
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("pos-java-jdbc-jpa-hibernate");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager(); /* Prove a parte de persistencia */
	}

	public static Object getPrimaryKey(Object entity) { // retorna a primary key
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
