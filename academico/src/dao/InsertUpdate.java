package dao;

import org.hibernate.*;

import util.HibernateUtil;
/**
 * @author http://javaes.wordpress.com/
 * */
public class InsertUpdate 
{
	
	private static Session session; 
    private static Transaction transacao;
    
    public static void salvar(Object obj) throws Exception
    {
         try
        {
            session                                     = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao                                   = session.beginTransaction();
            session.saveOrUpdate(obj);
            transacao.commit();
        }
        catch(Exception erro)
        {
            throw new Exception(erro.getMessage());
        }
        finally
        {
            try
            {
                if(session!= null && session.isOpen())
                    session.close();
            }
            catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
    }
    
    public static void atualizar(Object obj) throws Exception
    {
         try
        {
            session                                     = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao                                   = session.beginTransaction();
            session.update(obj);
            transacao.commit();
        }
        catch(Exception erro)
        {
            throw new Exception(erro.getMessage());
        }
        finally
        {
            try
            {
                if(session.isOpen())
                    session.close();
            }
            catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
    }
    
    public static void deletar(Object obj) throws Exception
    {
         try
        {
            session                                     = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao                                   = session.beginTransaction();
            session.delete(obj);
            transacao.commit();
        }
        catch(Exception erro)
        {
            throw new Exception(erro.getMessage());
        }
        finally
        {
            try
            {
                if(session.isOpen())
                    session.close();
            }
            catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
    }

}
