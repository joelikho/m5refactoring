/*Exercici 2. El Gestor de Lloguers lite
Codifica la classe GestorLloguersLite que crei un client amb el teu nom, 
que disposi de un mínim de tres lloguers, un per cada tipus de vehicle.*/
import java.util.Vector;
import  java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class GestorLloguersLite{
	public static String composaClient(Client c){
		String cli="Client: "+c.getNom()+"\n"+c.getNif()+"\n"+c.getTelefon();
		String llo="";
		int cont=0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Vector<Lloguer> lloguers=c.getLloguers();
		for (Lloguer ll : lloguers ) {
			llo+="\nLloguers:"+c.getLloguers().size()+"\n"+cont+". vehicle: "+ll.getVehicle().getMarca()+""+ll.getVehicle().getModel()+"\ndata d'inici: "+dateFormat.format(ll.getData())+"\ndies llogats: "+ll.getDies();
		}
		return cli+llo;
	}
	public static void main(String[] args) {
		 // comprova que el constructor Punt() pugui ser cridat
        Client c=new Client("53639767","Joel","65847554");
        String s="Informe de lloguers del client Joel (53639767)\n\tTata Vista: 90.0e\n\tFerrari TestaRosa: 180.0e\nImport a pagar: 270.0e\nPunts guanyats: 2\n";
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
		System.out.println(c.informe());
		System.out.println(c.informeHTML());
	}


}
