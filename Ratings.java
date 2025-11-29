import java.util.*;
// ibrahim ghabouba
public class Ratings {
    void ratingupdate(String id,float newrate) {
         int i=0;
            if (users.loau.isEmpty()) {
                System.out.println("La liste est vide");
            }
            else{
                
            while (users.loau.get(i).get(0) == null ? id != null : !users.loau.get(i).get(0).equals(id)){
                i++;
            }
            if (users.loau.get(i).get(0) == null ? id == null : users.loau.get(i).get(0).equals(id)){
                
            users.loau.get(i).set(7, String.valueOf(Integer.parseInt(users.loau.get(i).get(7)) + newrate));
            if (!student.loas.isEmpty()) {
                i=0;
            while (student.loas.get(i).get(0) == null ? id != null : !student.loas.get(i).get(0).equals(id) ){
                i++;
            }
        }
            if (student.loas.get(i).get(0) == null ? id == null : student.loas.get(i).get(0).equals(id)){
                 student.loas.get(i).set(7, String.valueOf((Float.parseFloat(student.loas.get(i).get(7)) + newrate)/2));
            }else{
            
            if (!teacher.loat.isEmpty()) {
                    i=0;
                while (teacher.loat.get(i).get(0) == null ? id != null : !teacher.loat.get(i).get(0).equals(id) ){
                    i++;
                }
            }
                if (teacher.loat.get(i).get(0) == null ? id == null : teacher.loat.get(i).get(0).equals(id)){
                teacher.loat.get(i).set(7, String.valueOf((Float.parseFloat(teacher.loat.get(i).get(7)) + newrate)/2));
                }else{

                    if (!ATS.loaa.isEmpty()) {
                        i=0;
                    while ((ATS.loaa.get(i).get(0) == null ? id != null : !ATS.loaa.get(i).get(0).equals(id))){
                        i++;
                    }
                }
                    if (ATS.loaa.get(i).get(0) == null ? id == null : ATS.loaa.get(i).get(0).equals(id)){
                   ATS.loaa.get(i).set(7, String.valueOf((Float.parseFloat(ATS.loaa.get(i).get(7)) + newrate)/2));
                    }
                }
            }
            }
        }
    }
    void interfaceRatings(String idr) {
        System.out.println("-aidez nous a trouve les mauvais utilisateurs et a ameliorer votre experience- ");
        System.out.println("1. 1 étoile");
        System.out.println("2. 2 étoiles");
        System.out.println("3. 3 étoiles");
        System.out.println("4. 4 étoiles");
        System.out.println("5. 5 étoiles");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez votre choix: ");
        int choix = scanner.nextInt();
         scanner.nextLine();
        try{
        while(true){
        if (choix == 1) {
            System.out.println("Merci pour votre évaluation de 1 étoile!");
            ratingupdate(idr, choix);
        } else if (choix == 2) {
            System.out.println("Merci pour votre évaluation de 2 étoiles!");
            ratingupdate(idr, choix);
        } else if (choix == 3) {
            System.out.println("Merci pour votre évaluation de 3 étoiles!");
            ratingupdate(idr, choix);
        } else if (choix == 4) {
            System.out.println("Merci pour votre évaluation de 4 étoiles!");
            ratingupdate(idr, choix);
        } else if (choix == 5) {
            System.out.println("Merci pour votre évaluation de 5 étoile!");
            ratingupdate(idr, choix);
        } else {
            System.out.println("Choix invalide");
        }
    }
}catch(Exception e){
    scanner.nextLine();
}
}
}
