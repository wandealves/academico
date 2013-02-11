package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Orientador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4780292770415688469L;
	@Id
    @GeneratedValue
	private long idOrientador;
	private String nome;
	private String cpf;
	private String instituicao;
	private String titulacao;
	
	public Orientador(){}

	public long getIdOrientador() {
		return idOrientador;
	}

	public void setIdOrientador(long idOrientador) {
		this.idOrientador = idOrientador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + (int) (idOrientador ^ (idOrientador >>> 32));
		result = prime * result
				+ ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((titulacao == null) ? 0 : titulacao.hashCode());
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
		Orientador other = (Orientador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (idOrientador != other.idOrientador)
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (titulacao == null) {
			if (other.titulacao != null)
				return false;
		} else if (!titulacao.equals(other.titulacao))
			return false;
		return true;
	}
	
	

}
