package dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import com.sun.xml.internal.ws.org.objectweb.asm.Type;

import util.HibernateUtil;

import modelo.PublicacaoAlunoOrientador;

public class PublicacaoAlunoOrientadorDAOHibernate implements PublicacaoAlunoOrientadorDAO{

	  private Session session; 
	  private Transaction transacao;
	  
	@Override
	public List<PublicacaoAlunoOrientador> lista() throws Exception {
		List<PublicacaoAlunoOrientador> lista 	= null;
		try
        {
           this.session = HibernateUtil.getSessionFactory().getCurrentSession();
           this.transacao = this.session.beginTransaction();
           String sql		= "SELECT publicacao.idPublicacao ,publicacao.titulo,publicacao.tipo,";
           sql				+="aluno.nome as nomeAluno,orientador.nome as nomeOrientador";
           sql				+=" FROM publicacao ";
           sql				+=" INNER JOIN publicacao_aluno ON publicacao.idPublicacao = publicacao_aluno.idPublicacao ";
           sql				+=" INNER JOIN aluno ON publicacao_aluno.idAluno = aluno.idAluno ";
           sql				+=" INNER JOIN orientador ON publicacao.idOrientador = orientador.idOrientador ";
           sql				+=" ORDER BY publicacao.dataPublicacao DESC ";
           SQLQuery query                                             = this.session.createSQLQuery(sql);

           query.addScalar("titulo");
           query.addScalar("tipo");
           query.addScalar("nomeAluno");
           query.addScalar("nomeOrientador");
           query.addScalar("idPublicacao",LongType.INSTANCE);
           query.setResultTransformer( Transformers.aliasToBean( PublicacaoAlunoOrientador.class ) );

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
}
