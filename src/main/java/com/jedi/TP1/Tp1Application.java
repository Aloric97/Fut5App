package com.jedi.TP1;

import com.jedi.TP1.Controllers.MenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp1Application implements CommandLineRunner {


	//inyectamos nuestra dependencia a la clase main
	@Autowired
	MenuPrincipal menuPrincipal;

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);

	}


	//Para evitar que el archivo principal este acoplado con un menu, cree otra clase extra con anotacion "component" que nos sirve para que nuestra app, detecte el componente creado con el menu de opciones
	@Override
	public void run(String... args) throws Exception {
		menuPrincipal.showMenuPrincipal();
	}
}
