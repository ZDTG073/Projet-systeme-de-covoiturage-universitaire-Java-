
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// ibrahim ghabouba
public class teacher extends users {
   

     public  List<String> lot = new ArrayList<>(); //liste des objects etudiants
 void listmaking(String id, String nom, String prenom, Boolean music, String garconfille, Boolean fumeur, String usersexe, String rate, String numerotlph,int adr, String fac) {       
    lot.addAll(Arrays.asList(id, nom, prenom, String.valueOf(music), garconfille, String.valueOf(fumeur), usersexe, rate, numerotlph, String.valueOf(adr), fac));
   
}   
public static List <List<String>> loat = new ArrayList<>(); 
 void listolists(List <String> lot){
    loat.add(lot);
 }
  // Méthode pour sauvegarder les données
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher_loat.dat"))) {
            oos.writeObject(loat);
            System.out.println("Données de 'teacher' sauvegardées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données de 'teacher' : " + e.getMessage());
        }
    }
     // Méthode pour charger les données
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher_loat.dat"))) {
            loat = (List<List<String>>) ois.readObject();
            System.out.println("Données de 'teacher' chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des données de 'teacher' : " + e.getMessage());
        }
    }
}
