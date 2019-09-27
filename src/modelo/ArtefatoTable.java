package modelo;
//erro tratado
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ArtefatoTable extends AbstractTableModel {
	
	private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_QUANTIDADE = 2;
    private static final int COL_TIPO = 3;
    private static final int COL_URL = 4;
    private static final int COL_DESCRICAO = 5;

	
	List<Artefato> linhas;
	private String[] colunas = new String[] {"ID","NOME","QUANTIDADE","TIPO","URL","DESCRICAO"};
	
	public ArtefatoTable(List<Artefato> artfact) {
        this.linhas = new ArrayList<>(artfact);
    }

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}
	
	public String getColumnName(int columnIndex) {
	    return colunas[columnIndex];
	}

	@Override
	public Object getValueAt(int row, int column) {
		 Artefato m = linhas.get(row);
		 
	        if (column == COL_ID) {
	            return m.getId();
	        } else if (column == COL_NOME) {
	            return m.getNome();
	        } else if (column == COL_QUANTIDADE) {
	            return m.getQuantidade();
	        } else if (column == COL_TIPO) {
	            return m.getTipo();
	        }  else if (column == COL_URL) {
	            return m.getUrlImagem();
	        }  else if (column == COL_DESCRICAO) {
	            return m.getDescricao();
	        }
	        return "";
	}
	
	public Artefato getObject(int row) {
		return linhas.get(row);
	}
	
	 public void setValueAt(Object aValue, int row, 
			    int column) {
			        Artefato u = linhas.get(row);
			        if (column == COL_ID) {
			            u.setId((Integer) aValue);
			        } else if (column == COL_NOME) {
			            u.setNome(aValue.toString());
			        } else if (column == COL_QUANTIDADE) {
			            u.setQuantidade(Integer.parseInt((String) aValue));
			        } else if (column == COL_TIPO) {
			            u.setTipo(aValue.toString());
			        } else if (column == COL_URL) {
			            u.setUrlImagem(aValue.toString());
			        }else if (column == COL_DESCRICAO) {
			            u.setDescricao(aValue.toString());
			        }
			    }
	
	public boolean isCellEditable(int rowIndex, int
		    columnIndex) {
		        return false;
		    }

}
