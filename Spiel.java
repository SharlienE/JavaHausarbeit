import java.util.Scanner;
import java.awt.*;
//import java.awt.geom.*;
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
    // Deklarieren der Instanzvariablen 
    private Canvas leinwand;
    private Ball ball1; 
    private Wurf wurf1;
    private Konsole konsole = new Konsole(); //gleichzeitige Objekterzeugung
    private String saveEingabe; 

    private String defaultprompt = ">"; // gleichzeitiges Initialisieren
    // erlaubt dem Spiel, etwas aus System.in zu lesen
    private Scanner scanner = new Scanner(System.in); //gleichzeitige Objekterzeugung
    
    
    /**
     * Konstruktor für Objekte der Klasse Spiel
     * 
     * Parameter:
     * int boden - Wert der Bodenpositionslinie
     * int xPos  - xPosition des Balls
     * int yPos  - yPosition des Balls
     * int balldurchmesser - Wert des Balldurchmessers
     * int xStart - x-Wert für den Startpunkt der Wurfrichtungslinie
     * int yStart - y-Wert für den Startpunkt der Wurfrichtungslinie
     * int xEnde  - x-Wert für den Endpunkt der Wurfrichtungslinie
     * int yEnde  - y-Wert für den Endpunkt der Wurfrichtungslinie
     * int v      - Wert der Anfangsgeschwindigkeit
     * int winkel0 - Wert des Anfangswinkels für den Wurf
     * 
     *  
     */
    public Spiel()
    {
        // Leinwand aus Canvas erzeugen (Titel, x, y, Farbe)
        leinwand = new Canvas("Korbwurf",650, 500, Color.white);
        // sichtbar machen
        leinwand.setVisible(true);
        // Größe der Leinwand festlegen
        leinwand.setSize(650, 500);
        // Bodenlinie für Aufprall des Balls definieren
        int boden = 400;
        // Objekt Ball erzeugen (xPos, yPos, Balldurchmesser, Ballfarbe,
        // BodenPosition, leinwand)
        ball1 = new Ball (500, 360, 40, Color.yellow, boden, leinwand); 
        // Objekt Wurf erzeugen (xStart, yStart, xEnde, yEnde, v, winkel0,
        // LinienFarbe, leinwand, ball1)
        wurf1 = new Wurf(520, 380, 400, 250,200, 45, Color.green, leinwand, ball1);
        // Methode zum Zeichnen des Spielfeldes aufrufen und zeichnen
        zeichneSpielfeld();
        // Hilfetext in Konsole anzeigen lassen 
        konsole.zeigeHilfetext();
    }

    /**
     * Willkommen im Spiel "Korbwurf"
     * Main-Methode zum Aufruf des Spiels
     * 
     * @public - Die Methode kan von außerhalb der Klasse aufgerufen werden
     * @static - Sie wird aufgerufen, ohne dass vorher ein Objekt der Klasse 
     *           Spiel erzeugt wurde; Klassenmethode
     * @void   - Kein Rückgabewert
     * @String[] args - Arrray wird übergeben, welches die Werte der 
     *                  vom Aufruf entgegengenommenen Kommandozeilen beinhaltet
     */
    public static void main(String[] args){
        // Implementierung der Programmlogik
        Spiel neuesSpiel = new Spiel();
        neuesSpiel.spielen();
    }
    
    /**
     * Methode zum Zeichnen des Spielfeldes: 
     * Rahmen, Korb, Ball, Wurfrichtung und Anfangsgeschwindigkeit
     * 
     * Parameter:
     * int boden - Wert der Bodenpositionslinie
     * 
     */
    private void zeichneSpielfeld()
    {
        // Schriftart und -größe festlegen
        leinwand.setFont(new Font("helvetica", Font.BOLD, 14));
        // Farbe für folgende Anweisungen festlegen
        leinwand.setForegroundColor(Color.BLUE);
        // Überschrift mit Positionsangaben
        leinwand.drawString("Spiel: Korbwurf", 220, 20);
        // Rahmenlinien zeichnen
        leinwand.drawLine(0,0,600,0); 
        leinwand.drawLine(600,0,600,400);
        leinwand.drawLine(600,400,0,400);
        leinwand.drawLine(0,400,0,0); 
        
        // neues Objekt als Rechteck erzeugen (vordefiniert in Canvas)
        Rectangle korb = new Rectangle(0,400,100,20);
        // mit oben definierter Farbe ausfüllen
        leinwand.fill(korb);
        
        // Ball am Startpunkt zeichnen
        int boden = 400; 
        ball1.zeichneBallAmAnfang();
        
        // Wurfrichtung zeichnen
        wurf1.wurfrichtungZeichnen();
        
        // Geschwindigkeit anzeigen
        wurf1.vZeichnen();  
    }
    
    /**
     * Lesen eines Kommandos, welcher in der Konsole eingegeben wurde 
     * 
     * Parameter:
     * String eingabe - das, was vom Benutzer eingegeben wird
     * String prompt  - Eingabeaufforderungen, sodass der Benutzer sehen kann, 
     *                  dass er etwas eingeben muss. 
     *                  
     * @return eingabe
     * 
     */
   
     private String lesen (String prompt){ 
        // In dieser Variable wird der eingelesene String gespeichert, der zurückgegeben wird
        String eingabe;
        
        // Ausgabe der Eingabeaufforderung, sodass in der Konsole etwas vom 
        // Benutzer eingegeben werden kann
        System.out.println(prompt);
        
        // Scanner gibt die übersprungene Eingabe zurück
        // String wird eingelesen
        eingabe = scanner.nextLine();
        
        // Konvertieren in kleine Buchstaben und entfernen der führenden 
        // und folgenden Leerzeichen
        if (eingabe.length()>0){
            eingabe = eingabe.toLowerCase().trim();
        }
        
        // Methode beenden und Parameter eingabe zurückgeben
        return eingabe;
    }
    
    /**
     * Durchführung der Kommandos
     * Wenn ein Kommando vom Benutzer eingegeben wurde, führe die nachfolgenden
     * Anweisungen aus.
     * 
     * Parameter:
     * String eingabe - das, was vom Benutzer eingegeben wird
     * boolean ende   - zum Beenden der While-Schleife
     * String saveEingabe - zum Zwischenspeichern der vorherigen Eingabe
     * 
     */
    private void spielen()
    {
        // lokalen String namens eingabe erzeugen
        String eingabe;
        // Datentyp boolean namens ende erzeugen und auf false setzen
        boolean ende = false;
        
       
        // Kommandos aus Konsole lesen
        // Eingabeaufforderung an den Benutzer
        eingabe = lesen (">");
        while (!ende){
            switch(eingabe){
                case("l"):
                //Wurfrichtung nach links
                    wurf1.wurfrichtungLinks();
                    // Den Wert der Eingabe im String saveEingabe (zwischen)speichern
                    saveEingabe = eingabe; 
                    break;
                    
                case("r"):
                //Wurfrichtung nach rechts
                    wurf1.wurfrichtungRechts();
                    saveEingabe = eingabe; 
                    break;
                    
                case("+"):
                //Geschwindigkeit erhöhen
                    wurf1.geschwindigkeitPlus();
                    saveEingabe = eingabe; 
                    break;
                    
                case("-"):
                //Geschwindigkeit reduzieren
                    wurf1.geschwindigkeitMinus();
                    saveEingabe = eingabe; 
                    break;
                    
                case("s"):
                //Ball wird geworfen
                //Nächste s-Eingabe wird verhindert.
                    werfenSpiel();                 
                    break;
                    
                case("f"):
                //Leinwand wird gelöscht und neugezeichnet
                //Ball befindet sich wieder in der Ausgangsposition
                    neustarten();
                    saveEingabe = eingabe;
                    break;
                    
                case("h"):
                //Ausgabe des Hilfetextes
                    konsole.zeigeHilfetext();
                    saveEingabe = eingabe; 
                    break; 
                    
                case("q"):
                //Spielende
                    ende=true;  // While-Schleife beenden
                    konsole.qEingabe();
                    // Beenden des Programms, indem die virtuelle Maschine beendet wird
                    // keine weitere Eingabe des Benutzers mehr möglich
                    // 0 = Status (erfolgreich)
                    System.exit(0); 
                    break; 
                    
                default:
                // Für alle anderen Fälle: falsches Kommando
                konsole.falscheEingabe();
                    break;
            }
            // Eingabeaufforderung an den Benutzer
            eingabe = lesen(">"); // Sonst Endlos-Schleife
            if (eingabe.equals("")){
                // Bei Enter wird das vorherige Kommando ausgeführt
                eingabe = saveEingabe;
            }
        }
    }
    
    /**
     * Methode, wenn "f" eingegeben wurde
     * Löschen und erneutes Zeichnen des Spielfeldes.
     * Der Ball befindet sich wieder am Startpunkt.
     * Werte aus vorherigen Würfen werden übernommen.
     * 
     * Parameter:
     * int boden - Wert der Bodenpositionslinie
     * int xPos  - xPosition des Balls
     * int yPos  - yPosition des Balls
     * int balldurchmesser - Wert des Balldurchmessers
     * 
     */
    private void neustarten()
    {
        // Löschen der Leinwand
        leinwand.erase(); 
        
        
        // neuen Ball an Anfangsposition zeichnen
        int boden = 400;
        ball1 = new Ball (500, 360, 40, Color.yellow, boden, leinwand);
        
        // Startwerte aus vorherigem Wurf übernehmen
        wurf1 = new Wurf (520, 380, wurf1.getXPunkt(), wurf1.getYPunkt() , 
               wurf1.getGeschwindigkeit(), wurf1.getWinkel(), Color.green, leinwand, ball1);
        
        // Spielfeld neu zeichnen
        zeichneSpielfeld();
        
    }

    /**
     * Methode, damit "s" nur einmal ausgeführt werden kann.
     * Danach muss das Spiel neugestartet oder beendet werden.
     * 
     * Parameter:
     * int boden        - Wert der Bodenpositionslinie
     * String eingabe   - das, was vom Benutzer eingegeben wird
     * boolean sEingabe - zum Beenden der While-Schleife
     * 
     */
    private void werfenSpiel()
    {
        // ersten Wurf ausführen
        wurf1.werfen();
        
        // Hilfetext nach der Eingabe von "s" anzeigen
        konsole.zeigeStext();
        
        // Eingabe neu lesen und "s" verhindern
        String eingabe;
        eingabe = lesen (">"); // Eingabeaufforderung an den Benutzer
        boolean sEingabe = false; 
        
        while (!sEingabe){
            switch(eingabe){
            case("f"):
                neustarten();
            //Beenden der Schleife
                sEingabe = true;
            break;
            
            case("q"):
            //Spielende
                sEingabe = true;    
                konsole.qEingabe(); 
                System.exit(0);
            break;
            
            
            default:
                konsole.falscheEingabeBeiS();
                konsole.zeigeStext();
            
                    break;
            }
            // Damit s nicht erneut bei Enter ausgeführt wird, sonst Endlos-Schleife
            // Eingabeaufforderung an den Benutzer
            if(!sEingabe)
            {
                eingabe = lesen(">"); 
            }
        }
        
}
}
