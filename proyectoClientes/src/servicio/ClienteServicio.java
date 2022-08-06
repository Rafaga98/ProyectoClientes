package servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Cliente;

public class ClienteServicio {
//creacion de lista
	List<Cliente> listaClientes = new ArrayList<>();
//constructor 
	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}
	public ClienteServicio() {
		
	}

//getter de listaClientes	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	
public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	//metodo recorre listaclientes y muestra
	public void retornoListarClientes() {
		for(Iterator iterador = listaClientes.iterator(); iterador.hasNext();) {
            String cliente = (String)iterador.next();
            System.out.println("Run del Cliente: " + cliente.codePointAt(0));
            System.out.println("Nombre del Cliente: " + cliente.codePointAt(1));
            System.out.println("Apellido del Cliente: " + cliente.codePointAt(2));
            System.out.println("Años como Cliente: " + cliente.codePointAt(3));
            
        }
	}

		
}
