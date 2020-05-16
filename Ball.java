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
       private static final int gravitation = 10; //Gravitationskraft
                
       private Ellipse2D.Double ball; // Definition einer Ellipse mit doppelter Genauigkeit
       private Color farbe; // Farbe des Balls
       public int durchmesser; // Durchmesser des Balls
       private int xPosition; // aktuelle xPosition des Balls
       private int yPosition; // aktuelle yPosition des Balls
       private final int bodenhoehe; 
       
       private Canvas leinwand; 
       public int yGeschwindigkeit = -60; // = vy = auch gleich (nur zu Anfang)
       public int xGeschwindigkeit = -10; // = vx = gleich
       
       private Wurf wurf = new Wurf(); 
                
                
        /**
        * Konstruktor für Objekte der Klasse Ball
        * 
        
        * 
        */
        public Ball(int xPos, int yPos, int balldurchmesser, Color ballfarbe, 
                    int bodenPosition, Canvas leinwandBall)
         {
           //"zeichengrund" = leinwandBall
                    
           xPosition = xPos;
           yPosition = yPos;
           farbe = ballfarbe;
           durchmesser = balldurchmesser;
           bodenhoehe = bodenPosition;
           leinwand = leinwandBall;
        
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
        // aus springenLassen aufrufen (Main)
       
        
        
        // An der aktuellen Position von der Leinwand entfernen.
        loescheBall();
            
        // Neue Position berechnen.
        
        
        yGeschwindigkeit = yGeschwindigkeit + gravitation;
        yPosition = yPosition + yGeschwindigkeit;
        xPosition = xPosition + xGeschwindigkeit; // fest?
        // Aus Wurf "getten"
        
        // Prüfen, ob der Boden erreicht ist.
        if(yPosition >= (bodenhoehe - durchmesser) && yGeschwindigkeit>0) {
            yPosition = (int) (bodenhoehe - durchmesser);
            yGeschwindigkeit = -yGeschwindigkeit; 
            
        }
         
            // An der neuen Position erneut zeichnen.
            zeichneBall();
            
            
                    
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
        // eigentlich unnötig, könnte raus später
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
    public int gibXposition ()
    {
        return xPosition;
    }

    /**
     * Gib die Y-Position des Balls.
     *
     * @param   yPos
     * @return  yPos
     */
    public int gibYposition ()
    {
        return yPosition;
    }

}   