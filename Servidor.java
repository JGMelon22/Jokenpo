import java.rmi.*;
import java.net.*;

public class Servidor {
    public static void main(String args[]) {
        try {
            ResultadoDist serv = new ServidorImpl();
            // Registra nome do servidor
            Naming.rebind("ServidorJogo", serv);
            System.out.println("### Servidor em execução ###");
        } catch (RemoteException e) {
            e.getMessage();
        } catch (MalformedURLException e) {
            e.getMessage();
        }
    }
}
