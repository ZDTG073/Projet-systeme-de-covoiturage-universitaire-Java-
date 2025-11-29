import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

//ilyes khadir
public class trajets {
    public List<String> listtrajets = new ArrayList<>();
void listrajets(String idp, String prenomp, String idd, String prenomd,String numerotlphp, String itenerary){
    listtrajets.addAll(Arrays.asList(idp, prenomp, idd, prenomd,numerotlphp , itenerary));
  
}
     static List<List<String>> loatr = new ArrayList<>();// tout l'historique des trajet

    static List<List<String>> loatrm = new ArrayList<>(); //trajets en ce moment
 // Méthode pour sauvegarder les données
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student_loas.dat"))) {
            oos.writeObject(loatr);
            oos.writeObject(loatrm);
        } catch (IOException e) {
        }
    }
     // Méthode pour charger les données
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student_loas.dat"))) {
            loatr = (List<List<String>>) ois.readObject();
            loatrm = (List<List<String>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
