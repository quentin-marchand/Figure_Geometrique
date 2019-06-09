package controleur;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Point;
import vue.VueDessin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class ManipulateurFormes implements MouseListener, MouseMotionListener {
    private DessinModele dm;
    private int indice;
    private int last_x;
    private int last_y;
    private List<FigureColoree> lfg;
    private int nbf;
    private int sel;
    private boolean trans;

    public ManipulateurFormes(DessinModele dm) {
        this.dm = dm;
        this.lfg = this.dm.getLfg();
        this.nbf = dm.getNbf();
        this.trans = false;
        this.sel = dm.getSel();
        this.last_x = -1;
        this.last_y = -1;
    }

    public FigureColoree figureSelection() {
        return this.lfg.get(sel);
    }

    public void selectionProchaineFigure() {
        // A completer
    }

    public int nbFigures() {
        return this.nbf;
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
        if (this.sel != -1)
            this.indice = this.lfg.get(this.sel).carreDeSelection(e.getX(),e.getY());
        if (this.indice != -1)
            this.trans = true;
        this.last_x = e.getX();
        this.last_y = e.getY();
        for (FigureColoree fc : this.lfg) {
            fc.deSelectionne();
        }
        this.dm.majAffichage();
        for (FigureColoree fc : this.lfg) {
            if (fc.estDedans(e.getX(), e.getY()) || fc.carreDeSelection(e.getX(), e.getY()) != -1) {
                if (this.sel != -1)
                    this.lfg.get(this.sel).deSelectionne();
                fc.selectionne();
                this.sel = this.lfg.indexOf(fc);
                break;
            } else {
                this.sel = -1;
            }
        }
        this.dm.majAffichage();
    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  <code>MOUSE_DRAGGED</code> events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * <code>MOUSE_DRAGGED</code> events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.sel != -1) {
            if (this.trans) {
                this.lfg.get(this.sel).transformation(e.getX() - this.last_x, e.getY() - this.last_y, this.indice);
            }
            else if (this.lfg.get(this.sel).estDedans(this.last_x, this.last_y)) {
                this.lfg.get(this.sel).translation(e.getX() - this.last_x, e.getY() - this.last_y);
            }
        }
        this.last_x = e.getX();
        this.last_y = e.getY();
        this.dm.majAffichage();
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        this.trans = false;
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

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        // A completer
    }

    public static synchronized void println(Object o){
        System.out.println(o);
    }
}
