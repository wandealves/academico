package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import util.Constantes;

import RN.AlunoRN;
import RN.OrientadorRN;
import RN.PublicacaoRN;

import modelo.Orientador;
/**
 * @author http://javaes.wordpress.com/
 * */
@ManagedBean
@SessionScoped
public class OrientadorBean 
{	
	private Orientador orientador = new Orientador();
	private List<Orientador> lista;
	private Constantes constantes = new Constantes();
	private String titulacao;
	
	public String salvar()
	{
		this.orientador.setTitulacao(titulacao);
		try 
		{
			if(this.orientador != null)
			{
				OrientadorRN.salvar(orientador);
				FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Orientador Salvo com sucesso!"));
			}
		} 
		catch (Exception e)
		{
			FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Erro a Salvar Orientador"));
			return null;
		}
		return null;
	}
	
	public void excluir()
	{
		try 
		{
			if(PublicacaoRN.buscaOrientadorPublicacao(orientador.getIdOrientador()))
				FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Não foi possível excluir, pois existe publicação relacionada."));
			else
			{
				if(AlunoRN.buscaOrientadorAluno(orientador.getIdOrientador()))
				{
					FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Não foi possível excluir, pois existe aluno relacionada."));
				}
				else
				{
					OrientadorRN.deletar(orientador);
					this.orientador = new Orientador();
					this.constantes = new Constantes();
					this.lista = null;
				}
			}
		} 
		catch (Exception e) 
		{
			FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Erro ao excluir Orientador"));
		}
	}
	
	public String novo()
	{
		return "orientador?faces-redirect=true";
	}
	
	public String editar()
	{
		return "orientador?faces-redirect=true";
	}
	
	public Orientador getOrientador() 
	{
		return orientador;
	}
	
	public void setOrientador(Orientador orientador) 
	{
		this.orientador = orientador;
	}
	
	public List<Orientador> getLista() throws Exception 
	{
		if(this.lista == null)
		{
			this.lista = OrientadorRN.listar();
		}
		return lista;
	}
	
	public Constantes getConstantes() 
	{
		return constantes;
	}
	
	public void setConstantes(Constantes constantes) 
	{
		this.constantes = constantes;
	}
	
	public String getTitulacao() 
	{
		return titulacao;
	}
	
	public void setTitulacao(String titulacao) 
	{
		this.titulacao = titulacao;
	}

}
