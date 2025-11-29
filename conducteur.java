import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
//shafik
public class conducteur {
 //cette methode permet de stocker les users quand ils se connectent en mode conducteur
     List<String> loc = new ArrayList<>();
     static int cptc=0;
    void driverlist(String id, String prenom, String music,String garconfille, String sexe, String fumeur, String numerotlph) {
         loc.addAll(Arrays.asList(id, prenom, music, garconfille, sexe,fumeur, numerotlph));
         
 }
   public static List <List<String>> loap = new ArrayList<>(); 
 void listolists(List <String> loc){
    loap.add(loc);
 }
 // Méthode pour sauvegarder les données
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("conducteur_loap.dat"))) {
            oos.writeObject(loap);
            System.out.println("Données de 'conducteur' sauvegardées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données de 'conducteur' : " + e.getMessage());
        }
    }

    // Méthode pour charger les données
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("conducteur_loap.dat"))) {
            loap = (List<List<String>>) ois.readObject();
            cptc = ois.readInt();
            System.out.println("Données de 'conducteur' chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des données de 'conducteur' : " + e.getMessage());
        }
    }

     void driverinterface(String id) {

        int i=0;
     if(!users.loau.isEmpty()){
    
    while (users.loau.get(i).get(0) == null ? id != null : !users.loau.get(i).get(0).equals(id)) {
        i++;
    }
     if (users.loau.get(i).get(0) == null ? id == null : users.loau.get(i).get(0).equals(id))
      {
    System.out.println("Bienvenue " + users.loau.get(i).get(1) + " " + users.loau.get(i).get(2));
    driverlist(users.loau.get(i).get(0), users.loau.get(i).get(2), users.loau.get(i).get(3), users.loau.get(i).get(4), users.loau.get(i).get(6), users.loau.get(i).get(5), users.loau.get(i).get(8));
    loadData();
    Scanner scanner = new Scanner(System.in); 
    try {
    while (true) {
        System.out.println("---Driver Interface---");
        System.out.println("1. lancer une course");
        System.out.println("2. deconnection");
        System.out.print("entrez votre choix: ");
        
        
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante
        if (choix == 1) {
            cptc++;
            itinerary it = new itinerary();
            it.interfaceitinerarydrivers(); 
            loc.add(String.valueOf(it.choix));
            loc.add(it.lieu);
             listolists(loc);
             saveData();
            System.out.println("vous etes maintenant visible pour les passagers, le numero de telephone du passager s'affichera ici :");
             System.out.println("Tapez 'stop' pour arrêter la recherche ou attendez qu'un passager soit trouvé.");
            while (true)  {
                trajets.loadData();
              if (!trajets.loatr.isEmpty()) {
    i = 0;
    while (i < trajets.loatr.size() && 
           (trajets.loatr.get(i).get(2) == null ? id != null : !trajets.loatr.get(i).get(2).equals(loc.get(0)))) {
        i++;
    }
    if (i < trajets.loatr.size() && 
        (trajets.loatr.get(i).get(2) == null ? id == null : trajets.loatr.get(i).get(0).equals(0))) {
        System.out.println("le numero de telephone du passager est : " + trajets.loatr.get(i).get(4));
    }
}
                   if (scanner.hasNextLine()) {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("stop")) {
            System.out.println("Recherche arrêtée par l'utilisateur.");
            break;
        }
    }
                // Ajout d'un délai pour ralentir la boucle
                 try {
                    Thread.sleep(1000); // Pause de 1 seconde (1000 millisecondes) pour éviter une boucle trop rapide
                } catch (InterruptedException e) {
                System.out.println("Erreur lors de la pause : " + e.getMessage());
                }
            }
            System.out.println("une fois que vous aurez terminer la course donner une note a votre conducteur");
            int j=0;
            if (loap.isEmpty()) {
                System.out.println("La liste est vide");
            }
            else{ 
            while (loap.get(j).get(0) == null ? id != null : !loap.get(j).get(0).equals(id)){
                j++;
            }
            if (loap.get(j).get(0) == null ? id == null : loap.get(j).get(0).equals(id)){
                
            loap.remove(j);
            cptc--;
            saveData();
            }
            } 
         
                
        } else if (choix == 2) {

            System.out.print("deconnection...");
            break;
        } else {
            System.out.println("choix invalide");
        }
    }
        }catch (Exception e) {
                System.out.println("Erreur: Entrez un nombre valide."+e.getMessage());
                scanner.nextLine(); 
        }
    } else {
        System.out.println("Utilisateur non trouvé.");
    }
    
}
    else {
        System.out.println("Aucun utilisateur trouvé.");
    }

}

} 
