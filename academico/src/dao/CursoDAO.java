package dao;

import java.util.List;

import modelo.Curso;

public interface CursoDAO {
	
	void salvar(Curso curso) throws Exception;
	void deletar(Curso curso) throws Exception;
	Curso buscarCursoID(long id) throws Exception;
	List<Curso> listar() throws Exception;

}
