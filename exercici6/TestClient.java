import org.junit.*;
import java.util.Vector;
import  java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import static org.junit.Assert.*;    // importa una classe static
 
public class TestClient {
    @Test
     public void testClientInforme4dies() {
         // comprova que el constructor Punt() pugui ser cridat
        Client c=new Client("53639767","Joel","65847554");
        String s="Informe de lloguers del client Joel (53639767)\n\tTata Vista: 135.0e\nImport a pagar: 135.0e\nPunts guanyats: 1\n";
        Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
        // demostració de construccuó d'un lloguer amb una data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date=null;
        try{
            date = dateFormat.parse("2/8/2013");
        }catch(ParseException e){
            System.out.println(e);
        }
        Lloguer lloguerBasic = new Lloguer(date, 4, vehicleBasic);
        c.afegeix(lloguerBasic);
        assertEquals(s, c.informe());   
    }
    @Test
     public void testClientInforme0dies() {
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
        Lloguer lloguerBasic = new Lloguer(date, 0, vehicleBasic);
        c.afegeix(lloguerBasic);
        assertEquals(s, c.informe());   
    }
    @Test
     public void testClientInforme1dies() {
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
        Lloguer lloguerBasic = new Lloguer(date, 0, vehicleBasic);
        c.afegeix(lloguerBasic);
        assertEquals(s, c.informe());   
    }
    @Test
     public void testClientInforme0Lloguers() {
         // comprova que el constructor Punt() pugui ser cridat
        Client c=new Client("53639767","Joel","65847554");
        String s="Informe de lloguers del client Joel (53639767)\nImport a pagar: 0.0e\nPunts guanyats: 0\n";
        assertEquals(s, c.informe());   
    }
    @Test
     public void testClientInforme2Lloguers() {
         // comprova que el constructor Punt() pugui ser cridat
        Client c=new Client("53639767","Joel","65847554");
        String s="Informe de lloguers del client Joel (53639767)\n\tTata Vista: 90.0e\n\tFerrari TestaRosa: 180.0e\nImport a pagar: 270.0e\nPunts guanyats: 2\n";
        Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
        Vehicle vehicleLuxe= new Vehicle("Ferrari","TestaRosa",Vehicle.LUXE);
        // demostració de construccuó d'un lloguer amb una data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date=null;
        try{
            date = dateFormat.parse("2/8/2013");
        }catch(ParseException e){
            System.out.println(e);
        }
        Lloguer lloguerLuxe = new Lloguer(date, 1, vehicleLuxe);
        Lloguer lloguerBasic = new Lloguer(date, 1, vehicleBasic);
        c.afegeix(lloguerBasic);
        c.afegeix(lloguerLuxe);
        assertEquals(s, c.informe());   
    }
    @Test
    public void testClientInforme3Lloguers(){
        Client c=new Client("53639767","Joel","65847554");
        String s="Informe de lloguers del client Joel (53639767)\n\tTata Vista: 90.0e\n\tAudi A3: 120.0e\n\tFerrari TestaRosa: 180.0e\nImport a pagar: 390.0e\nPunts guanyats: 3\n";
        Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
        Vehicle vehicleGeneral = new Vehicle("Audi", "A3", Vehicle.GENERAL);
        Vehicle vehicleLuxe= new Vehicle("Ferrari","TestaRosa",Vehicle.LUXE);
        // demostració de construccuó d'un lloguer amb una data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date=null;
        try{
            date = dateFormat.parse("2/8/2013");
        }catch(ParseException e){
            System.out.println(e);
        }
        Lloguer lloguerLuxe = new Lloguer(date, 1, vehicleLuxe);
        Lloguer lloguerGeneral = new Lloguer(date, 1, vehicleGeneral);
        Lloguer lloguerBasic = new Lloguer(date, 1, vehicleBasic);
        c.afegeix(lloguerBasic);
        c.afegeix(lloguerGeneral);
        c.afegeix(lloguerLuxe);
        assertEquals(s, c.informe()); 
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestClient");
    } 
}
