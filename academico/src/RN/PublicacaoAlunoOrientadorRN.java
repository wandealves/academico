package RN;

import java.util.*;

import dao.PublicacaoAlunoOrientadorDAO;
import dao.PublicacaoAlunoOrientadorDAOHibernate;
import modelo.*;
/**
 * @author http://javaes.wordpress.com/
 * */
public class PublicacaoAlunoOrientadorRN {
	
	private static PublicacaoAlunoOrientadorDAO dao;
	
	public static List<PublicacaoAlunoOrientador> listar() throws Exception
	{
		dao = new PublicacaoAlunoOrientadorDAOHibernate();
		return dao.lista();
	}

}
