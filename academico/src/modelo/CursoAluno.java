package modelo;
/**
 * @author http://javaes.wordpress.com/
 * */
public class CursoAluno 
{
	private long idAluno;
	private String nomeAluno;
	private String nomeCurso;
	private long idCurso;
	
	public CursoAluno(){}

	public long getIdAluno() 
	{
		return idAluno;
	}

	public void setIdAluno(long idAluno) 
	{
		this.idAluno = idAluno;
	}

	public String getNomeAluno() 
	{
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) 
	{
		this.nomeAluno = nomeAluno;
	}

	public String getNomeCurso() 
	{
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) 
	{
		this.nomeCurso = nomeCurso;
	}

	public long getIdCurso() 
	{
		return idCurso;
	}

	public void setIdCurso(long idCurso) 
	{
		this.idCurso = idCurso;
	}
}
