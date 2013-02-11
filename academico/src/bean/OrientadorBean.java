package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import util.Constantes;

import RN.OrientadorRN;

import modelo.Orientador;

@ManagedBean
@SessionScoped
public class OrientadorBean {
	
	private Orientador orientador = new Orientador();
	private List<Orientador> lista;
	private Constantes constantes = new Constantes();
	private String titulacao;
	
	public String salvar(){
		
		this.orientador.setTitulacao(titulacao);
		try 
		{
			OrientadorRN.salvar(orientador);
		} 
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Erro a Salvar Orientador"));
			return null;
		}
		return "/listaOrientador?faces-redirect=true";
	}
	
	public void excluir(){
		try {
			OrientadorRN.deletar(orientador);
			this.orientador = new Orientador();
			this.constantes = new Constantes();
			this.lista = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Erro ao excluir Orientador"));
		}
	}
	
	public void novo(){
		this.orientador = new Orientador();
	}
	
	public String editar()
	{
		return "orientador?faces-redirect=true";
	}

	public Orientador getOrientador() {
		return orientador;
	}

	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}
	
	public List<Orientador> getLista() throws Exception {
		if(this.lista == null){
			this.lista = OrientadorRN.listar();
		}
		
		return lista;
	}

	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
}
