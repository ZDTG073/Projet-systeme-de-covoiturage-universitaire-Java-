import java.util.*;
// Meddour mohammed amine
public class itinerary {
    public int choix;
    public String lieu;
    void interfaceitinerarydrivers(){
        Scanner scanner = new Scanner(System.in);

        try{
        System.out.println("Bienvenue dans l'interface conducteur");
        System.out.println("indiquez si vous allez faire un trajet retour (partir de l'universite) ou un trajet aller (aller a l'universite) :\n");
        System.out.println("1. trajet retour");
        System.out.println("2. trajet aller");
        choix = scanner.nextInt();
        scanner.nextLine(); 
        if (choix == 1) {
            System.out.println("Vous avez choisi de faire un trajet retour");
            System.out.println("-indiquez les place ou vous pouvez deposez les passager avant l'arrive a votre destination finale ainsi que votre destination finale :\n");
            int k=0;
            lieu = "=>" + scanner.nextLine();
            while (k!=2){
                System.out.println("si c'etait votre destination finale tapez '2' sinon tapez '1' pour continuer d'ajouter des lieux a votre trajet");
               k = scanner.nextInt();
               scanner.nextLine();
                if (k==1){
                    lieu += "=>" + scanner.nextLine();
                }
                else  {
                    System.out.println("choix invalide");
                }
    
            }

        } else if (choix == 2) {
            System.out.println("Vous avez choisi de faire un trajet aller\n-indiquez votre destination :\n");
            lieu = scanner.nextLine();
        } else {
            System.out.println("Choix invalide");
        }
       

        


    }catch (Exception e) {
        System.out.println("Erreur: Entrez un nombre valide"+e.getMessage());
        scanner.nextLine(); 
    }



    }
    void interfaceitinerarypassagers(){
    Scanner scanner = new Scanner(System.in);
    try{
    System.out.println("Bienvenue dans l'interface passager\n");
    System.out.println("indiquez si vous allez faire un trajet retour (partir de l'universite) ou un trajet aller (aller a l'universite) :\n");
    System.out.println("1. trajet retour");
    System.out.println("2. trajet aller");
    choix = scanner.nextInt();
    scanner.nextLine();
    if (choix == 1) {
        System.out.println("Vous avez choisi de faire un trajet retour");
        System.out.println("-indiquez ou vous voulez aller");
        lieu = scanner.nextLine(); 
    } else if (choix == 2) {
        System.out.println("Vous avez choisi de faire un trajet aller\n-indiquez votre destination de depart :\n");
        lieu = scanner.nextLine();
    } else {
        System.out.println("Choix invalide");
    }
    }catch (Exception e) {
        System.out.println("Erreur: Entrez un nombre valide."+e.getMessage());
        scanner.nextLine(); 
    }
}
}
