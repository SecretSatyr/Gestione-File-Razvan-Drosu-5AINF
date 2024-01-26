package gestionefile;

/**
 *
 * @author RazvanDrosu
 * @version 23/01/24
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 import java.util.Scanner;

public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sourceFilePath = "output.csv";
        String destinationFilePath = "copia.csv";
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        //2)ELABORAZIONE
        Scanner scanner = new Scanner(System.in);

        // Chiedo all'utente di inserire l'username
        System.out.print("Inserisci l'username: ");
        String username = scanner.nextLine();

        // Chiedo all'utente di inserire la password
        System.out.print("Inserisci la password: ");
        String password = scanner.nextLine();
        
        // Chiusura dello scanner
        scanner.close();
        try {
            // Aprertura del file sorgente in lettura usando BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));

            // Apertura del file di destinazione in scrittura usando BufferedWriter
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath));

            // Lettura di ogni riga dal file sorgente e poi scritta nel file di destinazione
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); 
            // Aggiunta di una nuova linea nel file di destinazione dopo ogni riga
            }

            // Chiusura le risorse
            reader.close();
            writer.close();

            System.out.println("Il file è stato copiato con successo.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username, password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
}
