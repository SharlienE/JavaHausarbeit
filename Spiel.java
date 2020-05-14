import java.util.Scanner;
import java.awt.*;
import java.awt.geom.*;
/**
 * Klasse Spiel
 * Dies ist die Main-Klasse des Programms "Korbwurf"
 * 
 * @author Jan Rietmüller (JR)
 * @author Sharlien Ehlers (SE)
 * @author Ann-Kathrin Siekmeier (AS)
 * 
 * Zenturie: W18b
 * @version 09052020
 */


 
public class Spiel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Canvas leinwand;
    private Ball ball1;
    private Wurf wurf; 
    
    private String defaultprompt = ">";
    private Scanner scanner = new Scanner(System.in);
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel()
    {
        // Instanzvariable initialisieren
        leinwand = new Canvas("Korbwurf",650, 500);
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
        
        wurf = new Wurf(); 
        
        leinwand.setForegroundColor(Color.BLUE);
        Punkt anfangspunkt0 = new Punkt();
        leinwand.drawString("Anfangsgeschwindigkeit: " + wurf.wiegroßistV(), 350, 450); //v 
        //leinwand.drawString(anfangspunkt0.getGeschwindigkeit(), 450, 450);
    }
    
      public void faerbekorb (){
          // Korb soll bei Ballberührung gefärbt werden
        
    }; 
    
    
    /**
     * Lesen eines Kommandos
     * @param prompt     String, der dem Benutzer anzeigt, dass eine Eingabe erfolgen kann
     * @return String    Eingegebens Kommando mit kleinen Buchstaben, ohne führende oder folgende Leerzeichen
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void spielen()
    {
        // put your code here
        zeichneSpielfeld();
        String eingabe;
        Konsole konsole = new Konsole();
        konsole.zeigeHilfetext();
        Punkt anfangspunkt = new Punkt();
        eingabe = lesen (">");
        
        while (eingabe.length()!=0){
            switch(eingabe){
                case("l"):
                //anfangspunkt.setRichtungHoch();
                //System.out.println("Okay! Die Richtung wurde auf " + anfangspunkt.getRichtung() + " geändert.");
                //System.out.println("Geschwindigkeit bei: " + anfangspunkt.getGeschwindigkeit());
                   
                //yGeschwindigkeit wird geringer.
                break;
                    
                case("r"):
                //anfangspunkt.setRichtungRunter();
                //System.out.println("Okay! Die Richtung wurde auf " + anfangspunkt.getRichtung() + " geändert.");
                //System.out.println("Geschwindigkeit bei: " + anfangspunkt.getGeschwindigkeit());
                   
                //yGeschwindigkeit wird höher.
                break;
                    
                case("+"):
                //anfangspunkt.setKrafthoch(); 
                //System.out.println("Done! Die Kraft wurde auf " + anfangspunkt.getKraft() + " gesetzt.");
                //System.out.println("Geschwindigkeit bei: " + anfangspunkt.getGeschwindigkeit());
                //anfangspunkt.setGeschwindigkeitHoch();
                //System.out.println("Geschwindigkeit auf :" + anfangspunkt.getGeschwindigkeit() + " erhöht.");
                
                // wiegroßistv()
                // v++;
                    break;
                    
                case("-"):
                //anfangspunkt.setGeschwindigkeitRunter();
                //System.out.println("Done! Die Kraft wurde auf " + anfangspunkt.getGeschwindigkeit() + " gesetzt.");
                //anfangspunkt.getGeschwindigkeit();
                //System.out.println("Geschwindigkeit bei: " + anfangspunkt.getGeschwindigkeit());
                    
                // wiegroßistv()
                // v--;
                break;
                    
                case("s"):
                springenLassen();
                    break;
                    
                case("f"):
                ball1.loescheBall();
                leinwand.wait(20);
                leinwand.erase();
                leinwand.wait(20);
                zeichneSpielfeld();
                    break;
                    
                case("h"):
                konsole.zeigeHilfetext();
                    break; 
                    
                case("q"):
                //konsole.spielende()
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
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void springenLassen()
    {
        int boden = 400; 
        
        ball1.bewegen();
        
        boolean fertig =  false;
        while(!fertig) { 
            leinwand.wait(50);           // kurze Pause
            ball1.bewegen();
            // Stoppen, wenn die Bälle weit genug gesprungen sind.
            if(ball1.gibYposition() >= boden - ball1.durchmesser) {
                fertig = true; 
                leinwand.setForegroundColor(Color.RED);
                Rectangle korbFailed = new Rectangle(0,400,100,20);
                leinwand.fill(korbFailed);
            }
        }
        
               
    }
    

}
