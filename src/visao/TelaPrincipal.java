package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Image;

import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import java.awt.Component;

import javax.print.DocFlavor.URL;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaPrincipal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 447, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][][grow]", "[][][]"));
		
		
		
		
				
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon("/home/luanleiteleao/git/Trabalho2019-1/Imagens/Passaportesfalsos.png").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT)));
		
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		
		frame.getContentPane().add(lblNewLabel_1, "cell 1 0,alignx center");
		
		
		JLabel lblNome = new JLabel("Nome");
		frame.getContentPane().add(lblNome, "flowx,cell 0 1,alignx trailing");
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		frame.getContentPane().add(lblQuantidade, "flowx,cell 1 1");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 0 1,alignx left");
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tipo"}));
		frame.getContentPane().add(comboBox, "cell 3 1,alignx left");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 1 1");
		textField_1.setColumns(5);
	}

	

	
}
