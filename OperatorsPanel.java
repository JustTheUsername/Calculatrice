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
public class OperatorsPanel extends JPanel {
    
    

private String[] buttonsText = {"C", "+", "-", "*", "/"};

    private ArrayList<JButton> boutonsList= new ArrayList<>();

    public OperatorsPanel(){
        this.setLayout(new GridLayout(6,1));

        for (int i = 0; i < buttonsText.length; i++) {

            JButton button = new JButton(buttonsText[i]);
//donne a mes boutonsList le nom " Button0 " "Button1" etc...
       

//ajoute mes boutonsList à l'arrayList Boutons
            boutonsList.add(button);
//ajoute un action listener sur chaque bouton
       button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
              //  if(Fenetre.displayPanel.getText().equals("0")){
                    Fenetre.clicOperator=true;
                    
                if (Fenetre.clicOperator==true && !e.getActionCommand().equals("C")){
                    Fenetre.clicOperator=false;
                    if(!Fenetre.operator.equals("")&&Fenetre.presenceChiffre==true){
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
                    
                    
                    
                    
                    
                    Fenetre.update=true;
                    Fenetre.currentResult=Double.parseDouble(Fenetre.displayPanel.getText());
                    Fenetre.operator = e.getActionCommand();

                      if (!e.getActionCommand().equals("0")){
                      
                          Fenetre.clicOperator=false;
                      }

                    }
                else if(e.getActionCommand().equals("C")){
                
                Fenetre.displayPanel.setText("0");
                Fenetre.clicOperator=false;    
                Fenetre.update=true;
                Fenetre.currentResult = 0;
                Fenetre.operator="";
                
                
                
                }
                else{
                
                Fenetre.displayPanel.setText(Fenetre.displayPanel.getText()+e.getActionCommand());
                
                }
                }
            });
        

// ajoute les bouttons au panel
            this.add(boutonsList.get(i));

        }

    }





}
    
