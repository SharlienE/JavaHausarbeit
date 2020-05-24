
/**
 * Klasse Konsole
 * 
 * In dieser Klasse befinden sich alle Ausgaben der Konsole, die dem Spieler
 * bei Eingabe eines Kommandos übergeben werden. 
 * 
 * 
 * 
 * @author (Ihr Name) 
 * 
 */
public class Konsole
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    

    /**
     * Konstruktor für Objekte der Klasse Konsole
     */
    public Konsole()
    {
        // Instanzvariable initialisieren
        
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void zeigeHilfetext()
    {
        // tragen Sie hier den Code ein
        System.out.println("");
        System.out.println("-------- " + "Spiel: Korbwurf" + "-----------------");
        System.out.println("-                                       -");
        System.out.println("- Bitte geben Sie ein Kommando ein! -");
        System.out.println("- l: Stoßrichtung dreht nach links -");
        System.out.println("- r: Stoßrichtung dreht nach rechts -");
        System.out.println("- +: Erhöhung der Stoßgeschwindigkeit -");
        System.out.println("- -: Reduktion der Stoßgeschwindigkeit -");
        System.out.println("- Enter: Der letzte Befehl wird erneut ausgeführt -");
        System.out.println("- s: Stoß starten -");
        System.out.println("- f: Löschen und erneut starten -");
        System.out.println("- h: Hilfe-Text-");
        System.out.println("- q: Spielende. Kosole kann mit STRG+W beendet werden -");
        System.out.println("-------- Viel Glück! -------");
    }
    
    /**
     * Konsolenausgabe beim Beenden des Spiels.
     *
     */
    public void qEingabe()
    {
        System.out.println("Das Spiel wurde beendet. Danke fürs Spielen!");
        System.out.println("Sie können die Konsole mit STRG+W beenden.");       
    }
    
    /**
     * Konsolenausgabe beim Beenden des Spiels.
     *
     */
    public void falscheEingabe()
    {
        System.out.println("Falsches Kommando. Bitte geben Sie eines der gültigen Kommandos ein!");
        zeigeHilfetext();   
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void zeigeStext()
    {
        // put your code here
        System.out.println("Netter Versuch. Sie können nochmal neu starten.");
        System.out.println("Dafür drücken Sie einfach: ");
        System.out.println("f - für den neuen Wurfversuch oder"); 
        System.out.println("q - um das Spiel zu beenden.");
    }

}
