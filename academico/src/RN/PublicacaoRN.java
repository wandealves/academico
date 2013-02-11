package RN;

import java.util.List;

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
}
