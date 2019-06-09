package vue;

import controleur.FabricantFigures;
import controleur.ManipulateurFormes;
import controleur.TraceurForme;
import modele.DessinModele;
import modele.FigureColoree;
import modele.Trait;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Cette classe définit la vue
 */
public class VueDessin extends JPanel implements Observer {
    private DessinModele dessin;
    private ManipulateurFormes mf;
    private FabricantFigures ff;
    private TraceurForme tf;

    public VueDessin() {
        // A completer
    }

    public DessinModele getDessin() {
        return this.dessin;
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        dessin = (DessinModele) o;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dessin != null) {
            for (FigureColoree fc : this.dessin.getLfg()) {
                g.setColor(fc.getColor());
                fc.affiche(g);
            }
            for (Trait t : this.dessin.getLf()) {
                g.setColor(t.getCouleur());
                t.affiche(g);
            }
        }
    }

    public void construit(FigureColoree fc) {
        this.ff = new FabricantFigures(fc);
        this.addMouseListener(ff);
    }

    public void activeManipulationsSouris() {
        this.mf = new ManipulateurFormes(this.dessin);
        this.addMouseListener(this.mf);
        this.addMouseMotionListener(this.mf);
    }

    public void dessiner(Color c) {
        this.tf = new TraceurForme(c);
        this.addMouseListener(this.tf);
        this.addMouseMotionListener(this.tf);
    }

    public void supprimeAuditeurs() {
        MouseListener[] ml = getListeners(MouseListener.class);
        for (MouseListener m : ml)
            removeMouseListener(m);
        MouseMotionListener[] mml = getListeners(MouseMotionListener.class);
        for (MouseMotionListener m : mml)
            removeMouseMotionListener(m);
    }

    public static synchronized void println(Object o){
        System.out.println(o);
    }
}
