import java.awt.*;
import java.awt.geom.*;

/**
 * Die Klasse Ball implementiert grafisch Bälle, die der Schwerkraft
 * unterworfen sind. Ein Ball kann bewegt werden. Die Bedingungen der Bewegung
 * werden dabei vom Ball selbst kontrolliert. Er fällt abwärts und beschleunigt
 * aufgrund der Schwerkraft. Er prallt ab, wenn er an eine Wand oder der Decke auftrifft.
 * 
 * Diese Bewegung kann simuliert werden, indem wiederholt die Operation
 * "bewegen" aufgerufen wird.
 * 
 *
 */

public class Ball
{
    private Ellipse2D.Double kreis;
    private Color farbe;
    public int durchmesser;
    public int xPosition;
    public int yPosition;
    public Canvas leinwand;
    private final int bodenhoehe; 
    private int xAnfang;
    private int yAnfang;
        
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
    public Ball(int xPos, int yPos, int balldurchmesser, Color ballfarbe,
                int bodenPosition, Canvas leinwand)
    {
        xPosition = xPos;
        yPosition = yPos;
        farbe = ballfarbe;
        durchmesser = balldurchmesser;
        bodenhoehe = bodenPosition;
        this.leinwand = leinwand;
    }

    /**
     * Zeichne diesen Ball an der aktuellen Position auf die Leinwand.
     **/
    public void zeichneBall()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }

    /**
     * Lösche diesen Ball an seiner aktuellen Position.
     **/
    public void loescheBall()
    {
        leinwand.eraseCircle(xPosition, yPosition, durchmesser);
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