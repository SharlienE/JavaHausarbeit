import java.awt.*;
import java.awt.geom.*;
import java.lang.Math; 

/**
 * Klasse Wurf
 * 
 * Die Klasse Wurf implementiert grafisch Bälle, die der Schwerkraft
 * unterworfen sind. Ein Ball kann bewegt werden. Die Bedingungen der Bewegung
 * werden dabei vom Ball selbst kontrolliert. Er fällt abwärts und beschleunigt
 * aufgrund der Schwerkraft. Er prallt ab, wenn er an eine Wand oder 
 * an der Decke auftrifft.
 * 
 * Ein Ball kann bewegt werden, wenn der Spiele die Eingabe "s" tätigt und 
 * somit die Methode "werfen" vom Programm aufgerufen wird.
 * 
 * @author 
 * 
 */
public class Wurf
{
    public Canvas leinwand;
    
    public int geschwindigkeit;   // Anfangsgeschwindigkeit
    public int winkel;             // Anfangswinkel
    
    private Color farbe;
    private Ball ball1;
    private int yAnfang, yPunkt; 
    private int xAnfang, xPunkt; 
    private int gravitation = 1;        // Einfluss der Gravitation
    private int wandrechts = 600;       // x-Koordinaten der Wand rechts
    private int wandlinks = 0;          // x - Koordinaten der Wand links
    public boolean deckeGetroffen = false;
    public boolean wandGetroffen = false;

    /**
     * Konstruktor für Objekte Wurf
     * 
     * (int) xStart ; yStart ; xEnde ; yEnde bzw.
     * (int) xAnfang ; yAnfang ; xPunkt ; yPunkt
     * (Color) linienFarbe = farbe
     * (Canvas) leinwand
     * 
     * 
     */
    public Wurf(int xStart, int yStart, int xEnde, int yEnde, int v, int alpha, Color linienFarbe, Canvas leinwand, Ball ball1)    
    {
        yAnfang = yStart;
        xAnfang = xStart;
        xPunkt = xEnde;
        yPunkt = yEnde;
        geschwindigkeit = v;
        winkel = alpha;
        this.leinwand = leinwand;
        farbe = linienFarbe;
        this.ball1 = ball1;
    }
    
    /**
     * Berechnung für X Position durch Geschwindigkeit und Winkel
     */
    public int getXPunkt()
    {
        double winkel1= ((winkel*Math.PI)/180);  
        double xPosition = xAnfang - (Math.cos(winkel1) * geschwindigkeit);
        return xPunkt;
    }
    
    /**
     * Berechnung für Y Position durch Geschwindigkeit und Winkel
     */
    public int getYPunkt()
    {
        double winkel1= ((winkel*Math.PI)/180);  
        double yPosition = yAnfang - (Math.sin(winkel1) * geschwindigkeit);
        return yPunkt;
    }
    
    /**
     * Linie der Wurfrichtung zeichnen.
     *
     * (int)  xAnfang, yAnfang, xPunkt, yPunkt
     */
    public void wurfrichtungZeichnen()
    {    
        leinwand.setForegroundColor(farbe);
        leinwand.paint(xAnfang, yAnfang, xPunkt, yPunkt);
    }
  
    /**
     * Geschwindigkeit auf der Leinwand später anzeigen lassen.
     *
     * @param   (float) geschwindigkeit
     * @param   (String) "Anfangsgeschwindigkeit"
     * 
     * durch 100 teilen, weil sonst zu groß?
     * --> so wird statt 200, nur 2.0 angezeigt. 
     */
    public void vZeichnen()
    
    {
        leinwand.setForegroundColor(Color.black);
        leinwand.drawString("Anfangsgeschwindigkeit: " + ((float) geschwindigkeit/10), 350, 450);
    }
    
    /**
     * Geschwindigkeit wieder auf der Leinwand löschen, 
     * damit sie überschrieben werden kann
     *
     * @param   (float) geschwindigkeit
     * @param   (String) "Anfangsgeschwindigkeit"
     *
     */
    public void geschwindigkeitErase()
    
    {
       leinwand.eraseString("Anfangsgeschwindigkeit: " + ((float) geschwindigkeit/100), 350, 450);
    }
    
    /**
     * Getter für Geschwindigkeit
     */
    public int getGeschwindigkeit()
    {
        // tragen Sie hier den Code ein
        return geschwindigkeit;
    }
    
    /**
     * Setter für Geschwindigkeit
     */
    public void setGeschwindigkeit(int v)
    {
        geschwindigkeit = v;
    }

    /**
     * Wenn die Geschwindigkeit mit der Eingabe "+" um eine Einheit erhöht werden soll
     * Einheit = 10
     * nicht schneller als 5.0
     * "setGeschwindigkeitHoch"
     *
     * @param       ERGÄNZEN
     *
     */
    public void geschwindigkeitPlus()
    
    {
        if(geschwindigkeit < 500){
           geschwindigkeitErase();
           setGeschwindigkeit(geschwindigkeit += 10);
           vZeichnen();    
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           getXPunkt();
           getYPunkt();
           ball1.zeichneBall();
           wurfrichtungZeichnen();
       }     
       else {
           System.out.println("Schneller geht leider nicht...");
       }
    }
    
    /**
     * Wenn die Geschwindigkeit mit der Eingabe "-" um eine Einheit reduziert werden soll
     * Einheit = 10
     * nicht langsamer als 0.1
     * "setGeschwindigkeitRunter"
     *
     * @param       ERGÄNZEN
     */
    public void geschwindigkeitMinus()
    
    {
       if(geschwindigkeit > 10 ){
           geschwindigkeitErase();
           setGeschwindigkeit(geschwindigkeit -= 10);
           vZeichnen();
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           getXPunkt();
           getYPunkt();
           ball1.zeichneBall();
           wurfrichtungZeichnen();
        }   
      else {
           System.out.println("Langsamer geht leider nicht...");
      }
    }
    
    /**
     * Getter für Winkel
     */
    public int getWinkel()
    {
        // tragen Sie hier den Code ein
        return winkel;
    }
    
    /**
     * Setter für Geschwindigkeit
     */
    public void setWinkel(int alpha)
    {
        winkel = alpha;
    }
    
    /**
     * Wenn die Wurfrichtung mit der Eingabe "r" um eine Einheit nach rechts gehen soll
     * Einheit = 5 Grad
     * nicht weiter als 180 Grad (d.h. bei 175 Grad darf nicht mehr erhöht werden)
     * "setRichtungHoch"
     * 
     * @param       ERGÄNZEN
     */
    public void wurfrichtungRechts()
    {
        if(winkel <= 175){
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           setWinkel(winkel += 5);
           getXPunkt();
           getYPunkt();
           ball1.zeichneBall();
           wurfrichtungZeichnen();
        } else  {
            System.out.println("Mehr AfD geht nicht...");
        }
    }   
    
    /**
     * Wenn die Wurfrichtung mit der Eingabe "l" um eine Einheit nach links gehen soll
     * Einheit = 5 Grad
     * nicht weiter als 0 Grad (d.h. bei 5 Grad darf nicht mehr reduziert werden)
     * "setRichtungRunter"
     * 
     * @param       ERGÄNZEN
     */
    public void wurfrichtungLinks()
    {
        if(winkel >= 5){
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           setWinkel(winkel -= 5);
           getXPunkt();
           getYPunkt();
           ball1.zeichneBall();
           wurfrichtungZeichnen();      
        }  else {
             System.out.println("Mehr Wagenknecht geht nicht...");
        }
    }
    
    //Passt das so??
    /**
     * Bewege diesen Ball entsprechend seiner Position und 
     * Geschwindigkeit und zeichne ihn erneut.
     **/
    public void bewegen()
    {
        //ball1.loescheBall();
        
        //Decke getroffen? 
        if(deckeGetroffen == true){
            winkel += 180;      // Also es klappt so halb mit 180 Grad..
            // Aber muss hier nicht irgendwie Einfallswinkel = Ausfallswinkel?
            
            // Damit die Leinwand nicht verschwindet, wenn der Ball durchgeht...
            leinwand.setFont(new Font("helvetica", Font.BOLD, 14));
            leinwand.setForegroundColor(Color.BLUE);
            leinwand.drawString("Spiel: Korbwurf", 220, 20);
            leinwand.drawLine(0,0,600,0);
        } 
        //Wand getroffen?
        if(wandGetroffen == true){
            //Left Bounce
             if(ball1.getXPosition() <= (wandlinks + ball1.durchmesser)){
                 winkel += 90;
                 // Hier siehe oben...?
                    
                 // Damit die Leinwand nicht verschwindet, wenn der Ball durchgeht...
                 leinwand.setForegroundColor(Color.BLUE);
                 leinwand.drawLine(0,400,0,0);
                }
            //Right Bounce
             if (ball1.getXPosition() >= (wandrechts - ball1.durchmesser)){
                 winkel -= 90;
                 // Hier siehe oben...?
                    
                 //Damit die Leinwand nicht verschwindet, wenn der Ball durchgeht...
                 leinwand.setForegroundColor(Color.BLUE);
                 leinwand.drawLine(600,0,600,400);
                }
        }
        gravitation += 1;
        double winkel1 = ((winkel*Math.PI)/180);
        double yÄnderung = (Math.sin(winkel1) * (geschwindigkeit)); 
        double xÄnderung = (Math.cos(winkel1) * (geschwindigkeit));       
        ball1.yPosition = ball1.yPosition - ((int)(yÄnderung/10) - gravitation);
        ball1.xPosition = ball1.xPosition - (int)(xÄnderung/10);
        deckeGetroffen = false;   
        wandGetroffen = false;
        // Boden erreicht?
        if(ball1.yPosition >= (ball1.bodenhoehe - ball1.durchmesser) && yÄnderung>0) {
            ball1.yPosition = (int) (ball1.bodenhoehe - ball1.durchmesser);
            yÄnderung = -yÄnderung; 
        }
        
        // An der neuen Position erneut zeichnen.
        ball1.zeichneBall();
    }  
    
    //Ich glaube, hier muss noch was verändert werden, damit "s" auf den neuen Ball zugreifen kann..
    //Irgendjemand Ideen??
    /**
     * Wenn der Ball durch die Eingabe "s" geworfen werden soll 
     * (mit entsprechenden Paramtern, also Winkel und Geschwindigkeit)
     *
     * @param    ERGÄNZEN
     * 
     */
    public void werfen()
    {
      boolean fertig = false;
      while (!fertig)
      {
          int boden = 400;
          leinwand.wait(50);
          bewegen();

          // Korb getroffen?
          if (ball1.getXPosition() <= 60 && ball1.getYPosition() >=360)
          {
              fertig = true;
              leinwand.setForegroundColor(Color.GREEN);
              Rectangle korbSuccess = new Rectangle(0,400,100,20);
              leinwand.fill(korbSuccess);
              System.out.println("Glückwunsch, Treffer!");
          }
              
          // Korb verfehlt?
          if(ball1.getYPosition() >= boden - ball1.durchmesser && ball1.getXPosition() >= 80) {
              fertig = true; 
              leinwand.setForegroundColor(Color.RED);
              Rectangle korbFailed = new Rectangle(0,400,100,20);
              leinwand.fill(korbFailed);
              System.out.println("Schade, versuchen Sie es noch einmal!");
            }
          
          //Decke getroffen?
          if(ball1.getYPosition() <= 0 && geschwindigkeit > 0)
          {
            deckeGetroffen = true;
          }
          
          //Wand getroffen?                 
          if((ball1.getXPosition() <= 0 || ball1.getXPosition() >= 560) && geschwindigkeit > 0)
          {
            wandGetroffen = true;
          }
          
          // Ich glaube, die folgende If-Schleife kann raus... 
          // (Bitte vorsichtshalber als Kommentar so lassen)
          //if(ball1.getYPosition() >= 360 && ball1.getXPosition() > 60  ) 
          //{
          //  fertig = true;
          //}
          if (ball1.getYPosition() <= 0 )
          {
              break;
            }
       }          
     }

}
