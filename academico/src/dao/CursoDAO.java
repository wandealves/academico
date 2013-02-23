package dao;

import java.util.List;

import modelo.Curso;
/**
 * @author http://javaes.wordpress.com/
 * */
public interface CursoDAO 
{
	
	void salvar(Curso curso) throws Exception;
	void deletar(Curso curso) throws Exception;
	Curso buscarCursoID(long id) throws Exception;
	List<Curso> listar() throws Exception;
	boolean verificaExistencia(long id) throws Exception;
}
