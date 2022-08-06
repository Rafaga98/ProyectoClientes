package servicio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import modelo.Cliente;
import servicio.ClienteServicio;

public abstract class Exportador extends ClienteServicio{

	public Exportador(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}
	public Exportador() {}
	
	public abstract void exportar(String fileName, List<Cliente> listaClientes) throws IOException;
	
	public abstract void crearCarpeta(String fileName);
	
	public abstract void crearArchivo(String nombreArchivo);
}


