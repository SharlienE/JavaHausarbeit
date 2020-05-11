import java.awt.*;
import java.awt.geom.*;

/**
 * Beschreiben Sie hier die Klasse Abprall.
 * Inhate dieser Klasse:
 *      -Aufruf der Parameter aus Klasse Ball (Koordinaten, Geschwindigkeit)
 *      -Berechnung der Funktion (Link in Aufgabe)
 *      -sobald y=0 führe die Funktion für den Korb aus Klasse Ball aus
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Abprall
{
    private static final int gravitation = 3;  // Einfluss der Gravitation
    private int bremsfaktor = 2;  // simuliert den Luftwiderstand?
    private Ellipse2D.Double kreis;
    private Color farbe;
    private int durchmesser;
    private int xPosition;
    private int yPosition;
    private final int bodenhoehe;      // y-Position des Bodens
    private Canvas leinwand;
    private int yGeschwindigkeit = 1;

    /**
     * Konstruktor für Exemplare von Ball
     *
     * @param xPos  die horizontale Koordinate des Balles
     * @param yPos  die vertikale Koordinate des Balles
     * @param balldurchmesser  der Durchmesser des Balles (in Bildschirmpunkten)
     * @param ballfarbe  die Farbe des Balles
     * @param bodenPosition  die y-Position des Bodens (wo der Ball aufspringt)
     * @param zeichengrund die Leinwand, auf der dieser Ball gezeichnet wird
     */
    public Abprall(int xPos, int yPos, int balldurchmesser, Color ballfarbe,
                        int bodenPosition, Canvas leinwandAbprall)
    {
        xPosition = xPos;
        yPosition = yPos;
        farbe = ballfarbe;
        durchmesser = balldurchmesser;
        bodenhoehe = bodenPosition;
        leinwand = leinwandAbprall;
    }

    /**
     * Zeichne diesen Ball an der aktuellen Position auf die Leinwand.
     **/
    public void zeichnen()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }

    /**
     * Lösche diesen Ball an seiner aktuellen Position.
     **/
    public void loeschen()
    {
        leinwand.eraseCircle(xPosition, yPosition, durchmesser);
    } 
    
    /**
     * Bewege diesen Ball entsprechend seiner Position und 
     * Geschwindigkeit und zeichne ihn erneut.
     **/
    public void bewegeAbprallendenBall()
    {
        // Aktuelle Position bekommen
        int xPos;
        int yPos;
        
        
        // An der aktuellen Position von der Leinwand entfernen.
        loeschen();
            
        // Neue Position berechnen.
        yGeschwindigkeit += gravitation;
        yPosition += yGeschwindigkeit;
        xPosition +=2;

        // Prüfen, ob der Boden erreicht ist.
        if(yPosition >= (bodenhoehe - durchmesser) && yGeschwindigkeit > 0) {
            yPosition = (int)(bodenhoehe - durchmesser);
            yGeschwindigkeit = -yGeschwindigkeit + bremsfaktor; 
        }

        // An der neuen Position erneut zeichnen.
        zeichnen();
    }    

    /**
     * Liefere die horizontale Position dieses Balls.
     */
    public int gibXPosition()
    {
        return xPosition;
    }

    /**
     * Liefere die vertikale Position dieses Balls.
     */
    public int gibYPosition()
    {
        return yPosition;
    }
}