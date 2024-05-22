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


    public Empleado busquedaPorCedula(long cedula) throws Exception {
        if (listaempleados.isEmpty()) {
            throw new Exception("No hay empleados");
        }
        if (cedula < listaempleados.get(0).getCedula() ||
                cedula > listaempleados.get(listaempleados.size() - 1).getCedula()) {
            throw new Exception("Esa cedula no existe");
        }

        int superior, inferior, centro;
        inferior = 0;
        superior = listaempleados.size() - 1;
        while (inferior <= superior) {
            centro = (inferior + superior) / 2;
            Empleado em = listaempleados.get(centro);
            if (em.getCedula() == cedula)
                return em;
            else if (em.getCedula() > cedula)
                superior = centro - 1;
            else
                inferior = centro + 1;
        }
        throw new Exception("No existe esa cedula");
    }

    public boolean actualizarEmpleado(long cedula, String nNombre, float nSueldo, float naportealsegurosocial, float nimpuestoalarenta) {
        try {
            Empleado empleado = busquedaPorCedula(cedula);
            if (empleado != null) {
                empleado.setNombre(nNombre);
                empleado.setSueldo(nSueldo);
                empleado.setAportealsegurosocial(naportealsegurosocial);
                empleado.setImpuestoalarenta(nimpuestoalarenta);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    /*Busqueda por nombre*/
    public ArrayList<Empleado> buscarNombre(String nombre){
        ArrayList<Empleado> busqueda = new ArrayList();
        for(Empleado p:listaempleados){
            if(p.getNombre().contains(nombre)){
                busqueda.add(p);

            }
        }return busqueda;
    }
    /*Imprimir lista*/
    public String listaelementos(){
        Empleado e;
        String lista="";
        for (int i=listaempleados.size()-1;i>=0;i--){
            e=(Empleado) listaempleados.toArray()[i];
            lista+=e.toString();
        }
        return lista;
    }
    /* Ordenar sueldos*/
    public void actualizarSueldo(){
        if (listaempleados.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay elementos en la lista");

        }
        else {
            int i= listaempleados.size()-2;
            Empleado temporal=listaempleados.get(listaempleados.size()-1);
            while (i>=0 && listaempleados.get(i).getSueldo()>temporal.getCedula())
            {
                listaempleados.set(i + 1, listaempleados.get(i));
                i--;
            }
            listaempleados.set(i + 1, temporal);
        }
    }

}
