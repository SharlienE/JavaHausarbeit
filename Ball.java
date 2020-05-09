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
       private final int bodenhoehe; // y-Position des Bodens
       private Canvas leinwand; 
       private int yGeschwindigkeit = 1; // anfängliche Abwärtsgeschwindigkeit
                
                
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
           bodenhoehe = bodenposition;
           leinwand = leinwandBall;
                    
         }
         
     /**
     * Zeichne den Ball an der aktuellen Position auf der Leinwand. 
     *
     * @param 
     */
    public void zeichneBall()
    {
        leinwand.setForegroundColor(farbe);
        leinwand.fillCircle(xPosition, yPosition, durchmesser);
    }
    
    /**
     * Lösche den Ball an der aktuellen Position auf der Leinwand.
     *
     * @param  
     */
    public void loescheBall()
    {
        leinwand.eraseCircle(xPosition, yPosition, durchmesser);
    }
    
    /**
     * Bewege den Ball 
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void bewegeBall()
    {
        //
    }

    
    
         
}       
