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
 * 
 */
public class Spiel
{
    // Instanzvariablen 
    private Canvas leinwand;
    private Ball ball1; 
    private Wurf wurf1;
    private Konsole konsole = new Konsole();
    
    private String saveEingabe;

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
        zeichneSpielfeld();
        konsole.zeigeHilfetext();
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
        
        leinwand.drawLine(600,0,600,400);
        
        leinwand.drawLine(600,400,0,400);
        
        leinwand.drawLine(0,400,0,0);
        
        
        Rectangle korb = new Rectangle(0,400,100,20);
        leinwand.fill(korb);
        
        int boden = 400; 
        ball1 = new Ball (500, 360, 40, Color.yellow, boden, leinwand); 
        ball1.zeichneBall(); 
        
        wurf1 = new Wurf(520, 400, 399, 259, Color.green, leinwand, ball1);
        wurf1.wurfrichtungZeichnen();
        wurf1.geschwindigkeitZeichnen(); 
        
        //leinwand.setForegroundColor(Color.BLUE);

        
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
     * Methode zum Speichern des letzten ausgeführten Kommandos durch Enter-Betätigung
     * (Funktioniert nicht bei "s" oder "q")
     *
     * 
     */
    private void saveEingabe ()
    {
        
    }
    
    /**
     * Durchführung der Kommandos
     */
    private void spielen()
    {
        
        //zeichneSpielfeld();
        String eingabe;
        //Konsole konsole = new Konsole();
        //konsole.zeigeHilfetext();
        eingabe = lesen (">");
        
        while (eingabe.length()!=0){
            switch(eingabe){
                case("l"):
                wurf1.wurfrichtungLinks();
                saveEingabe = eingabe; 
                break;
                    
                case("r"):
                wurf1.wurfrichtungRechts();
                saveEingabe = eingabe; 
                break;
                    
                case("+"):
                wurf1.geschwindigkeitErhöhen();
                saveEingabe = eingabe; 
                break;
                    
                case("-"):
                wurf1.geschwindigkeitSenken();
                saveEingabe = eingabe; 
                break;
                    
                case("s"):
                //Ball wird geworfen
                wurf1.werfen();
                
                // Alles beenden und auf Eingabe f warten!
                
                break;
                    
                case("f"):
                //löschen und erneutes Zeichnen des Spielfeldes.
                //der Ball ist wieder am Startpunkt.
                ball1.loescheBall();
                leinwand.wait(20);
                leinwand.erase();
                leinwand.wait(20);
                zeichneSpielfeld();
                
                //f neu ausführen
                saveEingabe = eingabe; 
                //Startwerte aus vorherigem Wurf übernehmen
                
                    break;
                    
                case("h"):
                //Ausgabe des Hilfetextes
                konsole.zeigeHilfetext();
                saveEingabe = eingabe; 
                    break; 
                    
                case("q"):
                //Spielende
                konsole.qEingabe();
                System.exit(0);
                
                    break; 
                    
                default:
                konsole.falscheEingabe();
                    break;
            }
            eingabe = lesen(">");
            if (eingabe.equals("")){
                eingabe = saveEingabe;
            }
        }
    }
    
    

}
