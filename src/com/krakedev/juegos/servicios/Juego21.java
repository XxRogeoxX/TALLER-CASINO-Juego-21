package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {
	private ArrayList<Jugador> jugadores = new ArrayList<>();
	private Dealer dealer;

	// === GETTERS Y SETTERS ===

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	// === MÉTODOS ===

	public void cargarValores() {
		for (Carta carta : dealer.getNaipe()) {
			String valor = carta.getValor();

			if (valor.equals("A")) {
				carta.setValorJuego(11);
			} else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
				carta.setValorJuego(10);
			} else {
				carta.setValorJuego(Integer.parseInt(valor));
			}
		}
	}

	public void inicializar() {
		dealer = new Dealer();
		cargarValores();
	}

	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	public void reiniciarJugadores() {
		for (Jugador jugador : jugadores) {
			jugador.reiniciar();
		}
	}

	public void repartirCarta(Jugador jugador) {
		Carta carta = dealer.entregarCarta();
		jugador.recibirCarta(carta);
	}

	public void repartirRonda() {
		for (Jugador jugador : jugadores) {
			repartirCarta(jugador);
		}
		calcularTotal();
	}

	public void calcularTotal() {
		for (Jugador jugador : jugadores) {
			int suma = 0;
			for (Carta carta : jugador.getCartas()) {
				suma += carta.getValorJuego();
			}
			jugador.setPuntajeCartas(suma);
		}
	}

	public ArrayList<Jugador> validarGanador() {
		ArrayList<Jugador> ganadores = new ArrayList<>();

		for (Jugador jugador : jugadores) {
			if (jugador.getPuntajeCartas() == 21) {
				ganadores.add(jugador);
			}
		}

		return ganadores;
	}

	public ArrayList<Jugador> jugar() {
		ArrayList<Jugador> ganadores = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			repartirRonda();
			ganadores = validarGanador();

			if (ganadores.size() > 0) {
				break;
			}
		}

		return ganadores;
	}
}