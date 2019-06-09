package controleur;

import modele.*;
import modele.Rectangle;
import vue.VueDessin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Cette classe définit une partie du controleur.
 * @author MARCHAND Quentin
 */
public class PanneauChoix extends JPanel {
    private VueDessin vdessin;
    private DessinModele dmodele;
    private FigureColoree fc;

    /**
     * Constructeur de la classe
     * @param vdessin objet de type DessinFigure (JPanel)
     */
    public PanneauChoix(VueDessin vdessin) {
        this.vdessin = vdessin;
        this.dmodele = new DessinModele();
        this.dmodele.addObserver(this.vdessin);
        /** Layout principal */
        this.setLayout(new BorderLayout());
        /** Boutons radio pour le choix des opérations */
        final JRadioButton b1 = new JRadioButton("Nouvelle figure");
        final JRadioButton b2 = new JRadioButton("Tracé à main levee");
        final JRadioButton b3 = new JRadioButton("Manipulations");
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        JPanel haut = new JPanel();
        haut.add(b1);
        haut.add(b2);
        haut.add(b3);
        add(haut, BorderLayout.NORTH);
        dmodele.initDessinModele();

        /** Menu déroulant pour le choix de la forme géométrique à construire */
        final JComboBox<String> type_fig = new JComboBox<>(new String [] {"quadrilatère", "triangle", "rectangle", "cercle"});

        /** Menu déroulant pour le choix de la couleur*/
        final JComboBox<String> couleurs = new JComboBox<>(new String [] {"noir", "rouge", "vert", "bleu", "jaune"});

        /**
         * Evenements du menu déroulant "couleurs".
         */

        couleurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = determineCouleur(couleurs.getSelectedIndex());
                if ((b1.isSelected()) && (fc != null))
                    fc.changeCouleur(c);
                if (dmodele.getSel() != -1)
                    dmodele.getLfg().get(dmodele.getSel()).changeCouleur(c);
                if (b2.isSelected()) {
                    vdessin.supprimeAuditeurs();
                    vdessin.dessiner(c);
                }
                vdessin.repaint();
                dmodele.majAffichage();
            }
        });

        /**
         * Evenement du menu déroulant "forme geometrique"
         */
        type_fig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc = creeFigure(type_fig.getSelectedIndex());
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vdessin.supprimeAuditeurs();
                type_fig.setEnabled(true);
                if (fc != null) {
                    fc = creeFigure(type_fig.getSelectedIndex());
                    fc.changeCouleur(determineCouleur(couleurs.getSelectedIndex()));
                    vdessin.construit(fc);
                    fc.selectionne();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vdessin.supprimeAuditeurs();
                type_fig.setEnabled(false);
                vdessin.dessiner(determineCouleur(couleurs.getSelectedIndex()));
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vdessin.supprimeAuditeurs();
                vdessin.activeManipulationsSouris();
                type_fig.setEnabled(false);
            }
        });

        b1.setSelected(true);
        b1.doClick();

        JPanel bas = new JPanel();
        bas.add(type_fig);
        bas.add(couleurs);
        add(bas, BorderLayout.SOUTH);
    }

    private Color determineCouleur(int i) {
        switch (i) {
            case 1 :
                return Color.red;
            case 2 :
                return Color.green;
            case 3 :
                return Color.blue;
            case 4 :
                return Color.yellow;
            default :
                return Color.black;
        }
    }

    private FigureColoree creeFigure(int i) {
        switch (i) {
            case 1:
                return new Triangle();
            case 2:
                return new Rectangle();
            case 3 :
                return new Cercle();
            default :
                return new Quadrilatere();
        }
    }

    public static synchronized void println(Object o){
        System.out.println(o);
    }
}
