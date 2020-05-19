import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * Klasse Ball
 * 
 * In dieser Klasse kann ein Ball mit bestimmten Attributen erzeugt werden. 
 * Er besitzt einen Durchmesser von 40, hat eine aktuelle x- und y-Postition 
 * und eine Farbe.
 * Das Objekt "Ball" wird in der Klasse Spiel erzeugt. 
 * 
 * @author
 *
 */

public class Ball
{
    //Instanzvariablen
    private Ellipse2D.Double kreis;
    private Color farbe;
    public int durchmesser = 40;
    public int xPosition;
    public int yPosition;
    public Canvas leinwand;
    public final int bodenhoehe; 
    private int xAnfang; // Werden diese benötigt?
    private int yAnfang; // Werden diese benötigt?
        
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