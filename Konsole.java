
/**
 * Beschreiben Sie hier die Klasse Konsole.
 * Inhalte dieser Klasse:
 *      -Ausgabe des Hilfstextes (Begrüßungstext, Erklärung der Kommandos)
 *      -Funktionalität der Befehle
 *      -Eingabevariablen an Klasse Ball weitergeben
 *      -Fehlerakzeptanz bei Eingabe anderer Buchstaben in die Konsole
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Konsole
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

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
        System.out.println("- l:                 -");
        System.out.println("- r:                 -");
        System.out.println("- +:                 -");
        System.out.println("- -:                 -");
        System.out.println("- Enter:             -");
        System.out.println("- s:                 -");
        System.out.println("- f:                 -");
        System.out.println("- h:                 -");
        System.out.println("- q:                 -");
        System.out.println("-------- Viel Glück! -------");
        
    }
}
