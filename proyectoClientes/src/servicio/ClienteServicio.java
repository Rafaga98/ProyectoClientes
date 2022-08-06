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
		
		for(Iterator<Cliente> iterador = getListaClientes().iterator(); iterador.hasNext();) {
			Cliente producto = (Cliente)iterador.next();
			System.out.println("PRODUCTO");
			System.out.println("Nombre Articulo: "+ producto);
		}
		 
	}

		
}
