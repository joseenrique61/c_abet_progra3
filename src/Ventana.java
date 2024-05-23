import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtSueldo;
    private JTextField txtBusqueda;
    private JTextArea txtMonstrarEmpleado;
    private JTextField txtModificarNombre;
    private JTextField txtModificarSueldo;
    private JButton btnActualizar;
    private JButton btnBuscar;
    private JButton btnIngresar;
    private JTextField txtBusquedaNombre;
    private JButton btnOrdenar;
    private JTable tbEmpleados;
    Lista empleados = new Lista();
    DefaultTableModel dtm = new DefaultTableModel();
    public void configurarTabla() {
        dtm.addColumn("CÈDULA");
        dtm.addColumn("NOMBRE");
        dtm.addColumn("SUELDO");
        dtm.addColumn("IMPUESTO A LA RENTA");
        dtm.addColumn("SEGURO SOCIAL");
        tbEmpleados.setModel(dtm);
    }
    public Ventana() {
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long cedula = Long.parseLong(txtCedula.getText().toString());
                String nombre = txtNombre.getText().toString();
                float sueldo = Float.parseFloat(txtSueldo.getText().toString());
                Empleado emple = new Empleado(cedula,nombre,sueldo);
                float seguro= empleados.calculoaportealsegurosocial(sueldo);
                float renta = empleados.calculoimpuestoalarenta(sueldo);
                empleados.agregarempleados(emple);
                JOptionPane.showMessageDialog(null, "EMPLEADO REGISTRADO");
                Object[] fila = {cedula,nombre,sueldo, renta, seguro};
                dtm.addRow(fila);
            }
        });
        configurarTabla();
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comprobacion= txtBusqueda.getText();
                if(empleados.isLong(comprobacion)){
                    try {
                        long cedula = Long.parseLong(comprobacion);
                        txtMonstrarEmpleado.setText(empleados.busquedaPorCedula(cedula).toString());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    txtMonstrarEmpleado.setText(empleados.buscarNombre(comprobacion).toString());
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long cedula = Long.parseLong(txtBusqueda.getText().toString());
                String nuevoNombre = txtModificarNombre.getText();
                float sueldo = Float.parseFloat(txtModificarSueldo.getText().toString());
                empleados.actualizarEmpleado(cedula,nuevoNombre,sueldo);
            }
        });
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
