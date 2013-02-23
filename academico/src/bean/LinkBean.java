package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * @author http://javaes.wordpress.com/
 * */
@ManagedBean
@SessionScoped
public class LinkBean {
	public String listaLinkAluno()
	{
		return "listaAluno?faces-redirect=true";
	}
	public String listaLinkOrientador()
	{
		return "listaOrientador?faces-redirect=true";
	}
	public String listaLinkCurso()
	{
		return "listaCurso?faces-redirect=true";
	}
	public String listaLinkPublicacao()
	{
		return "listaPublicacao?faces-redirect=true";
	}
	public String listaLinkPesquisa()
	{
		return "listaPesquisa?faces-redirect=true";
	}
	
	public String linkAluno()
	{
		return "aluno?faces-redirect=true";
	}
	public String linkOrientador()
	{
		return "orientador?faces-redirect=true";
	}
	public String linkCurso()
	{
		return "curso?faces-redirect=true";
	}
	public String linkPublicacao()
	{
		return "publicacao?faces-redirect=true";
	}
	
	public String linkCursoAluno()
	{
		return "cursoaluno?faces-redirect=true";
	}
	
	public String listaLinkCursoAluno()
	{
		return "listaCursoAluno?faces-redirect=true";
	}
}
