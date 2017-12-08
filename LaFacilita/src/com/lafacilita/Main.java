package com.lafacilita;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static float inicio;
	static float fin;
	static float intervalo;
	static float x;
	static String informacion;

	public static void main(String[] args) {
		
		String cad = "";
		Scanner lector = new Scanner(System.in);
		boolean bandera = false;
		
		do{
			try{
				System.out.print("Defina el inicio: ");
				cad = lector.nextLine();
				inicio = Float.valueOf(cad); //Conviertes la cadena a float
				System.out.print("Defina el intervalo: ");
				cad = lector.nextLine();
				intervalo = Float.valueOf(cad);
				System.out.print("\n");
				operarFuncion2();
				guardarArchivo();
				
			}catch(NumberFormatException ex)
			{
				/*
				 * Manejar la posible excepcion para asegurarse
				 * de que estamos ingresando un numero
				 */
				System.out.println("Valor no válido, vuelva a intentar...");
				continue;//Regresas al comienzo del do
			}
			bandera = true;
		}while(!bandera);
		
	}

	public static void operarFuncion2() {
		informacion = "";
		
		int cont = 0;
		double y = 0;
		x = inicio;
		int i = 0;//Variable para mortra la iteracion correspondiente
		do {
			y = (Math.pow(x, 2)) + 1;
			System.out.println((i+1)+" - X: " + String.format("%.4f", x) + " Y: " + String.format("%.4f", y)); //Redondear con la cantidad especifica de decimales
			/*La idea es guardar todo en un string para despues escribirlo a un archivo de texto*/
			informacion += (i+1)+" - X: " + String.format("%.4f", x) + " Y: " + String.format("%.4f", y)+"\n";
			x += intervalo;
			i++;
		} while (x < 25);
	
	}
	
	public static void guardarArchivo()
	{
		File file;
		//Clase buffer de escritura
		FileOutputStream fop;
		file = new File("/Users/Javier/Desktop/Generation/Semana 11 04-12-17/mi_archivo.txt");
		try {
			//Instanciar al buffer de escritura y pasarle el archivo
			fop = new FileOutputStream(file);//Agregamos esta linea primero despues el try and catch
			if(!file.exists()) //Si no existe el archivo
			{
				file.createNewFile();
			}
			//Arreglo de tipo de dato byte
			byte[] misBytes = informacion.getBytes();
			//Escribit esos bytes en el archivo
			fop.write(misBytes);
			//Limpiar el buffer
			fop.flush();
			//Cerrar el buffer
			fop.close();
			System.out.println("\nArchivo creado");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}
}