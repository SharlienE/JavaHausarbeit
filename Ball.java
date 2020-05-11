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
                
       private Ellipse2D.Double ball; // Definition einer Ellipse mit doppelter Genauigkeit
       private Color farbe; // Farbe des Balls
       private int durchmesser; // Durchmesser des Balls
       private int xPosition; // aktuelle xPosition des Balls
       private int yPosition; // aktuelle yPosition des Balls
       private final int bodenhoehe; // = 400???; // y-Position des Bodens
       // private final int deckenhoehe; // =0???; // y-Position der Decke
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
                    int bodenposition, Canvas leinwandBall)
         {
           //"zeichengrund" = leinwandBall
                    
           xPosition = xPos;
           yPosition = yPos;
           farbe = ballfarbe;
           durchmesser = durchmesserball;
           bodenhoehe = bodenposition; // ???
           leinwand = leinwandBall;
           //geschw = yGeschwindigkeit;
           // wurfrichtung = r; // selbst hinzugefügt; ???
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void bewegen()
    {
        //wenn eingabe="s"
        //Punkt punkt1 = new Punkt();
        
        
        // An der aktuellen Position von der Leinwand entfernen.
        loescheBall();
            
        // Neue Position berechnen.
        //punkt1.setzeGeschwindigkeit(x, y) += gravitation; 
        
        yPosition += yGeschwindigkeit;
        xPosition += -2; //veränderbar??
        
        // Prüfen, ob der Boden erreicht ist.
        if(yPosition >= (bodenhoehe - durchmesser) && yGeschwindigkeit>0) {
            yPosition = (int) (bodenhoehe - durchmesser);
            yGeschwindigkeit = -yGeschwindigkeit; 
            
        }
        
            // An der neuen Position erneut zeichnen.
            zeichneBall();
            
            
        //if (yPosition == bodenhoehe && xPosition >=60){
           //zeichneBall();
           // korb = Color rot ???
           // Methode "ballAufBoden"
         
        //}
        //if (yPosition == bodenhoehe && xPosition < 60) {
            //zeichneBall();
            // korb = Color grün ???
            // Methode "ballImKorb"
            
        //}
        // if (yPosition == deckenhoehe || xPosition = 0 || xPosition == 600) {
        // Abprall abprall = new Abprall ();
        // abprall.abstoßen();
        //}
    }

    /**
     * Bewege den Ball 
     *
     * 
     */
    public void bewegeBall()
    {
        //wenn eingabe="s"
        int boden  = 400;
        
        leinwand.setVisible(true);
        
        boolean fertig =  false;
        while(!fertig) {
            leinwand.wait(50);           // kurze Pause
            bewegen();
            
            // Stoppen, wenn die Bälle weit genug gesprungen sind.
            if(xPosition<=60) {
                fertig = true;
                //Färbe Korb grün
            }
            else {
                fertig = false;
                
            }
            
        }
        if (fertig = true && xPosition>=60){
                //Färbe Korb rot
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
        // setzeStossrichtung(xPos--);
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
        // setzeStossrichtung(xPos++);
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
        // setzeGeschwindigkeit(geschw++);
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
        // setzeGeschwindigkeit(geschw--);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setzeGeschwindigkeit(int geschw)
    {
        // put your code here
        geschw = yGeschwindigkeit;
    }


}       
