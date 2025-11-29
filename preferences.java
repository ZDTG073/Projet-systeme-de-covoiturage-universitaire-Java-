import java.util.Scanner;
//Meddour mohammed amine

public class preferences {
       boolean music,fumeur;
       String fillegarcon;
      void preference(){

        System.out.println("selectionnez vos preferences : \nREMARQUE: ces preferences seront utilisees que quand vous etes passager\n" );
        System.out.println("- la musique :\n1. oui\n2. non");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        scanner.nextLine();
        if (choix == 1) {
            music = true;
        } else if (choix == 2) {
            music = false;
        } else {
            System.out.println("choix invalide");
        }
        System.out.println("desirez-vous absolument un conducteur de meme sexe ?\n1. oui\n2. non\n REMARQUE: Si aucun conducteur na le meme sexe que vous nous vous proposerons un conducteur de sexe opposé");
        
        int choix1 = scanner.nextInt();
        scanner.nextLine();
        if (choix1 == 1) {
            fillegarcon = "du meme sexe";
        } else if (choix1 == 2) {
            fillegarcon = "indifferent";
        } else {
            System.out.println("choix invalide");
        }
        System.out.println("- fumeur :\n1. oui\n2. non");
        int choix2 = scanner.nextInt();
        scanner.nextLine();
        if (choix2 == 1) {
            fumeur = true;
        } else if (choix2 == 2) {
            fumeur = false;
        } else {
            System.out.println("choix invalide");
        }
      }
}
