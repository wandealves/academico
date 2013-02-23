package dao;

import java.util.List;
import modelo.Publicacao;
/**
 * @author http://javaes.wordpress.com/
 * */
public interface PublicacaoDAO {
	
	void salvar(Publicacao publicacao) throws Exception;
	void deletar(Publicacao publicacao) throws Exception;
	Publicacao buscarPublicacaoID(long id) throws Exception;
	List<Publicacao> listar() throws Exception;
	List listaID(long id) throws Exception;
	List<Publicacao> buscaOrientadorPublicacao(long id)throws Exception;
}
