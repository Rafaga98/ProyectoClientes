package vista;
import java.util.Scanner;
import servicio.*;

public class menu {
	
	ClienteServicio clienteServicio;
	ArchivoServicio archivoServicio;
	ExportadorCsv exportarCsv;
	ExportadorTxt exportarTxt;
	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	
	Scanner leer = new Scanner(System.in);

	
	//Constructor
		public menu(ClienteServicio clienteServicio, ArchivoServicio archivoServicio, ExportadorCsv exportarCsv,
			ExportadorTxt exportarTxt, String fileName, String fileName1, Scanner leer) {
		//super();
		this.clienteServicio = clienteServicio;
		this.archivoServicio = archivoServicio;
		this.exportarCsv = exportarCsv;
		this.exportarTxt = exportarTxt;
		this.fileName = fileName;
		this.fileName1 = fileName1;
		this.leer = leer;
	}

	//getters y setters 
	public ClienteServicio getClienteServicio() {
		return clienteServicio;
	}

	public void setClienteServicio(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	public ArchivoServicio getArchivoServicio() {
		return archivoServicio;
	}

	public void setArchivoServicio(ArchivoServicio archivoServicio) {
		this.archivoServicio = archivoServicio;
	}

	public ExportadorCsv getExportarCsv() {
		return exportarCsv;
	}

	public void setExportarCsv(ExportadorCsv exportarCsv) {
		this.exportarCsv = exportarCsv;
	}

	public ExportadorTxt getExportarTxt() {
		return exportarTxt;
	}

	public void setExportarTxt(ExportadorTxt exportarTxt) {
		this.exportarTxt = exportarTxt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public Scanner getLeer() {
		return leer;
	}

	public void setLeer(Scanner leer) {
		this.leer = leer;
	}
	
	
	
	
	//metodos de negocio
	public void listarCliente() {
		
	}
	public void agregarCliente() {	
	}
	public void editarCliente() {	
	}
	public void importarDatos() {	
	}
	public void exportarDatos() {	
	}
	public void terminarPrograma() {
	}
}
