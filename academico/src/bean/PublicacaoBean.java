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

import modelo.Aluno;
import modelo.Orientador;
import modelo.Publicacao;

@ManagedBean
@SessionScoped
public class PublicacaoBean {

	private Publicacao publicacao = new Publicacao();
	private List<Publicacao> lista;
	private Constantes constantes = new Constantes();
	private long idOrientador;
	private List<Orientador> orientadores;
	private long idAluno;
	private List<Aluno> alunos;
	public String tipo;

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public List<Publicacao> getLista() throws Exception {
		if(this.lista == null)
		{
			this.lista = PublicacaoRN.listar();
		}
		return lista;
	}	
	
	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}
	
	
	public long getIdOrientador() {
		return idOrientador;
	}

	public void setIdOrientador(long idOrientador) {
		this.idOrientador = idOrientador;
	}
	
	
	public List<Orientador> getOrientadores() throws Exception {
		return OrientadorRN.listar();
	}

	public void setOrientadores(List<Orientador> orientadores) {
		this.orientadores = orientadores;
	}
	
	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}
	
	public List<Aluno> getAlunos() throws Exception {
		return AlunoRN.listar();
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String salvar()
	{
		try 
		{
			PublicacaoRN.salvar(publicacao);
			this.lista = null;
		} 
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Erro a Salvar Publicação"));
			return null;
		}
		return "/listaPublicacao?faces-redirect=true";
	}
	
	public String excluir()
	{
		try 
		{
			PublicacaoRN.deletar(publicacao);
			this.lista = null;
		} 
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("curso", new FacesMessage("Erro ao excluir Publicação"));
			return null;
		}
		return "/listaPublicacao?faces-redirect=true";
	}
	
	public void novo(){
		this.publicacao = new Publicacao();
	}
	
	public String editar(){
		return "/publicacao?faces-redirect=true";
	}
	
	public void gravarOrientador(){
		
	}
	
	public String novoOrientador(){
		return "orientador?faces-redirect=true";
	}
	
	public void gravarAluno(){
		
	}
	
	public String novoAluno(){
		return "aluno?faces-redirect=true";
	}
}
