import java.util.ArrayList;

public class Lista {
    private ArrayList<Empleado> listaempleados;

    public Lista() {
        listaempleados=new ArrayList<>();
    }
    public void agregarempleados(Empleado nuevo){
        listaempleados.add(nuevo);
    }

    public Empleado busquedaPorCedula (String cedula) throws Exception{
        if (listaempleados.isEmpty()){
            throw new Exception("No hay empleados");
        }
        if (cedula.compareTo(listaempleados.get(0).getCedula()) < 0 ||
                cedula.compareTo(listaempleados.get(listaempleados.size() - 1).getCedula()) > 0) {
            throw new Exception("Esa cedula no existe");
        }

        int superior, inferior, centro, comp;
        inferior = 0;
        superior = listaempleados.size()-1;
        while (inferior<=superior){
            centro=(inferior+superior)/2;
            Empleado em = listaempleados.get(centro);
            comp = em.getCedula().compareTo(cedula);
            if (comp==0)
                return em;
            else if(comp > 0)
                superior =centro-1;
            else
                inferior = centro+1;
        }
        {
            throw new Exception("No existe esa cedula");
        }
    }
    public boolean actualizarEmpleado(String cedula, String nNombre, float nSueldo, float naportealsegurosocial, float nimpuestoalarenta) {
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
}

