package dao;

import java.util.List;
import modelo.Publicacao;

public class PublicacaoDAOHibernate implements PublicacaoDAO{

	@Override
	public void salvar(Publicacao publicacao) throws Exception {
		InsertUpdate.salvar(publicacao);
	}

	@Override
	public void deletar(Publicacao publicacao) throws Exception {
		InsertUpdate.deletar(publicacao);
		
	}

	@Override
	public Publicacao buscarPublicacaoID(long id) throws Exception {
		ObterObject<Publicacao> obj = new  ObterObject<Publicacao>(new Publicacao());
		return (Publicacao)obj.buscarObjectID(id, "idPublicacao");
	}

	@Override
	public List<Publicacao> listar() throws Exception {
		ObterObject<Publicacao> obj = new  ObterObject<Publicacao>(new Publicacao());
		return obj.listar();
	}

}
