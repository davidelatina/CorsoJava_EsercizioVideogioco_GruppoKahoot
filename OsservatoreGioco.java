
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interfaccia Observer
interface OsservatoreGioco {
  void update(Messaggio messaggio);
}

// Interfaccia Subject
/*
interface Subject {
  void registerObserver(OsservatoreGioco observer);

  void removeObserver(OsservatoreGioco observer);

  void notifyObservers();
}*/

// ConcreteSubject
class NotificationSystem /*implements Subject*/ {
  private List<OsservatoreGioco> observers = new ArrayList<>();
  // private String state;

  public void setState(Messaggio messaggio) {
    // this.state = state;
    notifyObservers(messaggio);
  }

  public void registerObserver(OsservatoreGioco observer) {
    observers.add(observer);
  }

  public void removeObserver(OsservatoreGioco observer) {
    observers.remove(observer);
  }

  public void notifyObservers(Messaggio messaggio) {
    if (observers.isEmpty()) {
      return;
    }
    for (OsservatoreGioco observer : observers) {
      observer.update(messaggio);
    }
  }
}

//---------USER

class User implements OsservatoreGioco {
  String nome;

  //Giocatore personaggio;

  User(String nome) {
    this.nome = nome;
  }

  public void update(Messaggio messaggio) {
    System.out.println("L'utente " + this.nome + "ha ricevuto il messaggio: ");
    messaggio.getContenuto();
  }

}

//------------DECORATORE
/*
public class EsercizioDecorator {
  public static void main(String[] args) {
    Scanner scannerStr = new Scanner(System.in);

    System.out.print("Inserire messaggio: ");

    // Oggetto base
    MessaggioBase myMessaggioBase = new MessaggioBase(scannerStr.nextLine());

    // Decoratore
    DecoratoreMaiuscolo myDecoratoreMaiuscolo = new DecoratoreMaiuscolo(myMessaggioBase);

    System.out.println("Messaggio originale: " + myMessaggioBase.getContenuto() + "\nMessaggio decorato: "
        + myDecoratoreMaiuscolo.getContenuto());

    scannerStr.close();
  }
}
*/
// Interfaccia Component
interface Messaggio {
  String getContenuto();
}

// Componente Concreto
class MessaggioBase implements Messaggio {
  String messaggio;

  MessaggioBase(String messaggio) {
    this.messaggio = messaggio;
  }

  public String getContenuto() {
    return messaggio;
  }
}

// Decorator astratto
abstract class Decorator implements Messaggio {
  protected Messaggio component;

  public Decorator(Messaggio component) {
    this.component = component;
  }

  public String getContenuto() {
    return component.getContenuto();
  }
}

// Decoratore Concreto
class NotificaConTimestamp extends Decorator {
  public NotificaConTimestamp(Messaggio component) {
    super(component);
  }

  public String getContenuto() {
    String dataOra = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    return "[" + dataOra + "] " + component.getContenuto();
  }
}

// Decoratore Concreto
class NotificaConColore extends Decorator {
  public NotificaConColore(Messaggio component) {
    super(component);
  }

  public String getContenuto() {
    return "(ROSSO) " + component.getContenuto().toUpperCase();
  }
}

// Decoratore Concreto
class NotificaConLivelloAllerta extends Decorator {
  public NotificaConLivelloAllerta(Messaggio component) {
    super(component);
  }

  public String getContenuto() {
    return "[ALERT!] " + component.getContenuto();
  }
}