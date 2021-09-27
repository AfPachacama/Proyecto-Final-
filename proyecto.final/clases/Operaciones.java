//Declaracion de Paquete

package clases;

//Declaracion de importacion Librerias y Clases
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import clases.Libro;


public class Operaciones {
	
	private int cont;
	Libro arrayLibros[]=new Libro[this.cont+1];
	ArrayList<Libro> arrayLibro=new ArrayList();
	Calendar calendar = Calendar.getInstance();
	//Datos iniciales
	Libro libro=new Libro(34,"Programacion I","Adam Bien",2007,"Libresa",567,50.5f,1726703357,"Reservado",calendar.getTime(),"Libro de trabajo","LSC2");
	Libro libro2=new Libro(45,"Programacion II","Adam Bien",2016,"Libresa",667,30.5f,0,"Disponible",null,"Libro de trabajo","LSC3");
	Libro libro3=new Libro(46,"Programacion III","Adam Bien",2016,"Libresa",1567,35.5f,172670337,"Prestado",calendar.getTime(),"Libro de trabajo","LSC4");
	Scanner sn = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public Operaciones(){
		arrayLibro.add(libro);
		arrayLibro.add(libro2);
		arrayLibro.add(libro3);	
	}
	public Libro ingresarDatosLibro() throws IOException{
		
		System.out.println("=============================================");
        System.out.println("\tINGRESAR LIBROS");
        System.out.println("=============================================");
        Libro li=new Libro();
		System.out.println("Ingrese el codigo del libro: ");			
		li.setCodigo(sn.nextInt());
		System.out.println("Ingrese el nombre del libro: ");	
		li.setNombre(br.readLine());
		System.out.println("Ingrese el autor del libro: ");			
		li.setAutor(br.readLine());
		System.out.println("Ingrese el año de publicacion: ");			
		li.setAnioPublicacion(sn.nextInt());
		System.out.println("Ingrese la Editorial del libro: ");			
		li.setEditorial(br.readLine());
		System.out.println("Ingrese la cantidad de paginas del libro: ");			
		li.setCantidadPaginas(sn.nextInt());
		System.out.println("Ingrese el precio del libro: ");			
		li.setPrecio(sn.nextFloat());
		System.out.println("Seleccione el tipo de libro \n 1. Libro de trabajo \n 2. Libro Lectura");	
		li.setEstado("Disponible");
		int opcion = sn.nextInt();
		if(opcion==1){
			li.setTipo("Libro de trabajo");
			System.out.println("Ingrese el codigo de autorizacion");
			li.setCodigoAutorizacion(br.readLine());
		}else if(opcion==2){
			li.setTipo("Libro de trabajo");
			System.out.println("Ingrese el tiempo de lectura en minutos");
			li.setTiempoLectura(sn.nextInt());		
		}	
		return li;		
	}
	public void insertarLibros(Libro l){
		arrayLibro.add(l);
		System.out.println("El libro se ha guardado Exitosamente");
										
	}	
	public void buscarLibros(String nombre){
		boolean conf=false;
		for (Libro libro : arrayLibro) {
			if(libro.getNombre().equals(nombre)){				
					System.out.println("Libro Encontrado con exito!!");
					String fecha;
					if(libro.getFechaEntrega()!=null){
						int year=libro.getFechaEntrega().getYear()+1900;
						int month=libro.getFechaEntrega().getMonth()+1;
						int day=libro.getFechaEntrega().getDate();
						fecha=day+"/"+month+"/"+year;
					}else{
						fecha=null;
					}
					System.out.println("===================================================================================================");
					System.out.println("Codigo: "+libro.getCodigo()+" - Nombre: "+libro.getNombre()+" - Autor: "+libro.getAutor()+" - Estado: "+libro.getEstado()+" - Fecha Entrega: "+fecha);	
					System.out.println("===================================================================================================\n");
					conf=true;
			}
		}
		if(conf==false){
			System.out.println("Libro no encontrado!");
		}
	}

	
	public void ReservarLibro(int codigo,long cedula){
		for (Libro libro : arrayLibro) {
			if(libro.getCodigo()== codigo){
				if(libro.getEstado().equals("Reservado") || libro.getEstado().equals("Prestado") ){
					System.out.println("El libro ya se encuentra reservado \n");
				}else{
					
//					Calendar es una clase de Java que nos permite manejar fechas de una manera distinta de como lo hacíamos con Date.
					calendar.add(Calendar.DAY_OF_MONTH,5);
					libro.setCedulaReserva(cedula);
					libro.setFechaEntrega(calendar.getTime());
					libro.setEstado("Reservado");
					System.out.println("Libro reservado con exito!! pase a retirarlo en la Biblioteca");
				}
			}			
		}
}
	
		public void PrestarLibro(int codigo) throws ParseException{
//			La sentencia throw se utiliza para lanzar explícitamente una excepción.
			boolean conf=false;
			for (Libro libro : arrayLibro) {
				if(libro.getCodigo()== codigo){
					if(libro.getEstado().equals("Reservado")){
						conf=true;
						String fecha;
						if(libro.getFechaEntrega()!=null){
							int year=libro.getFechaEntrega().getYear()+1900;
							int month=libro.getFechaEntrega().getMonth()+1;
							int day=libro.getFechaEntrega().getDate();
							fecha=day+"/"+month+"/"+year;
						}else{
							fecha=null;
						}
						System.out.println("===================================================================================================");
						System.out.println("Codigo: "+libro.getCodigo()+" - Nombre: "+libro.getNombre()+" - Estado: "+libro.getEstado()+" - Fecha Entrega: "+fecha+" -Reservado por: "+libro.getCedulaReserva());	
						System.out.println("===================================================================================================\n");
						System.out.println("\nSeleccione una opcion \n1. Prestar \n 2. No prestar");	
						int opcion = sn.nextInt();
						if(opcion==1){
							libro.setEstado("Prestado");
							sn.nextLine();
							System.out.println("Ingrese la fecha de prestamo en el formato dd/mm/yy");
							String fechaPrestamo=sn.nextLine();
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date date = formatter.parse(fechaPrestamo);
							calendar.setTime(date);
							libro.setFechaEntrega(calendar.getTime());
							System.out.println("Libro prestado con exito!!");
						}else if(opcion==2){
							System.out.println("Libro no prestado");		
						}
					}
				}
			}
			if(conf==false){
					System.out.println("El libro no se encuentra reservado\n");			
			}
		}
		
		public void AplazarLibro(int codigo,long cedula){
			boolean conf=false;
			for (Libro libro : arrayLibro) {
				if(libro.getCodigo()== codigo && libro.getCedulaReserva()==cedula){
					if(libro.getEstado().equals("Prestado")){
						conf=true;
						String fecha;
						if(libro.getFechaEntrega()!=null){
							int year=libro.getFechaEntrega().getYear()+1900;
							int month=libro.getFechaEntrega().getMonth()+1;
							int day=libro.getFechaEntrega().getDate();
							fecha=day+"/"+month+"/"+year;
						}else{
							fecha=null;
						}
						System.out.println("===================================================================================================");
						System.out.println("Codigo: "+libro.getCodigo()+" - Nombre: "+libro.getNombre()+" - Estado: "+libro.getEstado()+" - Fecha Entrega: "+fecha+" - Prestado a: "+libro.getCedulaReserva());	
						System.out.println("===================================================================================================\n");
						System.out.println("\nSeleccione una opcion \n1. Aplazar \n 2. No Aplazar");	
						int opcion = sn.nextInt();
						if(opcion==1){
							calendar.setTime(libro.getFechaEntrega());
							calendar.add(Calendar.DAY_OF_MONTH,5);
							libro.setFechaEntrega(calendar.getTime());
							System.out.println("La fecha de la entrega ha sido aplazado con exito");
						}else if(opcion==2){
							System.out.println("Libro no aplazado");		
						}
					}
				}
			}
			if(conf==false){
					System.out.println("El libro no ha sido encontrado, verifique que el codigo y la cedula sea la correcta\n");			
			}
		}	

}



