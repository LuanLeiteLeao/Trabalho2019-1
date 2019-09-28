package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Artefato;

import java.awt.FlowLayout;

public class FormCadastro extends JFrame {

	public FormCadastro() {
		super("Cadastro");
		criaTela();
		
		
		Cadastro c = new Cadastro();
		this.add(c);
		setVisible(true);
		
	}
	
	public FormCadastro(Artefato art) {
		super("Editar");
		criaTela();
		
		
		Cadastro c = new Cadastro(art);
		this.add(c);
		setVisible(true);
		
	}
	
	
	
	private void criaTela() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().setLayout(new BorderLayout(0, 0));
	}
	

}
