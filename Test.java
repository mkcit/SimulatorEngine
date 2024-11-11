import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import mksEngine.Stage;

public class Test {
    public static void main(String[] args) {
        JFrame frm = new JFrame();
        Stage s = new Stage();
        s.setBackground(Color.black);
        Bar b = new Bar();
        // Bar2 b2 = new Bar2();
        Stage.spawnActor(b);
        // Stage.spawnActor(b2);


        frm.add(s);
        frm.setSize(1000, 800);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
