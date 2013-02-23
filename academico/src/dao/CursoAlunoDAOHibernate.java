package dao;

import java.util.List;

import modelo.CursoAluno;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;

import util.HibernateUtil;
/**
 * @author http://javaes.wordpress.com/
 * */
public class CursoAlunoDAOHibernate  implements CursoAlunoDAO
{
	private Session session; 
	private Transaction transacao;
	  
	@Override
	public List<CursoAluno> lista() throws Exception 
	{
		List<CursoAluno> lista 	= null;
		try
       {
          this.session = HibernateUtil.getSessionFactory().getCurrentSession();
          this.transacao = this.session.beginTransaction();
          String sql		= "SELECT DISTINCT curso_aluno.idAluno,curso_aluno.idCurso,";
          sql				+="aluno.nome as nomeAluno, curso.nome as nomeCurso";
          sql				+=" FROM curso_aluno ";
          sql				+=" INNER JOIN curso ON curso_aluno.idCurso = curso.idCurso ";
          sql				+=" INNER JOIN aluno ON curso_aluno.idAluno = aluno.idAluno ";
          sql				+=" ORDER BY curso.nome DESC ";
          SQLQuery query                                             = this.session.createSQLQuery(sql);

          query.addScalar("nomeCurso");
          query.addScalar("nomeAluno");
          query.addScalar("idCurso",LongType.INSTANCE);
          query.addScalar("idAluno",LongType.INSTANCE);
          query.setResultTransformer( Transformers.aliasToBean( CursoAluno.class ) );

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
