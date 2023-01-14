package eek.ee;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;


public class Mainframe extends JFrame {
    private GameComp gameComponent;

    public Mainframe () {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(Frame.MAXIMIZED_BOTH);

        gameComponent = new GameComp();

        add(gameComponent,BorderLayout.CENTER);

        JButton nextStep = new JButton("next");
        nextStep.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameComponent.toNextStep();
            }
        });
        add(nextStep, BorderLayout.EAST);
    }
}
