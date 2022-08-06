package servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Cliente;

public class ClienteServicio {
	List<Cliente> listaClientes = new ArrayList<>();

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}

	public void retornoListarClientes() {
		Iterator<Cliente> nombreIterator = listaClientes.iterator();
		while(nombreIterator.hasNext()){
			Cliente cliente = nombreIterator.next();
			System.out.println(cliente);
		}
	}
	
		
}
