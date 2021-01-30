/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Oki Ardana
 */
public class RoundedPanel extends JPanel{
    private Color backgroundcolor;
    private int corneradius = 15;
    
    public RoundedPanel(LayoutManager layout,int radius){
        super(layout);
        corneradius = radius;
    }
    public RoundedPanel(LayoutManager layout,int radius,Color bgColor){
        super(layout);
        corneradius = radius;
        backgroundcolor = bgColor;
    }
    public RoundedPanel(int radius){
        super();
        corneradius = radius;
    }
    public RoundedPanel(int radius,Color bgColor){
        super();
        corneradius = radius;
        backgroundcolor = bgColor;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension arcs = new Dimension(corneradius,corneradius);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(backgroundcolor != null){
            graphics.setColor(backgroundcolor);
        }else{
            graphics.setBackground(getBackground());
        }
        graphics.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcs.width, arcs.height);
        graphics.setColor(getForeground());
    }
}
