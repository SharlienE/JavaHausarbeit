import java.awt.*;
import java.awt.geom.*;
            
 /**
  * Beschreiben Sie hier die Klasse Ball.
  * Inhalte dieser Klasse:
  *      -Einlesen der Parameter (Geschwindigkeit, Wurfrichtung) aus der Klasse Konsole
  *      -Berechnung der parabelförmigen Funktion in einer Schleife
  *          (schiefer Wurf: Funktion, google)
  *      -x/y Koordinaten an Klasse Leinwand geben
  *      -Erzeugung vom Objekt Ball
  *      -Funktion für den Korb (was passiert beim Treffer/ daneben werfen)
  *      -wenn der Ball eine Wand berührt, führe die Klasse elastischer Stoß aus
  *
  * Die Klasse Ball implementiert grafisch Bälle, die einer Gravitationskraft
  * unterliegen. Ein Ball kann bewegt werden. 
  * 
  *
  *
  * 
  * @author AS 
  * @version 03052020
  */
            
         
 public class Ball
    {
       // Instanzvariablen
       private static final int gravitation = 3; //Gravitationskraft
                
       private int bremsfaktor = 2;  // Simulation des Luftwiderstandes
       private Ellipse2D.Double ball; // Definition einer Ellipse mit doppelter Genauigkeit
       private Color farbe; // Farbe des Balls
       private int durchmesser; // Durchmesser des Balls
       private int xPosition; // xPosition des Balls
       private int yPosition; // yPosition des Balls
       private final int bodenhoehe; // = 400???; // y-Position des Bodens
       private Canvas leinwand; 
       private int yGeschwindigkeit = 1; // anfängliche Abwärtsgeschwindigkeit
       private int xGeschwindigkeit = 1; // ???
       private int wurfrichtung; //???
                
                
        /**
        * Konstruktor für Objekte der Klasse Ball
        * 
        
        * 
        */
        public Ball(int xPos, int yPos, int durchmesserball, Color ballfarbe, 
                    int bodenposition, Canvas leinwandBall, int r)
         {
           //"zeichengrund" = leinwandBall
                    
           xPosition = xPos;
           yPosition = yPos;
           farbe = ballfarbe;
           durchmesser = durchmesserball;
           bodenhoehe = bodenposition;
           leinwand = leinwandBall;
           wurfrichtung = r;
           // Hat Ball auch Attribute Geschwindigkeit / Stoßrichtung??
           // --> Bezug zu Scannnereingabe
         }
         
    /**
    * Zeichne den Ball an der aktuellen Position auf der Leinwand. 
    *
    * 
    */
    public void zeichneBall()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }
    
    /**
     * Lösche den Ball an der aktuellen Position auf der Leinwand.
     *
     * 
     */
    public void loescheBall()
    {
        leinwand.eraseCircle(xPosition, yPosition, durchmesser);
    }
    
    /**
     * Bewege den Ball 
     *
     * 
     */
    public void bewegeBall()
    {
        //wenn eingabe="s"
        
        
        // An der aktuellen Position von der Leinwand entfernen.
        loescheBall();
            
        // Neue Position berechnen.
        yGeschwindigkeit += gravitation;
        xGeschwindigkeit += gravitation;
        yPosition += yGeschwindigkeit;
        xPosition += xGeschwindigkeit;

        // Prüfen, ob der Boden erreicht ist.
        while(yPosition > (bodenhoehe - durchmesser) && yGeschwindigkeit > 0 && xGeschwindigkeit > 0) {
            yPosition = (int) (bodenhoehe - durchmesser);
            yGeschwindigkeit = -yGeschwindigkeit + bremsfaktor; 
            // An der neuen Position erneut zeichnen.
            zeichneBall();
        }
        if (yPosition == bodenhoehe && xPosition >=60){
           zeichneBall();
           // korb = Color rot ???
        }
        if (yPosition == bodenhoehe && xPosition < 60) {
            zeichneBall();
            // korb = Color grün ???
        }
    }
    
    /**
     * Gib die X-Position des Balls.
     *
     * @param   xPos
     * @return  xPos
     */
    public int gibXposition (int xPos)
    {
        return xPos;
    }

    /**
     * Gib die Y-Position des Balls.
     *
     * @param   yPos
     * @return  yPos
     */
    public int gibYposition (int yPos)
    {
        return yPos;
    }

    /**
     * Gib die Geschwindigkeit des Balls. 
     *
     * @param   yGeschwindigkeit
     * @param   xGeschwindigkeit
     * @return    Summe???
     */
    public int gibGeschwindigkeit(int yGeschwindigkeit, int xGeschwindigkeit)
    {
        
        // return yGeschwindigkeit, xGeschwindigkeit; ???
        return yGeschwindigkeit;
    }

  
    /**
     * Gib die Wurfrichtung des Balls. 
     *
     * @param     r 
     * @return    r
     */
    public int gibWurfrichtung(int r)
    {
        // gestrichelte Linie
        return r;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void stossrichtungLinks()
    {
        // wenn eingabe="l"
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void stossrichtungRechts()
    {
        // wenn eingabe="r"
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void erhoeheGeschwindigkeit()
    {
        // wenn eingabe="+"
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void reduziereGeschwindigkeit()
    {
        // wenn eingabe="-"
        
    }
    
    

}       
