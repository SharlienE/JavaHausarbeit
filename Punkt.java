
/**
 * Beschreiben Sie hier die Klasse Punkt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Punkt
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    int xKraft;
    int yRichtung;
    float vGeschwindigkeit;
    float geschwindigkeit;
    

    /**
     * Konstruktor für Objekte der Klasse Punkt
     */
    public Punkt()
    {
        // Instanzvariable initialisieren
        xKraft = 100;
        yRichtung = 200;
        
        vGeschwindigkeit = (int) Math.pow(xKraft,2) + (int) Math.pow(yRichtung,2);      
        geschwindigkeit = (int) Math.sqrt(vGeschwindigkeit);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setKrafthoch()
    {
        // put your code here
        this.xKraft = xKraft;
        xKraft++;
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setKraftrunter()
    {
        // put your code here
        this.xKraft = xKraft;
        xKraft--;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getKraft()
    {
        // put your code here
        return xKraft;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setRichtunghoch()
    {
        // put your code here
        this.yRichtung = yRichtung;
        yRichtung++;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setRichtungrunter()
    {
        // put your code here
        this.yRichtung = yRichtung;
        yRichtung--;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getRichtung()
    {
        // put your code here
        return yRichtung;
    }
    /**
     * Methode zur Berechnung von Geschwindigkeit (Pythagoras)
     */
    public float getGeschwindigkeit (){
        //hier kommt die Berechnung (pythagoras)
        vGeschwindigkeit = (int) Math.pow(xKraft,2) + (int) Math.pow(yRichtung,2);      
        geschwindigkeit = (int) Math.sqrt(vGeschwindigkeit);
        
        return geschwindigkeit;
    }
    
}
