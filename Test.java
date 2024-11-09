import javax.swing.JFrame;
import javax.swing.WindowConstants;

import mksEngine.Actor;
import mksEngine.Stage;
import mksEngine.Vector2d;

public class Test {
    public static void main(String[] args) {
        JFrame frm = new JFrame();
        Stage s = new Stage();

        Actor a1 = new Actor("A1", new Vector2d(0, 0), null);
        s.addActor(a1);

        a1.start();

        // System.out.println(a1);
        // System.out.println("Move");
        // a1.move(5.5f, WorldDirection.RIGTH);
        // a1.turnClockwise(1);
        // a1.turnClockwiseC(1);

        // a1.move(5, a1.getLocalLeftDirection());

    //    var ss = mksEngine.Math.subVectors(new Vector2d(25, 18), new Vector2d(35, -45));
    //    System.err.println(ss);
    //     //

    //     System.out.println(a1);
        frm.add(s);
        frm.setSize(1000, 800);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
