package vista;
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
	
	Scanner leer = new Scanner(System.in);
	int opcion = 0;
	String respuesta;
	String ruta;
	
	 public menu() {}
	
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
	
	public void iniciarMenu() {
		do {
			System.out.println("1.- Listar Clientes");
			System.out.println("2.- Agregar Cliente");
			System.out.println("3.- Editar Cliente");
			System.out.println("4.- Cargar Datos");
			System.out.println("5.- Exportar Datos");
			System.out.println("6.- Salir");
			System.out.println("Ingrese una opcion: ");
			opcion = leer.nextInt();
			
			switch(opcion) {
				case 1 :{
					listarCliente();
				}
				case 2 :{
					agregarCliente();
				}
				case 3 :{
					editarCliente();
				}
				case 4 :{
					importarDatos();
				}
				case 5 :{
					exportarDatos();
				}
				case 6 :{
					terminarPrograma();
				}
				default:
					System.out.println("Opcion no valida.");
					break;
					
			}
			
		}while(opcion!=6);
			
		
	}
	
	
	public void listarCliente() {
		System.out.println("-----------------Datos del Cliente----------------");
		ClienteServicio sc = new ClienteServicio();
		sc.retornoListarClientes();
		System.out.println("RUN del Cliente: " );
		System.out.println("Nombre del Cliente: ");
		System.out.println("Apellido del Cliente: ");
		System.out.println("Edad del Cliente: ");
		System.out.println("Categoria del Cliente: ");
		System.out.println("--------------------------------------------------");
	}
	public void agregarCliente() {	
		System.out.println("-----------------Crear Cliente----------------");
		System.out.println("Ingresa RUN del Cliente: ");
		String rut = leer.next();
		System.out.println("Ingresa Nombre del Cliente: ");
		String nombre= leer.next();
		System.out.println("Ingresa Apellido del Cliente: ");
		String apellido= leer.next();
		System.out.println("Ingresa Edad del Cliente: ");
		String edad= leer.next();
		System.out.println("-----------------------------------------------");
		
		Cliente cliente = new Cliente(rut, nombre, apellido, edad, null);
		System.out.println(cliente.toString());
		
	}
	
	
	
	public void editarCliente() {	
		System.out.println("-----------------Editar Cliente----------------");
		do {
			System.out.println("Seleccione que desea hacer: ");
			System.out.println("1.-Cambiar el estado del Cliente");
			System.out.println("2.-Editar los datos ingresados del Cliente");
			System.out.println("Ingrese opcion: ");
			opcion = leer.nextInt();
			switch(opcion) {
				case 1:
					System.out.println("Ingrese RUN del Cliente a editar:");
					respuesta = leer.next();
					System.out.println("------Actualizando estado del Cliente------");
					System.out.println("El estado actual es: Activo");
					System.out.println("1.- Si desea cambiar el estado del Cliente a Inactivo");
					System.out.println("2.- Si desea mantener el estado del Cliente Activo");
					System.out.println("Ingrese opcion: ");
					opcion = leer.nextInt();
					do {
						switch(opcion){
							case 1:
								System.out.println("El estado actual es: Inactivo");
								break;
							case 2:
								System.out.println("Se mantuvo el estado actual del Cliente: Activo");
								break;
							default:
								System.out.println("Opcion no valida");
								break;
						}
					}while(opcion != 2);
					System.out.println("-------------------------------------------");
					break;
				case 2:
					System.out.println("------Actualizando estado del Cliente------");
					System.out.println("1.- El RUN del Cliente es: ");
					System.out.println("2.- El Nombre del Cliente es: ");
					System.out.println("3.- El Apellido del Cliente es: ");
					System.out.println("4.- Los años del Cliente son: ");
					System.out.println("Ingrese opcion a editar: ");
					opcion = leer.nextInt();
					System.out.println("-------------------------------------------");
					do {
						switch(opcion) {
						case 1:
							System.out.println("1.- Ingrese nuevo RUN del Cliente: ");
							respuesta = leer.next();
							System.out.println("Datos cambiados con éxito");
							break;
						case 2:
							System.out.println("2.- Ingrese nuevo Nombre del Cliente: ");
							respuesta = leer.next();
							System.out.println("Datos cambiados con éxito");
							break;
						case 3:
							System.out.println("3.- Ingrese nuevo Apellido del Cliente: ");
							respuesta = leer.next();
							System.out.println("Datos cambiados con éxito");
							break;
						case 4:
							System.out.println("4.- Ingrese nueva Edad del Cliente: ");
							respuesta = leer.next();
							System.out.println("Datos cambiados con éxito");
							break;
						default:
							System.out.println("Opcion no valida");
							break;
						}
					}while(opcion != 4);
					System.out.println("-------------------------------------------");
					break;
				default:
					System.out.println("Opcion no valida");
					break;
			}
		}while(opcion != 2);
		System.out.println("-----------------------------------------------");
	}//cierre del metodo editar
	
	
	
	public void importarDatos() {
		System.out.println("---------------------Cargar Datos---------------------");
		System.out.println("1.-Linux o Mac");
		System.out.println("2.-Windows");
		System.out.println("Ingrese Opcion: ");
		opcion = leer.nextInt();
		do {
			switch(opcion) {
			case 1 :
				System.out.println("-----------Cargar Datos en Linux o MAC--------------");
				System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
				ruta = leer.next();
				System.out.println("----------------------------------------------------");
				System.out.println("Datos Cargados Correctamente en la lista");
				break;
			case 2:
				System.out.println("-----------Cargar Datos en Windows--------------");
				System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
				ruta = leer.next();
				System.out.println("----------------------------------------------------");
				System.out.println("Datos Cargados Correctamente en la lista");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}while(opcion != 2);
		
		System.out.println("Datos Cargados Correctamente");
	}//cierre del metodo importar
	
	
	public void exportarDatos() {
		System.out.println("-----------Exportar Datos--------------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("Ingrese una opción para exportar: ");
		opcion = leer.nextInt();
		do {
			switch(opcion) {
			case 1:
				System.out.println("------------------Exportar Datos en Linux o MAC------------------------");
				System.out.println("Ingresa la ruta en donde se desea exportar el archivo clientes.csv: ");
				ruta = leer.next();		
				System.out.println("----------------------------------------------------");
				System.out.println("Datos de Clientes exoportados correctamente en formato csv.");
				break;
			case 2:
				System.out.println("----------------------Exportar Datos en Windows-----------------------");
				System.out.println("Ingresa la ruta en donde se desea exportar el archivo clientes.txt: ");
				ruta = leer.next();		
				System.out.println("----------------------------------------------------");
				System.out.println("Datos de Clientes exoportados correctamente en formato txt.");
				break;
			default:
				break;
			}
		}while(opcion != 2);
		
		System.out.println("----------------------------------------------------");
	}//cierre del metodo exportar
	
	
	
	public void terminarPrograma() {
		System.out.println("Saliendo del sistema de gestion de los clientes...");
		System.out.println("Acaba de salir del sistema.");
		System.exit(0);
	}
}

