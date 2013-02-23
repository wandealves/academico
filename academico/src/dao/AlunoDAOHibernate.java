package dao;

import java.util.List;

import RN.AlunoRN;
import RN.OrientadorRN;

import modelo.Aluno;
import modelo.Orientador;
/**
 * @author http://javaes.wordpress.com/
 * */
public class AlunoDAOHibernate implements AlunoDAO{

	@Override
	public void salvar(Aluno aluno) throws Exception 
	{
		InsertUpdate.salvar(aluno);
	}

	@Override
	public void deletar(Aluno aluno) throws Exception 
	{
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		InsertUpdate.deletar(aluno);
	}

	@Override
	public Aluno buscarAlunoID(long id) throws Exception
	{
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return (Aluno)obj.buscarObjectID(id, "idAluno");
	}

	@Override
	public Aluno buscarAlunoMatricula(String matricula) throws Exception
	{
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return (Aluno)obj.buscarObjectID(matricula, "matricula");
	}

	@Override
	public Aluno buscarAlunoCPF(String cpf) throws Exception 
	{
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return (Aluno)obj.buscarObjectUnique(cpf, "cpf");
	}

	@Override
	public List<Aluno> listar() throws Exception 
	{
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return obj.listar();
	}

	@Override
	public boolean verificaExistencia(long id, String nomeTabela, String campo)throws Exception 
	{
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return obj.verificaExistencia(id, nomeTabela, campo);
	}

	@Override
	public List<Aluno> buscaOrientadorAluno(long id) throws Exception 
	{
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		Orientador or = OrientadorRN.buscarOrientadorID(id);
		return obj.buscaPorIdRelacionamento(or,"orientador");
	}

}
