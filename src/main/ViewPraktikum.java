
package main;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Panel;

import static java.awt.SystemColor.window;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;


public class ViewPraktikum extends JFrame {
    
	JLabel lmoney = new JLabel("Money");
	JLabel lmoneyValue = new JLabel("0"); 
	JLabel lmultiplication = new JLabel("Multiplication");
	JLabel lmultiplicationValue = new JLabel("0x");
	JLabel llevelUpCost = new JLabel("Level Up Cost");
	JLabel llevelUpCostValue = new JLabel("0");
	
	JButton bclick = new JButton("Click");
	JButton breset = new JButton("Reset");
	JButton bmultiplication = new JButton("Level Up");
          
    public void main(){
    	
    	setLayout(null);
    	add(lmoney);
    	add(lmoneyValue);
    	add(lmultiplication);
    	add(lmultiplicationValue);
    	add(llevelUpCost);
    	add(llevelUpCostValue);
    	add(bclick);
    	add(breset);
    	add(bmultiplication);

    	lmoney.setBounds(30, 10, 80, 20);
    	lmoneyValue.setBounds(130, 10, 80, 20);
    	lmultiplication.setBounds(30, 40, 80, 20);
    	lmultiplicationValue.setBounds(130, 40, 80, 20);
    	llevelUpCost.setBounds(30 , 130 , 100 , 20);
    	llevelUpCostValue.setBounds(130 , 130 , 100 , 20);
    	bclick.setBounds(30 , 70 , 120 , 20);
    	breset.setBounds(180 , 70 , 120 , 20);
    	bmultiplication.setBounds(30 , 110 , 270 , 20);
    	
    	setSize(350,200);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
}
        
}

