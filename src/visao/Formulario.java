package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controle.Controle;
import modelo.Artefato;
import modelo.ArtefatoTable;

import javax.swing.JButton;
import javax.swing.JTable;



public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Controle c = new Controle();
	ArtefatoTable modelo;
	JPanel panel_1;
	JScrollPane scrollPane;
	List<Artefato> artlist;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		super("CUPAIB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new Cadastrar());
		panel.add(btnCadastrar);
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new Editar());
		panel.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ExcluirArtefato());
		panel.add(btnExcluir);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		artlist = c.selectArtefato();
		modelo = new ArtefatoTable(artlist);
		
		table = new JTable(modelo);
	//	panel_1.add(table);
		scrollPane = new JScrollPane(table);
		add(scrollPane);		
	}
	
	private class Cadastrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			FormCadastro fc = new FormCadastro();
			
			artlist = c.selectArtefato();
			ArtefatoTable newModelo = new ArtefatoTable(artlist);
			table.setModel(newModelo);
			table.repaint();
			//Cadastro c = new Cadastro();
			//fc.add(c);
		
		}
	}
	
	private class Editar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Artefato a = modelo.getObject(table.getSelectedRow());
			FormCadastro fc = new FormCadastro(a);
			
		}
	}
	
	private class ExcluirArtefato implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Artefato a = modelo.getObject(table.getSelectedRow());
			c.deleteArtefato(a);
			artlist = c.selectArtefato();
			ArtefatoTable newModelo = new ArtefatoTable(artlist);
			table.setModel(newModelo);
			table.repaint();
			
			
			
			
			
		}
	}
}
	
	
