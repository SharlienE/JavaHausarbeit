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
    public int durchmesser;
    public int xPosition;
    public int yPosition;
    public Canvas leinwand;
    public final int bodenhoehe; 
    private int xAnfang; // Werden diese benötigt?
    private int yAnfang; // Werden diese benötigt?
        
    /**
     * Konstruktor für Objekte Ball
     * 
     * 
     * Parameter:
     * (int)    xPos ; yPos ; balldurchmesser ; bodenPosition
     * (Color)  ballfarbe 
     * (Canvas) zeichengrund 
     */
    public Ball(int xPos, int yPos, int balldurchmesser, Color ballfarbe,
                int bodenPosition, Canvas leinwand)
    {
        xPosition = xPos;
        xAnfang = xPos;
        yPosition = yPos;
        yAnfang = yPos;
        farbe = ballfarbe;
        durchmesser = balldurchmesser;
        bodenhoehe = bodenPosition;
        this.leinwand = leinwand;
    }

    /**
     * Zeichne den Ball an der aktuellen Position.
     **/
    public void zeichneBall()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }
    
    /**
     * Zeichne den Ball an der Position am Anfang.
     **/
    public void zeichneBallAmAnfang()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xAnfang, yAnfang, durchmesser);
        xPosition = xAnfang;
        yPosition = yAnfang;
    }

    /**
     * Lösche den Ball an seiner aktuellen Position.
     **/
    public void loescheBall()
    {
        leinwand.eraseCircle(xPosition, yPosition, durchmesser);
    }    
     
    /**
     * Gebe die xPosition des Balls zurück. 
     * 
     * @return xPosition (aktuelle xPosition des Balls)
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * Gebe die yPosition des Balls zurück. 
     * 
     * @return yPosition (aktuelle yPosition des Balls)
     */
    public int getYPosition()
    {
        return yPosition;
    }
}