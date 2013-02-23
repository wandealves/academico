package modelo;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
/**
 * @author http://javaes.wordpress.com/
 * */
@Entity
public class Publicacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -79875297018191341L;
	@Id
    @GeneratedValue
	private long idPublicacao;
	private String titulo;
	@Temporal(TemporalType.DATE)
	private Calendar dataPublicacao = Calendar.getInstance();
	private String tipo;
	@ManyToOne
    @JoinColumn(name="idOrientador")
	private Orientador orientador;
	@ManyToMany
	@JoinTable(name="publicacao_aluno",joinColumns={@JoinColumn(name="idPublicacao")},inverseJoinColumns={@JoinColumn(name="idAluno")})
	private Set<Aluno> alunos = new HashSet<Aluno>();
	public Publicacao(){}

	public long getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(long idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Orientador getOrientador() {
		return orientador;
	}

	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result
				+ ((dataPublicacao == null) ? 0 : dataPublicacao.hashCode());
		result = prime * result + (int) (idPublicacao ^ (idPublicacao >>> 32));
		result = prime * result
				+ ((orientador == null) ? 0 : orientador.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Publicacao other = (Publicacao) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (dataPublicacao == null) {
			if (other.dataPublicacao != null)
				return false;
		} else if (!dataPublicacao.equals(other.dataPublicacao))
			return false;
		if (idPublicacao != other.idPublicacao)
			return false;
		if (orientador == null) {
			if (other.orientador != null)
				return false;
		} else if (!orientador.equals(other.orientador))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
