package mksEngine;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class Stage extends JPanel implements Runnable {

    private static Vector<Actor> actors = new Vector<Actor>();
    private static boolean isAlive = true;

    public Stage() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    protected final void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderActors(g);
    }

    private final void renderActors(Graphics g) {
        if (actors != null) {
            for (int i = 0; i < actors.size(); i++) {
                actors.get(i).render(g);
            }
        }

    }

    public static final boolean spawnActor(Actor actor) {
        if (actors != null) {
            System.err.println("Yes it's a live");
            if (actor != null) {
                if (actor.isStillAlive()) {
                    actors.add(actor);
                    return true;
                }

            }
        }
        return false;
    }

    static final boolean destroyActor(Actor actor) {
        return actors.remove(actor);
    }

    @Override
    public final void run() {
        while (isAlive) {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void stop() {
        Stage.actors = null;
        Stage.isAlive = false;
    }
}
