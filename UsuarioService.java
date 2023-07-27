package co.edu.sena.models.service;

import co.edu.sena.models.entity.Usuario;

public interface UsuarioService {
	
	public Usuario save(Usuario userNew);
	public String login(String user, String password);
}
