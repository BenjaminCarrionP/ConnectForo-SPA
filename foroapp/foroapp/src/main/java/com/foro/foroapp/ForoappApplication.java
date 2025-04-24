package com.foro.foroapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.foro.foroapp.Controller.UsuarioController;

@SpringBootApplication
public class ForoappApplication implements CommandLineRunner{
	private final UsuarioController usuarioController;

	
	public ForoappApplication(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}


	public static void main(String[] args) {
		SpringApplication.run(ForoappApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		usuarioController.menuInicio();
	}

}
