package dao;

import java.util.List;
import modelo.Curso;

public class CursoDAOHibernate implements CursoDAO {

	@Override
	public void salvar(Curso curso) throws Exception {
		InsertUpdate.salvar(curso);
	}

	@Override
	public void deletar(Curso curso) throws Exception {
		InsertUpdate.deletar(curso);
	}

	@Override
	public Curso buscarCursoID(long id) throws Exception {
		ObterObject<Curso> obj = new  ObterObject<Curso>(new Curso());
		return (Curso)obj.buscarObjectID(id, "idCurso");
	}

	@Override
	public List<Curso> listar() throws Exception {
		ObterObject<Curso> obj = new  ObterObject<Curso>(new Curso());
		return obj.listar();
	}

}
