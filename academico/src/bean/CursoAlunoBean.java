package bean;
import modelo.Aluno;
import modelo.Curso;
import modelo.CursoAluno;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import RN.AlunoRN;
import RN.CursoAlunoRN;
import RN.CursoRN;
import RN.PublicacaoRN;
/**
 * @author http://javaes.wordpress.com/
 * */
@ManagedBean
@SessionScoped
public class CursoAlunoBean 
{
	private List<Curso> cursos;
	private long idCursoSeleciondao;
	private String nomeCursoSelecionado;
	private long idAluno;
	private List<Aluno> alunos;
	private List<Aluno> alunosSelecionados = new ArrayList();
	private Curso curso;
	private List<CursoAluno> lista;
	
	public List<Curso> getCursos() throws Exception 
	{
		return CursoRN.listar();
	}

	public void setCursos(List<Curso> cursos) 
	{
		this.cursos = cursos;
	}

	public long getIdCursoSeleciondao()
	{
		return idCursoSeleciondao;
	}

	public void setIdCursoSeleciondao(long idCursoSeleciondao) 
	{
		this.idCursoSeleciondao = idCursoSeleciondao;
	}

	public String getNomeCursoSelecionado() 
	{
		return nomeCursoSelecionado;
	}

	public void setNomeCursoSelecionado(String nomeCursoSelecionado) 
	{
		this.nomeCursoSelecionado = nomeCursoSelecionado;
	}
	
	public long getIdAluno()
	{
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

	public List<Aluno> getAlunosSelecionados() {
		return alunosSelecionados;
	}

	public void setAlunosSelecionados(List<Aluno> alunosSelecionados) {
		this.alunosSelecionados = alunosSelecionados;
	}
	
	public List<CursoAluno> getLista() throws Exception 
	{
		if(this.lista == null)
		{
			this.lista = CursoAlunoRN.listar();
		}
		return this.lista;
	}

	public void setLista(List<CursoAluno> lista) 
	{
		this.lista = lista;
	}

	public void gravarCurso()
	{
		if(this.idCursoSeleciondao > 0)
		{
			try 
			{
				curso 							= CursoRN.buscarCursoID(this.idCursoSeleciondao);
				this.nomeCursoSelecionado 		= curso.getNome();
			} catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("cursoaluno", new FacesMessage("Selecione um curso."));
		}
	}
	
	public String novoCurso()
	{
		return "curso?faces-redirect=true";
	}
	
	public void gravarAluno()
	{
		
		try 
		{
			if(idAluno > 0){
			Aluno aluno = AlunoRN.buscarAlunoID(idAluno);
			this.alunosSelecionados.add(aluno);
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage("cursoaluno", new FacesMessage("Selecione um aluno."));
			}
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String novoAluno()
	{
		return "aluno?faces-redirect=true";
	}
	
	public String novo()
	{
		this.nomeCursoSelecionado = "";
		this.alunosSelecionados = new ArrayList();
		return "cursoaluno?faces-redirect=true";
	}
	
	public void salvar()
	{
		if(this.curso != null && this.alunosSelecionados.size() > 0)
		{
			Set<Aluno> lista = PublicacaoRN.carregaAlunos(this.alunosSelecionados);
			this.curso.setAlunos(lista);
			try 
			{
				CursoRN.salvar(curso);
				this.lista = null;
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FacesContext.getCurrentInstance().addMessage("cursoaluno", new FacesMessage("Aluno(s) cadastrado no curso."));
		}
	}
}
