package blastGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class saveActionlistener implements ActionListener{

		private JTextArea resultArea;
			
		public saveActionlistener(JTextArea resultArea) {
			
			this.resultArea=resultArea;
	
		}
		
		public void actionPerformed(ActionEvent e)  {
			JFileChooser fileChooser = new JFileChooser();	 
			fileChooser.setSelectedFile(new File("blast_query.txt"));
			fileChooser.showSaveDialog(null);
	 
			String filePath = fileChooser.getSelectedFile().toString();
			try {
				FileWriter writer = new FileWriter(filePath);
				writer.append(resultArea.getText());
				writer.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
}
