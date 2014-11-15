package clases;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;

public class Principal extends JFrame{
	
	ArrayList<String> skins;
	JButton btn;
	JComboBox<String> comboSkins;
	JTextField txt;
	JCheckBox chk;
	
	public Principal(){
		
		setLayout(new BorderLayout());
		
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		
		chk=new JCheckBox("Checkea si deseas ingresar un skin que no aparezca en la lista.");
		chk.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(chk.isSelected()){
					txt.setEnabled(true);
					comboSkins.setEnabled(false);
				}else{
					txt.setEnabled(false);
					comboSkins.setEnabled(true);
				}
			}
		});
		txt=new JTextField(20);
		
		JPanel pcheck=new JPanel();
		pcheck.setLayout(new BoxLayout(pcheck, BoxLayout.Y_AXIS));
		pcheck.add(chk);
		pcheck.add(txt);

		JPanel pcombo=new JPanel();
		comboSkins=new JComboBox<String>(llenarCombo());
		pcombo.add(comboSkins);
		
		p.add(pcheck,BorderLayout.NORTH);
		p.add(pcombo,BorderLayout.CENTER);
		
		JPanel pboton=new JPanel();
		btn=new JButton("Aceptar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					  SubstanceLookAndFeel.setSkin(skins.get(comboSkins.getSelectedIndex()));
				      //UIManager.setLookAndFeel(skins.get(comboSkins.getSelectedIndex()));
				      SwingUtilities.updateComponentTreeUI(Principal.this);
				     } catch (Exception e) {
						// TODO: handle exception
				    	 e.printStackTrace();
					}
			}
		});
		pboton.add(btn);
		
		add(p,BorderLayout.CENTER);
		add(pboton,BorderLayout.SOUTH);
		
		this.setSize(new Dimension(500, 150));
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	public String[] llenarCombo(){
		String listado[];
		skins=new ArrayList<String>();
		TreeMap<String, SkinInfo> pieles= (TreeMap<String, SkinInfo>) SubstanceLookAndFeel.getAllSkins();
		Iterator<Entry<String,SkinInfo>> it=pieles.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,SkinInfo> e = (Entry<String,SkinInfo>)it.next();
			skins.add(e.getValue().getClassName());
		}
		listado=new String[skins.size()];
		for(int i=0;i<skins.size();i++){
			listado[i]=skins.get(i);
		}
		return listado;
	}
	
	public static void main(String arg[]){
		JFrame.setDefaultLookAndFeelDecorated(true);
	    new Principal();
	}
	
}
