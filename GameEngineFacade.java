import java.util.Scanner;

public class GameEngineFacade {
    //creazione oggetto Scanner
    private Scanner scanner = new Scanner(System.in);
    private SessionManager sessionManager = SessionManager.getInstanceSessionManager();
    
    private Utente utente;

    public void avviaGioco() {
        String input;

        loginUtente();

        do {
            System.out.println("Comandi disponibili: 1 azione, 2 per cambiare notifica o 0 per uscire");
            System.out.print("Inserisci comando: ");
            input = scanner.nextLine();

            switch (input) {
                case "0":
                    System.out.println("Uscita dal gioco.");
                    return;

                case "1":
                    eseguiAzione();
                    break;

                case "2":
                    personalizzaNotifiche();
                    break;

                default:
                    System.out.println("Comando non riconosciuto.");
            }
        } while (true);
    }

    private void loginUtente() {
        System.out.print("Inserisci il tuo nome utente: ");
        String username = scanner.nextLine();
        System.out.println("Login effettuato per: " + username);
        
        System.out.println("Scegli un personaggio: mago, guerriero, arciere");
        String scelta = scanner.nextLine();
    }

    private void impostaStrategia() {
        
        System.out.println("Scegli una strategia di attacco: 1 melee, 2 magico, 3 a distanza");
        String scelta = scanner.nextLine();

        switch (scelta) {
            case "1":
                //giocatore.setStrategiaAttacco(new AttaccoMelee());
                break;
            case "2":
                //giocatore.setStrategiaAttacco(new AttaccoMagico());
                break;
            case "3":
                //giocatore.setStrategiaAttacco(new AttaccoDistanza());
                break;
            default:
                System.out.println("Strategia non valida.");
        }
    }

    private void eseguiAzione() {
        System.out.println("Scegli una strategia di attacco: 1 melee, 2 magico, 3 a distanza");
        String scelta = scanner.nextLine();

        switch (scelta) {
            case "1":
                //giocatore.setStrategiaAttacco(new AttaccoMelee());
                break;
            case "2":
                //giocatore.setStrategiaAttacco(new AttaccoMagico());
                break;
            case "3":
                //giocatore.setStrategiaAttacco(new AttaccoDistanza());
                break;
            default:
                System.out.println("Strategia non valida.");
        }

        //giocatore.eseguiAzione();
        //notificatore.notificaTutti("Azione eseguita da " + sessionManager.getUtenteConnesso());
    }

    private void personalizzaNotifiche() {
        
        //scelta decorator
        System.out.println("Notifiche personalizzate con decoratori.");
    }
}
