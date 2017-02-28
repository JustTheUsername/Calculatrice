/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicescalculetteinterface;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

/**
 *
 * @author Formation
 */
public class DisplayPanel extends JLabel {

    public DisplayPanel() {

        System.out.println("lol");

        this.setPreferredSize(new Dimension(340, 50));
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
       // this.setHorizontalTextPosition(RIGHT);
        this.setHorizontalAlignment(JLabel.RIGHT);
        this.setText("0");

    }
}
