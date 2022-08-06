package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import servicio.*;
import modelo.Cliente;

public class ExportadorTxt extends Exportador{
	String nombreArchivo = "Cliente.txt";
	public ExportadorTxt(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void exportar(String nombreArchivo, List<Cliente> listaClientes) throws IOException {
		// TODO Auto-generated method stub
		File archivo = new File(this.nombreArchivo);
		FileWriter escribir = new FileWriter(archivo,true);
		BufferedWriter memoriaEscritura= new BufferedWriter(escribir);
		for(Iterator<Cliente> iterador = listaClientes.iterator(); iterador.hasNext();) {
			Cliente cliente = (Cliente)iterador.next();
			memoriaEscritura.write("-----------------------------------------");
			memoriaEscritura.newLine();
			memoriaEscritura.write("Nombre: "+cliente.getRunCliente());
			memoriaEscritura.newLine();
			memoriaEscritura.write("Precio: "+cliente.getNombreCliente());
			memoriaEscritura.newLine();
			memoriaEscritura.write("Codigo: "+cliente.getApellidoCliente());
			memoriaEscritura.newLine();
			memoriaEscritura.write("Codigo: "+cliente.getAniosCliente());
			memoriaEscritura.newLine();
			memoriaEscritura.write("Codigo: "+cliente.getNombreCategoria());
			memoriaEscritura.newLine();
			memoriaEscritura.write("-----------------------------------------");
		}
		
		memoriaEscritura.close();


	}
	@Override
	public void crearCarpeta(String fileName) {
		// TODO Auto-generated method stub
		File carpeta = new File(fileName);
		if(!carpeta.exists()) {
			try{
				carpeta.mkdirs();
				System.out.println("Carpeta Creada");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void crearArchivo(String nombreArchivo) {
		// TODO Auto-generated method stub
		File archivo = new File(this.nombreArchivo);
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
