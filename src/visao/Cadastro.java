package visao;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.border.BevelBorder;

import modelo.Artefato;

import java.awt.Canvas;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Cadastro extends JPanel {
	private JTextField txtNome;
	private JTextField txtQuantidade;
	private JTextField txtDescricao;
	private TextField tfimagem;
	private JComboBox cbtipo;

	/**
	 * Create the panel.
	 */
	public Cadastro() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel popupCadastro = new JPanel();
		add(popupCadastro, BorderLayout.CENTER);
		popupCadastro.setLayout(new MigLayout("", "[49.00][39.00,grow][10.00]", "[][][][][57.00][][129.00][][]"));
		
		JLabel lblCadastro = new JLabel("CADASTRO");
		lblCadastro.setFont(new Font("Times New Roman", Font.BOLD, 20));
		popupCadastro.add(lblCadastro, "cell 1 0");
		
		JSeparator separator = new JSeparator();
		popupCadastro.add(separator, "cell 1 1");
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		popupCadastro.add(lblNome, "flowx,cell 0 2,alignx left");
		
		txtNome = new JTextField();
		popupCadastro.add(txtNome, "cell 1 2,growx,aligny baseline");
		txtNome.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		popupCadastro.add(lblQuantidade, "flowx,cell 0 3,alignx left");
		
		txtQuantidade = new JTextField();
		popupCadastro.add(txtQuantidade, "flowx,cell 1 3,alignx leading");
		txtQuantidade.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		popupCadastro.add(lblDescrio, "flowx,cell 0 4,alignx left");
		
		JLabel lblTipo = new JLabel("Tipo");
		popupCadastro.add(lblTipo, "cell 1 3,alignx center");
		
		cbtipo = new JComboBox();
		popupCadastro.add(cbtipo, "cell 1 3,growx");
		
		txtDescricao = new JTextField();
		popupCadastro.add(txtDescricao, "cell 1 4,grow");
		txtDescricao.setColumns(10);
		
		Button btnImagem = new Button("Imagem");
	//	btnImagem.addActionListener(new adicionarImagem());
		popupCadastro.add(btnImagem, "cell 0 5");
		
		tfimagem = new TextField();
		popupCadastro.add(tfimagem, "cell 1 5,growx,aligny baseline");
		
		JLabel lblImagem = new JLabel("");
		popupCadastro.add(lblImagem, "cell 1 6,alignx left,growy");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new salvaCadastro());
		popupCadastro.add(btnSalvar, "flowx,cell 1 7,alignx center");
		
		JButton btnCancelar = new JButton("Cancelar");
		popupCadastro.add(btnCancelar, "cell 1 7,alignx right");

	}
	
//	private class  adicionarImagem implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			JFileChooser arquivo = new JFileChooser();
//			arquivo.setDialogTitle("Selecione uma Imagem");
//			arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
//			
//			int opc = arquivo.showOpenDialog(this);
//			if(opc == JFileChooser.APPROVE_OPTION) {
//				File file = new File("Caminho");
//				file = arquivo.getSelectedFile();
//				String filename = file.getAbsolutePath();
//				tfimagem.setText(filename);
//				
//				ImageIcon.imagem = new ImageIcon(arquivo.getSelectedFile().getPath());
//				
//			
//		}
//		
//			
//		}
	
	private class salvaCadastro implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Artefato artfact = new Artefato(txtNome.toString(), Integer.parseInt(txtQuantidade.toString()) 
					, cbtipo.getSelectedItem().toString(),"1", txtDescricao.toString());
			System.out.print(artfact);
	
			
			
		}
	}
	
	private class fecharJanela implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
						
		}
	}
	

}
