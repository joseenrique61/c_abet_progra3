import javax.swing.*;
import java.util.ArrayList;

public class Lista {
    private ArrayList<Empleado> listaempleados;

    public Lista() {
        listaempleados=new ArrayList<>();
    }
    public void agregarempleados(Empleado aux){
        listaempleados.add(aux);
    }


    public void mostrarEmpleados() {
        if (listaempleados.isEmpty()) {
            System.out.println("La lista de empleados está vacía.");
        } else {
            System.out.println("Lista de empleados:");
            for (Empleado empleado : listaempleados) {
                System.out.println("Cédula: " + empleado.getCedula());
                System.out.println("Nombre: " + empleado.getNombre());

            }
        }
    }
    public void actualizarempleados(){
            if (listaempleados.isEmpty()){
                JOptionPane.showMessageDialog(null,"No hay elementos en la lista");

            }
           else {
                    int i= listaempleados.size()-2;
                    Empleado temporal=listaempleados.get(listaempleados.size()-1);
                    while (i>=0 && listaempleados.get(i).getCedula()>temporal.getCedula())
                    {
                        listaempleados.set(i + 1, listaempleados.get(i));
                        i--;
                    }
                listaempleados.set(i + 1, temporal);
           }
    }



}
