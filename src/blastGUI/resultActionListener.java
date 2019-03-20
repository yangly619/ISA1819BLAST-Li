package blastGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import blast.BlastController;

public class resultActionListener implements ActionListener{
	BlastController bCnt;
	char p='p';
	String dataBaseFile;
	String dataBaseIndexes;
	
	JTextArea resultArea;
	JRadioButton p1;
	JRadioButton p2;
	JComboBox<String> sec;
	JTextField porcentaje;
	
	public resultActionListener (JTextField porcentaje,JComboBox<String> sec,JRadioButton p1,JRadioButton p2,
			JTextArea resultArea,BlastController bCnt,String dataBaseFile,String dataBaseIndexes) {
		
		this.bCnt=bCnt;
		this.dataBaseFile=dataBaseFile;
		this.dataBaseIndexes=dataBaseIndexes;
		this.resultArea=resultArea;
		this.sec=sec;
		this.porcentaje=porcentaje;
		this.p1=p1;
		this.p2=p2;
	}
	
	public void actionPerformed(ActionEvent e) {
		try{
			if(p1.isSelected()) {
				p='p';
			}else if(p2.isSelected())
				p='n';
			
			String result = bCnt.blastQuery(p, dataBaseFile, 
					dataBaseIndexes, Float.parseFloat(porcentaje.getText()),sec.getSelectedItem().toString());
			resultArea.setText(result);
			
		} catch(Exception exc){
			System.out.println("Error en la llamada: " + exc.toString());
		}
	}

	
	
	
}
