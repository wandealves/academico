package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory	sessionFactory	= buildSessionFactory();
	private static SessionFactory buildSessionFactory() 
	{
		try 
		{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			return cfg.buildSessionFactory(registry);
		} 
		catch (Throwable e) 
		{
			System.out.println("Criao inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
