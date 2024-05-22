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
        if (cedula<(Empleado)listaempleados.toArray()[0]).getCedul
                || (cedula > (Empleado)listaempleados.toArray()[listaempleados.size()-1]).getCedula))){
            throw new Exception("NO EXISTE NUMERO DE TRACK");
        }
        int superior, inferior, centro;
        inferior = 0;
        superior = listaempleados.size()-1;
        while (inferior<=superior){
            centro=(inferior+superior)/2;
            Empleado em = (Empleado) listaempleados.toArray()[centro];
            if (em.getCedula()==cedula)
                return em;
            else if(cedula<em.getCedula())
                superior =centro-1;
            else
                inferior = centro+1;
        }
        {
            throw new Exception("No existe esa cedula");
        }
    }
    public boolean actualizarEmpleado(String cedula, String nNombre, float nSuledo, float naportealsegurosocial, float nimpuestoalarenta)


}
