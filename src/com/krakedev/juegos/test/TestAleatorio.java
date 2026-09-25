package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestAleatorio {
	public static void main(String[] args) {
		Dealer dealer = new Dealer();

		int maximo = 10;
		boolean salioCero = false;
		boolean salioMaximo = false;

		for (int i = 0; i < 100; i++) {
			int numero = dealer.generarAleatorio(maximo);
			System.out.println("Número generado: " + numero);

			// Verificamos que nunca se pase del rango permitido
			if (numero < 0 || numero > maximo) {
				System.out.println("¡ERROR! Se salió del rango: " + numero);
			}

			if (numero == 0) {
				salioCero = true;
			}
			if (numero == maximo) {
				salioMaximo = true;
			}
		}

		System.out.println("¿Salió el 0 en algún momento? " + salioCero);
		System.out.println("¿Salió el " + maximo + " en algún momento? " + salioMaximo);
	}
}
