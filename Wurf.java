import java.awt.*;
import java.awt.geom.*;
import java.lang.Math; 

/**
 * Beschreiben Sie hier die Klasse Wurf.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 * 

 * 
 */
public class Wurf
{
    private int yAnfang; //Ursprungs y-position vom erstellten stoß 
    private int xAnfang; //Ursprungs x-position vom erstellten stoß
    private int xPunkt;
    private int yPunkt;
    private Color farbe;
    private Ball ball1;
    public Canvas leinwand;
    private int gravitation = 10;  // Einfluss der Gravitation
    public int geschwindigkeit = 200;
    public int winkel = 45;
    private int gespeicherterWinkel;
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
        leinwand.setForegroundColor(farbe); // Wurflinienfarbe wird gewählt
        leinwand.drawLine(xAnfang, yAnfang, xPunkt, yPunkt);  
    }
  
    public void geschwindigkeitSchreiben()
    //Di Geschwindigkeitsanzeige wird erstellt
    {
        leinwand.setForegroundColor(Color.black);
        leinwand.drawString("Anfangsgeschwindigkeit: " + (geschwindigkeit/10), 
            xAnfang - 140, yAnfang + 20);
    }
    
    //Funktioniert
    public void geschwindigkeitLöschen()
    //Die Geschwindigkeitsanzeige wird gelöscht
    {
       leinwand.eraseString("Anfangsgeschwindigkeit: " + (geschwindigkeit/10),  
        xAnfang - 140, yAnfang + 20); 
    }
    
    public void geschwindigkeitErhöhen()
     //Hier wird nach der Eingabe von + die Geschwindigkeit erhöht
    {
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
        if(deckeGetroffen == true){
            winkel += 180;      // wenn der Ball an der Decke abprallt, wird die Steigung gespiegelt. Faür erhält der sinus winkel plus 180°
        } 
            //Überprüfung, ob es ein Seitenabpraller ist
        if(wandGetroffen == true){
            //Überprüfung, ob links abprallt
             if(ball1.gibXPosition() <= 40){
                    winkel += 90;
                }
            //Überprüfung, ob rechts abprallt
             if (ball1.gibXPosition() >= 560){
                    winkel -= 90;
                }
        }
        gravitation += 5;
        double winkel1 = ((winkel*Math.PI)/180);
        double yÄnderung = (Math.sin(winkel1) * (geschwindigkeit/5)); 
        double xÄnderung = (Math.cos(winkel1) * (geschwindigkeit/5));       
        ball1.yPosition = ball1.yPosition - ((int)(yÄnderung) - gravitation);
        ball1.xPosition = ball1.xPosition - (int)(xÄnderung);
        deckeGetroffen = false;   
        wandGetroffen = false;
        // An der neuen Position erneut zeichnen.
        ball1.zeichneBall();
    }  

    
    //Der Ball soll mit den gegebenen Parametern gestoßen werden
    //Funktioniert
    public void werfen()
    {
      gespeicherterWinkel = winkel;
      boolean fertig = false;
      while (!fertig)
      {
          leinwand.wait(50);// kurze Verzögerung, damit man eine Animation sieht
          bewegen();
          // Überprüfung, ob getroffen wurde
          if (ball1.gibXPosition() <= 60 && ball1.gibYPosition() >=360)
          {
            fertig = true;
          }
                            
          //Prüfung & Berechnung der Decken Abpraller
          if(ball1.gibYPosition() <= 0 && geschwindigkeit > 0)
          {
            deckeGetroffen = true;
          }
                           
          if((ball1.gibXPosition() <= 0 || ball1.gibXPosition() >= 600) && geschwindigkeit > 0)
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
        gravitation = 5;
    }
    
    public int gibGeschwindigkeit()
    {
        return geschwindigkeit;
    }
    
}

