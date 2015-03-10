import java.util.Vector;
 
public class Vehicle {
	 public static final int BASIC=0;
	 public static final int GENERAL=1;
	 public static final int LUXE=2;
     private String model;
     private String marca;
     private int categoria;
     public Vehicle(String marca,String model, int categoria){
     	this.marca=marca;
     	this.model=model;
     	this.categoria=categoria;
     }
     public String getModel(){
     	return model;
     }
     public String getMarca(){
     	return marca;
     }
     public int getCategoria(){
     	return categoria;
     }
}
