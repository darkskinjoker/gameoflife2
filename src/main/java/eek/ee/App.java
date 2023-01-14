package eek.ee;

import java.awt.*;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Mainframe mainframe = new Mainframe();
            mainframe.setVisible(true);
        });
    }
}
