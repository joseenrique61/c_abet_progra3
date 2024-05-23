import java.util.ArrayList;
import java.util.Objects;

public class Lista {
    private final ArrayList<Empleado> listaEmpleados;

    public Lista() {
        listaEmpleados =new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
        ordenarUltimoElemento();
    }

    public boolean actualizarEmpleado(long cedula, String nombre, float sueldo) {
        Empleado empleado = busquedaPorCedula(cedula);
        if (empleado == null) {
            return false;
        }

        if (!Objects.equals(nombre, "")) {
            empleado.setNombre(nombre);
        }

        if (sueldo != -1) {
            empleado.setSueldo(sueldo);
        }
        return true;
    }

    public Empleado busquedaPorCedula(long cedula) {
        if (listaEmpleados.isEmpty()) {
            return null;
        }
        if (cedula < listaEmpleados.getFirst().getCedula() || cedula > listaEmpleados.getLast().getCedula()) {
            return null;
        }

        int superior, inferior, centro;
        inferior = 0;
        superior = listaEmpleados.size() - 1;
        while (inferior <= superior) {
            centro = (inferior + superior) / 2;
            Empleado empleado = listaEmpleados.get(centro);
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
        for(Empleado p : listaEmpleados){
            if(p.getNombre().contains(nombre)){
                busqueda.add(p);
            }
        }return busqueda;
    }

    public ArrayList<Empleado> ordenarPorSueldo() {
        ArrayList<Empleado> array = new ArrayList<>();
        for (Object empleado : listaEmpleados.toArray()) {
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
        int i= listaEmpleados.size()-2;
        Empleado temporal= listaEmpleados.getLast();
        while (i>=0 && listaEmpleados.get(i).getCedula()>temporal.getCedula())
        {
            listaEmpleados.set(i + 1, listaEmpleados.get(i));
            i--;
        }
        listaEmpleados.set(i + 1, temporal);
    }
}
