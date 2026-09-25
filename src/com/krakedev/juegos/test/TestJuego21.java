package com.krakedev.juegos.test;

import java.util.ArrayList;

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

		// ============================
		// PRIMERA PRUEBA: una sola partida
		// ============================
		System.out.println("========== PRIMERA PRUEBA ==========");
		ArrayList<Jugador> ganadores = juego.jugar();

		for (Jugador jugador : juego.getJugadores()) {
			jugador.imprimir();
		}

		System.out.println("Ganadores: " + ganadores.size());
		for (Jugador ganador : ganadores) {
			System.out.println("¡Ganó " + ganador.getNickname() + " con " + ganador.getPuntajeCartas() + " puntos!");
		}

		// ============================
		// SEGUNDA PRUEBA: repetir hasta que haya ganadores (máx. 10 intentos)
		// ============================
		System.out.println("\n========== SEGUNDA PRUEBA ==========");
		for (int intento = 1; intento <= 10; intento++) {
			System.out.println("--- Intento " + intento + " ---");

			// Se reinicia todo: dealer con 52 cartas de nuevo, y jugadores en 0 puntos sin cartas
			juego.inicializar();
			juego.reiniciarJugadores();

			ganadores = juego.jugar();

			for (Jugador jugador : juego.getJugadores()) {
				jugador.imprimir();
			}

			if (ganadores.size() > 0) {
				System.out.println("¡Hubo ganador(es) en el intento " + intento + "!");
				for (Jugador ganador : ganadores) {
					System.out.println("Ganador: " + ganador.getNickname() + " con " + ganador.getPuntajeCartas() + " puntos");
				}
				break;
			} else {
				System.out.println("Sin ganadores en este intento.");
			}
		}
	}
}