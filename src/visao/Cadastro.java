package visao;

import javax.swing.JPanel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Cadastro extends JPanel {
	private JTextField recebeNome;

	/**
	 * Create the panel.
	 */
	public Cadastro() {
		setLayout(new MigLayout("", "[][][][grow]", "[][]"));
		
		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "cell 1 1");
		
		recebeNome = new JTextField();
		add(recebeNome, "cell 3 1,growx");
		recebeNome.setColumns(10);

	}

}
