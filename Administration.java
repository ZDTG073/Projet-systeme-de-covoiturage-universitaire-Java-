import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
//ilyes khadir 
   class Administration {
    
    private static List <List<String>> loab = new ArrayList<>();
    private String getPass(){ return"miis";}
        // Méthode pour sauvegarder les données
    public static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("admin_loab.dat"))) {
            oos.writeObject(loab);
            System.out.println("Données de 'loab' sauvegardées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des données de 'loab' : " + e.getMessage());
        }
    }

    // Méthode pour charger les données
    public static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("admin_loab.dat"))) {
            loab = (List<List<String>>) ois.readObject();
            System.out.println("Données de 'loab' chargées avec succès !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des données de 'loab' : " + e.getMessage());
        }
    }

     void viewstats() {
        System.out.println("Statistiques de l'application");
        System.out.println("Nombre d'utilisateurs :  " + users.cptu );
        System.out.println("Nombre d'étudiants :  " + users.cpts );
        System.out.println("Nombre de professeurs : " + users.cptt );
        System.out.println("Nombre d'ATC : " + users.cptat );
        System.out.println("nombre d'utilisateurs en ligne : " + (passager.cptp+conducteur.cptc));
        System.out.println("nombre de passagers(utilisateurs en mode passager en ce moment) : " + passager.cptp);
        System.out.println("nombre de conducteurs(utilisateurs en mode conducteur en ce moment) : " + conducteur.cptc);
         
    }
    


    private void Gestion(List <List<String>> L ) {
          Scanner scanner = new Scanner(System.in);
          Scanner scanner1 = new Scanner(System.in);
        System.out.println("Bienvenue dans le système de gestion!");
        System.out.println("Veuillez choisir une option :");
        System.out.println("1. supprimer un utilisateur");
        System.out.println("2. bannir un utilisateur");
        System.out.println("3. debannir un utilisateur");
        System.out.println("4. afficher la liste des utilisateurs bannis");
        System.out.println("5. ajouter un utilisateurs");
        System.out.println("Entrer n'importe quoi pour quitter");
        System.out.print("Entrez votre choix: ");
       try{
        int choix = scanner.nextInt();
        scanner.nextLine();
     if(choix >= 1 && choix <4) {
            
        System.out.print("Entrez l'ID de l'utilisateur : ");
        String id = scanner1.nextLine();
        if (choix == 1) {
            System.out.println("Suppression d'un utilisateur...");
        int i=0;
            if (users.loau.isEmpty()) {
                System.out.println("La liste est vide");
            }
            else{
                
            while (users.loau.get(i).get(0) == null ? id != null : !users.loau.get(i).get(0).equals(id)){
                i++;
            }
            if (users.loau.get(i).get(0) == null ? id == null : users.loau.get(i).get(0).equals(id)){
                
            users.loau.remove(i);
            if (!student.loas.isEmpty()) {
                i=0;
            while (student.loas.get(i).get(0) == null ? id != null : !student.loas.get(i).get(0).equals(id) ){
                i++;
            }
        }
            if (student.loas.get(i).get(0) == null ? id == null : student.loas.get(i).get(0).equals(id)){
                student.loas.remove(i);
                student.cpts--;
            }else{
            
            if (!teacher.loat.isEmpty()) {
                    i=0;
                while (teacher.loat.get(i).get(0) == null ? id != null : !teacher.loat.get(i).get(0).equals(id) ){
                    i++;
                }
            }
                if (teacher.loat.get(i).get(0) == null ? id == null : teacher.loat.get(i).get(0).equals(id)){
                    teacher.loat.remove(i);
                    teacher.cptt--;
                }else{

                    if (!ATS.loaa.isEmpty()) {
                        i=0;
                    while ((ATS.loaa.get(i).get(0) == null ? id != null : !ATS.loaa.get(i).get(0).equals(id))){
                        i++;
                    }
                }
                    if (ATS.loaa.get(i).get(0) == null ? id == null : ATS.loaa.get(i).get(0).equals(id)){
                        ATS.loaa.remove(i);
                        ATS.cptat--;
                    }
                }
            }
            }
        }
                

        } else if (choix == 2) {
            System.out.println("Bannissement d'un utilisateur...");
            if (!L.isEmpty()) {
            
            int i=0;
            while (L.get(i).get(0) == null ? id != null : !L.get(i).get(0).equals(id)){
                i++;
            }
            if (L.get(i).get(0) == null ? id == null : L.get(i).get(0).equals(id)){
            loab.add(L.get(i));
            L.remove(i);
            }
        }else{
            System.out.println("liste vide");
        }
        } 
        else if (choix == 3) {
            System.out.println("Débannissement d'un utilisateur...");
            if(!loab.isEmpty()) {
            int i=0;
            while (loab.get(i).get(0) == null ? id != null : !loab.get(i).get(0).equals(id)){
                i++;
            }
            if (loab.get(i).get(0) == null ? id == null : loab.get(i).get(0).equals(id)){
            L.add(loab.get(i));
            loab.remove(i);
            }
        }else{
            System.out.println("liste vide");
        }
        }
        
         else if (choix == 4) {
             System.out.println("Affichage de la liste des utilisateurs bannis...\n");
             if (!loab.isEmpty()) {
             int i=0;
            while (i < loab.size()){
                System.out.println(loab.get(i) + "\n");
                i++;
            }
        }
            else{
                System.out.println("liste vide");
            }
        } 
    }
         else if (choix == 5) {
           
            System.out.println("Ajout d'un utilisateur...");
            users u = new users();
            u.createUser();
        }
    
        else {
            System.out.println("Choix invalide");
        }
      }
      catch (Exception e) {
        System.out.println("Erreur: Entrez un nombre valide."+e.getMessage());
        scanner.nextLine();
  
     }
        finally{
            System.out.println("Merci d'avoir utilisé le système de gestion!");
        }
    }

    void interfacegestion(List <List<String>> e, List <List<String>> t,List <List<String>> a){
        Scanner scanner = new Scanner(System.in);
    try{
    System.out.println("---Gestion des utilisateurs---");
    System.out.println("1. afficher la liste des etudiant");
    System.out.println("2. afficher la liste des enseignants");
    System.out.println("3. afficher la liste des ats");
    System.out.println("4. afficher la liste de tous les utilisateurs");
    System.out.println("5. gerer les utilisateurs");
    System.out.print("votre choix :");
    
    int choix = scanner.nextInt();
    scanner.nextLine(); 
    if (choix == 1) {
        System.out.println("Liste des étudiants :\n");
        int i=0;
       while (i < student.loas.size()){
            System.out.println("etudiant num "+(i+1)+student.loas.get(i) + "\n");
            i++;
        }
    
    } else if (choix == 2) {
        System.out.println("Liste des enseignants :\n");
        int i=0;
        while (i < teacher.loat.size()){
            System.out.println("enseignant num "+(i+1)+teacher.loat.get(i) + "\n");
            i++;
        }
    
    } else if (choix == 3) {
        System.out.println("Liste des ATS :");
        int i=0;
       while (i < ATS.loaa.size()){
            System.out.println("ATS num "+(i+1)+ATS.loaa.get(i) + "\n");
            i++;
        }
    
    } else if (choix == 4) {
        System.out.println("Liste de tous les utilisateurs :\n");
        int i=0;
       while (i < users.loau.size()){
            System.out.println("utilisateur num "+(i+1)+users.loau.get(i) + "\n");
            i++;
        }

    } else if (choix == 5) {
        System.out.println("Gestion des utilisateurs :");
        Gestion(users.loau);
    } else {
        System.out.println("Choix invalide");
    }
    }catch (InputMismatchException e1) {
        System.out.println("Erreur : Veuillez entrer un nombre valide !");
        scanner.nextLine(); // Consommer l'entrée incorrecte pour éviter une boucle infinie
    }
    catch (Exception e2) {
        System.out.println("Une erreur inattendue s'est produite : " + e2.getMessage());
        scanner.nextLine(); 
    }
   
}

   void adminterface(){
       Scanner scanner = new Scanner(System.in);
       loadData();
       student.loadData();
         teacher.loadData();
            ATS.loadData();

       try {
       System.out.print("Entrez le mot de passe administrateur : ");
       String adrpass = scanner.nextLine();
       if (adrpass.equals(getPass())){
        System.out.println("Bienvenue dans l'interface administrateur");
        while (true) { 
            
        
           System.out.println("1- Gestion des utilisateurs");
           System.out.println("2- visualisation des trajets");
           System.out.println("3- visualisation des statistiques");
              System.out.println("4- Quitter");
           System.out.print("Entrez votre choix : "); 
           int choice = scanner.nextInt();
           scanner.nextLine();
       if (choice == 1) {
        interfacegestion(student.loas,teacher.loat,ATS.loaa); // Gérer les utilisateurs
        } else if (choice == 2) {
            trajets.loadData();
            System.out.println("1. historique des trajets : \n");
         int i=0;
       while (i < trajets.loatr.size()){
            System.out.println("trajet num "+(i+1)+trajets.loatr.get(i) + "\n");
            i++;
        }

        i=0;
        while (i < trajets.loatrm.size()){
            System.out.println("trajet num "+(i+1)+trajets.loatrm.get(i) + "\n");
            i++;
        }
        } else if (choice == 3) {
         viewstats(); // Afficher les statistiques
        } else if (choice==4){
             System.out.println("Merci d'avoir utilisé l'interface administrateur");
            break;
        }else {
        System.out.println("Choix invalide"); // Message pour les choix non valides
        }

       }}else{
           System.out.println("Mot de passe incorrect");
       }
     }
       catch (Exception e) {
           System.out.println("Erreur: Entrez un nombre valide.");
           scanner.nextLine(); 
       }
       saveData();
       student.saveData();
         teacher.saveData();
            ATS.saveData();

   }
  
}
