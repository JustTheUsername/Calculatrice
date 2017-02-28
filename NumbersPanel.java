/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicescalculetteinterface;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Formation
 */
public class NumbersPanel extends JPanel {

    private String[] buttonsText = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "="};

    private ArrayList<JButton> boutonsList = new ArrayList<>();

    public NumbersPanel() {
        this.setLayout(new GridLayout(5, 4));

        for (int i = 0; i < buttonsText.length; i++) {

            JButton button = new JButton(buttonsText[i]);
//donne a mes boutonsList le nom " Button0 " "Button1" etc...
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Fenetre.update=true;
                    if (Fenetre.update == true && !e.getActionCommand().equals("=")) {

                        Fenetre.displayPanel.setText(e.getActionCommand());
                        if (!e.getActionCommand().equals("0")) {

                            Fenetre.update = false;
                            Fenetre.presenceChiffre = true;
                            //J'ai essayé de disabl le . si on l'a deja utilisé mais ca marche pas
                                if (e.getActionCommand().equals(".")){
                                 //ca sert a rien pour le momenet mais on verra plus tard pour autoriser un point unique  
                                    Fenetre.presencePoint =true;
                                                                   
                                }
                        }

                    } else if (e.getActionCommand().equals("=")) {
                            //si on 
                        if (Fenetre.operator.equals("")) {

                            Fenetre.displayPanel.setText(String.valueOf(Fenetre.currentResult));

                            Fenetre.update = true;

                        } else {
                                    // les opérations 
                            switch (Fenetre.operator) {

                                case "+":

                                    Fenetre.currentResult = Fenetre.currentResult + (Double.parseDouble(Fenetre.displayPanel.getText()));

                                    Fenetre.displayPanel.setText(String.valueOf(Fenetre.currentResult));

                                    Fenetre.operator = "";
                                    
                                    Fenetre.presenceChiffre=false;

                                    break;

                                case "-":
                                    Fenetre.currentResult = Fenetre.currentResult - (Double.parseDouble(Fenetre.displayPanel.getText()));

                                    Fenetre.displayPanel.setText(String.valueOf(Fenetre.currentResult));

                                    Fenetre.operator = "";
                                    Fenetre.presenceChiffre=false;

                                    break;

                                case "*":
                                    Fenetre.currentResult = Fenetre.currentResult * (Double.parseDouble(Fenetre.displayPanel.getText()));

                                    Fenetre.displayPanel.setText(String.valueOf(Fenetre.currentResult));

                                    Fenetre.operator = "";
                                    Fenetre.presenceChiffre=false;

                                    break;
                                case "/":
                                    try {
                                        Fenetre.currentResult = Fenetre.currentResult / (Double.parseDouble(Fenetre.displayPanel.getText()));
                                    } catch (ArithmeticException exep) {

                                        Fenetre.displayPanel.setText("infinity");

                                    }
                                    Fenetre.displayPanel.setText(String.valueOf(Fenetre.currentResult));

                                    Fenetre.operator = "";
                                    Fenetre.presenceChiffre=false;

                                    break;
                            }

                        }
                    } else {
                            // concaténation de la String du display
                        Fenetre.displayPanel.setText(Fenetre.displayPanel.getText() + e.getActionCommand());

                    }

                }
            });

//ajoute mes boutonsList à l'arrayList Boutons
            boutonsList.add(button);
//ajoute un action listener sur chaque bouton

// ajoute les bouttons au panel
            this.add(boutonsList.get(i));

        }

    }

}
