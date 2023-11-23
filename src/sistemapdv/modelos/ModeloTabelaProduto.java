package sistemapdv.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaProduto extends AbstractTableModel {

    private static ModeloTabelaProduto instancia = null;

    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_DESCRICAO = 1;
    private static final int COLUNA_UNIDADE = 2;
    private static final int COLUNA_PRECO = 3;
    private static final int COLUNA_QTDESTOQUE = 4;

    private String[] colunas = new String[]{"Codigo", "Descricao", "Unidade", "Preco", "Qtd em estoque"};
    private ArrayList<Produto> produtos;

    // Construtor privado para impedir a criação direta de instâncias
    ModeloTabelaProduto() {
        this.produtos = new ArrayList<Produto>();
    }

    // Método estático para obter a instância única
    public static ModeloTabelaProduto getInstance() {
        if (instancia == null) {
            instancia = new ModeloTabelaProduto();
        }
        return instancia;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
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
        Produto produto = produtos.get(row);
        switch (col) {
            case COLUNA_CODIGO:
                return produto.getCodigo();
            case COLUNA_DESCRICAO:
                return produto.getDescricao();
            case COLUNA_UNIDADE:
                return produto.getUnidade();
            case COLUNA_PRECO:
                return produto.getPreco();
            case COLUNA_QTDESTOQUE:
                return produto.getQtdEstoque();
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Produto produto = produtos.get(row);
        switch (column) {
            case COLUNA_CODIGO:
                produto.setCodigo(Integer.parseInt(aValue.toString()));
                break;
            case COLUNA_DESCRICAO:
                produto.setDescricao(aValue.toString());
                break;
            case COLUNA_UNIDADE:
                produto.setUnidade(aValue.toString());
                break;
            case COLUNA_PRECO:
                produto.setPreco(Double.parseDouble(aValue.toString()));
                break;
            case COLUNA_QTDESTOQUE:
                produto.setQtdEstoque(Integer.parseInt(aValue.toString()));
                break;
        }
    }

    public Produto obterProduto(int indice) {
        return produtos.get(indice);
    }

    public void incluirProduto(Produto produto) {
        produtos.add(produto);
        fireTableDataChanged();
    }

    public void atualizarProduto(int indice, Produto produto) {
        produtos.set(indice, produto);
        fireTableRowsUpdated(indice, indice);
    }

    public void excluirProduto(int indice) {
        produtos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
}
