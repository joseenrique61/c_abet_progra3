public class Empleado {
    private final long cedula;
    private String nombre;
    private float sueldo;
    private float aporteAlSeguroSocial;
    private float impuestoALaRenta;

    public Empleado(long cedula, String nombre, float sueldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        setSueldo(sueldo);
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
        setImpuestoALaRenta(sueldo);
        setAporteAlSeguroSocial(sueldo);
    }

    public float getAporteAlSeguroSocial() {
        return aporteAlSeguroSocial;
    }

    public float getImpuestoALaRenta() {
        return impuestoALaRenta;
    }

    private void setAporteAlSeguroSocial(float sueldo){
        aporteAlSeguroSocial = ((9.35f*sueldo)/100f);
    }

    private void setImpuestoALaRenta(float sueldo){
        float sueldoanual=sueldo*12;

        if (sueldoanual<=5000){
            impuestoALaRenta = 0;
        }
        if (sueldoanual> 5000 && sueldoanual<=10000){
            impuestoALaRenta = ((10f*5000)/100f);
        }
        if (sueldoanual> 10000 && sueldoanual<=18000){
            impuestoALaRenta = ((20f*10000)/100f);
        }
        if((sueldoanual> 18000)){
            impuestoALaRenta = ((30f*18000)/100f);
        }
    }

    @Override
    public String toString() {
        return "EMPLEADO:\t\n" + "Cedula: " + cedula + "\nNombre: " + nombre  + "\nSueldo: " + sueldo + "\nAporte al seguro social: " + aporteAlSeguroSocial + "\nImpuesto a la renta: " + impuestoALaRenta;
    }
}
