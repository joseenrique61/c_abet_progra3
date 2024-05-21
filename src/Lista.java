import java.util.ArrayList;

public class Lista {
    private ArrayList<Empleado> listaempleados;

    public Lista() {
        listaempleados=new ArrayList<>();
    }
    public void agregarempleados(Empleado aux){
        listaempleados.add(aux);
    }


}
