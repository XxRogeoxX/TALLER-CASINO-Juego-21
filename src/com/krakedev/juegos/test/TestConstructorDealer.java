package com.krakedev.juegos.test;
 
import com.krakedev.juegos.servicios.Dealer;
 
public class TestConstructorDealer {
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
 
		dealer.imprimirNaipe();
 
		System.out.println("Total de cartas: " + dealer.getNaipe().size());
	}
}
