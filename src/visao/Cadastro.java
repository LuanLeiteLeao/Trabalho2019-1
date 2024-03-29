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

import controle.Controle;
import modelo.Artefato;

import java.awt.Canvas;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultComboBoxModel;

public class Cadastro extends JPanel {
	private String[] tipo= {"Treco leco","Bagulho","Coiso","Troço","Documento"};
	private JTextField txtNome;
	private JTextField txtQuantidade;
	private JTextField txtDescricao;
	private TextField tfimagem;
	private Artefato artaux;
	private JButton btnSalvar;
	private JComboBox tipoComboBox;
	/**
	 * Create the panel.
	 */
	public Cadastro() {
		criaTela();
		btnSalvar.addActionListener(new salvaCadastro());
	}
	
	public Cadastro(Artefato art) {
		artaux = art;
		criaTela();
		txtNome.setText(art.getNome());
		txtDescricao.setText(art.getDescricao());
		txtQuantidade.setText(Integer.toString(art.getQuantidade()));
		tfimagem.setText(art.getUrlImagem());
		tipoComboBox.setSelectedItem(art.getTipo());
		btnSalvar.addActionListener(new editarCadastro());
	}
	
	private void criaTela() {
		setLayout(new BorderLayout(0, 0));
		JPanel popupCadastro = new JPanel();
		add(popupCadastro, BorderLayout.CENTER);
		popupCadastro.setLayout(new MigLayout("", "[49.00][39.00,grow][10.00]", "[][][][][57.00][119.00][42.00][][129.00][][]"));
		
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
		
		JLabel lblTipo = new JLabel("Tipo");
		popupCadastro.add(lblTipo, "cell 1 3,alignx center");
		
		JLabel lblImagem_1 = new JLabel("Imagem");
		popupCadastro.add(lblImagem_1, "cell 0 4");
		
		tfimagem = new TextField();
		popupCadastro.add(tfimagem, "cell 1 4,growx,aligny baseline");
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		popupCadastro.add(lblDescrio, "flowx,cell 0 5,alignx left");
		
		txtDescricao = new JTextField();
		popupCadastro.add(txtDescricao, "cell 1 5,grow");
		txtDescricao.setColumns(10);
		
		JLabel lblImagem = new JLabel("");
		popupCadastro.add(lblImagem, "cell 1 8,alignx left,growy");
		
		btnSalvar = new JButton("Salvar");
		
		popupCadastro.add(btnSalvar, "flowx,cell 1 9,alignx center");
		
		tipoComboBox = new JComboBox();
		tipoComboBox.setModel(new DefaultComboBoxModel(this.tipo));
		popupCadastro.add(tipoComboBox, "cell 1 3");
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
	
	private void limparTela() {
		txtNome.setText("");
		txtQuantidade.setText("");
		//txtTipo.setText("");
		tfimagem.setText("");
		txtDescricao.setText("");
	}
	
	private class salvaCadastro implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Artefato artfact = new Artefato(txtNome.getText(), Integer.parseInt(txtQuantidade.getText()),tipoComboBox.getSelectedItem().toString(), tfimagem.getText(), txtDescricao.getText() );
			Controle c = new Controle();
			c.inserArtefato(artfact);
			
			limparTela();
		
		}
	}
	
	private class editarCadastro implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Artefato artfact = new Artefato(txtNome.getText(), Integer.parseInt(txtQuantidade.getText()), tipoComboBox.getSelectedItem().toString(), tfimagem.getText(), txtDescricao.getText() );
			artfact.setId(artaux.getId());
			Controle c = new Controle();
			c.altealterArtefato(artfact);
			
			limparTela();
		
		}
	}	

}
