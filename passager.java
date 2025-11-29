import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
//shafik 
public class passager {
    static int cptp=0;
    List<String> lop = new ArrayList<>();
 void passagerlist(String id, String prenom, String music,String garconfille, String sexe, String fumeur, String numerotlph) {
         lop.addAll(Arrays.asList(id, prenom, music, garconfille, sexe,fumeur, numerotlph));
         
 }
   public static List <List<String>> loap = new ArrayList<>(); 
 void listolists(List <String> los){
    loap.add(los);
 }

 // Méthode pour sauvegarder les données
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("passager_loap.dat"))) {
            oos.writeObject(loap);
            oos.writeObject(cptp);
            System.out.println("Données de 'passager' sauvegardées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données de 'passager' : " + e.getMessage());
        }
    }

    // Méthode pour charger les données
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("passager_loap.dat"))) {
            loap = (List<List<String>>) ois.readObject();
            cptp = ois.readInt();
            System.out.println("Données de 'passager' chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des données de 'passager' : " + e.getMessage());
        }
    }
    int cptcomp=0; //c'est un compteur de compatibilité pour trouve e meilleur conducteur disponible pour le passager 
  void interfacepassager(String id){
    int i=0;
    loadData();
    if(!users.loau.isEmpty()){
    
    while (users.loau.get(i).get(0) == null ? id != null : !users.loau.get(i).get(0).equals(id)) {
        i++;
    }
    
    if (users.loau.get(i).get(0) == null ? id == null : users.loau.get(i).get(0).equals(id)) {
        cptp++;

    System.out.println("Bienvenue " + users.loau.get(i).get(1) + " " + users.loau.get(i).get(2));
    passagerlist(users.loau.get(i).get(0), users.loau.get(i).get(2), users.loau.get(i).get(3), users.loau.get(i).get(4), users.loau.get(i).get(6), users.loau.get(i).get(5), users.loau.get(i).get(8));
     Scanner scanner = new Scanner(System.in);
    try{
    while (true) {

    System.out.println("---Passager Interface---");    
    System.out.println("1. lancer la recherche d'une course");
    System.out.println("2. modifiez vos preferences");
    System.out.println("3. deconnection");
    

    System.out.print("entrez votre choix: ");
    int choix = scanner.nextInt();
    scanner.nextLine(); 
    if (choix == 1) {
        itinerary it = new itinerary();
         it.interfaceitinerarypassagers();
        lop.add(String.valueOf(it.choix));
        lop.add(it.lieu);
        loadData();
        listolists(lop);
        saveData();
        System.out.println("lancement de la recherche d'une course en fonction de vos preferences...");
        conducteur.loadData();
        if(!conducteur.loap.isEmpty()){
            int bestcpt=0;
            trajets tr = new trajets();
            int g=0;
        while (i<conducteur.loap.size()){
            conducteur.loadData();
            if (lop.get(6).equals(conducteur.loap.get(i).get(6)) && conducteur.loap.get(i).get(7).contains(lop.get(7)) ) {
                cptcomp=0;
             
             if (lop.get(2).equals(conducteur.loap.get(i).get(2)) ) {
                cptcomp++;
             }    
             if (lop.get(4).equals(conducteur.loap.get(i).get(4)) && lop.get(3).equals("du meme sexe")){
                cptcomp++;
             }else if (lop.get(3).equals("indifferent")){
                cptcomp++;
             }

            if (lop.get(5).equals(conducteur.loap.get(i).get(5)) && lop.get(3).equals("du meme sexe")){
                    cptcomp++;
             }
            
            if (cptcomp==3) {
                System.out.println("conducteur trouve avec succes");
                System.out.println("le numero de telephone du conducteur est : " + conducteur.loap.get(i).get(6));
                trajets t = new trajets();
                t.listrajets(lop.get(0), lop.get(1), conducteur.loap.get(i).get(0), conducteur.loap.get(i).get(1),lop.get(6), it.lieu);
                trajets.loadData();
                trajets.loatrm.add(t.listtrajets);
                trajets.loatr.add(t.listtrajets);
                trajets.saveData();
                
                break;
            } else if (cptcomp>bestcpt) {
                bestcpt=cptcomp;
                tr.listrajets(lop.get(0), lop.get(1), conducteur.loap.get(i).get(0), conducteur.loap.get(i).get(1),lop.get(6), conducteur.loap.get(i).get(8));
                g=i;
            }
            i++;
        }   
           try {
                    Thread.sleep(1000); // Pause de 1 seconde (1000 millisecondes) pour éviter une boucle trop rapide
                } catch (InterruptedException e) {
                System.out.println("Erreur lors de la pause : " + e.getMessage());
                }
        }  
        if (cptcomp<3) {
            System.out.println("aucun conducteur qui correspond a tout vos critere n'est disponible,cependant nous avons trouve un conducteur qui leur correspond le plus :");
            System.out.println("le numero de telephone du conducteur est : " + conducteur.loap.get(g).get(6));
            trajets.loadData();
            trajets.loatrm.add(tr.listtrajets);
            trajets.loatr.add(tr.listtrajets);
            trajets.saveData();
        }
        System.out.println("une fois que vous aurez terminer la course donner une note a votre conducteur");
        Ratings R = new Ratings();  
        R.interfaceRatings(conducteur.loap.get(g).get(0));
             int k=0;
            if (trajets.loatrm.isEmpty()) {
                System.out.println("La liste est vide");
            }
            else{
                
            while (trajets.loatrm.get(k).get(0) == null ? id != null : !trajets.loatr.get(k).get(0).equals(id)){
                k++;
            }
            if (trajets.loatrm.get(k).get(0) == null ? id == null : trajets.loatrm.get(k).get(0).equals(id)){
                
            trajets.loatrm.remove(k);
            saveData();
            }
            } 
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
            cptp--;
            saveData();
            }
            } 
        
        }else {
            System.out.println("Aucun conducteur trouvé.");
        }
    
    } else if (choix == 2) {
        System.out.println("modification de vos preferences...");
        preferences p = new preferences();
        p.preference();
        System.out.println("vos preferences ont ete modifiees avec succes");
        
    } else if (choix == 3) {
        System.out.println("deconnection...");
        System.out.println("Merci d'avoir utilise notre application");
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
            saveData();
            }
            }
        break;
    } else {
        System.out.println("choix invalide");
    }
}
    } catch (Exception e) {
        System.out.println("Erreur: Entrez un nombre valide.");
        scanner.nextLine(); 
    }
    
    } else {
        System.out.println("Utilisateur non trouvé, Assurez-vous que vous avez entré le bon id?");
    } 
    } else {
        System.out.println("Aucun utilisateur trouvé.");
    }
 }
  
}

