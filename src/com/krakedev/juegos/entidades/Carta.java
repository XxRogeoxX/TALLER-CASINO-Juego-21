package com.krakedev.juegos.entidades;

public class Carta {
	private String valor;
	private int valorJuego;
	private String palo;

	// === CONSTRUCTOR ===

	public Carta(String valor, String palo) {
		this.valor = valor;
		this.palo = palo;
		// valorJuego no se asigna aquí: queda en 0 hasta que Juego21 lo cargue
	}

	// === GETTERS Y SETTERS ===

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getValorJuego() {
		return valorJuego;
	}

	public void setValorJuego(int valorJuego) {
		this.valorJuego = valorJuego;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	// === IMPRIMIR ===

	public void imprimir() {
		String mensaje = "Valor: " + valor + ", Palo: " + palo + ", Valor de juego: " + valorJuego;
		System.out.println(mensaje);
	}
}