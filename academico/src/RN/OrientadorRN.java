package RN;

import java.util.List;

import modelo.Orientador;
import dao.OrientadorDAO;
import dao.OrientadorDAOHibernate;

public class OrientadorRN 
{
	private static OrientadorDAO daoOrientador;
	
	public static void salvar(Orientador orientador) throws Exception 
	{
		daoOrientador = new OrientadorDAOHibernate();
		daoOrientador.salvar(orientador);
	}

	public static void deletar(Orientador orientador) throws Exception 
	{
		daoOrientador = new OrientadorDAOHibernate();
		daoOrientador.deletar(orientador);
	}

	public static Orientador buscarOrientadorID(long id) throws Exception 
	{
		daoOrientador = new OrientadorDAOHibernate();
		return daoOrientador.buscarOrientadorID(id);
	}

	public static Orientador buscarOrientadorCPF(String cpf) throws Exception 
	{
		daoOrientador = new OrientadorDAOHibernate();
		return daoOrientador.buscarOrientadorCPF(cpf);
	}

	public static List<Orientador> listar() throws Exception 
	{
		daoOrientador = new OrientadorDAOHibernate();
		return daoOrientador.listar();
	}
}
