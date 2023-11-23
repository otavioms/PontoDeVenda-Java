package sistemapdv.main;

import sistemapdv.janelas.JanelaPrincipal;

public class Main {

    public static void main(String[] args) {
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setTitle("PDV");
        try {
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
     }
    }
