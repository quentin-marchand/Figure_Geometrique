package controleur;

import modele.Trait;
import vue.VueDessin;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TraceurForme implements MouseMotionListener, MouseListener {
    private int x, y, lastX, lastY;
    private Color couleur;

    public TraceurForme(Color c) {
        this.couleur = c;
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
        this.x = e.getX();
        this.y = e.getY();
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
        lastX = e.getX();
        lastY = e.getY();
        ((VueDessin)(e.getSource())).getDessin().ajoute(new Trait(this.x, this.y, this.lastX, this.lastY, this.couleur));
        x = lastX;
        y = lastY;
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
