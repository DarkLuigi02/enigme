import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class enigme {

    public static void increment(int valeur){valeur++;}

    public static void init(String[][] plateau){
        for (int i=0; i< plateau.length;i++){
            for (int j=0; j<plateau.length;j++){
                if (Math.random()<=Math.random()){
                    plateau[i][j]=" ";
                }else{
                plateau[i][j]="*";
                }
            }
        }
    }
    public static void initCoordonnées(String[][] plateau){
        int tours =1;
        int y = 0,x=0;
        boolean fin=false;
        init(plateau);
        while(!fin){
            increment(tours);
            sortirJeu(plateau);
            System.out.println("Veuillez Saisir x (entre 0 et "+ (plateau.length-1)+")");
            x=saisirXY(plateau);
            System.out.println("Veuillez Saisir y (entre 0 et "+ (plateau.length-1)+")");
            y=saisirXY(plateau);
            générationSuivante(plateau,x,y);
            if (tours%9==0){
                System.out.println("votre nombre de tours et actuellement de "+ tours);
            fin=stop();
            }
        }
        boolean bool=false;
        for (int i=0; i< plateau.length;i++){
            for (int j=0; j<plateau.length;j++){
                if (plateau[i][j]=="*"){
                    verifier(bool);
                }
            }
        }
        if(bool==false){
            System.out.println("vous avez reussi l'enigme en "+ tours +" tours");
        }else{
            System.out.println("Dommage peut etre une prochaine fois");
        };
    }

    private static boolean verifier(boolean bool) {
        return bool=true;
    }

    public static void sortirJeu(String[][] plateau) {
        for (int i=0; i< plateau.length;i++){
            for (int j=0; j<plateau.length;j++){
                System.out.print(plateau[i][j]);
            }
            System.out.println();
        }
    }
    public static Integer voisin(String[][] plateau, Integer x, Integer y){
        Integer vivant=0;
        if (x==0){
            if (y==0){
                if(plateau[y][x+1].equals("*")){
                    ;
                }else{}
                if(plateau[y+1][x].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x+1].equals("*")){
                    vivant++;
                }else{}
            }else if (y==plateau.length){
                if(plateau[y][x+1].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x+1].equals("*")){
                    vivant++;
                }else{}
            }else{
                if(plateau[y][x+1].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x-1].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x+1].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y][x-1].equals("*")){
                    vivant++;
                }else{}
            }
        }
        else if (x==plateau.length){
            if (y==0){
                if(plateau[y][x+1].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x+1].equals("*")){
                    vivant++;
                }else{}
            }else if (y==plateau.length){
                if (y==0){
                    if(plateau[y][x+1].equals("*")){
                        vivant++;
                    }else{}
                    if(plateau[y+1][x].equals("*")){
                        vivant++;
                    }else{}
                    if(plateau[y+1][x+1].equals("*")){
                        vivant++;
                    }else{}
                }else if (y==plateau.length){
                    if(plateau[y][x+1].equals("*")){
                        vivant++;
                    }else{}
                    if(plateau[y+1][x].equals("*")){
                        vivant++;
                    }else{}
                    if(plateau[y+1][x+1].equals("*")){
                        vivant++;
                    }else{}
                }else{
                    if(plateau[y][x-1].equals("*")){
                        vivant++;
                    }else{}
                    if(plateau[y-1][x].equals("*")){
                        vivant++;
                    }else{}
                    if(plateau[y-1][x-1].equals("*")){
                        vivant++;
                    }else{}
                    if(plateau[y+1][x-1].equals("*")){
                        vivant++;
                    }else{}
                    if(plateau[y+1][x].equals("*")){
                        vivant++;
                    }else{}
                }
            }else{
                if(plateau[y][x-1].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y-1][x].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y-1][x-1].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x-1].equals("*")){
                    vivant++;
                }else{}
                if(plateau[y+1][x].equals("*")){
                    vivant++;
                }else{}
            }
        }
        else{
            if(plateau[y-1][x-1].equals("*")){
                vivant++;
            }else{}
            if(plateau[y-1][x].equals("*")){
                vivant++;
            }else{}
            if(plateau[y-1][x+1].equals("*")){
                vivant++;
            }else{}
            if(plateau[y+1][x-1].equals("*")){
                vivant++;
            }else{}
            if(plateau[y+1][x].equals("*")){
                vivant++;
            }else{}
            if(plateau[y+1][x+1].equals("*")){
                vivant++;
            }else{}
            if(plateau[y-1][x].equals("*")){
                vivant++;
            }else{}
            if(plateau[y+1][x].equals("*")){
                vivant++;}
            else{}
        }
        return vivant;
    }

    public static void transfer(String[][] plateau1, String[][] plateau2){
        for (int i=0; i< plateau2.length;i++){
            for (int j=0; j<plateau2.length;j++){
                plateau2[i][j]=plateau1[i][j];
            }
        }
    }
    public static void générationSuivante(String[][] plateau, int x , int y){
        String temp[][]=new String[10][10];
        transfer(temp,plateau);
        voisin(plateau,x,y);
    }

    public static Integer saisirXY(String[][] damier) {
        Scanner input = new Scanner(System.in);
        Integer i;
        try {
            i = input.nextInt();
            if(i<0 || i>=damier.length){
                System.out.println("Vous devez saisir une valeur entre 0 et "+(damier.length-1)+". Recommencez");
                i = saisirXY(damier);
            }
        } catch (Exception e) {
            System.out.println("Erreur dans la saisie. Recommencez.");
            i = saisirXY(damier);
        }
        return i;
    }

    // fonction pour arreter l'initialisatoin manuelle
    public static Boolean stop(){
        Scanner input = new Scanner(System.in);
        String fin;
        Boolean finInit;
        System.out.println("Voulez-vous continuer ? (o/n)");
        fin = input.next();
        if(fin.equals("o")){
            finInit=false;
        }else if (fin.equals("n")){
            finInit=true;
        }else {
            System.out.println("Erreur dans la réponse");
            finInit = stop();
        }
        return finInit;
    }
    public static void main(String[] args) throws InterruptedException {
            String[][] monplateau = new String[10][10];
            afficheTitre();
            initCoordonnées(monplateau);
    }

    private static void afficheTitre() {
        // http://patorjk.com/software/taag/

        System.out.println(
                " ____           *  ____                                \n"+
                " |       \\   |  | /        |\\      /|    ___          \n" +
                " |--     |\\  |  | |  __    | \\    / |   / _ \\         \n" +
                " |       | \\ |  | |     |   |  \\  /  |   |  __/        \n" +
                " |___    |  \\|  |  ----    |   \\/   |   \\ ___|        \n" );
    }
}
