package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
/**
 * @author http://javaes.wordpress.com/
 * */
@Entity
public class Curso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7442417535932684661L;
	@Id
    @GeneratedValue
	private long idCurso;
	private String nome;
	@ManyToMany
	@JoinTable(name="curso_aluno",joinColumns={@JoinColumn(name="idCurso")},inverseJoinColumns={@JoinColumn(name="idAluno")})
	private Set<Aluno> alunos = new HashSet<Aluno>();
	
	public Curso(){}

	public long getIdCurso() 
	{
		return idCurso;
	}

	public void setIdCurso(long idCurso) 
	{
		this.idCurso = idCurso;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public Set<Aluno> getAlunos() 
	{
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) 
	{
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + (int) (idCurso ^ (idCurso >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (idCurso != other.idCurso)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	

	
}
