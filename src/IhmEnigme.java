import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class IhmEnigme extends JDialog {

    private JPanel plateau1;
    private JLabel gagne;
    private JButton buttonRestart;
    ArrayList<JRadioButton> listebouton=new ArrayList<JRadioButton>();
    Enigme jeu= new Enigme();
    int tours =0;
    String[][] monplateau = new String[10][10];



    public IhmEnigme() {
        setContentPane(plateau1);
        setModal(true);
        getRootPane().setDefaultButton(buttonRestart);

        onRestart();
        buttonRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRestart();
            }
        });
        initplateau(monplateau,listebouton);
        for(JRadioButton bouton:listebouton) {
            bouton.setText("");
            bouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onClick(bouton);
                    jeu.générationSuivante(monplateau,bouton.getX(),bouton.getY());

                }
            });
        }

    }

    public void onRestart(){
        gagne.setVisible(false);
        gagne.setText("");
        this.tours=0;
        jeu.init(monplateau);
        initplateau(monplateau,listebouton);
    }

    public static void initplateau(String[][] plateau, ArrayList<JRadioButton> listebouton) {
            listebouton.clear();
            for (int i=0; i< 10;i++){
                for (int j=0; j<10;j++){
                    JLabel a = new JLabel();
                    a.setText(plateau[i][j]);
                    JRadioButton bouton=new JRadioButton();
                    listebouton.add(i+j,bouton);
                    if (plateau[i][j] == "*"){
                        listebouton.get(i+j).setSelected(true);
                    }else {listebouton.get(i+j).setSelected(false);}
                    //listebouton.add(button);
                }
            }
    }

    public void onClick(JRadioButton button) {
            this.tours++;
            int x =button.getX();
            x=jeu.saisirXY(monplateau);
            int y =button.getY();
            y=jeu.saisirXY(monplateau);
    }

    public static void main(String[] args) {
        IhmEnigme dialog = new IhmEnigme();
        dialog.pack();
        dialog.setVisible(false);
        System.exit(0);
    }


}
