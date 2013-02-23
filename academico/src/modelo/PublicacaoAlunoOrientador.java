package modelo;
/**
 * @author http://javaes.wordpress.com/
 * */
public class PublicacaoAlunoOrientador {
	
	private String titulo;
	private String tipo;
	private String nomeOrientador;
	private String nomeAluno;
	private Long idPublicacao;

	public PublicacaoAlunoOrientador(){}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNomeOrientador() {
		return nomeOrientador;
	}


	public void setNomeOrientador(String nomeOrientador) {
		this.nomeOrientador = nomeOrientador;
	}


	public String getNomeAluno() {
		return nomeAluno;
	}


	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}


	public Long getIdPublicacao() {
		return idPublicacao;
	}


	public void setIdPublicacao(Long idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	
	
}
