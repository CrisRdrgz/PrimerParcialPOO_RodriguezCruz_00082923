package Dispositivos;

public class Laptop extends DispositivosElectronicos implements ObtenerPrecioYDescripcion{
    private String procesador;
    private int ram;

    public Laptop(String nombre, String modelo, String descripcion, float precio, String procesador, int ram) {
        super(nombre, modelo, descripcion, precio);
        this.procesador = procesador;
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public float obtenerPrecio(float precio) {
        System.out.println("precio de laptop");

        return precio;
    }

    @Override
    public String obtenerDescripcion(String descripcion) {
        System.out.println("Dispositivo laptop");
        return descripcion;
    }
}
