package com.krakedev.juegos.test;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {
	public static void main(String[] args) {
		Juego21 juego = new Juego21();

		Jugador j1 = new Jugador("Mario");
		Jugador j2 = new Jugador("Andres");
		Jugador j3 = new Jugador("Sofia");

		juego.agregarJugador(j1);
		juego.agregarJugador(j2);
		juego.agregarJugador(j3);

		juego.inicializar();
		juego.repartirRonda();

		System.out.println("=== Cartas de cada jugador ===");
		for (Jugador jugador : juego.getJugadores()) {
			jugador.imprimir();
		}

		System.out.println("=== Naipe restante en el dealer ===");
		juego.getDealer().imprimirNaipe();
		System.out.println("Cartas restantes: " + juego.getDealer().getNaipe().size());
	}
}