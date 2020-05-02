package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerPraktikum {

    ModelPraktikum modelpraktikum;
    ViewPraktikum viewpraktikum;
    
    
    public ControllerPraktikum(ModelPraktikum modelpraktikum, ViewPraktikum viewpraktikum) {
        this.modelpraktikum = modelpraktikum;
        this.viewpraktikum = viewpraktikum;
        
        int ambilMoney = 0;
        int imultiplication = 0;
        int ilevelUpCost = 0;
        String sambilMoney = null;
        String smultiplication = null;
        String slevelUpCost = null;
        
        ambilMoney = modelpraktikum.selectMoney();
        sambilMoney = Integer.toString(ambilMoney);
        imultiplication = modelpraktikum.selectMultiplication();
        ilevelUpCost = (int) (imultiplication * 2.5);
        slevelUpCost = Integer.toString(ilevelUpCost);
        smultiplication = Integer.toString(imultiplication);
        smultiplication += "x";
        
        viewpraktikum.main();
        viewpraktikum.lmoneyValue.setText(sambilMoney);
        viewpraktikum.lmultiplicationValue.setText(smultiplication);
        viewpraktikum.llevelUpCostValue.setText(slevelUpCost);
        
        viewpraktikum.bclick.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        String updateMoney = null;
				int money = 0;
				int multiplication = 0;
				money = modelpraktikum.selectMoney();
				multiplication = modelpraktikum.selectMultiplication();
				updateMoney = Integer.toString(hitungMoney(money,multiplication));
				modelpraktikum.updateMoney(updateMoney);
				viewpraktikum.lmoneyValue.setText(updateMoney);
			}
		});
        
        viewpraktikum.breset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modelpraktikum.updateMultiplicationToZero();
				modelpraktikum.updateMoneyToZero();
				viewpraktikum.lmoneyValue.setText("0");
				viewpraktikum.lmultiplicationValue.setText("1x");
				viewpraktikum.llevelUpCostValue.setText("2");
			}
		});
       
        viewpraktikum.bmultiplication.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modelpraktikum.testLevelUpCost() == 1) {
					int imultiplication = 0;
					int ilevelUpCost = 0;
					int imoney = 0;
					String smultiplication = null;
					String slevelUpCost = null;
					String smoney = null;
					imoney = modelpraktikum.selectMoney();
					imultiplication = modelpraktikum.selectMultiplication();
					ilevelUpCost = (int) (imultiplication * 2.5);
					imoney -= ilevelUpCost;
					imultiplication += 1;
					ilevelUpCost = (int) (imultiplication * 2.5);
					smoney = Integer.toString(imoney);
					slevelUpCost = Integer.toString(ilevelUpCost);
					smultiplication = Integer.toString(imultiplication);
					modelpraktikum.updateMoney(smoney);
					modelpraktikum.updateMultiplication(smultiplication);
					smultiplication += "x";
					viewpraktikum.lmultiplicationValue.setText(smultiplication);
					viewpraktikum.llevelUpCostValue.setText(slevelUpCost);
					viewpraktikum.lmoneyValue.setText(smoney);
				}
				else {
					JOptionPane.showMessageDialog(null,"You Cant Level Up");
				}
				
			}
		});
        
    }
    
    public int hitungMoney(int a , int b)
    {
    	int c = a + b;
    	return c;
    }
}
