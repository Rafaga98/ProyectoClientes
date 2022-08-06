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

//getter de listaClientes	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
//metodo recorre listaclientes y muestra
	public void retornoListarClientes() {
		Iterator<Cliente> nombreIterator = listaClientes.iterator();
		while(nombreIterator.hasNext()){
			Cliente cliente = nombreIterator.next();
			System.out.println(cliente);
		}
	}
	
		
}
