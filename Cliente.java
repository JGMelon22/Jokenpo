import java.rmi.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String args[]) {

        clearScreen(); // Limpa o console do cliente automaticamente a cada jogada

        try {

            if (args.length == 0) {
                System.out.println("Atenção: deve ser passado como argumento o endereçoo IP do servidor.");
                return;
            }

            Scanner sc = new Scanner(System.in);
            String enderecoServ = args[0];
            ResultadoDist servidor = (ResultadoDist) Naming.lookup("rmi://" + enderecoServ + "/ServidorJogo");

            System.out.print("Escolha entre pedra, papel ou tesoura: ");
            String item = sc.nextLine().toLowerCase().trim();

            String resultado = servidor.julgaItens(item);
            System.out.println(resultado);

            sc.close(); // Fecha recursos da classe Scanner. Poderiamos usar try-with-resources também

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
