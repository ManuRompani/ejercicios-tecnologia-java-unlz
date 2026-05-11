package models;

import utils.Randomizador;

public class Rectangulo  {

	private double base;
	private double altura;	
	
	public Rectangulo(String nombre, double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	
	
	public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public double getArea() {
		return this.getBase() * this.getAltura();
	}

	public double getPerimetro() {
		return 2 * (this.getBase() + this.getAltura());
	}
	
	public static Rectangulo getRandom() {
		Randomizador r = new Randomizador();
		String nombre = r.getNombre();
		int base = r.getInt(1, 100);
		int altura = r.getInt(1, 100);
		
		Rectangulo rec = new Rectangulo(nombre, base, altura);	
		
		return rec;
		
		
		
	}
	

	@Override
	public String toString() {
		return "Rectangulo [Base=" + getBase() +
				", Altura=" + getAltura() +
				", Area=" + getArea()
				+ ", Perimetro=" +	getPerimetro() ;
	}






}
