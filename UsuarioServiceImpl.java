package co.edu.sena.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Usuario;
import co.edu.sena.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario save(Usuario userNew) {
		
		return usuarioRepository.save(userNew);
	}

	@Override
	public String login(String user, String password) {
		
		Usuario usuario = usuarioRepository.findByUsuario(user);
		
		if(usuario == null) {
			return "Usuario no encontrado.";
		}
		if(!usuario.getContraseña().equals(password)) {
			return "Contraseña incorrecta.";
		}
		return "Inicio de sesión exitoso.";
	}

}
