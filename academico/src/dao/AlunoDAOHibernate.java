package dao;

import java.util.List;

import modelo.Aluno;

public class AlunoDAOHibernate implements AlunoDAO{

	@Override
	public void salvar(Aluno aluno) throws Exception 
	{
		InsertUpdate.salvar(aluno);
	}

	@Override
	public void deletar(Aluno aluno) throws Exception {
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		obj.deletaAssociativa("curso_aluno","idAluno",aluno.getIdAluno());
		InsertUpdate.deletar(aluno);
	}

	@Override
	public Aluno buscarAlunoID(long id) throws Exception {
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return (Aluno)obj.buscarObjectID(id, "idAluno");
	}

	@Override
	public Aluno buscarAlunoMatricula(String matricula) throws Exception {
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return (Aluno)obj.buscarObjectID(matricula, "matricula");
	}

	@Override
	public Aluno buscarAlunoCPF(String cpf) throws Exception {
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return (Aluno)obj.buscarObjectUnique(cpf, "cpf");
	}

	@Override
	public List<Aluno> listar() throws Exception {
		ObterObject<Aluno> obj = new  ObterObject<Aluno>(new Aluno());
		return obj.listar();
	}

}
