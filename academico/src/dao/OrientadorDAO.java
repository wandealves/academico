package dao;

import java.util.List;

import modelo.Orientador;
/**
 * @author http://javaes.wordpress.com/
 * */
public interface OrientadorDAO 
{
	void salvar(Orientador orientador) throws Exception;
	void deletar(Orientador orientador) throws Exception;
	Orientador buscarOrientadorID(long id) throws Exception;
	Orientador buscarOrientadorCPF(String cpf) throws Exception;
	List<Orientador> listar() throws Exception;
}
