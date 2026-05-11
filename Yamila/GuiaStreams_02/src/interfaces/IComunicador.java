package interfaces;

import java.util.List;

public interface IComunicador{
	
	public abstract void enviar(String mensaje);
	public String recibir(String mensaje);
	
	public <T> void imprimirLista(List<T> e);
	
	
}
