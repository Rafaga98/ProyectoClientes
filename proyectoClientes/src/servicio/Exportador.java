package servicio;
import java.util.List;

import modelo.Cliente;
import servicio.ClienteServicio;

public abstract class Exportador extends ClienteServicio{

	public Exportador(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}
	
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
	}
	
}
