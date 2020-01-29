package decimo;

import java.util.ArrayList;
import java.util.Scanner;

import decimo.Cliente;

public class Menu {
	
	  public static int buscar(String rut, String clave, ArrayList<Cliente> listaClientes) {
		    for(Cliente cliente: listaClientes) {
		      if(cliente.rut.equals(rut) && cliente.password.equals(clave)) {
		        return listaClientes.indexOf(cliente);
		      }
		    }
		    return -1;
		  }
	
	 public static Cliente Login(ArrayList<Cliente> listaClientes) {
		    boolean ingreso = false;
		    String rut;
		    String clave;
		    Cliente usuario = null;
		    
		    Scanner input = new Scanner(System.in);
		    
		    while(ingreso == false) {
		      System.out.println("Ingrese rut");
		      rut = input.nextLine();
		      System.out.println("Ingrese clave de acceso");
		      clave = input.nextLine();

		      int ubicacion = buscar(rut, clave, listaClientes);
		      if(ubicacion != -1) {
		        usuario = listaClientes.get(ubicacion);
		        System.out.println("Bienvenido, " + usuario.nombre);
		        ingreso = true;
		        continue;
		      } else {
		        System.out.println("Combinaci�n incorrecta");
		      }
		    }
		    
		    return usuario;

		    
		  }
	
    public static int Inicio() {
   	
		int num;
		
		while(true) {
		Scanner sc = new Scanner(System.in);
		
    	System.out.println("�Qu� desea hacer?");
    	System.out.println("1.- Buscar art�culo");
    	System.out.println("2.- Reservar art�culo");
    	System.out.println("3.- Salir.");
		
		num = sc.nextInt();
		
			if(num > 0 && num < 5) {
				break;
			}
		}
		
		return num;
    }
    
	public static Recurso buscarArticulo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa el nombre del art�culo a buscar");
		String nombre = sc.nextLine();		
		nombre = nombre.trim().toLowerCase();
		Recurso recurso = Recurso.buscar(nombre);
		
		return recurso;
	}
	
	public static String reservarArticulo(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa el c�digo del art�culo a reservar");
		int codigo = sc.nextInt();
		
		Recurso recurso = Recurso.buscarPorCodigo(codigo);
		
		if(recurso == null) {
			return "No existe un art�culo con ese c�digo";
		}
		
		boolean listo = Recurso.reservar(recurso, cliente);
		
		if (listo == true) {
			return "Has reservado " + recurso.nombre;
		} else {
			if (recurso.prestadoA == cliente) {
				return "Ya reservaste este art�culo.";
			} else {
				return "El libro ha sido reservado a otro usuario";
			}
		}
	}
}
