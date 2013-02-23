package dao;

import java.util.List;

import modelo.CursoAluno;

/**
 * @author http://javaes.wordpress.com/
 * */
public interface CursoAlunoDAO 
{
	List<CursoAluno> lista() throws Exception;
}
