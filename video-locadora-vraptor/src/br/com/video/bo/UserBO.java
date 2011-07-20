package br.com.video.bo;

import java.util.List;

import br.com.video.dao.InterfaceDAO;
import br.com.video.entity.User;

/**
 * Classe que sera responsavel pelas regras de negocio
 * dos usuarios
 * @author johny
 *
 */

public class UserBO implements InterfaceBO<User> {

	private final InterfaceDAO<User> userDao;
	
	// CONSTRUTOR
	public UserBO(InterfaceDAO<User> userDao){
		this.userDao = userDao;
	}
	
	// METODO GETTERS E SETTERS
	public InterfaceDAO<User> getUserDao() {
		return userDao;
	}

	// DEMAIS METODOS
	@Override
	public List<User> consult(User user) {
		System.out.println("Funcionou!");
		return null;
	}
	
	public void message(){
		System.out.println("Estou no userbo.");
	}
}