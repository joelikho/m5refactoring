import java.util.Vector;
 
public class Client {
     private String nif;
     private String nom;
     private String telefon;
     private Vector<Lloguer> lloguers;
 
     public Client(String nif, String nom, String telefon) {
         this.nif = nif;
         this.nom = nom;
         this.telefon = telefon;
         this.lloguers = new Vector<Lloguer>();
    }
 
     public String getNif()     { return nif;     }
     public String getNom()     { return nom;     }
     public String getTelefon() { return telefon; }
 
     public void setNif(String nif) { this.nif = nif; }
     public void setNom(String nom) { this.nom = nom; }
     public void setTelefon(String telefon) {
         this.telefon = telefon;
     }
     public void afegeix(Lloguer lloguer) {
         if (! lloguers.contains(lloguer) ) {
             lloguers.add(lloguer);
         }
     }
     public void elimina(Lloguer lloguer) {
         if (lloguers.contains(lloguer) ) {
             lloguers.remove(lloguer);
         }
     }
     public boolean conte(Lloguer lloguer) {
         return lloguers.contains(lloguer);
     }
     public Vector<Lloguer> getLloguers(){
        return lloguers;
     }
     private double quantitatPerLloguer(Lloguer lloguer){
        double quantitat=0;
             switch (lloguer.getVehicle().getCategoria()) {
                 case Vehicle.BASIC:
                     quantitat += 3;
                     if (lloguer.getDies() > 3) {
                         quantitat += (lloguer.getDies() - 3) * 1.5;
                     }
                     break;
                 case Vehicle.GENERAL:
                     quantitat += 4;
                     if (lloguer.getDies() > 2) {
                         quantitat += (lloguer.getDies() - 2) * 2.5;
                     }
                     break;
                 case Vehicle.LUXE:
                     quantitat += lloguer.getDies() * 6;
                     break;
             }
        return quantitat;
     }
     public String informe() {
         double total = 0;
         int bonificacions = 0;
         String resultat = "Informe de lloguers del client " +
             getNom() +
             " (" + getNif() + ")\n";
         for (Lloguer lloguer: lloguers) {
             double quantitat = this.quantitatPerLloguer(lloguer);
             // afegeix lloguers freqüents
             bonificacions ++;
             // afegeix bonificació per dos dies de lloguer de Luxe
             if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
                     lloguer.getDies()>1 ) {
                 bonificacions ++;
             }
             // composa els resultats d'aquest lloguer
             resultat += "\t" +
                 lloguer.getVehicle().getMarca() +
                 " " +
                 lloguer.getVehicle().getModel() + ": " +
                 (quantitat * 30) + "e" + "\n";
             total += quantitat * 30;
         }
     
         // afegeix informació final
         resultat += "Import a pagar: " + total + "e\n" +
             "Punts guanyats: " + bonificacions + "\n";
         return resultat;
     }
     public String capHTML(String s){
        return "<html><head/><body>"+s;
     }
     public String peuHTML(String s){
        return s+"</body></html>";
     }
     public String htmlElement(String s, String element){
        return "<"+element+">"+s+"</"+element+">";
     }
     public String informeHTML() {
         double total = 0;
         int bonificacions = 0;
         String resultat = this.htmlElement("Informe de lloguers del client " +
             getNom() +
             " (" + getNif() + ")\n","h3");
         for (Lloguer lloguer: lloguers) {
             double quantitat = 0;
             switch (lloguer.getVehicle().getCategoria()) {
                 case Vehicle.BASIC:
                     quantitat += 3;
                     if (lloguer.getDies() > 3) {
                         quantitat += (lloguer.getDies() - 3) * 1.5;
                     }
                     break;
                 case Vehicle.GENERAL:
                     quantitat += 4;
                     if (lloguer.getDies() > 2) {
                         quantitat += (lloguer.getDies() - 2) * 2.5;
                     }
                     break;
                 case Vehicle.LUXE:
                     quantitat += lloguer.getDies() * 6;
                     break;
             }
     
             // afegeix lloguers freqüents
             bonificacions ++;
     
             // afegeix bonificació per dos dies de lloguer de Luxe
             if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
                     lloguer.getDies()>1 ) {
                 bonificacions ++;
             }
     
             // composa els resultats d'aquest lloguer
             resultat += this.htmlElement("\t" +
                 lloguer.getVehicle().getMarca() +
                 " " +
                 lloguer.getVehicle().getModel() + ": " +
                 (quantitat * 30) + "e" + "\n","p");
             total += quantitat * 30;
        }
     
         // afegeix informació final
         resultat += this.htmlElement("Import a pagar: " + total + "e\n" +
             "Punts guanyats: " + bonificacions + "\n","p");
         resultat=this.capHTML(resultat);
         resultat=this.peuHTML(resultat);
         return resultat;
     }
 }
