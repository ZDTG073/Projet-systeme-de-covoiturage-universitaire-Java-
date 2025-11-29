
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
// ibrahim ghabouba

public class ATS extends users {
   //liste des objects etudiants
    public List<String> loa = new ArrayList<>();
   void listmaking(String id, String nom, String prenom, Boolean music, String garconfille, Boolean fumeur, String usersexe, String rate, String numerotlph,int adr) { 
     
    loa.addAll(Arrays.asList(id, nom, prenom, String.valueOf(music),garconfille, String.valueOf(fumeur), usersexe, rate, numerotlph, String.valueOf(adr)));
 
 }
  public static List <List<String>> loaa = new ArrayList<>(); 
 void listolists(List <String> loa){
    loaa.add(loa);
 }
    // Méthode pour sauvegarder les données
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ATS_loaa.dat"))) {
            oos.writeObject(loaa);
            System.out.println("Données de 'ATS' sauvegardées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données de 'ATS' : " + e.getMessage());
        }
    }

    // Méthode pour charger les données
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ATS_loaa.dat"))) {
            loaa = (List<List<String>>) ois.readObject();
            System.out.println("Données de 'ATS' chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des données de 'ATS' : " + e.getMessage());
        }
    }
}