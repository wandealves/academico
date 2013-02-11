package dao;

import java.util.List;

import modelo.Publicacao;

public interface PublicacaoDAO {
	
	void salvar(Publicacao publicacao) throws Exception;
	void deletar(Publicacao publicacao) throws Exception;
	Publicacao buscarPublicacaoID(long id) throws Exception;
	List<Publicacao> listar() throws Exception;

}
