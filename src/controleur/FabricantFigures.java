package controleur;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Point;
import vue.VueDessin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FabricantFigures implements MouseListener {

    private FigureColoree figure_en_cours_de_fabrication;
    private int nb_points_cliques;
    private Point[] points_cliques;

    public FabricantFigures(FigureColoree fc) {
        if (fc != null) {
            this.figure_en_cours_de_fabrication = fc;
            this.nb_points_cliques = 0;
            this.points_cliques = new Point[fc.nbClics()];
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // A completer
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        DessinModele dm = ((VueDessin)(e.getSource())).getDessin();
        if (this.figure_en_cours_de_fabrication != null) {
            this.points_cliques[nb_points_cliques] = new Point(e.getX(), e.getY());
            if (nb_points_cliques < this.points_cliques.length - 1) {
                this.nb_points_cliques++;
            } else {
                this.figure_en_cours_de_fabrication.modifierPoints(this.points_cliques);
                dm.ajoute(this.figure_en_cours_de_fabrication);
                ((VueDessin)(e.getSource())).supprimeAuditeurs();
            }
        }
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // A completer
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        // A completer
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // A completer
    }

    public static synchronized void print(String str){
        System.out.print(str);
    }

    public static synchronized void println(String str){
        System.out.println(str);
    }
}
