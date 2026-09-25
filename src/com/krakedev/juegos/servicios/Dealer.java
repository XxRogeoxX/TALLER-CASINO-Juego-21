package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;

public class Dealer {
	private ArrayList<Carta> naipe;

	// === CONSTRUCTOR ===

	public Dealer() {
		naipe = new ArrayList<>(); // 1. Primero se crea la lista
		generarNaipe(); // 2. Luego se llena con las 52 cartas
	}

	// === GETTERS Y SETTERS ===

	public ArrayList<Carta> getNaipe() {
		return naipe;
	}

	public void setNaipe(ArrayList<Carta> naipe) {
		this.naipe = naipe;
	}

	// === MÉTODOS ===

	public void generarNaipe() {
		// Listas auxiliares con los palos y los valores posibles
		ArrayList<String> palos = new ArrayList<>();
		palos.add("T");
		palos.add("CN");
		palos.add("D");
		palos.add("CR");

		ArrayList<String> valores = new ArrayList<>();
		valores.add("A");
		for (int i = 2; i <= 10; i++) {
			valores.add(i + ""); // convierte el número a String: "2", "3", ... "10"
		}
		valores.add("J");
		valores.add("Q");
		valores.add("K");

		// Por cada palo se crean las 13 cartas: 4 palos x 13 valores = 52
		for (String palo : palos) {
			for (String valor : valores) {
				Carta carta = new Carta(valor, palo);
				naipe.add(carta);
			}
		}
	}

	public void imprimirNaipe() {
		for (Carta carta : naipe) {
			carta.imprimir();
		}
	}

	public int generarAleatorio(int maximo) {
		return (int) (Math.random() * (maximo + 1));
	}

	public Carta entregarCarta() {
		int posicion = generarAleatorio(naipe.size() - 1);
		Carta carta = naipe.get(posicion);
		naipe.remove(posicion);
		return carta;
	}
}