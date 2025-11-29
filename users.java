import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.*;
import java.util.*;
//Meddour mohammed amine
public class users{
    String nom,prenom,fac,spec,usersexe,numerotlph;

    int statut,adr,ada,adra;
    public static List<List<String>> loau = new ArrayList<>(); //liste des objects utilisateurs
    public static int cptu=0,cpts=0,cptt=0,cptat=0;;//compteur user,compteur etudiant ,compteur enseignant,compteur ats
      // Méthode pour sauvegarder les données
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users_loau.dat"))) {
            oos.writeObject(loau);
            oos.writeInt(cptu);
            oos.writeInt(cpts);
            oos.writeInt(cptt);
            oos.writeInt(cptat);
            System.out.println("Données de 'users' sauvegardées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données de 'users' : " + e.getMessage());
        }
    }
    // Méthode pour charger les données
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users_loau.dat"))) {
            loau = (List<List<String>>) ois.readObject();
            cptu = ois.readInt();
            cpts = ois.readInt();
            cptt = ois.readInt();
            cptat = ois.readInt();
            System.out.println("Données de 'users' chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des données de 'users' : " + e.getMessage());
        }
    }

     void listusers(List <String> s){
        loau.add(s);
  
   }
   String generateId(){
        LocalDateTime now = LocalDateTime.now();
        String id = nom +now.getYear() + "" + now.getMonthValue() + "" + now.getDayOfMonth() + "" + now.getHour() + "" + now.getMinute() + "" + now.getSecond();
        System.out.print("Votre id est : " + id + "\nNOTE IMPORTANTE : ne le montrez a personne et retenez le bien !!!(vous en aurez besoin pour vous connecter)\n");
        return id;
   }
   void createUser(){
      Scanner scanner = new Scanner(System.in);
      try{
      System.out.print("Entrez votre nom: ");
      nom = scanner.nextLine();

      System.out.print("Entrez votre prenom: ");
      prenom = scanner.nextLine();

      System.out.print("selectionnez votre sexe :\n1- Garcon\n2- Fille\nsexe :");
      int sexe = scanner.nextInt();
      scanner.nextLine();
      if (sexe == 1) {
         usersexe = "Garcon";
      } else if (sexe == 2) {
          usersexe = "Fille";
        } else {
          System.out.println("Erreur: sexe invalide.");
          return;
        }
          System.out.print("Entrez votre numero de telephone : ");
      numerotlph = scanner.nextLine();
      preferences p = new preferences();
        p.preference();
      System.out.print("----selection du statut----\n1- Etudiant\n2- Enseignant\n3- Administrateur\nEntrez votre statut :");
       
      statut = scanner.nextInt();
      scanner.nextLine(); 
        if (statut==1) {
                System.out.print("Entrez votre annee d'admission a l'universite : ");
                        LocalDateTime now = LocalDateTime.now();
                do { 
                    ada = scanner.nextInt();
                    scanner.nextLine(); 
                } while (ada < 1974 || ada > now.getYear());
                System.out.print("Entrez le nom de votre faculte :");
                fac = scanner.nextLine();
                System.out.print("Entrez le nom de votre specialite :");
                spec = scanner.nextLine();

                student s = new student();
                s.listmaking(generateId(), nom, prenom, p.music, p.fillegarcon, p.fumeur,usersexe,"5",numerotlph, ada, fac, spec);
                s.listolists(s.los);
                student.saveData();
                listusers(s.los);
                saveData();
               cpts++;
        } else if (statut == 2) {
            
                System.out.print("Entrez votre annee de recrutement :");
                LocalDateTime now = LocalDateTime.now();
                do {
                    adr = scanner.nextInt();
                    scanner.nextLine();
                } while (adr < 1974 || adr > now.getYear());
                System.out.print("Entrez le nom de la faculte a laquelle vous appartenez :");
                fac = scanner.nextLine();
                teacher t = new teacher();
                t.listmaking(generateId(), nom, prenom, p.music, p.fillegarcon, p.fumeur, usersexe, "5", numerotlph, adr, fac);
                t.listolists(t.lot);
                teacher.saveData();
                listusers(t.lot);
                saveData();
                cptt++;
        } else if (statut == 3) {
                
                System.out.print("Entrez votre annee de recrutement");
               LocalDateTime now = LocalDateTime.now();
                do {

                    adra = scanner.nextInt();
                    scanner.nextLine();

                } while (adra < 1974 || adra > now.getYear());
                ATS a = new ATS();
                a.listmaking(generateId(), nom, prenom, p.music, p.fillegarcon, p.fumeur, usersexe, "5", numerotlph, adra);
                a.listolists(a.loa);
                ATS.saveData();
                listusers(a.loa);
                saveData();
                cptat++;
        }

      }catch (Exception e) {
         System.out.println("Erreur: Entrez un nombre valide.");
         scanner.nextLine(); 
      }
    

      System.out.print("Merci d'avoir cree un compte avec nous, vous pouvez vous connecter maintenant\n");
      cptu++;
      saveData();
   }
    
   
}
