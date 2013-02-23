package dao;

import java.util.List;

import modelo.Orientador;
/**
 * @author http://javaes.wordpress.com/
 * */
public class OrientadorDAOHibernate implements OrientadorDAO
{

	@Override
	public void salvar(Orientador orientador) throws Exception 
	{
		InsertUpdate.salvar(orientador);
	}
	
	@Override
	public void deletar(Orientador orientador) throws Exception 
	{
		InsertUpdate.deletar(orientador);
	}
	
	@Override
	public Orientador buscarOrientadorID(long id) throws Exception 
	{
		ObterObject<Orientador> obj = new  ObterObject<Orientador>(new Orientador());
		return (Orientador)obj.buscarObjectID(id, "idOrientador");
	}
	
	@Override
	public Orientador buscarOrientadorCPF(String cpf) throws Exception
	{
		ObterObject<Orientador> obj = new  ObterObject<Orientador>(new Orientador());
		return (Orientador)obj.buscarObjectUnique(cpf, "cpf");
	}
	
	@Override
	public List<Orientador> listar() throws Exception 
	{
		ObterObject<Orientador> obj = new  ObterObject<Orientador>(new Orientador());
		return obj.listar();
	}

}
