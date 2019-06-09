package modele;

import java.awt.*;

public abstract class FigureColoree {
    private final static int TAILLE_CARRE_SELECTION = 4;
    private final static int PERIPHERIE_CARRE_SELECTION = 8;
    private boolean selected;
    protected Color couleur;
    protected Point[] tab_mem;

    public FigureColoree() {
        this.selected = false;
        this.couleur = Color.BLACK;
        this.tab_mem = new Point[this.nbPoints()];
    }

    public abstract int nbPoints();

    public abstract int nbClics();

    public abstract void modifierPoints(Point[] pts);

    public void affiche(Graphics g) {
        g.setColor(Color.black);
        if (selected) {
            for (Point p : tab_mem) {
                g.fillRect(p.rendreX() - 1, p.rendreY() - 1, TAILLE_CARRE_SELECTION, TAILLE_CARRE_SELECTION);
            }
        }
    }

    public void selectionne() {
        this.selected = true;
    }

    public void deSelectionne() {
        this.selected = false;
    }

    public void changeCouleur(Color c) {
        this.couleur = c;
    }

    public Color getColor() {
        return this.couleur;
    }

    public abstract boolean estDedans(int x, int y);

    public int carreDeSelection(int x, int y) {
        for (int i = 0; i < this.tab_mem.length; i++) {
            if (this.tab_mem[i].equals(new Point(x, y)))
                return i;
            if ((this.tab_mem[i].rendreX() > x - PERIPHERIE_CARRE_SELECTION) && (this.tab_mem[i].rendreX() < x + PERIPHERIE_CARRE_SELECTION) && (this.tab_mem[i].rendreY() > y - PERIPHERIE_CARRE_SELECTION) && (this.tab_mem[i].rendreY() < y + PERIPHERIE_CARRE_SELECTION))
                return i;
        }
        return -1;
    }

    public void transformation(int dx, int dy, int i) {
        this.tab_mem[i].translation(dx, dy);
    }

    public void translation(int dx, int dy) {
        for (Point p : this.tab_mem)
            p.translation(dx, dy);
    }

    public boolean isSelected() {
        return this.selected;
    }

    public Point[] getTab_mem() {
        return this.tab_mem;
    }

    public static synchronized void println(Object o){
        System.out.println(o);
    }

    public Point getPoint(int i) {
        return this.tab_mem[i];
    }
}
