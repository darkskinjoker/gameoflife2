package eek.ee;

import eek.ee.Idea.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class GameComp extends JComponent {
    public static int DEFAULT_VISIBLE_CELLS = 20;
    public static int PADDING_CAM= 40;

    private Cam camera;

    private Grid grid= new Grid();

    public GameComp (){
        int size = grid.getBoxCells().length;
        camera = new Cam(size/2 - DEFAULT_VISIBLE_CELLS/2,
                size/2 - DEFAULT_VISIBLE_CELLS/2,
                DEFAULT_VISIBLE_CELLS,
                DEFAULT_VISIBLE_CELLS);
        setPreferredSize(new Dimension(600,600));
        grid.changedState(500,500,true);
        grid.changedState(501,500,true);
        grid.changedState(500,502,true);
        grid.changedState(499,500,true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int clickX = e.getX();
                int clickY = e.getY();
            }
        });
    }

    public void toNextStep(){
        grid.nextBox();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D d3 = (Graphics2D) g;

        boolean[][]frameCells = grid.getBoxCells();
        double cellSide = (double) camera.pixelW/ camera.width;
        for (int i = camera.y; i < camera.y + camera.length; i++) {
            for (int j = camera.x; j < camera.x + camera.width; j++) {
                boolean liveCells = frameCells[i][j];
                int i1 = i - camera.y;
                int j1 = j - camera.x;
                if (liveCells){
                    d3.setPaint(Color.RED);
                    d3.fill(new Rectangle2D.Double(PADDING_CAM + cellSide * j1, PADDING_CAM + cellSide * i1, cellSide,cellSide) {
                    });
                    d3.setPaint(Color.BLACK);
                    d3.fill(new Rectangle2D.Double(PADDING_CAM + cellSide * j1, PADDING_CAM + cellSide * i1, cellSide,cellSide) {
                    });
                }
            }
            
        }
    }
    private class Cam {
        private int pixelW = 600;

        private int x;
        private int y;
        private int width;
        private int length;

        public Cam(int x, int y, int width, int length) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.length = length;
        }
    };
}

