import java.util.ArrayList;
import java.util.Objects;

public class Lista {
    private final ArrayList<Empleado> listaempleados;

    public Lista() {
        listaempleados=new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado){
        listaempleados.add(empleado);
        ordenarUltimoElemento();
    }

    public void actualizarEmpleado(long cedula, String nombre, float sueldo) {
        Empleado empleado = busquedaPorCedula(cedula);
        if (empleado == null) {
            return;
        }

        if (!Objects.equals(nombre, "")) {
            empleado.setNombre(nombre);
        }

        if (sueldo != -1) {
            empleado.setSueldo(sueldo);
        }
    }

    public Empleado busquedaPorCedula(long cedula) {
        if (listaempleados.isEmpty()) {
            return null;
        }
        if (cedula < listaempleados.getFirst().getCedula() || cedula > listaempleados.getLast().getCedula()) {
            return null;
        }

        int superior, inferior, centro;
        inferior = 0;
        superior = listaempleados.size() - 1;
        while (inferior <= superior) {
            centro = (inferior + superior) / 2;
            Empleado empleado = listaempleados.get(centro);
            if (empleado.getCedula() == cedula) {
                return empleado;
            }
            else if (empleado.getCedula() > cedula) {
                superior = centro - 1;
            }
            else {
                inferior = centro + 1;
            }
        }
        return null;
    }

    public ArrayList<Empleado> buscarNombre(String nombre){
        ArrayList<Empleado> busqueda = new ArrayList<>();
        for(Empleado p : listaempleados){
            if(p.getNombre().contains(nombre)){
                busqueda.add(p);
            }
        }return busqueda;
    }

    public ArrayList<Empleado> ordenarPorSueldo() {
        ArrayList<Empleado> array = new ArrayList<>();
        for (Object empleado : listaempleados.toArray()) {
            array.add((Empleado) empleado);
        }

        for (int j = 0; j < array.size(); j++) {
            Empleado temporal = array.get(j);

            int i = j - 1;
            while (i>=0 && array.get(i).getSueldo()>temporal.getSueldo())
            {
                array.set(i + 1, array.get(i));
                i--;
            }
            array.set(i + 1, temporal);
        }
        return array;
    }

    public void ordenarUltimoElemento(){
        int i= listaempleados.size()-2;
        Empleado temporal=listaempleados.getLast();
        while (i>=0 && listaempleados.get(i).getCedula()>temporal.getCedula())
        {
            listaempleados.set(i + 1, listaempleados.get(i));
            i--;
        }
        listaempleados.set(i + 1, temporal);
    }
}
