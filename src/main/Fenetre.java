package main;
import java.awt.*;
import javax.swing.*;

import modele.DessinModele;
import vue.VueDessin;
import controleur.PanneauChoix;

/**
 * Cette classe définit l'interface utilisateur et la méthode main
 * @author MARCHAND Quentin
 * @version 1
 */
public class Fenetre extends JFrame {
    private VueDessin vdessin;
    private JPanel principal;
    private JPanel choix;


    public Fenetre(String s , int w , int h) {
        super(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vdessin = new VueDessin();
        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setPreferredSize(new Dimension(w,h));
        principal.add(vdessin, BorderLayout.CENTER);
        choix = new PanneauChoix(vdessin);
        principal.add(choix, BorderLayout.NORTH);
        this.setContentPane(principal);
        pack();
    }

    public static void main(String[] args) {
        Fenetre f = new Fenetre("Figure Géométrique", 800,600);
        f.setVisible(true);
    }

    public static synchronized void print(String str){
        System.out.print(str);
    }

    public static synchronized void println(String str){
        System.err.println(str);
    }
}
