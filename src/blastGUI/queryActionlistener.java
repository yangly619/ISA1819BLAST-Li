package blastGUI;
import java.awt.event.*;

import javax.swing.JComboBox;
public class queryActionlistener implements ActionListener {
	private JComboBox<String> combox;
	
	public queryActionlistener (JComboBox<String> combox) {
		this.combox=combox;
	}
	public void actionPerformed(ActionEvent e) {
		String memoria=combox.getEditor().getItem().toString();
		combox.addItem(memoria);
		for(int i=0;i<combox.getItemCount();i++) {
			for( int j  =  combox.getItemCount() - 1 ; j  >  i; j --)
			if(combox.getItemAt(j).equals(combox.getItemAt(i))) {
				combox.removeItemAt(j);
			}
		}
	}
}
