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
		Client c=new Client("53639767","Joel","65847554");
		// demostració de construcció d'un vehicle de categoria BASIC
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
		System.out.println(c.informe());
		System.out.println(c.informeHTML());
	}


}
