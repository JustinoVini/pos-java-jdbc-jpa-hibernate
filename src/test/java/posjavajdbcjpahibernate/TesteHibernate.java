package posjavajdbcjpahibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setNome("Primeiro Teste 3");
		pessoa.setIdade(45);
		pessoa.setEmail("email.teste3@email.com");
		pessoa.setLogin("teste");
		pessoa.setSenha("admin");
		pessoa.setSobrenome("Tester");
		
		daoGeneric.salvar(pessoa);		
	}
	
}
