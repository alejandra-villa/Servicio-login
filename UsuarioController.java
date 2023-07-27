package co.edu.sena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.sena.models.entity.Usuario;
import co.edu.sena.models.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public Usuario registrar(@RequestBody Usuario userNew) {
		
		return usuarioService.save(userNew);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> iniciarSesion(@RequestBody Usuario user) {
		
		String mss = usuarioService.login(user.getUsuario(), user.getContraseña());
		return ResponseEntity.ok(mss);
	}
	
}
