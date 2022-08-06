package vista;
import utilidades.Utilidad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;
import modelo.CategoriaEnum;
import servicio.*;

public class menu {

	ClienteServicio clienteServicio;
	ArchivoServicio archivoServicio;
	ExportadorCsv exportarCsv;
	ExportadorTxt exportarTxt;
	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";

	ArrayList<Cliente> clientes = new ArrayList<>();
	
	Utilidad utilidad = new Utilidad();
	
	Scanner leer = new Scanner(System.in);
	int opcion = 0;
	String respuesta;
	String ruta;

	public menu() {
	}

	// Constructor
	public menu(ClienteServicio clienteServicio, ArchivoServicio archivoServicio, ExportadorCsv exportarCsv,
			ExportadorTxt exportarTxt, String fileName, String fileName1, Scanner leer) {
		// super();
		this.clienteServicio = clienteServicio;
		this.archivoServicio = archivoServicio;
		this.exportarCsv = exportarCsv;
		this.exportarTxt = exportarTxt;
		this.fileName = fileName;
		this.fileName1 = fileName1;
		this.leer = leer;
	}

	// getters y setters
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

	// metodos de negocio

	public void iniciarMenu() throws IOException {
		do {
			System.out.println("1.- Listar Clientes");
			System.out.println("2.- Agregar Cliente");
			System.out.println("3.- Editar Cliente");
			System.out.println("4.- Cargar Datos");
			System.out.println("5.- Exportar Datos");
			System.out.println("6.- Salir");
			System.out.println("Ingrese una opcion: ");
			opcion = leer.nextInt();

			switch (opcion) {
			case 1: {
				listarCliente();
				break;
			}
			case 2: {
				agregarCliente();
				break;
			}
			case 3: {
				editarCliente();
				break;
			}
			case 4: {
				importarDatos();
				break;
			}
			case 5: {
				exportarDatos();
				break;
			}
			case 6: {
				terminarPrograma();
				break;
			}
			default:
				utilidad.mostrarMensaje();
				break;

			}

		} while (opcion != 6);

	}

	public void listarCliente() {
		System.out.println("-----------------Datos del Cliente----------------");
		ClienteServicio sc = new ClienteServicio();
		sc.retornoListarClientes(this.clientes);
		utilidad.tiempoEspera();
		utilidad.limpieza();
	}

	public void agregarCliente() {
		System.out.println("-----------------Crear Cliente----------------");
		System.out.println("Ingresa RUN del Cliente: ");
		String rut = leer.next();
		System.out.println("Ingresa Nombre del Cliente: ");
		String nombre = leer.next();
		System.out.println("Ingresa Apellido del Cliente: ");
		String apellido = leer.next();
		System.out.println("Ingresa Edad del Cliente: ");
		String edad = leer.next();
		
		System.out.println("-----------------------------------------------");

		Cliente cliente = new Cliente(rut, nombre, apellido, edad, CategoriaEnum.ACTIVO);

		this.clientes.add(cliente);
		// System.out.print(clientes);
		ClienteServicio scc = new ClienteServicio();
		scc.setListaClientes(clientes);
		System.out.println(cliente.toString());
		utilidad.tiempoEspera();
		utilidad.limpieza();
	}

	public void editarCliente() {

		System.out.println("-----------------Editar Cliente----------------");

		System.out.println("Ingrese RUN del Cliente a editar:");
		respuesta = leer.next();

		Cliente cliente = buscarClientePorRun(respuesta);

		if (cliente == null) {

			System.out.println("Rut no existe");
		} else {
			menuEditarCliente(cliente);
		}

		utilidad.tiempoEspera();
		utilidad.limpieza();
	}

	private Cliente buscarClientePorRun(String rutCliente) {

		for (Cliente cliente : this.clientes) {
			if (rutCliente.equals(cliente.getRunCliente())) { // compara rut con arreglo
				return cliente;
			}
		}

		return null;
	}

	private void menuEditarCliente(Cliente cliente) {

		do {
			System.out.println("Seleccione que desea hacer: ");
			System.out.println("1.-Cambiar el estado del Cliente");
			System.out.println("2.-Editar los datos ingresados del Cliente");
			System.out.println("Ingrese opcion: ");
			opcion = leer.nextInt();
			switch (opcion) {
			case 1:
				cambiarEstadoCliente(cliente);
				break;
			case 2:
				cambiarDatosCliente(cliente);
				utilidad.limpieza();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
				
			}
		}while (opcion<1||opcion>2);
	}

	private void cambiarEstadoCliente(Cliente cliente) {
		
		
		System.out.println("------Actualizando estado del Cliente "+ cliente.getNombreCliente()+" "+ cliente.getApellidoCliente());
		System.out.println("El estado actual es: "+ cliente.getNombreCategoria());
		System.out.println("¿Desea cambiar el estado?");
		System.out.println("1 - Si");
		System.out.println("2 - No");
		System.out.println("Ingrese opcion: ");
		opcion = leer.nextInt();
		do {
			switch(opcion){
				case 1:
					
					if(cliente.getNombreCategoria() == CategoriaEnum.ACTIVO) {
						cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
						System.out.println("Se cambio el estado correctamente a: "+cliente.getNombreCategoria());
					}else {
						cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
						
					}
					break;
				case 2:
					System.out.println("Se mantuvo el estado actual del Cliente");
					break;
				default:
					utilidad.mostrarMensaje();
					break;
			}
		}while(opcion <1 || opcion>2);
		utilidad.tiempoEspera();
		utilidad.limpieza();
		
		
	}
	
	private void cambiarDatosCliente(Cliente cliente) {
		
		System.out.println("------Actualizando estado del Cliente------");
		System.out.println("1.- El RUN del Cliente es: " + cliente.getRunCliente() );
		System.out.println("2.- El Nombre del Cliente es: "+ cliente.getNombreCliente());
		System.out.println("3.- El Apellido del Cliente es: "+ cliente.getApellidoCliente());
		System.out.println("4.- Los años del Cliente son: "+ cliente.getAniosCliente());
		System.out.println("Ingrese opcion a editar: ");
		opcion = leer.nextInt();
		System.out.println("-------------------------------------------");
		 do{
			switch (opcion) {
			case 1:
				System.out.println("1.- Ingrese nuevo RUN del Cliente: ");
				respuesta = leer.next();
				cliente.setRunCliente(respuesta);
				System.out.println("Datos cambiados con éxito");
				break;
			case 2:
				System.out.println("2.- Ingrese nuevo Nombre del Cliente: ");
				respuesta = leer.next();
				cliente.setNombreCliente(respuesta);
				System.out.println("Datos cambiados con éxito");
				break;
			case 3:
				System.out.println("3.- Ingrese nuevo Apellido del Cliente: ");
				respuesta = leer.next();
				cliente.setApellidoCliente(respuesta);
				System.out.println("Datos cambiados con éxito");
				break;
			case 4:
				System.out.println("4.- Ingrese nueva Edad del Cliente: ");
				respuesta = leer.next();
				cliente.setAniosCliente(respuesta);
				System.out.println("Datos cambiados con éxito");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (opcion <1||opcion>4);
		 System.out.println("salir");
		System.out.println("-------------------------------------------");
	}
	
	
	
	
	public void importarDatos() {
		System.out.println("---------------------Cargar Datos---------------------");
		System.out.println("1.-Linux o Mac");
		System.out.println("2.-Windows");
		System.out.println("Ingrese Opcion: ");
		opcion = leer.nextInt();
		do {
			switch (opcion) {
			case 1:
				System.out.println("-----------Cargar Datos en Linux o MAC--------------");
				System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
				ruta = leer.next();
				utilidad.tiempoEspera();
				utilidad.limpieza();
				utilidad.mostrarMensaje2();
				break;
			case 2:
				System.out.println("-----------Cargar Datos en Windows--------------");
				System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
				ruta = leer.next();
				utilidad.tiempoEspera();
				utilidad.limpieza();
				utilidad.mostrarMensaje2();
				break;
			default:
				utilidad.mostrarMensaje();
				break;
			}
		} while (opcion != 2);

		System.out.println("Datos Cargados Correctamente");
	}// cierre del metodo importar

	public void exportarDatos() throws IOException {
		System.out.println("-----------Exportar Datos--------------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("Ingrese una opción para exportar: ");
		opcion = leer.nextInt();
		do {
			switch (opcion) {
			case 1:
				System.out.println("------------------Exportar Datos en Linux o MAC------------------------");
				System.out.println("Ingresa la ruta en donde se desea exportar el archivo clientes.csv: ");
				ruta = leer.next().toString();
				ExportadorCsv ecsv = new ExportadorCsv();
				ecsv.crearCarpeta(ruta);
				ecsv.crearArchivo(ruta+"/cliente.csv");
				ecsv.exportar(ruta+"/cliente.csv", clientes);
				utilidad.tiempoEspera();
				utilidad.limpieza();
				System.out.println("Datos de Clientes exoportados correctamente en formato csv.");
				break;
			case 2:
				System.out.println("----------------------Exportar Datos en Windows-----------------------");
				System.out.println("Ingresa la ruta en donde se desea exportar el archivo clientes.txt: ");
				//Scanner ss = new Scanner();
				ruta = leer.next().toString();
				ExportadorTxt ett = new ExportadorTxt();
				ett.crearCarpeta(ruta);
				ett.crearArchivo(ruta+"/cliente.txt");
				ett.exportar(ruta+"/cliente.txt", clientes);
				utilidad.tiempoEspera();
				utilidad.limpieza();
				System.out.println("Datos de Clientes exoportados correctamente en formato txt.");
				break;
			default:
				break;
			}
		} while (opcion != 2);

		utilidad.tiempoEspera();
		utilidad.limpieza();
	}// cierre del metodo exportar

	public void terminarPrograma() {
		System.out.println("Saliendo del sistema de gestion de los clientes...");
		System.out.println("Acaba de salir del sistema.");
		System.exit(0);
	}
}
