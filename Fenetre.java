/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicescalculetteinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Formation
 */
public class Fenetre extends JFrame{
        NumbersPanel numbersPanel;
        static DisplayPanel displayPanel ;
        OperatorsPanel operatorsPanel = new OperatorsPanel();
        static boolean update = false;
        static boolean clicOperator=false;
        static boolean presenceChiffre=false;
        static boolean presencePoint=false;
        static String operator ="";
        static double currentResult = 0.00;
        
        public Fenetre(){
    //param.fenetre
    this.setTitle("Calculatrice");
    this.setSize(340, 480);
    this.setMinimumSize(new Dimension(340, 480));
    this.setLocationRelativeTo(null);
    
    this.setLayout(new BorderLayout());
    
    this.numbersPanel = new NumbersPanel();
    this.displayPanel = new DisplayPanel();
    
    numbersPanel.setPreferredSize(new Dimension(250,480));
    operatorsPanel.setPreferredSize(new Dimension(80,480));
    this.getContentPane().add(displayPanel,BorderLayout.NORTH);
    this.getContentPane().add(numbersPanel);
    this.getContentPane().add(operatorsPanel,BorderLayout.EAST);

    //affichage fenetre
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    
    
    //System.out.println(this.getContentPane().getComponent(0));
    
    }
}
