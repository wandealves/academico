package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import RN.CursoRN;
import modelo.Curso;
/**
 * @author http://javaes.wordpress.com/
 * */
@ManagedBean
@SessionScoped
public class CursoBean 
{
	
	private Curso curso = new Curso();
	private List<Curso> lista;
	
	public Curso getCurso() 
	{
		return curso;
	}
	
	public void setCurso(Curso curso) 
	{
		this.curso = curso;
	}
	
	public List<Curso> getLista() throws Exception
	{
		if(this.lista == null)
		{
			this.lista = CursoRN.listar();
		}
		return lista;
	}	
		
	public String salvar()
	{
		try 
		{
			CursoRN.salvar(curso);
			this.lista = null;
			FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Curso salvo com sucesso!"));
		} 
		catch (Exception e) 
		{
			FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Erro a Salvar Curso"));
			return null;
		}
		return null;
	}
		
	public String excluir()
	{
		try 
		{
			if(CursoRN.verificaExistencia(curso.getIdCurso()))
			{
				FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Não foi possível excluir o curso, pois existe alunos cadastrado."));
				return null;
			}
			else
			{
				CursoRN.deletar(curso);
				this.lista = null;
				FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Curso excluido com sucesso."));
			}
		} 
		catch (Exception e)
		{
			FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Erro ao excluir Curso"));
			return null;
		}
		return "listaCurso?faces-redirect=true";
	}
		
	public String novo()
	{
		this.curso = new Curso();
		return "curso?faces-redirect=true";
	}
	
	public String editar()
	{
		return "curso?faces-redirect=true";
	}
}
