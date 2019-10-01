package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controle.Controle;
import modelo.Artefato;
import modelo.ArtefatoTable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;



public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Controle c = new Controle();
	ArtefatoTable modelo;
	JPanel panel_1;
	JScrollPane scrollPane;
	List<Artefato> artlist;
	private JButton btnAtualizar;
	

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

	public Formulario() {
		super("CUPAIB");
		
		ImageIcon icone = new ImageIcon("Imagens/icone.png");
		setIconImage(icone.getImage());
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		
		
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
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new atualizar());
		panel.add(btnAtualizar);
		panel.add(btnExcluir);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		artlist = c.selectArtefato();
		modelo = new ArtefatoTable(artlist);
		
		table = new JTable(modelo);
	//	panel_1.add(table);
		scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);		
	}
	
	private void acaoIncluir() {
		FormCadastro fc = new FormCadastro();
	}
	
	private Artefato retornaObjetodaLinha() {
		return modelo.getObject(table.getSelectedRow());
	}
	
	private void acaoEditar() {
		Artefato a = retornaObjetodaLinha();
		FormCadastro fc = new FormCadastro(a);
		
	}
	
	private int chamarTelaExcluir(Artefato a) {
		ExcluirDialog ed = new ExcluirDialog();
		return JOptionPane.showConfirmDialog(ed,"Tem certeza que deseja excluir o Artefato: \nNome: "+a.getNome()+"\nQuantidade: "
				+a.getQuantidade()+"\nTipo: "+a.getTipo()+"\nDescrição: "+a.getDescricao()+"\nURL: "+a.getUrlImagem(),
				"Excluir", JOptionPane.YES_NO_OPTION);
		
		 
	}
	
	private void acaoExcluir() {
		Artefato a = retornaObjetodaLinha();
		
		int resposta = chamarTelaExcluir(a);
		
		if (resposta == JOptionPane.YES_OPTION) {
			c.deleteArtefato(a);
	      }
	     	
	}
	
	private void refresh () {
		artlist = c.selectArtefato();
		modelo = new ArtefatoTable(artlist);
		table.setModel(modelo);
		table.repaint();
	}
	
	
	private class Cadastrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			acaoIncluir();
			refresh();
			
					
		}
	}
	
	private class atualizar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	}
	
	
	private class Editar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			acaoEditar();
			setEnabled(false);
			refresh();
			setEnabled(true);			
		}
	}
	
	private class ExcluirArtefato implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			acaoExcluir();
			refresh();
		}
	}
}
	
	
