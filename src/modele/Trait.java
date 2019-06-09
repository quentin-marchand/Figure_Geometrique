package modele;

import java.awt.*;

public class Trait {
    private int abs, ord, lAsb, lOrd;
    private Color couleur;

    public Trait(int x, int y, int lastX, int lastY, Color c) {
        this.abs = x;
        this.ord = y;
        this.lAsb = lastX;
        this.lOrd = lastY;
        this.couleur = c;
    }

    public int getAbs() {
        return this.abs;
    }

    public int getOrd() {
        return this.ord;
    }

    public int getlAsb() {
        return this.lAsb;
    }

    public int getlOrd() {
        return this.lOrd;
    }

    public Color getCouleur() {
        return this.couleur;
    }

    public void affiche(Graphics g) {
        g.setColor(this.couleur);
        g.drawLine(this.abs, this.ord, this.lAsb, this.lOrd);
    }
}
