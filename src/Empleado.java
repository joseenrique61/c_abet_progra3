import javax.swing.*;

public class Empleado {
    private long cedula;
    private String nombre;
    private float sueldo;
    /*private float aportealsegurosocial;
    private float impuestoalarenta;*/

    public Empleado(long cedula, String nombre, float sueldo/*, float aportealsegurosocial, float impuestoalarenta*/) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
        /*this.aportealsegurosocial = aportealsegurosocial;
        this.impuestoalarenta = impuestoalarenta;*/
    }


    public long getCedula() {
        return cedula;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    /*public float getAportealsegurosocial() {
        return aportealsegurosocial;
    }

    public void setAportealsegurosocial(float aportealsegurosocial) {
        this.aportealsegurosocial = aportealsegurosocial;
    }

    public float getImpuestoalarenta() {
        return impuestoalarenta;
    }

    public void setImpuestoalarenta(float impuestoalarenta) {
        this.impuestoalarenta = impuestoalarenta;
    }*/

    @Override
    public String toString() {
        return "EMPLEADO:\t\n" + "Cedula:" + cedula + "\nNombre:" + nombre  + "\nSueldo:" + sueldo + "\nAporte al segurosocial:\n" /*+ aportealsegurosocial + "\nImpuesto a la renta:" + impuestoalarenta */;
    }
}
