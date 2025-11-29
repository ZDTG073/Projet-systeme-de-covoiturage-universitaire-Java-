import java.util.Scanner;
//ibrahim ghabouba
public class main {
    
    public static void main(String[] args) {
         users.loadData();
            student.loadData();
            teacher.loadData();
            ATS.loadData();
        System.out.println("Bienvenue dans le monde du covoiturage universitaires!!");
        Scanner scanner = new Scanner(System.in);
         while (true) {
           
            
            try {
                
             System.out.println("\n1- nouvelle utilisateur!!!\n2- administrateur\n3- conducteur\n4- passager\n5- quitter");
             System.out.print("Entrez votre choix :");
             int choix = scanner.nextInt();
                scanner.nextLine();
             if (choix==1) {
                     users u = new users();
                     u.createUser();
             }
             else if (choix==2) {
             Administration ad = new Administration();
              ad.adminterface();
             }
             else if(choix==3){
             System.out.print("Entrez votre id :");
             
                String id = scanner.nextLine();
                conducteur c = new conducteur();
                c.driverinterface(id);
             }
             else if(choix==4){
              System.out.print("Entrez votre id :");
               
                    String id = scanner.nextLine();
                    passager p = new passager();
                    p.interfacepassager(id);
               }
               else if(choix==5){
                System.out.print("Au revoir et a bientot");
                users.saveData();
                student.saveData();
                teacher.saveData();
                ATS.saveData();
                break;
                }
                else{
                 System.out.print("Choix invalide");
                }
            }
            catch (Exception e) {
                System.out.println("Erreur: Entrez un nombre valide."+e.getMessage());
                scanner.nextLine(); 
            }
         }
        

    }
}
