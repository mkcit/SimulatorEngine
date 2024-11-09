package mksEngine;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class Stage extends JPanel {

    private Vector<Actor> actors = new Vector<Actor>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderActors(g);
    }

    public void addActor(Actor actor) {
        if (actor != null)
            actors.add(actor);
    }

    private void renderActors(Graphics g) {
        for (int i = 0; i < actors.size(); i++) {
            actors.get(i).render(g);
        }
    }
}
