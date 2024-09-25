import Team.Coverage;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Coverage c = new Coverage();
        //stampa a video
        System.out.println("Inserisci i tipi che hai già inserito nel team, per terminare l'inserimento premi invio");
        while(true){
            //chiedo un input all'utente
            String inputUtente = input.nextLine();
            if (inputUtente.equals(""))break;
            //aggiungo al team l'input utente attuale
            c.team.add(inputUtente);    
        }
        //stampa a video
        System.out.print("Per completare la copertura ti mancano i seguenti tipi: ");
        //completo la copertura
        c.build();
        //chiudo lo scanner
        input.close();
    }
}
