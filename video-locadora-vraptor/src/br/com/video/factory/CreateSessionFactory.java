package br.com.video.factory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class CreateSessionFactory implements ComponentFactory<SessionFactory> {

	private SessionFactory factory;
	
	@PostConstruct
	public void openFactory(){
		Configuration configuration = new Configuration();
		configuration.configure();
		this.factory = configuration.buildSessionFactory();
	}
	
	@Override
	public SessionFactory getInstance() {
		return this.factory;
	}
	
	@PreDestroy
	public void closeFactory() {
		this.factory.close();
	}

}