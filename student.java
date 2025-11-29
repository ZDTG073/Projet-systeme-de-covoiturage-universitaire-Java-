import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
// ibrahim ghabouba
public class student extends users {
    


     public  List<String> los = new ArrayList<>(); //liste des objects etudiants
 void listmaking(String id, String nom, String prenom, Boolean music, String garconfille, Boolean fumeur, String usersexe, String rate, String numerotlph, int ada, String fac, String spec) {       
    los.addAll(Arrays.asList(id, nom, prenom,String.valueOf(music), garconfille, String.valueOf(fumeur), usersexe, rate, numerotlph, String.valueOf(ada), fac, spec));

}  
    public static List <List<String>> loas = new ArrayList<>(); 
 void listolists(List <String> los){
    loas.add(los);
 }
  // Méthode pour sauvegarder les données
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student_loas.dat"))) {
            oos.writeObject(loas);
            System.out.println("Données de 'student' sauvegardées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données de 'student' : " + e.getMessage());
        }
    }
     // Méthode pour charger les données
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student_loas.dat"))) {
            loas = (List<List<String>>) ois.readObject();
            System.out.println("Données de 'student' chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des données de 'student' : " + e.getMessage());
        }
    }
}