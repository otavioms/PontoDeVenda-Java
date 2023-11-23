package sistemapdv.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaVenda extends AbstractTableModel {
    
    private static ModeloTabelaVenda instancia = null;
    
    private static final int COLUNA_DATA = 0;
    private static final int COLUNA_HORA = 1;
    private static final int COLUNA_VALORTOTAL = 2;
    //private static final int COLUNA_ITENS = 3;
    
    
    private String[] colunas = new String[]{"Data", "Hora", "Vlr Total" /*, "Itens"*/};
    private ArrayList<Venda> vendas;
    
    ModeloTabelaVenda() {
        this.vendas = new ArrayList<Venda>();
    }
    
    public static ModeloTabelaVenda getInstance() {
        if (instancia == null) {
            instancia = new ModeloTabelaVenda();
        }
        return instancia;
    }
    
    @Override
    public int getRowCount() {
        return vendas.size();
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
    
    @Override
    public Object getValueAt(int row, int col) {
        Venda venda = vendas.get(row);
        switch (col) {
            case COLUNA_DATA:
                return venda.getData();
            case COLUNA_HORA:
                return venda.getHora();
            case COLUNA_VALORTOTAL:
                return venda.getValorTotal();
            /*case COLUNA_ITENS:
                return venda.getItens();*/
        }
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Venda venda = vendas.get(row);
        switch (column) {
            case COLUNA_DATA:
                venda.setData(aValue.toString());
                break;
            case COLUNA_HORA:
                venda.setHora(aValue.toString());
                break;
            case COLUNA_VALORTOTAL:
                venda.setValorTotal(Double.parseDouble(aValue.toString()));
                break;
        }
    }
    
    public Venda obterVenda(int indice) {
        return vendas.get(indice);
    }

    public void incluirVenda(Venda venda) {
        vendas.add(venda);
        fireTableDataChanged();
    }

    public void atualizarVenda(int indice, Venda venda) {
        vendas.set(indice, venda);
        fireTableRowsUpdated(indice, indice);
    }

    public void excluirVenda(int indice) {
        vendas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
}
