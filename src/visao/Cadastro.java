package visao;

import javax.swing.JPanel;
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
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Canvas;

public class Cadastro extends JPanel {
	private JTextField txtNome;
	private JTextField txtQuantidade;
	private JTextField txtDescricao;

	/**
	 * Create the panel.
	 */
	public Cadastro() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel popupCadastro = new JPanel();
		add(popupCadastro, BorderLayout.CENTER);
		popupCadastro.setLayout(new MigLayout("", "[49.00][39.00,grow][10.00]", "[][][][][57.00][][][]"));
		
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
		
		JComboBox cbtipo = new JComboBox();
		popupCadastro.add(cbtipo, "cell 1 3,growx");
		
		txtDescricao = new JTextField();
		popupCadastro.add(txtDescricao, "cell 1 4,grow");
		txtDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		popupCadastro.add(btnSalvar, "flowx,cell 1 6,alignx center");
		
		JButton btnCancelar = new JButton("Cancelar");
		popupCadastro.add(btnCancelar, "cell 1 6,alignx right");

	}

}
