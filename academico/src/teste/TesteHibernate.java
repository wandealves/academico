package teste;

import dao.PublicacaoAlunoOrientadorDAO;
import dao.PublicacaoAlunoOrientadorDAOHibernate;

public class TesteHibernate {
	  public static void main(String[] args) 
	  {
		  PublicacaoAlunoOrientadorDAO dao = new PublicacaoAlunoOrientadorDAOHibernate();
		  try {
			dao.lista();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
}
