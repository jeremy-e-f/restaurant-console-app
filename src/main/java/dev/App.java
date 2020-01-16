package dev;

import dev.ihm.Menu;


import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
    	
    	// Création du contexte Spring
    	  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
    	  // récupération du bean Menu
    	  Menu menu = context.getBean(Menu.class);
    	  menu.afficher();
    	  // fermeture du Scanner
    	  context.getBean(Scanner.class).close();
    	  // fermeture du contexte Spring
    	  context.close();

    }
}
