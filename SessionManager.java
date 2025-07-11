import java.util.ArrayList;

public class SessionManager {//classe SessionManager hce mantiene lo stato della sessione utente connesso
    static private SessionManager currentSession; //attributo statico dell'unica istanza del SessionManager
    Utente currentUser = new Utente(); //utente attualmente connesso alla sessione
    ArrayList<Utente> listTeamUsers = new ArrayList<>();//lista degli utenti nel team

    private SessionManager(){}; //costruttore privato non richiamabile

    public static SessionManager getInstanceSessionManager(){ //metodo che restituisce il riferimento all'unica istanza di SessionManager
        if(currentSession==null){
            currentSession = new SessionManager();
        }
        return currentSession;
    }

}

class Utente{//classe che modella gli utenti all'interno del gioco
    private String nomeUtente; //nome dell'utente
    
    private String password; //password dell'utente

    public String getNomeUtente() { //metodo che restituisce il nome dell'utente
        return nomeUtente;
    }
    
    public void setNomeUtente(String nomeUtente) { //metodo che cambia il nome dell'utente
        this.nomeUtente = nomeUtente;
    }

    private String getPassword() { //metodo privato che restituisce la password dell'utente
        return password;
    }

    public boolean checkPassword(String password) {//metodo che verifica la password dell'utente, true se corretta, false in caso contrario
        if(this.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }




}
