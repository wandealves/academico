package RN;

import java.util.List;

import dao.CursoDAO;
import dao.CursoDAOHibernate;

import modelo.Curso;
/**
 * @author http://javaes.wordpress.com/
 * */
public class CursoRN 
{
	
private static CursoDAO cursoDAO;
	
	public static void salvar(Curso curso) throws Exception 
	{
		cursoDAO = new CursoDAOHibernate();
		cursoDAO.salvar(curso);
	}

	public static void deletar(Curso curso) throws Exception 
	{
		cursoDAO = new CursoDAOHibernate();
		cursoDAO.deletar(curso);
	}

	public static Curso buscarCursoID(long id) throws Exception 
	{
		cursoDAO = new CursoDAOHibernate();
		return (Curso)cursoDAO.buscarCursoID(id);
	}

	public static List<Curso> listar() throws Exception 
	{
		cursoDAO = new CursoDAOHibernate();
		return cursoDAO.listar();
	}
	
	public static boolean verificaExistencia(long id) throws Exception
	{
		cursoDAO = new CursoDAOHibernate();
		return 		cursoDAO.verificaExistencia(id);
	}

}
