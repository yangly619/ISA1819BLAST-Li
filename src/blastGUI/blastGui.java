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
	private BlastController bCnt = new BlastController();
	ImageIcon im=new ImageIcon ("gen1.jpg");
	
		private JFrame frame;
		private JSplitPane splitpanel;
		private backImage panelleft;
		private JScrollPane panelright;
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
		private JLabel imagen;
		private JMenuBar menuBar;
		
		@SuppressWarnings("deprecation")
		public blastGui() {
			
			//la ventana se divide en dos partes
			splitpanel=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			splitpanel.setDividerSize(2);
			splitpanel.setDividerLocation(200);
				//panel izquierdo
			panelleft =new backImage(im);
			panelleft.setSize(200,500);
			panelleft.setLayout(new FlowLayout());
				//panel derecho, solo tiene un textArea para demostrar el resultado
			resultArea=new JTextArea();
			panelright = new JScrollPane(resultArea);
			panelright.setSize(400,500);
			
			
			
			//componentes del panel izquierdo:
				//radiobuttons
			buttonGroup=new ButtonGroup();
			protein= new JRadioButton("PROTEIN");
			nucleotid=new JRadioButton("NUCLEOTID");
			buttonGroup.add(protein);
			buttonGroup.add(nucleotid); 
			panelleft.add(protein);
			panelleft.add(nucleotid);
		
			//textField para introducir el porcentaje y su label
			porcentaje=new JTextField("",8);
			porcentaje.setEditable(true);
			l_percent=new JLabel("Porcentaje de acierto (0-1) ");
			panelleft.add(l_percent);
			panelleft.add(porcentaje);
			
			//comboBox para escribir la secuencia con su actionListener para cuardar historia
			
			l_secuence=new JLabel("Introduzca la secuencia");
			secuencia=new JComboBox<String> ();
			secuencia.setEditable(true);
			secuencia.addActionListener(new queryActionlistener (secuencia));
			panelleft.add(l_secuence);
			panelleft.add(secuencia);
			
			//boton inicio
			boton=new JButton ("start");
			boton.addActionListener(new resultActionListener(porcentaje,secuencia,protein,nucleotid,
					resultArea,bCnt,dataBaseFile,dataBaseIndexes));
			panelleft.add(boton);
			
			//menubar and menu : cuardar fichero y limpiar datos
			menuBar = new JMenuBar();
			JMenu menu1=new JMenu("File");
			JMenuItem saveMenu = new JMenuItem("Save");
			JMenuItem resetMenu = new JMenuItem("Reset");
			saveMenu.addActionListener(new saveActionlistener(resultArea) );
			resetMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					porcentaje.setText(null);
					secuencia.removeAllItems();
					buttonGroup.clearSelection();
					resultArea.setText(null);
				}
			});
	
			menu1.add(saveMenu);
			menu1.add(resetMenu);
			menuBar.add(menu1);
			this.setJMenuBar(menuBar);
			
			
			
			//diseño sobre le panel y ajust sobre el frame
			panelleft.setBorder(BorderFactory.createLineBorder(Color.blue));
			panelright.setBorder(BorderFactory.createLineBorder(Color.blue));
			splitpanel.setLeftComponent(panelleft);
			splitpanel.setRightComponent(panelright);
			
			this.setContentPane(splitpanel);
			this.setVisible(true);
			this.setSize(600,500);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		}
		
		
}

