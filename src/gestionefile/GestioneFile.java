package gestionefile;

/**
 *
 * @author RazvanDrosu
 * @version 23/01/24
 */
 import java.util.Scanner;

public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        //2)ELABORAZIONE
        Scanner scanner = new Scanner(System.in);

        // Chiedi all'utente di inserire l'username
        System.out.print("Inserisci l'username: ");
        String username = scanner.nextLine();

        // Chiedi all'utente di inserire la password
        System.out.print("Inserisci la password: ");
        String password = scanner.nextLine();

        // Chiudi lo scanner
        scanner.close();
        
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username, password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
}
