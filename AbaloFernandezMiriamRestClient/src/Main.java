import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.sdi.business.resteasy.ServiceRs;
import com.sdi.model.Asignatura;
import com.sdi.model.Matricula;
import com.sdi.model.Usuario;

public class Main implements ServiceRs {

	private ServiceRs servicio;
	private static Main client;

	public Main() {
		ClientExecutor clientexecutor = credentials("sdi", "password");

		servicio = ProxyFactory.create(ServiceRs.class,
				"http://localhost:8180/AbaloFernandezMiriamWEB/rest/",
				clientexecutor);
	}

	public static void main(String[] args) {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());

		client = new Main();
		int num;
		System.out.println("Bienvenido a la consola del cliente REST:");
		while (true) {
			mostrarMenu();
			num = getOpcion();
			procesarOpcion(num);
		}

	}

	public ClientExecutor credentials(String userId, String password) {
		Credentials credentials = new UsernamePasswordCredentials(userId,
				password);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		httpClient.getCredentialsProvider().setCredentials(
				org.apache.http.auth.AuthScope.ANY, credentials);
		ClientExecutor clientExecutor = new ApacheHttpClient4Executor(
				httpClient);
		return clientExecutor;
	}

	private static void mostrarNotas() {
		List<Usuario> usuarios = client.getAlumnos();
		List<String> ids = new ArrayList<String>();
		printHeaderUsuario2();
		for (Usuario u : usuarios) {
			ids.add(u.getId());
			printLineUsuario2(u);
		}
		System.out
				.println("Introduzca el id del usuario para ver su expediente:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id;
		try {
			id = br.readLine();
			if (ids.contains(id)) {
				mostrarExpediente(id);
			} else {
				System.out
						.println("ERROR: El id no corresponde a ningun usuario");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarExpediente(String id) {
		List<Matricula> matriculas = client.verExpediente(id);
		System.out.println("EXPEDIENTE______");
		for (Matricula m : matriculas)
			printLineExpediente(m);
		if (matriculas.isEmpty())
			System.out.println(">> El usuario \"" + id
					+ "\" no esta matriculado en ninguna asignatura");
	}

	private static void mostrarAlumnosAsignatura() {
		List<Asignatura> asignaturas = client.getAsignaturas();
		List<String> ids = new ArrayList<String>();

		printHeaderAsignatura2();
		for (Asignatura a : asignaturas) {
			ids.add(a.getId());
			printLineAsignatura2(a);
		}
		System.out
				.println("Introduce el codigo de la asignatura para ver sus alumnos:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String id = br.readLine();
			if (ids.contains(id)) {
				mostrarAlumnos(id);
			} else {
				System.out
						.println("ERROR: El numero no corresponde a ninguna asignatura");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void mostrarAlumnos(String id) {
		List<Usuario> usuarios = client.getAlumnos(id);
		printHeaderUsuario();
		for (Usuario u : usuarios) {
			printLineUsuario(u);
		}
		if (usuarios.isEmpty()) {
			System.out.println(">>> La asignatura \"" + id
					+ "\" no tiene alumnos matriculados.");
		}
	}

	public static void mostrarMenu() {
		System.out.println("Introduzca la opcion que desea:");
		System.out.println("1- Mostrar las notas de un alumno");
		System.out.println("2- Mostrar los alumnos de una asignatura");

	}

	@SuppressWarnings("resource")
	private static int getOpcion() {
		Scanner entrada = new Scanner(System.in);
		return entrada.nextInt();
	}

	private static void procesarOpcion(int num) {
		switch (num) {
		case 1:
			mostrarNotas();
			break;
		case 2:
			mostrarAlumnosAsignatura();
			break;
		default:
			System.out
					.println("ERROR: Has introducido una opcion no disponible.");
			break;
		}

	}

	private static void printHeaderUsuario() {
		System.out.printf("%s %s %s %s\n", "_APELLIDOS__________",
				"_NOMBRE________", "_EMAIL___________________", "_NOTA_");
	}

	private static void printLineUsuario(Usuario a) {
		System.out.printf("%-20s %-15s %-25s %-8s\n", a.getApellidos(),
				a.getNombre(), a.getEmail(), a.getNota());
	}

	private static void printHeaderUsuario2() {
		System.out.printf("%s %s %s %s\n", "_Nº_", "_APELLIDOS__________",
				"_NOMBRE________", "_EMAIL___________________");
	}

	private static void printLineUsuario2(Usuario a) {
		System.out.printf("%-10s %-15s %-25s %-8s\n", a.getId(),
				a.getApellidos(), a.getNombre(), a.getEmail());
	}

	private static void printLineAsignatura2(Asignatura a) {
		System.out
				.printf("%-10s %-25s %-15s %-8s\n", a.getId(), a.getNombre(),
						"(" + a.getCurso() + "º curso)", a.getCreditos()
								+ " creditos.");
	}

	private static void printHeaderAsignatura2() {
		System.out.printf("%s %s %s\n", "_Nº_",
				"_NOMBRE________________________________",
				"_CURSO_____CREDITOS_____", "_________");
	}

	private static void printLineExpediente(Matricula m) {
		System.out.println(">>" + m.getAsignatura().getNombre() + "("
				+ m.getAsignatura().getCurso() + "º curso) Nota: "
				+ m.getCalificacion());
	}

	@Override
	public List<Usuario> getAlumnos(String idAsignatura) {
		return servicio.getAlumnos(idAsignatura);
	}

	@Override
	public List<Matricula> verExpediente(String idAlumno) {
		return servicio.verExpediente(idAlumno);
	}

	@Override
	public List<Usuario> getAlumnos() {
		return servicio.getAlumnos();
	}

	@Override
	public List<Asignatura> getAsignaturas() {
		return servicio.getAsignaturas();
	}

}