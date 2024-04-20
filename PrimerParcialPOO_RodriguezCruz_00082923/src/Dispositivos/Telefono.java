package Dispositivos;

public class Telefono extends DispositivosElectronicos implements ObtenerPrecioYDescripcion{
    private int megapixeles;
    private int cantidadCamaras;

    public Telefono(String nombre, String modelo, String descripcion, float precio, int megapixeles, int cantidadCamaras) {
        super(nombre, modelo, descripcion, precio);
        this.megapixeles = megapixeles;
        this.cantidadCamaras = cantidadCamaras;
    }

    public int getMegapixeles() {
        return megapixeles;
    }

    public void setMegapixeles(int megapixeles) {
        this.megapixeles = megapixeles;
    }

    public int getCantidadCamaras() {
        return cantidadCamaras;
    }

    public void setCantidadCamaras(int cantidadCamaras) {
        this.cantidadCamaras = cantidadCamaras;
    }

    @Override
    public float obtenerPrecio(float precio) {
        System.out.println("Precio de telefono");
        return precio;
    }

    @Override
    public String obtenerDescripcion(String descripcion) {
        System.out.println("Dispositivo telefono");
        return descripcion;
    }

}
