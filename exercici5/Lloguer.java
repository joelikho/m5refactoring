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
}
