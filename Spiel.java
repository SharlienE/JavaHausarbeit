import java.util.Scanner;
import java.awt.*;
import java.awt.geom.*;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Canvas leinwand;
    public Ball ball1;
    public Wurf wurf1;

    private String defaultprompt = ">";
    private Scanner scanner = new Scanner(System.in);
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel()
    {
        leinwand = new Canvas("Korbwurf",650, 500, Color.white);
        leinwand.setVisible(true);
        leinwand.setSize(650, 500);
    }

    /**
     * Klassenmethode zum Aufruf des Spiels
     * 
     * @param  String[] Mögliche Parameter (hier keine)
     */
    public static void main(String[] args){
        // Instantiierung der Klasse
        Spiel neuesSpiel = new Spiel();
        neuesSpiel.spielen();
    }
    
    /**
     * Methode zum Zeichnen des Spielfeldes
     */
    public void zeichneSpielfeld()
    {
        leinwand.setFont(new Font("helvetica", Font.BOLD, 14));
        leinwand.setForegroundColor(Color.BLUE);
        leinwand.drawString("Spiel: Korbwurf", 220, 20);
        leinwand.drawLine(0,0,600,0);
        //leinwand.setForegroundColor(Color.BLUE);
        leinwand.drawLine(600,0,600,400);
        //leinwand.setForegroundColor(Color.BLUE);
        leinwand.drawLine(600,400,0,400);
        //leinwand.setForegroundColor(Color.BLUE);
        leinwand.drawLine(0,400,0,0);
        //leinwand.setForegroundColor(Color.BLUE);
        
        Rectangle korb = new Rectangle(0,400,100,20);
        leinwand.fill(korb);
        
        int boden = 400; 
        ball1 = new Ball (500, 360, 40, Color.yellow, boden, leinwand); 
        ball1.zeichneBall(); 
        
        wurf1 = new Wurf(520, 400, 399, 259, Color.green, leinwand, ball1);
        wurf1.wurfrichtungZeichnen();
        wurf1.geschwindigkeitSchreiben();
        
        leinwand.setForegroundColor(Color.BLUE);

        //leinwand.drawString("Anfangsgeschwindigkeit: " + wurf.wiegroßistV(), 350, 450); //v 
    }
    
    /**
     * Lesen eines Kommandos, welcher in der Konsole eingegeben wurde 
     */
   
     private String lesen (String prompt){ 
        // In dieser Variable wird der eingelesene String gespeichert, der zurückgegeben wird
        String eingabe;
        
        // Ausgabe der Eingabeaufforderung
        System.out.println(prompt);
        
        // einlesen
        eingabe = scanner.nextLine();
        
        // Konverieren in kleine Buchstaben und entfernen der führenden und folgenden Leerzeichen
        if (eingabe.length()>0){
            eingabe = eingabe.toLowerCase().trim();
        }
        
        return eingabe;
    }
    
    /**
     * Durchführung der Kommandos
     */
    private void spielen()
    {
        // put your code here
        zeichneSpielfeld();
        String eingabe;
        Konsole konsole = new Konsole();
        konsole.zeigeHilfetext();
        eingabe = lesen (">");
        
        while (eingabe.length()!=0){
            switch(eingabe){
                case("l"):
                //Stoßrichtung dreht nach links um eine Einheit
                wurf1.wurfrichtungLinks();
                break;
                    
                case("r"):
                //Stoßrichtung dret nach rechts um eine Einheit
                wurf1.wurfrichtungRechts();
                break;
                    
                case("+"):
                //Anfangsgeschwindigkeit wird um eine Einheit erhöht
                wurf1.geschwindigkeitErhöhen();
                break;
                    
                case("-"):
                //Anfangsgeschwindigkeit wird um eine Einheit reduziert
                wurf1.geschwindigkeitSenken();
                break;
                    
                case("s"):
                //Ball wird geworfen
                wurf1.werfen();
                // Alles beenden
                break;
                    
                case("f"):
                //löschen und erneutes Zeichnen des Spielfeldes.
                //der Ball ist wieder am Startpunkt.
                ball1.loescheBall();
                leinwand.wait(20);
                leinwand.erase();
                leinwand.wait(20);
                zeichneSpielfeld();
                    break;
                    
                case("h"):
                //Ausgabe des Hilfetextes
                konsole.zeigeHilfetext();
                    break; 
                    
                case("q"):
                //Spielende
                System.out.println("Das Spiel wurde beendet. Danke fürs Spielen!");
                System.out.println("Sie können die Konsole mit STRG+W beenden.");
                System.exit(0);
                    break; 
                    
                default:
                System.out.println("Falsches Kommando. Bitte geben Sie eines der gültigen Kommandos ein!");
                konsole.zeigeHilfetext();
                    break;
            }
            eingabe = lesen(">");
        
        }
    }

}
