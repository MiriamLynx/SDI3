import impl.sdi.business.RemoteEjbServicesFactory;

import java.sql.SQLException;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import alb.util.console.Console;

import com.sdi.business.UsuariosService;
import com.sdi.model.Usuario;

public class Main {

	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String MESSAGES_QUEUE = "jms/topic/togepi";
	private Usuario usuario;
	private Session session;
	private Connection con;
	private MessageProducer sender;
	private MessageConsumer consumer;
	private static UsuariosService usuariosService;

	public static void main(String[] args) {
		try {
			new Main().run();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void run() throws JMSException {
		initialize();
		login();
		if (usuario != null) {
			consumer.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message msg) {
					showMessage((MapMessage) msg);
				}
			});

			for (int i = 0; i < 5; i++) {
				MapMessage msg = createMessage();
				sender.send(msg);
			}
		}
		close();
	}

	private Usuario login() {
		return mostrarMenuLogin();
	}

	private Usuario mostrarMenuLogin() {
		try {
			String id = Console.readString("Introduzca su id de usuario");
			String pass = Console.readString("Introduzca su contraseña:");
			usuario = usuariosService.validar(id, pass);
			if (usuario.getPrivilegios().equals("administrador")) {
				printActivatedTag();
				printHeaderUsuario();
				List<Usuario> activados = usuariosService
						.verUsuariosActivados();
				printUsuarios(activados);
				printDesactivatedTag();
				printHeaderUsuario();
				List<Usuario> desactivados = usuariosService
						.verUsuariosDesactivados();
				printUsuarios(desactivados);

			}
			return usuario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void printUsuarios(List<Usuario> usuarios) {
		for (Usuario u : usuarios) {
			printLineUsuario(u);
		}
	}

	private void close() {
		try {
			sender.close();
			session.close();
			con.close();
			consumer.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void showMessage(MapMessage msg) {
		try {
			System.out.print(msg.getString("name") + " >>");
			System.out.println(msg.getString("msg"));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void initialize() throws JMSException {
		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);
		Destination queue = (Destination) Jndi.find(MESSAGES_QUEUE);
		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		consumer = session.createConsumer(queue);
		sender = session.createProducer(queue);
		usuariosService = new RemoteEjbServicesFactory()
				.createUsuariosService();
	}

	private MapMessage createMessage() throws JMSException {
		MapMessage msg = session.createMapMessage();
		msg.setString("name", usuario.getNombre());
		msg.setString("id", usuario.getId());
		String mensaje = Console.readString("Introduzca un nuevo mensaje:");
		msg.setString("msg", mensaje);
		return msg;
	}

	private void printHeaderUsuario() {
		System.out.printf("%s %s %s %s %s\n", "_ID__________",
				"_NOMBRE________", "_APELLIDOS___________________",
				"_EMAIL___________________________", "_NUMERO DE MENSAJES_");
	}

	private void printActivatedTag() {
		System.out.println("\n*********** Usuarios activados ************");
	}

	private void printDesactivatedTag() {
		System.out.println("\n*********** Usuarios desactivados ************");
	}

	private void printLineUsuario(Usuario a) {

		System.out.printf("%-20s %-15s %-25s %-40s %-8s\n", a.getId(),
				a.getNombre(), a.getApellidos(), a.getEmail(), a.getCounter());
	}
}
