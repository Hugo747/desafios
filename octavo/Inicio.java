package octavo;

import java.util.ArrayList;

/**
 * Inicio del programa.
 * 
 * @author Daniel Corval�n
 * @version 1.0
 */
public class Inicio {
    
  public static void main(String[] args) {
    
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
    //Creacionn de cliente para efectos de testing
    Cliente cliente = new Cliente("17399074K", "Daniel Corval�n", 7777);
    listaClientes.add(cliente);
    cliente.abrirCuentaCorriente();
    cliente.abrirTarjetaCredito();
    cliente.getCuentaCorriente().abonar(220000);
    
    Menu.Login(listaClientes);
  }
}
