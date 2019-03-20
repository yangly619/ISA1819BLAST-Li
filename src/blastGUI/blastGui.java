package blastGUI;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blast.BlastController;
import javax.swing.*;

public class blastGui extends JFrame {
	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	
	BlastController bCnt = new BlastController();
		private JFrame frame;
		private JSplitPane splitpanel;
		private JPanel panelleft;
		private JRadioButton protein;
		private JRadioButton nucleotid;
		private ButtonGroup buttonGroup;
		private JLabel l_percent;
		private JLabel l_secuence;
		private JComboBox<String>  secuencia;
		private JTextField porcentaje;
		private JButton boton;
		private JTextArea resultArea;
		private JScrollPane sp;
		
		public blastGui() {
			panelleft = new JPanel();
			splitpanel=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			buttonGroup=new ButtonGroup();
			protein= new JRadioButton("PROTEIN");
			nucleotid=new JRadioButton("NUCLEOTID");

		
			porcentaje=new JTextField("",8);
			l_percent=new JLabel("Porcentaje de acierto (0-1) ");
			porcentaje.setEditable(true);
			buttonGroup.add(protein);
			buttonGroup.add(nucleotid); 
			l_secuence=new JLabel("Introduzca la secuencia");
			
			boton=new JButton ("start");
			
		

			secuencia=new JComboBox<String> ();
			secuencia.setEditable(true);
			secuencia.addActionListener(new queryActionlistener (secuencia));
			
			
			resultArea=new JTextArea(20,30);
			JScrollPane panelright = new JScrollPane(resultArea);
			panelright.setSize(20,30);
			
			boton.addActionListener(new resultActionListener(porcentaje,secuencia,protein,nucleotid,resultArea,bCnt,dataBaseFile,dataBaseIndexes));
			
			panelleft.add(protein);
			panelleft.add(nucleotid);
			panelleft.add(l_percent);
			panelleft.add(porcentaje);
			panelleft.add(l_secuence);
			panelleft.add(secuencia);
			panelleft.add(boton);
			
			panelleft.setSize(200,400);
			panelleft.setLayout(new FlowLayout());
			
			panelright.setSize(400,400);
			 
			panelleft.setBorder(BorderFactory.createLineBorder(Color.blue));
			panelright.setBorder(BorderFactory.createLineBorder(Color.blue));
			splitpanel.setLeftComponent(panelleft);
			splitpanel.setRightComponent(panelright);
			
			splitpanel.setDividerSize(2);
			splitpanel.setDividerLocation(200);
		
			
			
			this.setContentPane(splitpanel);
			this.setVisible(true);
			this.setSize(600,500);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			
		}
		
}

