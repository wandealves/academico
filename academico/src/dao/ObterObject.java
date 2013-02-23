package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;
import modelo.PublicacaoAlunoOrientador;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;

import util.HibernateUtil;

public class ObterObject <T>{
	
	 
    T objeto;
    private Session session; 
    private Transaction transacao;
    
    public ObterObject(T objeto)
    {
        this.objeto = objeto;
    }
     /* Como usar
      * ObterRegistros<Usuario> ob = new  ObterRegistros(new Usuario());
        try {
            List lista = ob.listar();
            Iterator it = lista.iterator();
            
            while(it.hasNext())
            {
                Usuario us = (Usuario) it.next();
                System.out.println(us.getNome());
            }*/
     public List<T> listar() throws Exception
    {
        List<T> objGen                                          = null;
        try
        {
            session                                             = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao                                           = session.beginTransaction();
            Criteria filtro                                     = session.createCriteria(objeto.getClass());
            objGen                                              = filtro.list();
            transacao.commit();
        }
        catch(Exception erro)
        {
           if(transacao.isActive())
               transacao.rollback();
           throw new Exception(erro.getMessage());
        }
        finally
        {
            try
            {
            }
            catch(Exception erro)
            {
                if(session.isOpen())
                    session.close();
                throw new Exception(erro.getMessage());
            }
        }
        return objGen;
    }
     
        public List<T> listarFiltro(String email) throws Exception
    {
        List<T> objGen                                          = null;
        try
        {
            session                                             = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao                                           = session.beginTransaction();
            Criteria filtro                                     = session.createCriteria(objeto.getClass()).add(Restrictions.eq("email", email));
            objGen                                              = filtro.list();
            transacao.commit();
        }
        catch(Exception erro)
        {
           if(transacao.isActive())
               transacao.rollback();
           throw new Exception(erro.getMessage());
        }
        finally
        {
            try
            {
            }
            catch(Exception erro)
            {
                if(session.isOpen())
                    session.close();
                throw new Exception(erro.getMessage());
            }
        }
        return objGen;
    }
        
        public Object buscarObjectID(long id,String campo) throws Exception
        {
            Object obj = null;
            try
            {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
                this.transacao = this.session.beginTransaction();
                Criteria filtro =this.session.createCriteria(objeto.getClass());
                filtro.add(Restrictions.eq(campo,id));
                obj = filtro.uniqueResult();
                this.transacao.commit();
                
            }
            catch(Exception erro)
            {
                if(this.transacao.isActive())
                    this.transacao.rollback();
                throw new Exception(erro.getMessage());
            }
            finally
            {
                try
                {
                    if(this.session.isOpen())
                    this.session.close();
                }
                catch(Exception erro)
                {
                   throw new Exception(erro.getMessage()); 
                }
            }
            
            return obj;
        }
        
        public Object buscarObjectID(String id,String campo) throws Exception
        {
            Object obj = null;
            try
            {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
                this.transacao = this.session.beginTransaction();
                Criteria filtro =this.session.createCriteria(objeto.getClass());
                filtro.add(Restrictions.eq(campo,id));
                obj = filtro.uniqueResult();
                this.transacao.commit();
                
            }
            catch(Exception erro)
            {
                if(this.transacao.isActive())
                    this.transacao.rollback();
                throw new Exception(erro.getMessage());
            }
            finally
            {
                try
                {
                    if(this.session.isOpen())
                    this.session.close();
                }
                catch(Exception erro)
                {
                   throw new Exception(erro.getMessage()); 
                }
            }
            
            return obj;
        }
        
        
        public Object buscarObjectUnique(String valor,String campo) throws Exception
        {
            Object obj = null;
            try
            {
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
                this.transacao = this.session.beginTransaction();
                Criteria filtro =this.session.createCriteria(objeto.getClass());
                filtro.add(Restrictions.eq(campo,valor));
                obj = filtro.uniqueResult();
                this.transacao.commit();
                
            }
            catch(Exception erro)
            {
                if(this.transacao.isActive())
                    this.transacao.rollback();
                throw new Exception(erro.getMessage());
            }
            finally
            {
                try
                {
                    if(this.session.isOpen())
                    this.session.close();
                }
                catch(Exception erro)
                {
                   throw new Exception(erro.getMessage()); 
                }
            }
            
            return obj;
        }
        
        public void deletaAssociativa(String tabelaAssociativa,String filtro,long id) {
             try
             {
            	 //SELECT * FROM EMPLOYEE WHERE id = :employee_id
            	 if(id > 0 && !tabelaAssociativa.isEmpty() && !filtro.isEmpty()){
                this.session = HibernateUtil.getSessionFactory().getCurrentSession();
                this.transacao = this.session.beginTransaction();
                String sql                                                 = "DELETE FROM "+tabelaAssociativa+" WHERE "+filtro+" = :id";
                SQLQuery query                                             = this.session.createSQLQuery(sql);
                query.setParameter("id", id);
                this.transacao.commit();
            	 }
             }
             catch(Exception erro)
             {
                 if(this.transacao.isActive())
                     this.transacao.rollback();
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
        }
        
        public boolean verificaExistencia(long id,String nomeTabela,String campo) throws Exception {
    		List lista 	= new ArrayList();
    		boolean flag = false;
    		try
            {
               this.session 	= HibernateUtil.getSessionFactory().getCurrentSession();
               this.transacao 	= this.session.beginTransaction();
               String sql		= "SELECT DISTINCT idAluno";
               sql				+=" FROM "+ nomeTabela;
               sql				+=" WHERE " + campo+"="+id;
             
               SQLQuery query                                             = this.session.createSQLQuery(sql);
               lista 												   = query.list();
               if(lista.size() > 0)
               {
            	   flag = true;
               }
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
            return flag;
    	}
        
        public List<T> buscaPorIdRelacionamento(long id,String campo) throws Exception
        {
            List<T> objGen                                          = null;
            try
            {
                session                                             = HibernateUtil.getSessionFactory().getCurrentSession();
                transacao                                           = session.beginTransaction();
                Criteria filtro                                     = session.createCriteria(objeto.getClass()).add(Restrictions.eq(campo, id));
                objGen                                              = filtro.list();
                transacao.commit();
            }
            catch(Exception erro)
            {
               if(transacao.isActive())
                   transacao.rollback();
               throw new Exception(erro.getMessage());
            }
            finally
            {
                try
                {
                }
                catch(Exception erro)
                {
                    if(session.isOpen())
                        session.close();
                    throw new Exception(erro.getMessage());
                }
            }
            return objGen;
        }
}
