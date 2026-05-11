package utils;

import java.util.List;
import java.util.Scanner;

import interfaces.IComunicador;


public class ComunicadorConsola implements IComunicador{
	
	private Scanner sc;

	@Override
	public void enviar(String mensaje) {
		System.out.println(mensaje);
	}

	@Override
	public String recibir(String mensaje) {
		return sc.next();
	}

	@Override
	public <T> void imprimirLista(List<T> e) {
		int i = 1;
		for (T  item : e) {
			System.out.println(i +". " + item);
			i++;
		}
		this.enviar("---------------------------------");
	}

	@Override
	public void enviarNum(int numero) {
		System.out.println(numero);
	}


}