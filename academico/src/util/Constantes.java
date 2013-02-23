package util;
/**
 * @author http://javaes.wordpress.com/
 * */
public class Constantes 
{	
	public static class Sexo
	{
		private String descricao;
		private byte tipo;
		public Sexo(String descricao, byte tipo)
		{
			this.descricao = descricao;
			this.tipo = tipo;
		}
		public String getDescricao()
		{
			return descricao;
		}
		public byte getTipo()
		{
			return tipo;
		}
	}
	
	public static class Titulacao
	{
		private String nome;
		
		public Titulacao(String nome){
			this.nome = nome;
		}
		
		public String getNome(){
			return this.nome;
		}
	}
	
	public static class TipoPublicacao
	{
		private String nome;
		
		public TipoPublicacao(String nome){
			this.nome = nome;
		}
		
		public String getNome(){
			return this.nome;
		}
	}
	
	public Sexo[] getSexos() 
	{	 
		Sexo[] sexos = new Sexo[2];
		sexos[0] = new Sexo("Masculino", (byte)1);
		sexos[1] = new Sexo("Feminino", (byte)2);
		return sexos;
	}
	
	public Titulacao[] getTitulacoes(){
		String[] vet ={"Graduação","pós-graduação","Mestrado","Doutorado"};
		Titulacao[] titulacoes = new Titulacao[vet.length];
		for(int i=0;i<vet.length;i++){
			titulacoes[i] =  new Titulacao(vet[i]);
		}
		return titulacoes;
	}
	
	public TipoPublicacao[] getTipoPublicacao(){
		String[] vet ={"TCC","Monografia","Artigo","Tutorial"};
		TipoPublicacao[] tipoPublicacoes = new TipoPublicacao[vet.length];
		for(int i=0;i<vet.length;i++){
			tipoPublicacoes[i] =  new TipoPublicacao(vet[i]);
		}
		return tipoPublicacoes;
	}
}
