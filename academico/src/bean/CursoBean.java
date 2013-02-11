package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import RN.CursoRN;
import modelo.Curso;
@ManagedBean
@SessionScoped
public class CursoBean {
	
	private Curso curso = new Curso();
	private List<Curso> lista;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getLista() throws Exception {
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
		} 
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Erro a Salvar Curso"));
			return null;
		}
		return "/listaCurso?faces-redirect=true";
	}
	
	public String excluir()
	{
		try 
		{
			CursoRN.deletar(curso);
			this.lista = null;
		} 
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Erro ao excluir Curso"));
			return null;
		}
		return "/listaCurso?faces-redirect=true";
	}
	
	public void novo(){
		this.curso = new Curso();
	}
	
	public String editar(){
		return "/curso?faces-redirect=true";
	}
}
