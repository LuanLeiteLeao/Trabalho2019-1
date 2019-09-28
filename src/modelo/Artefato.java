package modelo;

public class Artefato {
	private int       id;
	private String    nome;
	private int       quantidade;
	private String    tipo;
	private String    urlImagem;
	private String    descricao;
	
	public Artefato() {
		super();
	}


	public Artefato(String nome, int quantidade, String tipo, String urlImagem, String descricao) {
		
		setNome(nome);
		setQuantidade(quantidade);
		setTipo(tipo);
		setUrlImagem(urlImagem);
		setDescricao(descricao);

	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public void print() {
		
		
			System.out.print(this.getId()+" ");
			System.out.print(this.getNome()+" ");
			System.out.print(this.getQuantidade()+" ");
			System.out.print(this.getTipo()+" ");
			System.out.print(this.getUrlImagem()+" ");
			System.out.println(this.getDescricao());

		
	}
}
