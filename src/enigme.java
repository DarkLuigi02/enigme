import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class enigme {
    public int getTours() {
        return tours;
    }

    int tours =0;
    public void inittour(){this.tours=0;}
    public void incrementtour(){tours++;}

    public void init(String[][] plateau){
        inittour();
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
    public void initCoordonnées(String[][] plateau){
        tours= getTours();
        int y = 0,x=0;
        boolean fin=false;
        init(plateau);
        plateau[y][x]="*";
        while(!fin){
            System.out.println("Veuillez Saisir x (entre 0 et "+ (plateau.length-1)+")");
            x=saisirXY(plateau);
            System.out.println("Veuillez Saisir y (entre 0 et "+ (plateau.length-1)+")");
            y=saisirXY(plateau);
            plateau[y][x]="*";
            if (tours==tours%10){
                System.out.println("votre nombre de tours et actuellement de"+ this.tours);
            fin=stop();
            }
        }
        System.out.println("vous avez reussi l'enigme en "+ getTours()+" tours");
    }
    public static void sortirJeu(String[][] plateau) {
        for (int i=0; i< plateau.length;i++){
            for (int j=0; j<plateau.length;j++){
                System.out.print(plateau[i][j]);
            }
            System.out.println();
        }
    }
    public Integer nombreVoisin(String[][] plateau, Integer x, Integer y){
        Integer vivant=0;
        if (x==0){
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

    public void transfer(String[][] plateau1, String[][] plateau2){
        for (int i=0; i< plateau2.length;i++){
            for (int j=0; j<plateau2.length;j++){
                plateau2[i][j]=plateau1[i][j]=" ";
            }
        }
    }
    public void générationSuivante(String[][] plateau){
        Scanner input = new Scanner(System.in);
        String temp[][]=new String[10][10];
        int nbvoisin;
        transfer(temp,plateau);
        for (int y=0; y< plateau.length;y++){
            for (int x=0; x<plateau.length;x++){
                nbvoisin = nombreVoisin(plateau,x,y);
                if (temp[y][x] == "*") {
                    if (2 == nbvoisin || nbvoisin == 3){
                        plateau[y][x] = "*";
                    } else {
                        plateau[y][x] = " ";
                    }
                } else if (temp[y][x] == " "){
                    if (nbvoisin == 3) {
                        plateau[y][x] = "*";
                    } else {
                        plateau[y][x] = " ";
                    }
                }
            }
        }
    }
    public Integer saisirXY(String[][] damier) {
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
    public Boolean stop(){
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
            init(monplateau);
            afficheTitre();
            sortirJeu(monplateau);
    }

    private static void afficheTitre() {
        // http://patorjk.com/software/taag/

        System.out.println(
                " ____            *  ____                                \n"+
                " |       \\   |  | /        |\\      /|    ___          \n" +
                " |--     |\\  |  | |  --    | \\    / |   / _ \\         \n" +
                " |       | \\ |  | \\    \\  |  \\  /  |   |  __/        \n" +
                " |___    |  \\|  |   ---    |   \\/   |   \\ ___|        \n" );
    }
}
