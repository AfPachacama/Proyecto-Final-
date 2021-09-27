//Declaracion de Paquete

package main;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import clases.Libro;
import clases.Operaciones;

public class Main {

		

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; 
        int cont=0;
        int contl=0;
        Operaciones op=new Operaciones();
        
 
        while (!salir) {
        	System.out.println("=============================================");
        	System.out.println("\tSISTEMA BIBLIOTECARIO UCE");
        	System.out.println("=============================================");
            System.out.println("Como desea ingresar:");
            System.out.println("1. Estudiante");
            System.out.println("2. Bibliotecario");
            System.out.println("3. Salir");
 
            try {
         
                System.out.println("Selecciona una opcion: ");
                opcion = teclado.nextInt();
                int opcion2;
                switch (opcion) {
                    case 1:
                    	boolean salir2=false;
                    	while(!salir2){
                    	System.out.println("=============================================");
                        System.out.println("\tESTUDIANTE");
                        System.out.println("=============================================");
                        System.out.println("1. Consultar Libros");
                        System.out.println("2. Reservar Libros"); 
                        System.out.println("3. Salir"); 
                        System.out.println("Selecciona una opcion: ");
                        opcion2 = teclado.nextInt();                        
	                        if(opcion2==1){
	                        	System.out.println("=============================================");
	                            System.out.println("\tCONSULTAR LIBROS");
	                            System.out.println("=============================================");
	                            teclado.nextLine();
	                        	System.out.println("Ingrese el nombre o autor del libro"); 
			                    String palabra = teclado.nextLine();		                    
								op.buscarLibros(palabra);                     	
	                        }else if(opcion2==2){
	                        	System.out.println("=============================================");
	                            System.out.println("\tRESERVAR LIBROS");
	                            System.out.println("=============================================");
	                            teclado.nextLine();
	                        	System.out.println("Ingrese el codigo del libro"); 
	                        	int codigoLibro = teclado.nextInt();	
		                        System.out.println("Ingrese la cedula del usuario"); 
				                int cedula = teclado.nextInt();	
				                op.ReservarLibro(codigoLibro, cedula);
		                    }else if(opcion2==3){
		                        	salir2=true;
		                    }
                    	}
                    	break;
                    case 2:
                    	boolean salir3=false;
                    	while(!salir3){
                        System.out.println("Bienvenido, que desea realizar");
                        System.out.println("1. Ingresar un libro");
                        System.out.println("2. Prestar Libro");
                        System.out.println("3. Aplazar fecha de entrega");
                        System.out.println("4. Salir"); 
                        opcion = teclado.nextInt();
                       
                    	
                        switch (opcion) {
						case 1:
							Libro li=op.ingresarDatosLibro();
							op.insertarLibros(li);
							break;
						case 2:
							System.out.println("=============================================");
                            System.out.println("\tPRESTAMO LIBRO");
                            System.out.println("=============================================");
                            teclado.nextLine();
                        	System.out.println("Ingrese el codigo del libro"); 
                        	int codigoLibro = teclado.nextInt();
							op.PrestarLibro(codigoLibro);
							break;
						case 3:
							System.out.println("=============================================");
                            System.out.println("\tAPLAZAMIENTO FECHA LIBRO");
                            System.out.println("=============================================");
                            teclado.nextLine();
                        	System.out.println("Ingrese el codigo del libro"); 
                        	int codigoLibro2 = teclado.nextInt();	
	                        System.out.println("Ingrese la cedula del usuario"); 
			                int cedula = teclado.nextInt();	
			                op.AplazarLibro(codigoLibro2, cedula);
						case 4:
							salir3=true;
						}
                    }
                    break;
                        
                    case 3:
                    	salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                        
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                teclado.next();
            }
        }
	}

}



