package modele;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Cette classe définit le modèle.
 * @author MARCHAND Quentin
 */
public class DessinModele extends Observable {

    private int nbf;
    private int sel;
    private List<FigureColoree> lfg;
    private List<Trait> lt;

    public DessinModele() {
        // A completer
    }

    public void initDessinModele() {
        this.lfg = new ArrayList<>();
        this.lt = new ArrayList<>();
        this.nbf = 0;
        this.sel = -1;
        setChanged();
        notifyObservers();
    }

    public void ajoute(FigureColoree figureColoree) {
        for (FigureColoree c : this.lfg) {
            c.deSelectionne();
        }
        this.lfg.add(figureColoree);
        figureColoree.selectionne();
        this.sel = this.nbf;
        this.nbf++;
        setChanged();
        notifyObservers();
    }

    public void ajoute(Trait t) {
        this.lt.add(t);
        setChanged();
        notifyObservers();
    }

    public void majAffichage() {
        setChanged();
        notifyObservers();
    }

    public List<FigureColoree> getLfg() {
        return this.lfg;
    }

    public List<Trait> getLf() {
        return this.lt;
    }

    public int getNbf() {
        return this.nbf;
    }

    public void setNbf(int i) {
        this.nbf = i;
    }

    public int getSel() {
        return this.sel;
    }

    public void setSel(int i) {
        this.sel = i;
    }

    public static synchronized void println(Object o){
        System.out.println(o);
    }
}
