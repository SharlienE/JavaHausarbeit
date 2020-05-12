import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Punkt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Punkt
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    double xPunkt;
    double yPunkt;
    int geschwindigkeit;
    int wurfrichtung;

    /**
     * Konstruktor für Objekte der Klasse Punkt
     */
    public Punkt()
    {
        // Instanzvariable initialisieren
        geschwindigkeit = 100;
        wurfrichtung = 30;
        
    }
    
    /**
     * Methode zuum Erstellen & Füllen eines Arrays mit den Geschwindigkeiten
     */
    public void arrayGeschwindigkeiten()
    {
        ArrayList<Integer> geschwindigkeiten = new ArrayList<Integer>();
        for (int i=0; i<=50;i++)
        {
            Integer geschwindigkeit = new Integer(0+10*i);
            geschwindigkeiten.add(geschwindigkeit);
        }
    }
  
    /**
     * Methode zum Erstellen & Füllen eines Arrays mit den Winkeln
     * 
     */
    public void arrayWurfrichtungen()
    {
        int winkel;
        ArrayList<Integer> wurfrichtungen = new ArrayList<Integer>();
        for (int i=0; i<=36;i++)
        {
            winkel = new Integer(0+5*i);
            wurfrichtungen.add(winkel);
        }
    }

    /**
     * Methode zur Berechnung von der x Koordinate vom Anfangspunkt (Sinussatz)
     */
    public void getXpunkt ()
    {
        //Berechnung von der x Koordinate vom Anfangspunkt
        xPunkt = geschwindigkeit*Math.sin(Math.PI*wurfrichtung/180);   
    }
    
    /**
     * Methode zur Berechnung von der y Koordinate vom Anfangspunkt (Sinussatz)
     */
    public void getYpunkt()
    {
        //Berechnung von der x Koordinate vom Anfangspunk
        double alpha;
        int zahl=90;
        alpha = zahl - wurfrichtung;
        yPunkt = geschwindigkeit*Math.sin(Math.PI*alpha/180);   
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
    public float getGeschwindigkeit()
    {
        // put your code here
        return geschwindigkeit;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setRichtungHoch()
    {
        // put your code here
        this.wurfrichtung = wurfrichtung;
        wurfrichtung++;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setRichtungRunter()
    {
        // put your code here
        this.wurfrichtung = wurfrichtung;
        wurfrichtung--;
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
        return wurfrichtung;
    }
    
}
