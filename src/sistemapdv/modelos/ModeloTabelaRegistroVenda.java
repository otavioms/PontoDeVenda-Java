package sistemapdv.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaRegistroVenda extends AbstractTableModel {
    
    private static final int COLUNA_CODIGOCHAMADA = 0;
    private static final int COLUNA_CODIGOPROD = 1;
    private static final int COLUNA_DESCRICAO = 2;
    private static final int COLUNA_QUANTIDADE = 3;
    private static final int COLUNA_PRECO = 4;
    private static final int COLUNA_VALORTOTAL = 5;
    
    private String[] colunas = new String[]{"N Item", "Cod Produto", "Descrição", "Quantidade", "Preco", "Vlr Total"};
    private ArrayList<ItemVenda> itemVendas;
    
    public ModeloTabelaRegistroVenda() {
        this.itemVendas = new ArrayList<ItemVenda>();
    }
    
    
    @Override
    public int getRowCount() {
        return itemVendas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Object getValueAt(int row, int col) {
       ItemVenda itemVenda = itemVendas.get(row);
        switch (col) {
            case COLUNA_CODIGOCHAMADA:
                return itemVenda.getNumeroItem();
            case COLUNA_CODIGOPROD:
                return itemVenda.getCodigoProduto();
            case COLUNA_DESCRICAO:
                return itemVenda.getDescricaoProduto();
            case COLUNA_QUANTIDADE:
                return itemVenda.getQuantidadeVendida();
            case COLUNA_PRECO:
                return itemVenda.getPrecoUnitario();
            case COLUNA_VALORTOTAL:
                return itemVenda.getTotalItem();
        }
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column) {
        ItemVenda itemVenda = itemVendas.get(row);
        switch (column) {
            case COLUNA_CODIGOCHAMADA:
                itemVenda.setNumeroItem(Integer.parseInt(aValue.toString()));
                break;
            case COLUNA_CODIGOPROD:
                itemVenda.setCodigoProduto(Integer.parseInt(aValue.toString()));
                break;
            case COLUNA_DESCRICAO:
                itemVenda.setDescricaoProduto(aValue.toString());
                break;
            case COLUNA_QUANTIDADE:
                itemVenda.setQuantidadeVendida(Integer.parseInt(aValue.toString()));
                break;
            case COLUNA_PRECO:
                itemVenda.setPrecoUnitario(Double.parseDouble(aValue.toString()));
                break;
            case COLUNA_VALORTOTAL:
                itemVenda.setTotalItem(Double.parseDouble(aValue.toString()));
                break;
        }
    }
    
    public ItemVenda obterItemVenda(int indice) {
        return itemVendas.get(indice);
    }
    
    public void incluirItemVenda(ItemVenda itemVenda) {
        itemVendas.add(itemVenda);
        fireTableDataChanged();
    }
    
}
