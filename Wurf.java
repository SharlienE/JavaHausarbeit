import java.awt.*;
import java.awt.geom.*;
import java.lang.Math; 

/**
 * Klasse Wurf
 * 
 * Die Klasse Wurf implementiert grafisch Bälle, die der Schwerkraft
 * unterworfen sind. Ein Ball kann bewegt werden. Die Bedingungen 
 * (Geschwindigkeit, Wurfrichtung) der Bewegung können dabei vom Spieler 
 * verändert werden. Er wird geworfen und beschleunigt
 * aufgrund der Schwerkraft. Er prallt ab, wenn er an eine Wand oder 
 * an der Decke auftrifft.
 * 
 * Ein Ball kann bewegt werden, wenn der Spiele die Eingabe "s" tätigt und 
 * somit die Methode "werfen" vom Programm aufgerufen wird.
 * 
 * @author Jan Rietmüller (JR)
 * @author Sharlien Ehlers (SE)
 * @author Ann-Kathrin Siekmeier (AS)
 * 
 */
public class Wurf
{
    public Canvas leinwand;
    
    public int geschwindigkeit;   // Anfangsgeschwindigkeit
    public int alpha;             // Anfangswinkel
    
    private Color farbe;
    private Ball ball1;
    private int yAnfang, yPunkt; 
    private int xAnfang, xPunkt; 
    private int gravitation = 1;        // Einfluss der Gravitation
    private int wandrechts = 600;       // x - Koordinaten der Wand rechts
    private int wandlinks = 0;          // x - Koordinaten der Wand links
    private boolean deckeGetroffen = false;
    private boolean wandGetroffen = false;
    private double yÄnderung; 
    private double xÄnderung;

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
    public Wurf(int xStart, int yStart, int xPos, int yPos,int v, int winkel0,
                Color linienFarbe, Canvas leinwand, Ball ball1)    
    {
        //Koordinaten des Balls am Boden
        yAnfang = yStart;
        xAnfang = xStart;
        //Koordinaten des Punktes zum Zeichnen der Linie
        xPunkt = xPos;
        yPunkt = yPos;
        //Parameter des Wurfes
        geschwindigkeit = v;
        alpha = winkel0;
        //Grafik & Ball, die hier benutzt werden, sind die Gleichen wie sonst auch
        this.leinwand = leinwand;
        farbe = linienFarbe;
        this.ball1 = ball1;
    }
        
    /**
     * Getter für X Punkt
     * 
     * (int) xPunkt
     */
    public int getXPunkt()
    {
        // sondierende Methode für x-Koordinate des Balls
        return xPunkt;
    }
    
    /**
     * Getter für Y Punkt
     * 
     * (int) yPunkt
     */
    public int getYPunkt()
    {
        // sondierende Methode für y-Koordinate des Balls
        return yPunkt;
    }
    
    /**
     * Berechnung für X Position durch Geschwindigkeit und Winkel
     * 
     * (double) winkel
     * (int) xAnfang, geschwindigkeit, xPunkt
     */
    private void setXPunkt()
    {
        // verändernde Methode für x- Koordinate des Balls
        // Umrechnung von Bogenmaß in Grad
        double winkel= ((alpha*Math.PI)/180);
        double xPosition = xAnfang - (Math.cos(winkel) * geschwindigkeit);
        // "Umrechnung" von double in int
        xPunkt = (int)xPosition;
    }
    
    /**
     * Berechnung für Y Position durch Geschwindigkeit und Winkel
     * 
     * (double) winkel
     * (int) yAnfang, geschwindigkeit, yPunkt
     */
    private void setYPunkt()
    {
        // verändernde Methode für y- Koordinate des Balls
        // Umrechnung von Bogenmaß in Grad
        double winkel= ((alpha*Math.PI)/180);  
        double yPosition = yAnfang - (Math.sin(winkel) * geschwindigkeit);
        // "Umrechnung" von double in int
        yPunkt = (int)yPosition;
    }
    
    /**
     * Linie der Wurfrichtung zeichnen.
     *
     * (int)  xAnfang, yAnfang, xPunkt, yPunkt
     */
    public void wurfrichtungZeichnen()
    {    
        //Aufrufen der Koordinaten vom Punkt
        getXPunkt();
        getYPunkt();
        //Farbe der Linie wählen, Linie zeichnen
        leinwand.setForegroundColor(farbe);
        leinwand.drawDashedLine(xAnfang, yAnfang, xPunkt, yPunkt); 
    }
  
    /**
     * Geschwindigkeit auf der Leinwand später anzeigen lassen.
     *
     * (int) geschwindigkeit
     */
    public void vZeichnen()
    
    {
        //Farbe der Schrift wählen, Geschwindigkeit anzeigen lassen
        leinwand.setForegroundColor(Color.black);
        // es wird /10 gerechnet, damit die Zahlen kleiner angezeigt werden
        leinwand.drawString("Anfangsgeschwindigkeit: " + (geschwindigkeit/10), 350, 450);
    }
    
    /**
     * Geschwindigkeit wieder auf der Leinwand löschen, 
     * damit sie überschrieben werden kann
     *
     * (int) geschwindigkeit
     */
    private void geschwindigkeitErase()
    
    {
       leinwand.eraseString("Anfangsgeschwindigkeit: " + ((int) geschwindigkeit/10), 350, 450);
    }
    
    /**
     * Getter für Geschwindigkeit
     */
    public int getGeschwindigkeit()
    {
        // sondierende Methode für Geschwindigkeit, damit sie verändert werden kann
        return geschwindigkeit;
    }
    
    /**
     * Setter für Geschwindigkeit
     * 
     * (int) v, geschwindigkeit
     */
    private void setGeschwindigkeit(int v)
    {
        // verändernde Methode für Geschwindigkeit
        geschwindigkeit = v;
    }

    /**
     * Die Geschwindigkeit wird mit der Eingabe "+" um 10 Einheiten erhöht (in der Anzeige +1)
     * Geschwindigkeit wird nur bis 500 (Anzeige: 50) erhöht
     *
     * (int) geschwindigkeit, xAnfang, yAnfang, xPunkt, yPunkt
     *
     */
    public void geschwindigkeitPlus()
    
    {
       if(geschwindigkeit < 600){
           //Geschwindigkeit wird erhöht
           geschwindigkeitErase();
           setGeschwindigkeit(geschwindigkeit += 10);
           vZeichnen(); 
           //Wurflinie wird neu gezeichnet
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           setXPunkt();
           setYPunkt();
           wurfrichtungZeichnen();
       }     
       else {
           System.out.println("Schneller geht leider nicht...");
       }
    }
    
    /**
     * Die Geschwindigkeit wird mit der Eingabe "-" um 10 Einheiten reduziert (in der Anzeige +1)
     * Geschwindigkeit wird nur über 10 (Anzeige: 1) reduziert
     *
     * @param       ERGÄNZEN
     */
    public void geschwindigkeitMinus()
    
    {
       if(geschwindigkeit > 10 ){
           //Geschwindigkeit wird erhöht
           geschwindigkeitErase();
           setGeschwindigkeit(geschwindigkeit -= 10);
           vZeichnen();
           //Wurflinie wird neu gezeichnet
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           setXPunkt();
           setYPunkt();
           wurfrichtungZeichnen();
        }   
      else {
           System.out.println("Langsamer geht leider nicht...");
      }
    }

    /**
     * Getter für Winkel
     * 
     * (int) alpha
     */
    public int getWinkel()
    {
        // sondierende Methode für Wurfrichtung, damit sie verändert werden kann
        return alpha;
    }
    
    /**
     * Setter für Winkel
     * 
     * (int) alpha, winkel0
     */
    private void setWinkel(int winkel0)
    {
        // verändernde Methode für Wurfrichtung, damit sie verändert wird
        alpha = winkel0;
    }
    
    /**
     * die Wurfrichtung wird bei der Eingabe "r" um 5 Grad nach rechts gedreht
     * Winkel wird bis 175 Grad erhöht
     * 
     * (int) alpha, xAnfang, yAnfang, xPunkt, yPunkt  
     */
    public void wurfrichtungRechts()
    {
        if(alpha < 175){
           // Winkel wird erhöht
           setWinkel(alpha += 5);
           // Wurfliie wird neu gezeichnet
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           setXPunkt();
           setYPunkt();
           wurfrichtungZeichnen();
        } else  {
           System.out.println("Weiter nach rechts geht nicht...");
        }
    }   
    
    /**
     * die Wurfrichtung wird bei der Eingabe "l" um 5 Grad nach links gedreht
     * Winkel wird bis 5 Grad reduziert
     * 
     * (int) alpha, xAnfang, yAnfang, xPunkt, yPunkt 
     */
    public void wurfrichtungLinks()
    {
        if(alpha > 5){
           //Winkel wird reduziert
           setWinkel(alpha -= 5);
           //Wurflinie wird neu gezeichnet
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           setXPunkt();
           setYPunkt();
           wurfrichtungZeichnen();      
        }  else {
           System.out.println("Weiter nach links geht nicht...");
        }
    }
    
    /**
     * Berechnung von der x- und y-Änderung
     * 
     * (double) winkel1, yDelta, xDelta
     * (int) alpha, geschwindigkeit, yÄnderung, xÄnderung
     */
    private void berechneÄnderung()
    {
        //Umrechnung von Bogenmaß in Grad
        double winkel1 = ((alpha*Math.PI)/180);
        //Berechnung der Änderung in y-Richtung
        double yDelta = (Math.sin(winkel1) * (geschwindigkeit/10)); 
        yÄnderung = (int) (yDelta);
        //Berechnung der Änderung in x-Richtung
        double xDelta = (Math.cos(winkel1) * (geschwindigkeit/10));  
        xÄnderung = (int) (xDelta);
    }

    /**
     * Bewege diesen Ball entsprechend seiner Position und 
     * Geschwindigkeit und zeichne ihn erneut.
     * 
     * (int) gravitation, yÄnderung, xÄnderung
     **/
    private void bewegen()
    {  
        //Gravitation nimmt immer um 1 zu
        gravitation += 1;     
        //Berechnung von x- und y-Position des Balls
        ball1.yPosition = ball1.yPosition - ((int)(yÄnderung) - gravitation);
        ball1.xPosition = ball1.xPosition - (int)(xÄnderung);
        // An der neuen Position erneut zeichnen
        ball1.zeichneBall();
    }  
    
    /**
     * Der Ball wird durch die Eingabe "s"  geworfen
     *
     * (boolean) fertig, 
     * 
     */
    public void werfen()
    {
      // Berechnung von der x- und y-Änderung
      berechneÄnderung();
      boolean fertig = false;
      while (!fertig)
      {
          int boden = 400;
          leinwand.wait(50);
          //während fertig = false, bewege den Ball
          bewegen();
          
          // Korb getroffen
          if (ball1.getXPosition() <= 60 && ball1.getYPosition() >=360)
          {
              fertig = true;
              //zeichne grünen Korb
              leinwand.setForegroundColor(Color.GREEN);
              Rectangle korbSuccess = new Rectangle(0,400,100,20);
              leinwand.fill(korbSuccess);
              //Ausgabe in Konsole
              System.out.println("Glückwunsch, Treffer!");
          }
          // Korb nicht
          if(ball1.getYPosition() >= boden - ball1.durchmesser && ball1.getXPosition() >= 80) {
              fertig = true; 
              //zeichne roten Korb
              leinwand.setForegroundColor(Color.RED);
              Rectangle korbFailed = new Rectangle(0,400,100,20);
              leinwand.fill(korbFailed);
              //Ausgabe in Konsoe
              System.out.println("Schade, versuchen Sie es noch einmal!");
          }
          //Decke getroffen
          if(ball1.getYPosition() <= 0)
          {
              //Verändere die y-Änderung, Winkel wird übernommen und umgedreht
              yÄnderung = -yÄnderung;
          }
          //Wand getroffen                
          if((ball1.getXPosition() <= 0 || ball1.getXPosition() >= 560))
          {
              //Verändere die x-Änderung, Winkel wird übernommen und umgedreht
              xÄnderung = -xÄnderung;
          }
       }          
     }
}
