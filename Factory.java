
// 
interface Giocatore {
    void azioneMelee(); 
    void azioneMagico();
    void azioneDistanza();
}

// personaggi prodotti concreti 
class Mago implements Giocatore { // implemento vari attacchi 

    public void azioneMelee() {
        System.out.println("AttaccoMelee");
    }

    public void azioneMagico() {
      System.out.println("Attacco magico");    
    }

     public void azioneDistanza() {
        System.out.println("Attacco a distanza");   
    }

}

class Guerriero implements Giocatore {
     public void azioneMelee() {
        System.out.println("AttaccoMelee");

    }

     public void azioneMagico() {
      System.out.println("Attacco magico");    
    }

     public void azioneDistanza() {
        System.out.println("Attacco a distanza");   
    }
}

class Arciere implements Giocatore {
     public void azioneMelee() {
        System.out.println("AttaccoMelee");

    }

     public void azioneMagico() {
      System.out.println("Attacco magico");    
    }

     public void azioneDistanza() {
        System.out.println("Attacco a distanza");   
    }
}
// classe astratta ruolo 
// 
abstract class Ruolo {
  public abstract Giocatore creaGiocatore(); 
        void azioneMelee() {};
        void azioneMagico() {};
        void azioneDistanza() {};
    }


// classe che crea istanza del personaggio scelto dall'utente
class GiocatoreFactory {
    public static Giocatore creaGiocatore(String tipo) {
        switch(tipo.toLowerCase()) {
            case "mago": return new Mago();
            case "guerriero": return new Guerriero();
            case "arciere": return new Arciere();
            default: return null;
        }
    }
}

