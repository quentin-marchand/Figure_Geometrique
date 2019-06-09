package modele;

public class Rectangle extends Quadrilatere {

    public Rectangle() {
        super();
    }

    public int nbClics() {
        return 2;
    }

    @Override
    public void modifierPoints(Point[] pts) {
        this.tab_mem[0] = pts[0];
        this.tab_mem[1] = new Point(pts[1].rendreX(), pts[0].rendreY());
        this.tab_mem[2] = pts[1];
        this.tab_mem[3] = new Point(pts[0].rendreX(), pts[1].rendreY());
    }

    @Override
    public void transformation(int dx, int dy, int i) {
        switch (i) {
            case 0 :
                this.tab_mem[0].translation(dx, dy);
                this.tab_mem[1].translation(0, dy);
                this.tab_mem[3].translation(dx, 0);
                break;
            case 1 :
                this.tab_mem[1].translation(dx, dy);
                this.tab_mem[0].translation(0, dy);
                this.tab_mem[2].translation(dx, 0);
                break;
            case 2 :
                this.tab_mem[2].translation(dx, dy);
                this.tab_mem[3].translation(0, dy);
                this.tab_mem[1].translation(dx, 0);
                break;
            case 3 :
                this.tab_mem[3].translation(dx, dy);
                this.tab_mem[2].translation(0, dy);
                this.tab_mem[0].translation(dx, 0);
                break;
        }
    }
}
