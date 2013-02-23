package dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;

import util.HibernateUtil;
import modelo.Orientador;
import modelo.Publicacao;
import modelo.PublicacaoAlunoOrientador;

public class PublicacaoDAOHibernate implements PublicacaoDAO{
	private Session session; 
	private Transaction transacao;
	
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
	
	@Override
	public List listaID(long id) throws Exception {
		List<PublicacaoAlunoOrientador> lista 	= null;
		try
        {
           this.session = HibernateUtil.getSessionFactory().getCurrentSession();
           this.transacao = this.session.beginTransaction();
           String sql		= "SELECT idAluno FROM publicacao_aluno";
           sql				+=" WHERE idPublicacao = "+id;
           
           SQLQuery query                                             = this.session.createSQLQuery(sql);

           lista 												   = query.list();
        }
        catch(Exception erro)
        {
        	System.out.println("ERRO:"+erro.getMessage());
        }
        finally
        {
            try
            {
                if(this.session.isOpen())
                    this.session.close();
            }
            catch(Exception e)
            {
            }
        }
        return lista;
	}

	@Override
	public List<Publicacao> buscaOrientadorPublicacao(long id) throws Exception {
		ObterObject<Publicacao> obj = new  ObterObject<Publicacao>(new Publicacao());
		return obj.buscaPorIdRelacionamento(id,"idOrientador");
	}

}
