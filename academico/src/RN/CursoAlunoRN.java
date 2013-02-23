package RN;

import java.util.List;
import modelo.CursoAluno;
import dao.CursoAlunoDAO;
import dao.CursoAlunoDAOHibernate;
/**
 * @author http://javaes.wordpress.com/
 * */
public class CursoAlunoRN 
{
	private static CursoAlunoDAO cursoAlunoDAO;
	
	public static List<CursoAluno> listar() throws Exception 
	{
		cursoAlunoDAO = new CursoAlunoDAOHibernate();
		return cursoAlunoDAO.lista();
	}
}
