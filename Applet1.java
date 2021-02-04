import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Applet1 extends JApplet {

	private JPanel jContentPane = null;
	private JLabel lblNombre = null;
	private JLabel lblApellido = null;
	private JTextField jTxtNombre = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JTextField jTxtApe = null;
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTxtNombre() {
		if (jTxtNombre == null) {
			jTxtNombre = new JTextField();
			jTxtNombre.setBounds(new java.awt.Rectangle(116,16,169,22));
		}
		return jTxtNombre;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(14,70,271,100));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
		}
		return jTable;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new java.awt.Rectangle(15,173,84,22));
			jButton.setText("Buscar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FileInputStream f;
					try {
						f = new FileInputStream("D:\\Applet1\\base.txt");
						InputStreamReader i = new InputStreamReader(f);
						BufferedReader b = new BufferedReader(i);
						String texto;
		                Vector nombreColumna=new Vector();
		                Vector dato=new Vector();
		                nombreColumna.add("Nombre");
		                nombreColumna.add("Apellido");
		                Vector temp = null;
		                String[] datos;
						while ((texto=b.readLine())!=null){
							datos= texto.split("@");
							if(datos.length>0 && datos[1].toLowerCase().startsWith(jTxtNombre.getText().toLowerCase())){
								temp = new Vector(new CopyOnWriteArrayList(datos));
								dato.addElement(temp);
							}
						}
						jTable=new JTable(dato,nombreColumna);
						jScrollPane.setViewportView(jTable);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new java.awt.Rectangle(201,173,84,22));
			jButton1.setText("Agregar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					FileOutputStream f = new FileOutputStream("D:\\Applet1\\base.txt",true);
					PrintStream p = new PrintStream(f);
					p.println(jTxtApe.getText()+"@"+ jTxtNombre.getText());
					jTxtApe.setText("");
					jTxtNombre.setText("");
					p.close();
					f.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTxtApe() {
		if (jTxtApe == null) {
			jTxtApe = new JTextField();
			jTxtApe.setBounds(new java.awt.Rectangle(116,44,165,22));
		}
		return jTxtApe;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public Applet1() {
		super();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void init() {
		this.setSize(301, 209);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblApellido = new JLabel();
			lblApellido.setBounds(new java.awt.Rectangle(56,49,58,16));
			lblApellido.setText("Apellido");
			lblNombre = new JLabel();
			lblNombre.setBounds(new java.awt.Rectangle(61,17,53,16));
			lblNombre.setText("Nombre");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.white);
			jContentPane.add(lblNombre, null);
			jContentPane.add(lblApellido, null);
			jContentPane.add(getJTxtNombre(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJTxtApe(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
