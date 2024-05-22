public class Empleado implements Comparable<Empleado>
{
    private String cedula;
    private String nombre;
    private float sueldo;
    private float aportealsegurosocial;
    private float impuestoalarenta;

    public Empleado(String cedula, String nombre, float sueldo, float aportealsegurosocial, float impuestoalarenta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.aportealsegurosocial = aportealsegurosocial;
        this.impuestoalarenta = impuestoalarenta;
    }

    public String getCedula() {
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
        return "Empleado:\n" + "Cedula:" + cedula + "\nNombre:" + nombre  + "\nSueldo:" + sueldo + "\nAporte al segurosocial:" + aportealsegurosocial + "\nImpuesto a la renta :" + impuestoalarenta ;
    }

    @Override
    public int compareTo(Empleado nuevo) {
        return this.cedula.compareTo(nuevo.getCedula());
    }
}
