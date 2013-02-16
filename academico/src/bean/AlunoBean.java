package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import util.Constantes;
import RN.AlunoRN;
import RN.OrientadorRN;
import modelo.Aluno;
import modelo.Orientador;
@ManagedBean
@SessionScoped
public class AlunoBean 
{
	private Aluno aluno = new Aluno();
	private long idOrientador;
	private Constantes constantes = new Constantes();
	private byte sexo;
	private List<Orientador> orientadores;
	private List<Aluno> listaAlunos;

	public Aluno getAluno() 
	{
		return aluno;
	}

	public void setAluno(Aluno aluno) 
	{
		this.aluno = aluno;
	}
	
	public long getIdOrientador() 
	{
		return idOrientador;
	}

	public List<Orientador> getOrientadores() throws Exception 
	{
		return OrientadorRN.listar();
	}
	
	public Constantes getConstantes() 
	{
		return constantes;
	}
	
	public List<Aluno> getListaAlunos() throws Exception
	{
		if(this.listaAlunos == null)
		{
			this.listaAlunos = AlunoRN.listar();
		}
		return this.listaAlunos;
	}
	
	public void gravarAluno()
	{
		try 
		{
			this.aluno.setSexo(sexo);
			AlunoRN.salvar(aluno);
		} catch (Exception e) 
		{
			FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Erro a Salvar Aluno"));
		}
		FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Aluno Salvo com Sucesso!"));
	}
	
	public void excluirAluno()
	{
		try 
		{
			AlunoRN.deletar(aluno);
			this.listaAlunos = null;
		} 
		catch (Exception e) 
		{
			FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Erro ao Excluir Aluno"));
		}
		FacesContext.getCurrentInstance().addMessage("orientador", new FacesMessage("Aluno Excluido com Sucesso!"));
	}
	
	public void novo()
	{
		this.aluno = new Aluno();
	}
	
	public String editar()
	{
		
		return "aluno?faces-redirect=true";
	}

	public void gravarOrientador() throws Exception
	{
		Orientador orientador = OrientadorRN.buscarOrientadorID(this.idOrientador);
		this.aluno.setOrientador(orientador);
	}
	
	public String novoOrientador(){
		
		return "orientador?faces-redirect=true";
	}

	public byte getSexo() {
		return sexo;
	}

	public void setSexo(byte sexo) {
		this.sexo = sexo;
	}

}
