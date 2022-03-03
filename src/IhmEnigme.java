import jdk.jshell.spi.ExecutionControl;

import javax.swing.*;
import java.util.ArrayList;
public class IhmEnigme extends JDialog {

    private JTabbedPane plateau1;
    ArrayList<JRadioButton> listebouton=new ArrayList<JRadioButton>();
    private JTabbedPane plateau1;



    public Enigme() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRestart);

        String[][] monplateau = new String[10][10];
        jeu.init(monplateau);
        initplateau(plateau1);

        JRadioButton button;
    }

        public static void initplateau(JTabbedPane plateau) {
            for (int i=0; i< 10;i++){
                for (int j=0; j<10;j++){
                    JRadioButton button = null;
                    //listebouton.add(button);
                }
            }
        }

    public static void main(String[] args) {
        Enigme dialog = new Enigme();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
