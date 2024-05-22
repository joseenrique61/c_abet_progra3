import javax.swing.*;

public class Empleado {
    private long cedula;
    private String nombre;
    private float sueldo;
    private float aportealsegurosocial;
    private float impuestoalarenta;

    public Empleado(long cedula, String nombre, float sueldo, float aportealsegurosocial, float impuestoalarenta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.aportealsegurosocial = aportealsegurosocial;
        this.impuestoalarenta = impuestoalarenta;
    }

    public static float calculoaportealsegurosocial(float s){
        return ((9.35f*s)/100f);
    }
    public static float calculoimpuestoalarenta(float su){
        float sueldoanual=su*12;

        if (sueldoanual<=5000){
            return 0;
        }
        if (sueldoanual> 5000 && sueldoanual<=10000){
            return ((10f*5000)/100f);
        }
        if (sueldoanual> 10000 && sueldoanual<=18000){
            return ((20f*10000)/100f);
        }
        if((sueldoanual> 18000)){
            return ((30f*18000)/100f);
        }
        return 0;
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

    public float getAportealsegurosocial() {
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
    }

    @Override
    public String toString() {
        return "Empleado:\n" + "Cedula:" + cedula + "\nNombre:" + nombre  + "\nSueldo:" + sueldo + "\nAporte al segurosocial:" + aportealsegurosocial + "\nImpuesto a la renta:" + impuestoalarenta ;
    }
}
