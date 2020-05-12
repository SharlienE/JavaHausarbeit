
/**
 * Beschreiben Sie hier die Klasse Punkt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Punkt
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    float xKraft;
    float yRichtung;
    float vGeschwindigkeit;
    float geschwindigkeit;
    double alpha;
        

    /**
     * Konstruktor für Objekte der Klasse Punkt
     */
    public Punkt()
    {
        // Instanzvariable initialisieren
        xKraft = 100.0f;
        yRichtung = 200.0f;
        
        
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
        //xKraft = vGeschwindigkeit, 2)
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
    public float getKraft()
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
    public float getRichtung()
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
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setGeschwindigkeitHoch()
    {
        // put your code here
        this.geschwindigkeit = geschwindigkeit;
        geschwindigkeit++;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setGeschwindigkeitRunter()
    {
        // put your code here
        this.geschwindigkeit = geschwindigkeit;
        geschwindigkeit--;
    }
    
   
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setRichtungPlus()
    {
        
        double alpha = Math.toDegrees(Math.atan(yRichtung/xKraft));
        System.out.println(alpha);
        alpha++;
        System.out.println(alpha);
        
    }

}
