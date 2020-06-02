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
 * @author Jan Rietmüller (JR)
 * @author Sharlien Ehlers (SE)
 * @author Ann-Kathrin Siekmeier (AS)
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
     * Im Konstrutor werden die Werte festgelegt die unser Objekt in einen
     * gültigen Zusand versetzen.
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
     * Die folgende Methode zeichnet den Ball immer an der aktuellen Stelle
     * auf der Leinwand. Der Befehl leinwand.fillcircle braucht dafür die x-
     * sowie yPosition und den von uns festgelegten Durchmessers des Balles.
     **/
    public void zeichneBall()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }
    
    /**
     * Diese Methode zeichnet den Ball an seiner von uns festgelegten
     * Ursprungsposition. Dies passiert durch den Aufruf dieser Methode
     * durch private void zeichneSpielfeld() in Klasse Spiel. 
     * 
     * Parameter:
     * int xAnfang
     * int xPosition
     * int yPosition
     * int yAnfang
     * int durchmesser
     **/
    public void zeichneBallAmAnfang()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xAnfang, yAnfang, durchmesser);
        xPosition = xAnfang;
        yPosition = yAnfang;
    }


    /**
     * Diese Methode gibt die aktuelle xPosition des Balles aus. Die aktuelle
     * Position des Balles wird benötigt um den Wurf zu berechnen. Außerdem
     * um zu überprufen ob der Ball beim Werfen die Decke berührt oder den
     * Korb getroffen hat.
     * 
     * @return xPosition (aktuelle xPosition des Balls)
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * Die Methode getYposition() gibt wie die aktuelle yPostion des Balles
     * aus. Auch hier wird der Wert zur Berechnung des Wurfes oder zum
     * Überprüfen ob die Wände oder Korb getrofen wurden.
     * 
     * @return yPosition (aktuelle yPosition des Balls)
     */
    public int getYPosition()
    {
        return yPosition;
    }
}