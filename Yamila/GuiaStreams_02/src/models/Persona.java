package models;

import utils.Randomizador;

public class Persona {

	private String nombre;
	private String apellido;
	private int edad;
	private double peso;
	private double estatura;

	public static Persona getRandom() {
		Randomizador r = new Randomizador();
		return new Persona(r.getNombre(), r.getApellido(), r.getInt(15, 80), r.getDouble(45, 120), r.getDouble(1.3, 2.1));

	}

	public Persona(String nombre, String apellido, int edad, double peso, double estatura) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.peso = peso;
		this.estatura = estatura;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getEstatura() {
		return this.estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", peso=" + peso
				+ ", estatura=" + estatura + "]";
	}

	public boolean isMenor() {
		return this.getEdad() < 18;
	}

}
