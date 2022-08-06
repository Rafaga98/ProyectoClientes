package servicio;

import java.util.List;
import java.io.File;
import java.io.IOException;

import modelo.Cliente;

public class ExportadorCsv extends Exportador{

	public ExportadorCsv(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearCarpeta(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearArchivo(String nombreArchivo) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
