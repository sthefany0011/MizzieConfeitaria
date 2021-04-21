package com.mizzieconfeitaria.Mizzie.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mizzieconfeitaria.Mizzie.model.UserLogin;
import com.mizzieconfeitaria.Mizzie.model.Usuario;
import com.mizzieconfeitaria.Mizzie.service.UsuarioService;




@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private Usuario usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Authentication(@RequestBody Optional<UserLogin> user){
		return UsuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(UsuarioService.CadastrarUsuario(usuarioService));


}}