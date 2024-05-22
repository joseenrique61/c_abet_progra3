import javax.swing.*;

public class Ventana {
    private JPanel Ventana;
    private JTabbedPane tabbedPane1;
    private JTextArea txtArlista;
    Lista listaempleados = new Lista();

    public Ventana() {
        /*Impresion de datos completos*/
        txtArlista.setText(listaempleados.listaelementos());


    }
}
