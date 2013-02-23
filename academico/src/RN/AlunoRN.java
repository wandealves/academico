package RN;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Aluno;
import modelo.Publicacao;
import dao.AlunoDAO;
import dao.AlunoDAOHibernate;
import dao.PublicacaoDAOHibernate;
/**
 * @author http://javaes.wordpress.com/
 * */
public class AlunoRN 
{
	private static AlunoDAO alunoDAO;
	
	public static void salvar(Aluno aluno) throws Exception 
	{
		alunoDAO = new AlunoDAOHibernate();
		alunoDAO.salvar(aluno);
	}

	public static void deletar(Aluno aluno) throws Exception 
	{
		alunoDAO = new AlunoDAOHibernate();
		alunoDAO.deletar(aluno);
	}

	public static Aluno buscarAlunoID(long id) throws Exception 
	{
		alunoDAO = new AlunoDAOHibernate();
		return (Aluno)alunoDAO.buscarAlunoID(id);
	}

	public static Aluno buscarAlunoMatricula(String matricula) throws Exception 
	{
		alunoDAO = new AlunoDAOHibernate();
		return (Aluno)alunoDAO.buscarAlunoMatricula(matricula);
	}

	public static Aluno buscarAlunoCPF(String cpf) throws Exception 
	{
		alunoDAO = new AlunoDAOHibernate();
		return (Aluno)alunoDAO.buscarAlunoCPF(cpf);
	}

	public static List<Aluno> listar() throws Exception 
	{
		alunoDAO = new AlunoDAOHibernate();
		return alunoDAO.listar();
	}
	
	public  Calendar parseData(String data){
		try
		{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		}catch(Exception e){
		throw new IllegalArgumentException(e);
		}
	}
	
	public static void verificaExistencia(long id) throws Exception 
	{
		alunoDAO = new AlunoDAOHibernate();
		if(alunoDAO.verificaExistencia(id, "curso_aluno", "idAluno"))
		{
			throw new Exception("Não foi possível deletar o aluno,possui curso relacionado.");
		}
		if(alunoDAO.verificaExistencia(id, "publicacao_aluno", "idAluno"))
		{
			throw new Exception("Não foi possível deletar o aluno,possui publicação relacionada.");
		}
	}
	
	public static boolean buscaOrientadorAluno(long id)throws Exception 
	{
		alunoDAO = new AlunoDAOHibernate();
		List<Aluno> lista = alunoDAO.buscaOrientadorAluno(id);
		if(lista.size() > 0)
			return true;
		else
			return false;
	}
	
}
