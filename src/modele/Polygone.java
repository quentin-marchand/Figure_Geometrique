package modele;

import java.awt.*;

public abstract class Polygone extends FigureColoree {
    private Polygon p;

    public Polygone() {
        super();
        p = new Polygon();
    }

    public void affiche(Graphics g) {
        p = new Polygon();
        for (int i = 0; i < this.tab_mem.length; i++) {
            p.addPoint(this.tab_mem[i].rendreX(), this.tab_mem[i].rendreY());
        }
        g.setColor(this.couleur);
        g.fillPolygon(this.p);
        super.affiche(g);
    }

    public int nbClics() {
        return nbPoints();
    }

    public void modifierPoints(Point[] pts) {
        this.tab_mem = pts;
    }

    public boolean estDedans(int x, int y) {
        return p.contains(x, y);
    }
}
