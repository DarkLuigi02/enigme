import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Enigme {

    public static void init(String[][] plateau){
        for (int i=0; i< plateau.length;i++){
            for (int j=0; j<plateau.length;j++){
                if (Math.random()<=Math.random()){
                    plateau[i][j]="'";
                }else{
                plateau[i][j]="*";
                }
            }
        }
    }
    public static void initCoordonnées(String[][] plateau){
        int tours =0;
        int y = 0,x=0;
        boolean fin=true;
        init(plateau);
        while(fin){
            tours++;
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
        quelfin(plateau,tours);
    }

    public static void quelfin(String [][] plateau,int tours){
        boolean bool=false;
        for (int i=0; i< plateau.length;i++){
            for (int j=0; j<plateau.length;j++){
                if (plateau[i][j]==("*")){
                    bool=true;
                }
            }
        }
        if(bool==false){
            System.out.println("vous avez reussi l'enigme en "+ tours +" tours");
        }else{
            System.out.println("Dommage peut etre une prochaine fois");
        };}

    public static void sortirJeu(String[][] plateau) {
        for (int i=0; i< plateau.length;i++){
            for (int j=0; j<plateau.length;j++){
                System.out.print(plateau[i][j]);
            }
            System.out.println();
        }
    }
    public static void voisin(String[][] plateau, Integer x, Integer y){
        if (x==0){
            if (y==0){
                verifier(plateau,x+1,y);
                verifier(plateau,x,y+1);
                verifier(plateau,x+1,y+1);
            }
            else if(y==plateau.length){
                verifier(plateau,x+1,y);
                verifier(plateau,x,y-1);
                verifier(plateau,x+1,y-1);
            }
            else{
                verifier(plateau,x+1,y);
                verifier(plateau,x,y+1);
                verifier(plateau,x,y-1);
                verifier(plateau,x+1,y+1);
                verifier(plateau,x+1,y-1);
            }
        }
        else if (x==plateau.length){
            if (y==0){
                verifier(plateau,x-1,y);
                verifier(plateau,x,y+1);
                verifier(plateau,x-1,y+1);
            }
            else if (y==plateau.length){
                verifier(plateau,x-1,y);
                verifier(plateau,x,y-1);
                verifier(plateau,x-1,y-1);
            }
            else{
                verifier(plateau,x-1,y);
                verifier(plateau,x,y+1);
                verifier(plateau,x,y-1);
                verifier(plateau,x-1,y+1);
                verifier(plateau,x-1,y-1);
            }
        }
        else{
            verifier(plateau,x,y-1);
            verifier(plateau,x,y+1);
            verifier(plateau,x-1,y);
            verifier(plateau,x+1,y);
            verifier(plateau,x-1,y-1);
            verifier(plateau,x+1,y-1);
            verifier(plateau,x-1,y+1);
            verifier(plateau,x+1,y+1);
        }
    }

    public static void verifier(String[][] plateau, Integer x, Integer y){
        if(plateau[y][x]==("*")){
            plateau[y][x]=("'");
        }
        else{plateau[y][x]=("*");}
    }

    public static void générationSuivante(String[][] plateau, int x , int y){
        String temp[][]=new String[10][10];
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
        if(fin==("o")){
            finInit=true;
        }else if (fin==("n")){
            finInit=false;
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
