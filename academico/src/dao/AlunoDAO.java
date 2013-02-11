package dao;

import java.util.List;

import modelo.Aluno;

public interface AlunoDAO {
	
	void salvar(Aluno aluno) throws Exception;
	void deletar(Aluno aluno) throws Exception;
	Aluno buscarAlunoID(long id) throws Exception;
	Aluno buscarAlunoMatricula(String matricula) throws Exception;
	Aluno buscarAlunoCPF(String cpf) throws Exception;
	List<Aluno> listar() throws Exception;
}
