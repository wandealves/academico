package bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import util.Constantes;

import RN.AlunoRN;
import RN.OrientadorRN;
import RN.PublicacaoAlunoOrientadorRN;
import RN.PublicacaoRN;

import modelo.Aluno;
import modelo.Orientador;
import modelo.Publicacao;
import modelo.PublicacaoAlunoOrientador;

@ManagedBean
@SessionScoped
public class PublicacaoBean {

	private Publicacao publicacao = new Publicacao();
	private List<PublicacaoAlunoOrientador> lista;
	private Constantes constantes = new Constantes();
	private long idOrientadorSelecionado;
	private List<Orientador> orientadores;
	private long idAluno;
	private List<Aluno> alunos;
	private List<Aluno> alunosSelecionados = new ArrayList();
	public String tipo;
	private String nomeOrientadorSelecionado;
	private PublicacaoAlunoOrientador publicacaoAlunoOrientador = new PublicacaoAlunoOrientador();

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public List<PublicacaoAlunoOrientador> getLista() throws Exception {
		if(this.lista == null)
		{
			this.lista = PublicacaoAlunoOrientadorRN.listar();
		}
		return lista;
	}	
	
	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}
	
	
	public long getIdOrientadorSelecionado() {
		return idOrientadorSelecionado;
	}

	public void setIdOrientadorSelecionado(long idOrientador) {
		this.idOrientadorSelecionado = idOrientador;
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
	
	
	public List<Aluno> getAlunosSelecionados() {
		return alunosSelecionados;
	}

	public void setAlunosSelecionados(List<Aluno> alunosSelecionados) {
		this.alunosSelecionados = alunosSelecionados;
	}
	
	
	public String getNomeOrientadorSelecionado() {
		return nomeOrientadorSelecionado;
	}

	public void setNomeOrientadorSelecionado(String nomeOrientadorSelecionado) {
		this.nomeOrientadorSelecionado = nomeOrientadorSelecionado;
	}
	
	
	public PublicacaoAlunoOrientador getPublicacaoAlunoOrientador() {
		return publicacaoAlunoOrientador;
	}

	public void setPublicacaoAlunoOrientador(
			PublicacaoAlunoOrientador publicacaoAlunoOrientador) {
		this.publicacaoAlunoOrientador = publicacaoAlunoOrientador;
	}

	public void salvar()
	{
		try 
		{
		
			if(this.alunosSelecionados.size() == 0){
				FacesContext.getCurrentInstance().addMessage("publicacao", new FacesMessage("Adicione ao menos um aluno na publicação."));
				return;
			}
				if(publicacao.getOrientador() == null){
					FacesContext.getCurrentInstance().addMessage("publicacao", new FacesMessage("Adicione o orientador na publicação."));
					return;
				}
			publicacao.setAlunos(PublicacaoRN.carregaAlunos(this.alunosSelecionados));
			publicacao.setTipo(tipo);
			PublicacaoRN.salvar(publicacao);
			
			this.nomeOrientadorSelecionado = "";
			this.alunosSelecionados = null;
			this.publicacao = null;
			this.lista = null;
			FacesContext.getCurrentInstance().addMessage("publicacao", new FacesMessage("Publicação salva com sucesso!"));
		} 
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("publicacao", new FacesMessage("Erro a Salvar Publicação"));
		}
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
		this.publicacao = null;
		this.nomeOrientadorSelecionado = "";
		this.alunosSelecionados = null;
	}
	
	public String editar() throws NumberFormatException, Exception{
		this.publicacao 						= PublicacaoRN.buscarPublicacaoID(this.publicacaoAlunoOrientador.getIdPublicacao());
		this.nomeOrientadorSelecionado 			= this.publicacao.getOrientador().getNome();
		this.idOrientadorSelecionado 			= this.publicacao.getOrientador().getIdOrientador();
		this.alunosSelecionados 				= PublicacaoRN.listaID(publicacao.getIdPublicacao());
		return "/publicacao?faces-redirect=true";
	}
	
	public void gravarOrientador() throws Exception{
		
		if(this.idOrientadorSelecionado > 0){
			Orientador orientador = OrientadorRN.buscarOrientadorID(this.idOrientadorSelecionado);
			this.publicacao.setOrientador(orientador);
			this.nomeOrientadorSelecionado = orientador.getNome();
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage("publicacao", new FacesMessage("Selecione um orientador."));
			}
		
	}
	
	public String novoOrientador(){
		return "orientador?faces-redirect=true";
	}
	
	public void gravarAluno(){
		
		try 
		{
			if(idAluno > 0){
			Aluno aluno = AlunoRN.buscarAlunoID(idAluno);
			this.alunosSelecionados.add(aluno);
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage("publicacao", new FacesMessage("Selecione um aluno."));
			}
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String novoAluno(){
		return "aluno?faces-redirect=true";
	}
}
