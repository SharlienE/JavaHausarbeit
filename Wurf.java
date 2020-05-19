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
 * @author (Ihr Name) 
 * 
 */
public class Wurf
{
    private int yAnfang; //Ursprungs y-Position vom erstellten Stoß 
    private int xAnfang; //Ursprungs x-Position vom erstellten Stoß
    private int xPunkt;
    private int yPunkt;
    private Color farbe;
    private Ball ball1;
    public Canvas leinwand;
    private int gravitation = 2;  // Einfluss der Gravitation
    public int geschwindigkeit = 200; // Anfangsgeschwindigkeit
    public int winkel = 45; // Anfangswinkel
    private int gespeicherterWinkel;
    private int wandrechts = 600; // x-Koordinaten der Wand rechts
    private int wandlinks = 0; // x - Koordinaten der Wand links
    private boolean deckeGetroffen = false;
    private boolean wandGetroffen = false;

    /**
     * Konstruktor für Objekte der Klasse Wurf
     * Anfangsgeschwindigkeit wird angegeben
     */
    public Wurf(int x0, int y0, int x1, int y1, Color linienFarbe, Canvas leinwand, Ball ball1)    
    {
        yAnfang = y0;
        xAnfang = x0;
        xPunkt = x1;
        yPunkt = y1;
        this.leinwand = leinwand;
        farbe = linienFarbe;
        this.ball1 = ball1;
    }
     
    public void wurfrichtungZeichnen()
    {    //die Wurflinie, die vom Nutzer gesehen wird, wird gezeichnet 
        leinwand.setForegroundColor(farbe); // Wurflinienfarbe wird gewählt - Grün
        leinwand.drawLine(xAnfang, yAnfang, xPunkt, yPunkt);  
    }
  
    public void geschwindigkeitSchreiben()
    //Die Geschwindigkeitsanzeige wird erstellt
    {
        leinwand.setForegroundColor(Color.black);
        leinwand.drawString("Anfangsgeschwindigkeit: " + ((float) geschwindigkeit/100), 350, 450);
    }
    
    //Funktioniert
    public void geschwindigkeitLöschen()
    //Die Geschwindigkeitsanzeige wird gelöscht
    {
       leinwand.eraseString("Anfangsgeschwindigkeit: " + ((float) geschwindigkeit/100), 350, 450);
    }
    
    public void geschwindigkeitErhöhen()
     //Hier wird nach der Eingabe von + die Geschwindigkeit erhöht
    {
       //geschwindigkeitSchreiben()
        if(geschwindigkeit < 500){
           geschwindigkeitLöschen();
           geschwindigkeit += 10;
           geschwindigkeitSchreiben();
           double winkel1= ((winkel*Math.PI)/180);    
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           double yPosition = yAnfang - (Math.sin(winkel1) * geschwindigkeit);
           yPunkt = (int)(yPosition);
           double xPosition = xAnfang - (Math.cos(winkel1) * geschwindigkeit);
           xPunkt = (int)(xPosition);
           ball1.zeichneBall();
           wurfrichtungZeichnen();
       }     
       else {
           System.out.println("Maximale Geschwindigkeit erreicht");
       }
       //geschwindigkeitLöschen();
    }
    
    public void geschwindigkeitSenken()
    //Hier wird nach der Eingabe von - die Geschwindigkeit gesenkt
    {
       if(geschwindigkeit > 10 ){
           geschwindigkeitLöschen();
           geschwindigkeit -= 10;
           geschwindigkeitSchreiben();
           double winkel1 = ((winkel*Math.PI)/180);
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           double yPosition = yAnfang - (Math.sin(winkel1) * geschwindigkeit);
           yPunkt = (int)(yPosition);
           double xPosition = xAnfang - (Math.cos(winkel1) * geschwindigkeit);
           xPunkt = (int)(xPosition);
           ball1.zeichneBall();
           wurfrichtungZeichnen();
        }   
      else {
           System.out.println("Minimale Geschwindigkeit erreicht");
      }
    }
        
    public void wurfrichtungRechts()
    {
        if(winkel <= 175){
           winkel += 5;
           double winkel1 = ((winkel*Math.PI)/180);
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           double yPosition = yAnfang - (Math.sin(winkel1) * geschwindigkeit);
           yPunkt = (int)(yPosition);
           double xPosition = xAnfang - (Math.cos(winkel1) * geschwindigkeit);
           xPunkt = (int)(xPosition);
           ball1.zeichneBall();
           wurfrichtungZeichnen();
        } else  {
            System.out.println("Weiter nach rechts geht es nicht");
        }
        
    }   
    
    //über 90 und bis 5 anpassen
    public void wurfrichtungLinks()
    {
       if(winkel >= 5){
           winkel -= 5;
           double winkel1 = ((winkel*Math.PI)/180);
           leinwand.eraseLine(xAnfang, yAnfang, xPunkt, yPunkt);
           double yPosition = yAnfang - (Math.sin(winkel1) * geschwindigkeit);
           yPunkt = (int)(yPosition);
           double xPosition = xAnfang - (Math.cos(winkel1) * geschwindigkeit);
           xPunkt = (int)(xPosition);
           ball1.zeichneBall();
           wurfrichtungZeichnen();      
        }  else {
             System.out.println("Weiter nach links geht es nicht");
        }
    }
  
    //bearbeiten
    /**
     * Bewege diesen Ball entsprechend seiner Position und 
     * Geschwindigkeit und zeichne ihn erneut.
     **/
    public void bewegen()
    {
        ball1.loescheBall();
        // Neue Position berechnen.
        
        
            
        
            //Überprüfung, ob Decke getroffen wurde
        if(deckeGetroffen == true){
            winkel += 180;      // wenn der Ball an der Decke abprallt, wird die Steigung gespiegelt. Faür erhält der sinus winkel plus 180°
            leinwand.setFont(new Font("helvetica", Font.BOLD, 14));
            leinwand.setForegroundColor(Color.BLUE);
            leinwand.drawString("Spiel: Korbwurf", 220, 20);
            leinwand.drawLine(0,0,600,0);
        } 
            //Überprüfung, ob es ein Seitenabpraller ist
        if(wandGetroffen == true){
            //Überprüfung, ob links abprallt
             if(ball1.gibXPosition() <= (wandlinks + ball1.durchmesser)){
                    winkel += 90;
                    leinwand.setForegroundColor(Color.BLUE);
                    leinwand.drawLine(0,400,0,0);
                }
            //Überprüfung, ob rechts abprallt
             if (ball1.gibXPosition() >= (wandrechts - ball1.durchmesser)){
                    winkel -= 90;
                    leinwand.setForegroundColor(Color.BLUE);
                    leinwand.drawLine(600,0,600,400);
                }
        }
        gravitation += 2;
        double winkel1 = ((winkel*Math.PI)/180);
        double yÄnderung = (Math.sin(winkel1) * (geschwindigkeit/5)); 
        double xÄnderung = (Math.cos(winkel1) * (geschwindigkeit/5));       
        ball1.yPosition = ball1.yPosition - ((int)(yÄnderung) - gravitation);
        ball1.xPosition = ball1.xPosition - (int)(xÄnderung);
        deckeGetroffen = false;   
        wandGetroffen = false;
        // Prüfen, ob der Boden erreicht ist.
        if(ball1.yPosition >= (ball1.bodenhoehe - ball1.durchmesser) && yÄnderung>0) {
            ball1.yPosition = (int) (ball1.bodenhoehe - ball1.durchmesser);
            yÄnderung = -yÄnderung; 
            
        }
        
        // An der neuen Position erneut zeichnen.
        ball1.zeichneBall();
    }  

    
    //Der Ball soll mit den gegebenen Parametern gestoßen werden
    //Funktioniert
    public void werfen()
    {
      int boden = 400;
      gespeicherterWinkel = winkel;
      //bewegen();
      boolean fertig = false;
      while (!fertig)
      {
          leinwand.wait(50);// kurze Verzögerung, damit man eine Animation sieht
          bewegen();
          if(ball1.gibYPosition() >= boden - ball1.durchmesser) {
                fertig = true; 
                leinwand.setForegroundColor(Color.RED);
                Rectangle korbFailed = new Rectangle(0,400,100,20);
                leinwand.fill(korbFailed);
                System.out.println("Schade, versuchen Sie es noch einmal!");
            }
          
          
          // Überprüfung, ob Korb getroffen wurde
          if (ball1.gibXPosition() <= 60 && ball1.gibYPosition() >=360)
          {
            fertig = true;
            leinwand.setForegroundColor(Color.GREEN);
                Rectangle korbSuccess = new Rectangle(0,400,100,20);
                leinwand.fill(korbSuccess);
                System.out.println("Glückwunsch, Treffer!");
          }
                            
          //Prüfung & Berechnung der Decken Abpraller
          if(ball1.gibYPosition() <= 0 && geschwindigkeit > 0)
          {
            deckeGetroffen = true;
          }
                           
          if((ball1.gibXPosition() <= 0 || ball1.gibXPosition() >= 560) && geschwindigkeit > 0)
          {
            wandGetroffen = true;
          }
         //Überprüfung, ob der Rand getroffen wurde
          if(ball1.gibYPosition() >= 360 && ball1.gibXPosition() > 60  ) 
          {
            fertig = true;
          }
    
      }          
     }
      
    public void restart()
        {
        winkel = gespeicherterWinkel;
        //gravitation = 5;
    }
    
    public int gibGeschwindigkeit()
    {
        return geschwindigkeit;
    }
    
}

