package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class ArchivoServicio extends Exportador{

	public ArchivoServicio(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}
	
	
	public abstract void cargarDatos(String fileName);
	
	
}
