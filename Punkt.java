
/**
 * Beschreiben Sie hier die Klasse Punkt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Punkt
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    int x,y;
    float geschwindigkeit,v;

    /**
     * Konstruktor für Objekte der Klasse Punkt
     */
    public Punkt()
    {
        // Instanzvariable initialisieren
        x = 300;
        y = 500;      
    
    }
   
    /**
     * Methode zur Berechnung von Geschwindigkeit (Pythagoras)
     */
    public void setzeGeschwindigkeit (){
        //hier kommt die Berechnung (pythagoras)
        v = (int) Math.pow(x,2) + (int) Math.pow(y,2);
        geschwindigkeit = (int) Math.sqrt(v);
        System.out.println("geschwindigkeit ist:" +geschwindigkeit);
    }
    
    /**
     * Methode für die Wurfrichtung
     */
}
