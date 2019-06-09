package modele;

import java.awt.*;

public class Cercle extends ConiqueCentree {
    private int rayon;

    @Override
    public int nbPoints() {
        return 4;
    }

    @Override
    public int nbClics() {
        return 2;
    }

    @Override
    public void modifierPoints(Point[] pts) {
        this.centre = pts[0];
        this.rayon = Math.abs(pts[0].distance(pts[1]));
        this.tab_mem[0] = new Point(this.centre.rendreX(), this.centre.rendreY() - this.rayon);
        this.tab_mem[1] = new Point(this.centre.rendreX() + this.rayon, this.centre.rendreY());
        this.tab_mem[2] = new Point(this.centre.rendreX(), this.centre.rendreY() + this.rayon);
        this.tab_mem[3] = new Point(this.centre.rendreX() - this.rayon, this.centre.rendreY());
    }

    @Override
    public boolean estDedans(int x, int y) {
        return (this.centre.distance(new Point(x, y)) <= this.rayon);
    }

    @Override
    public void affiche(Graphics g) {
        g.setColor(this.couleur);
        g.fillOval(this.centre.rendreX() - this.rayon, this.centre.rendreY() - this.rayon, this.rayon * 2, this.rayon * 2);
        super.affiche(g);
    }

    @Override
    public void translation(int dx, int dy) {
        this.centre.setX(this.centre.rendreX() + dx);
        this.centre.setY(this.centre.rendreY() + dy);
        super.translation(dx, dy);
    }

    @Override
    public void transformation(int dx, int dy, int i) {
        switch (i) {
            case 0 :
                this.rayon = this.centre.distance(new Point(this.tab_mem[0].rendreX() + dx, this.tab_mem[0].rendreY() + dy));
                break;
            case 1 :
                this.rayon = this.centre.distance(new Point(this.tab_mem[1].rendreX() + dx, this.tab_mem[1].rendreY() + dy));
                break;
            case 2 :
                this.rayon = this.centre.distance(new Point(this.tab_mem[2].rendreX() + dx, this.tab_mem[2].rendreY() + dy));
                break;
            case 3 :
                this.rayon = this.centre.distance(new Point(this.tab_mem[3].rendreX() + dx, this.tab_mem[3].rendreY() + dy));
                break;
        }
        this.tab_mem[0] = new Point(this.centre.rendreX(), this.centre.rendreY() - this.rayon);
        this.tab_mem[1] = new Point(this.centre.rendreX() + this.rayon, this.centre.rendreY());
        this.tab_mem[2] = new Point(this.centre.rendreX(), this.centre.rendreY() + this.rayon);
        this.tab_mem[3] = new Point(this.centre.rendreX() - this.rayon, this.centre.rendreY());
    }
}
