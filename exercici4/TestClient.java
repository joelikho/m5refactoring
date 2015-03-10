import org.junit.*;
import java.util.Vector;
import  java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import static org.junit.Assert.*;    // importa una classe static
 
public class TestClient {
    @Test
     public void testClientInforme() {
         // comprova que el constructor Punt() pugui ser cridat
        Client c=new Client("53639767","Joel","65847554");
        String s="Informe de lloguers del client Joel (53639767)\n\tTata Vista: 90.0e\nImport a pagar: 90.0e\nPunts guanyats: 1\n";
        Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
        // demostració de construccuó d'un lloguer amb una data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date=null;
        try{
            date = dateFormat.parse("2/8/2013");
        }catch(ParseException e){
            System.out.println(e);
        }
        Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);
        c.afegeix(lloguerBasic);
        assertEquals(s, c.informe());   
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestClient");
    } 
}
