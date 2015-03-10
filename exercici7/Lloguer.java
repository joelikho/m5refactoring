import java.util.Vector;
import  java.util.Date;
public class Lloguer {
     private Date data;
     private int dies;
     private Vehicle vehicle; 
     public Lloguer(Date data, int dies, Vehicle v){
     	this.data=data;
     	this.dies=dies;
     	this.vehicle=v;
     }
     public Date getData(){
     	return data;
     }
     public int getDies(){
     	return dies;
     }
     public Vehicle getVehicle(){
     	return vehicle;
     }
     public double quantitat(){
        double quantitat=0;
             switch (this.getVehicle().getCategoria()) {
                 case Vehicle.BASIC:
                     quantitat += 3;
                     if (this.getDies() > 3) {
                         quantitat += (this.getDies() - 3) * 1.5;
                     }
                     break;
                 case Vehicle.GENERAL:
                     quantitat += 4;
                     if (this.getDies() > 2) {
                         quantitat += (this.getDies() - 2) * 2.5;
                     }
                     break;
                 case Vehicle.LUXE:
                     quantitat += this.getDies() * 6;
                     break;
             }
        return quantitat;
     }
}
