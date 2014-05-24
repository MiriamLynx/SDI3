import impl.sdi.business.RemoteEjbServicesFactory;

import java.util.List;
import java.util.Scanner;

import javax.ejb.EJB;

import com.sdi.business.UsuariosService;
import com.sdi.model.Usuario;

public class Main {

	@EJB
	static UsuariosService usuariosService;
	private Scanner in;

	public static void main(String[] args) {
		Main main = new Main();

		try {

			main.run();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\n-- ejb remote client ended --");
	}

	private void run() throws Exception {
		usuariosService = new RemoteEjbServicesFactory()
				.createUsuariosService();

		int num;
		System.out.println("***Bienvenido a la consola del cliente EJB:");
		while (true) {
			mostrarMenu();
			num = getOpcion();
			procesarOpcion(num);
		}

	}

	private void procesarOpcion(int op) {
		switch (op) {
		case 1:
			addUser();
		case 2:
			activateUser();
		case 3:
			desactivateUser();
		case 4:
			listUsers();
		default:
			System.out.println("La opcion introducida es invalida");
			mostrarMenu();
		}
	}

	private int getOpcion() {
		in = new Scanner(System.in);
		System.out.println("Ingrese la opcion que desee: ");
		return in.nextInt();
	}

	private void mostrarMenu() {
		System.out.println("Introduzca una opcion:");
		System.out.println("1- Añadir un nuevo usuario");
		System.out.println("2- Activar usuario");
		System.out.println("3- Desactivar usuario");
		System.out.println("4- Ver listado de usuarios");
	}

	private void listUsers() {
		List<Usuario> activados = usuariosService.verUsuariosActivados();
		List<Usuario> desactivados = usuariosService.verUsuariosDesactivados();
		printActivatedTag();
		printHeaderUsuario();
		for (Usuario u : activados) {
			printLineUsuario(u);
		}
		printDesactivatedTag();
		printHeaderUsuario();
		for (Usuario u : desactivados) {
			printLineUsuario(u);
		}
	}

	private void desactivateUser() {
		in = new Scanner(System.in);
		System.out.println("Itroduzca el nick del usuario: ");
		String id = in.next();
		usuariosService.desactivarUsuario(id);
		System.out.println("Usuario activado correctamente");
	}

	private void activateUser() {
		in = new Scanner(System.in);
		System.out.println("Itroduzca el nick del usuario: ");
		String id = in.next();
		usuariosService.activarUsuario(id);
		System.out.println("Usuario activado correctamente");
	}

	private void addUser() {
		in = new Scanner(System.in);
		System.out.println("Itroduzca el nick del usuario: ");
		String id = in.next();
		System.out.println("Introduzca el nombre del usuario: ");
		String nombre = in.next();
		System.out.println("Introduzca los apellidos: ");
		String apellidos = in.next();
		System.out.println("Introduzca el e-mail: ");
		String email = in.next();
		System.out.println("Introduzca la password: ");
		String password = in.next();
		System.out.println("Vuelva a introducir la password: ");
		String password2 = in.next();
		validatePassword(password, password2);
		System.out
				.println("Eliga un tipo de usuario: (Escriba profesor / alumno)");
		String privilegios = in.next();
		usuariosService.insertarUsuario(id, nombre, apellidos, email, false,
				password, privilegios);
		System.out.println("Usuario añadido correctamente");
	}

	private void validatePassword(String password, String password2) {
		if (!password.equals(password2)) {
			System.out.println("Las contraseñas introducidas no coinciden");
			mostrarMenu();
		}
	}

	private void printHeaderUsuario() {
		System.out.printf("%s %s %s %s\n", "_ID__________", "_NOMBRE________",
				"_APELLIDOS___________________", "_EMAIL_");
	}

	private void printActivatedTag() {
		System.out.println("*********** Usuarios activados ************");
	}

	private void printDesactivatedTag() {
		System.out.println("*********** Usuarios desactivados ************");
	}

	private void printLineUsuario(Usuario a) {
		System.out.printf("%-20s %-15s %-25s %-8s\n", a.getId(), a.getNombre(),
				a.getApellidos(), a.getEmail());
	}
}
