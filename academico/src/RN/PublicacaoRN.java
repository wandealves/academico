package RN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import modelo.Aluno;
import modelo.Orientador;
import modelo.Publicacao;

import dao.*;

public class PublicacaoRN {

private static PublicacaoDAO publicacaoDAO;
	
	public static void salvar(Publicacao publicacao) throws Exception 
	{
		publicacaoDAO = new PublicacaoDAOHibernate();
		publicacaoDAO.salvar(publicacao);
	}

	public static void deletar(Publicacao publicacao) throws Exception 
	{
		publicacaoDAO = new PublicacaoDAOHibernate();
		publicacaoDAO.deletar(publicacao);
	}

	public static Publicacao buscarPublicacaoID(long id) throws Exception 
	{
		publicacaoDAO = new PublicacaoDAOHibernate();
		return (Publicacao)publicacaoDAO.buscarPublicacaoID(id);
	}

	public static List<Publicacao> listar() throws Exception 
	{
		publicacaoDAO = new PublicacaoDAOHibernate();
		return publicacaoDAO.listar();
	}
	
	public static Set<Aluno> carregaAlunos(List<Aluno> lista)
	{
		Iterator it = lista.iterator();
		Set<Aluno> alunos = new HashSet();
		while(it.hasNext())
		{
			Aluno al = (Aluno) it.next();
			
			if(alunos.contains(al) == false)
			{
				alunos.add(al);
			}
		}
		
		return alunos;
	}
	
	public static List<Aluno> listaID(long id) throws Exception 
	{
		List lista = new ArrayList();
		publicacaoDAO = new PublicacaoDAOHibernate();
		Iterator it = publicacaoDAO.listaID(id).iterator();
		while(it.hasNext())
		{
			Long idAluno = Long.parseLong(it.next().toString());
			Aluno aluno = AlunoRN.buscarAlunoID(idAluno);
			lista.add(aluno);
		}
		return lista;
	}
	
	public static boolean buscaOrientadorPublicacao(long id)throws Exception 
	{
		publicacaoDAO = new PublicacaoDAOHibernate();
		List<Publicacao> lista = publicacaoDAO.buscaOrientadorPublicacao(id);
		if(lista.size() > 0)
			return true;
		else
			return false;
	}
}
