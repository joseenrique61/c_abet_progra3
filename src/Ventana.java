import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Objects;

public class Ventana {
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
    private JTable tbEmpleados;
    Lista empleados = new Lista();
    DefaultTableModel dtm;

    public void configurarTabla() {
        dtm = new DefaultTableModel();
        dtm.addColumn("CÉDULA");
        dtm.addColumn("NOMBRE");
        dtm.addColumn("SUELDO");
        dtm.addColumn("IMPUESTO A LA RENTA");
        dtm.addColumn("SEGURO SOCIAL");
        dtm.addRow(new Object[] {"Cédula", "Nombre", "Sueldo", "Impuesto a la renta", "Seguro social"});
        tbEmpleados.setModel(dtm);
    }

    public Ventana() {
        configurarTabla();

        btnIngresar.addActionListener(e -> {
            if (Objects.equals(txtCedula.getText(), "") || Objects.equals(txtNombre.getText(), "") || Objects.equals(txtSueldo.getText(), "")) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
                return;
            }

            try {
                long cedula = Long.parseLong(txtCedula.getText());

                if (empleados.busquedaPorCedula(cedula) != null) {
                    JOptionPane.showMessageDialog(null, "El número de cédula ya existe.");
                    return;
                }

                String nombre = txtNombre.getText();
                float sueldo = Float.parseFloat(txtSueldo.getText());
                Empleado empleado = new Empleado(cedula,nombre,sueldo);
                empleados.agregarEmpleado(empleado);
                JOptionPane.showMessageDialog(null, "EMPLEADO REGISTRADO");

                actualizarTabla();

                txtCedula.setText("");
                txtSueldo.setText("");
                txtNombre.setText("");
            }
            catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "La cédula o el sueldo son inválidos.");
            }
        });

        btnBuscar.addActionListener(e -> {
            if (Objects.equals(txtBusqueda.getText(), "")) {
                JOptionPane.showMessageDialog(null, "La cédula ingresada no es válida.");
            }

            try {
                long cedula = Long.parseLong(txtBusqueda.getText());
                txtMonstrarEmpleado.setText(empleados.busquedaPorCedula(cedula).toString());
            } catch (Exception ex) {
                String lista = "";
                ArrayList<Empleado> empleados1 = empleados.buscarNombre(txtBusqueda.getText());
                if (empleados1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay nombres que coincidan con la búsqueda.");
                    return;
                }

                for (Empleado empleado : empleados1) {
                    lista += empleado.toString() + "\n";
                }
                txtMonstrarEmpleado.setText(lista);
            }
        });

        btnActualizar.addActionListener(e -> {
            if (Objects.equals(txtBusqueda.getText(), "")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una cédula o un nombre de empleado.");
                return;
            }

            if (Objects.equals(txtModificarNombre.getText(), "") && Objects.equals(txtModificarSueldo.getText(), "")) {
                JOptionPane.showMessageDialog(null, "Debe actualizarse por lo menos un atributo del empleado.");
                return;
            }

            try {
                long cedula = Long.parseLong(txtBusqueda.getText());
                String nuevoNombre = txtModificarNombre.getText();
                float sueldo = Objects.equals(txtModificarSueldo.getText(), "") ? -1 : Float.parseFloat(txtModificarSueldo.getText());
                empleados.actualizarEmpleado(cedula,nuevoNombre,sueldo);
                JOptionPane.showMessageDialog(null, "Empleado actualizado.");
                btnBuscar.doClick();
                actualizarTabla();
            }
            catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "La cédula o el sueldo no son válidos.");
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "No existe el número de cédula.");
            }
        });
    }

    public void actualizarTabla() {
        configurarTabla();

        for (Empleado empleado : empleados.ordenarPorSueldo()) {
            dtm.addRow(new Object[] {empleado.getCedula(), empleado.getNombre(), empleado.getSueldo(), empleado.getImpuestoALaRenta(), empleado.getAporteAlSeguroSocial()});
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
