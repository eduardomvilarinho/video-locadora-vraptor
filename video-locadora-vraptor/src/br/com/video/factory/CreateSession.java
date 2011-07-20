package br.com.video.factory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CreateSession implements ComponentFactory<Session> {
	
	private final SessionFactory factory;
	private Session session;
	
	public CreateSession(SessionFactory factory) {
		System.out.println("Construi o CreateSession");
		this.factory = factory;
	}
	
	@PostConstruct
	public void openSession(){
		this.session = this.factory.openSession();
	}
	
	@Override
	public Session getInstance() {
		return this.session;
	}
	
	@PreDestroy
	public void closeSession() {
		this.session.close();
	}

}
