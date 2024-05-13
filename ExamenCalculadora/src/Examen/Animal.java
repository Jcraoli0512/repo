package Examen;

public class Animal {
	 private String especie;
	 private int horasSueno;
	 private String nombre;
	 public Animal(String nombre, int horasSueno) {
	 especie = "Desconocida";
	 this.nombre = nombre;
	 this.horasSueno = horasSueno;
	 }
	 public void emitirSonido() {
	 System.out.println("El " + especie + " hace ruido.");
	 }
	 public double calcularVelocidadMedia(int distancia, int tiempo) {
	 return distancia / tiempo;
	 }
	 
	 public void dormir() {
	 System.out.println("Durmiendo durante " + horasSueno);
	 }

	 public void rugir() {
	 System.out.println("¡Grrr!");
	 }

	 public void moverCola() {
	 System.out.println(nombre+", mueve la cola");
	 }
	}
//Prueba de commit
