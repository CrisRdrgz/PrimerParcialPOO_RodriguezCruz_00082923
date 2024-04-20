import Dispositivos.DispositivosElectronicos;
import Dispositivos.Laptop;
import Dispositivos.Telefono;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static ArrayList<DispositivosElectronicos> listaDispositivos = new ArrayList<>();

    public static void main(String[] args) {


        Scanner sn = new Scanner(System.in);
        int opcion;
        while (true) {
            menuInicio();
            opcion = sn.nextInt();
            try{
                if (opcion == 0) {
                    System.out.printf("Saliendo...");
                    break;
                }
                switch (opcion) {
                    case 1: //crear articulo
                        agregarDispositivo();
                        break;
                    case 2: //modificar descripcion articulo
                        modificarDescripcion();
                        break;
                    case 3: //mostrar solo nombres
                        mostrarNombres();
                        break;
                    case 4: // mostrar extendido
                        mostrar();
                        break;

                }
            }catch (Exception e){
                System.out.printf("Ingrese un dato valido");
            }
        }



    }



    private static void agregarDispositivo(){
        Scanner sn = new Scanner(System.in);
        String nombre = null;
        String modelo = null;
        String descripcion = nombre;
        float precio = 0;
        try {


        System.out.println("Introduzca el nombre del dispositivo : ");
        nombre = sn.nextLine();
        System.out.println("Introduzca el modelo del dispositivo : ");
        modelo = sn.nextLine();
        System.out.println("Introduzca la descripcion del dispositivo : ");
        descripcion = sn.nextLine();
        System.out.println("Introduzca el precio del dispositivo : ");
        precio = sn.nextFloat();
        sn.nextLine();
        }catch (Exception e){
            System.out.println("Introduzca datos validos");
        }
        int tipoDispo = conseguirTipoDispositivo();
        switch (tipoDispo){
            case 1: //telefono
                int megapixeles;
                int cantidadCamaras;
                System.out.println("Introduzca la cantidad de megapixeles que tiene el telefono :");
                megapixeles = sn.nextInt();
                System.out.println("Introduzca la cantidad de camaras que tiene el telefono");
                cantidadCamaras = sn.nextInt();
                sn.nextLine();
                DispositivosElectronicos dispoTel = new Telefono(nombre, modelo, descripcion, precio, megapixeles, cantidadCamaras);
                listaDispositivos.add(dispoTel);
                break;
            case 2:  // laptops
                String procesador;
                int ram;
                System.out.println("Introduzca el procesador que tiene la laptop");
                procesador = sn.nextLine();
                System.out.println("Introduzca la cantidad de ram que tiene la laptop");
                ram = sn.nextInt();

                DispositivosElectronicos dispoLap = new Laptop(nombre, modelo, descripcion, precio, procesador, ram);
                listaDispositivos.add(dispoLap);
                break;

        }System.out.println("Dispositivo agregado con exito \n");

    }
    private static int conseguirTipoDispositivo(){
        Scanner sn = new Scanner(System.in);
        int opcion;
        while (true){
            try {
                System.out.println("Seleccione el tipo de dispositivo :\n");
                System.out.println("\t1. Telefono \n");
                System.out.println("\t2. Laptop \n");
                System.out.println("Opcion ->");
                opcion = sn.nextInt();
                if (opcion >= 1 && opcion <= 2){
                    return opcion;
                }
                System.out.println("Ingrese una opcion valida\n");

            }catch (Exception e){
                System.out.println("Ingrese un dato valido");
            }
        }
    }

    private static void modificarDescripcion(){
        Scanner sn = new Scanner(System.in);
        String nombreBuscar;
        String nuevaDescripcion;
        System.out.println("Introduzca el nombre del dispositivo al que cambiaremos la descripcion : ");
        nombreBuscar = sn.nextLine();
        for (int i = 0; i < listaDispositivos.size(); i++){
            if (listaDispositivos.get(i).getNombre().equals(nombreBuscar)){
                System.out.println("Introduzca la nueva descripcion del dispositivo : ");
                nuevaDescripcion = sn.nextLine();
                listaDispositivos.get(i).setDescripcion(nuevaDescripcion);
                System.out.println("Descripcion cambiada con exito\n");
            }
        }
    }

    private static void mostrarNombres(){
        for (int i = 0; i < listaDispositivos.size(); i++) {
            DispositivosElectronicos disp = listaDispositivos.get(i);
            System.out.println("-------------------");
            System.out.println("Nombre : "+disp.getNombre()+"\n");
        }
    }
    private static void mostrar(){
        for (int i = 0; i < listaDispositivos.size(); i++) {
            DispositivosElectronicos disp = listaDispositivos.get(i);
            System.out.println("--------------------------");
            System.out.println("Nombre : "+disp.getNombre());
            System.out.println("Modelo : "+disp.getModelo());
            System.out.println("Descripcion : "+disp.getDescripcion());
            System.out.println("Precio : "+disp.getPrecio()+"\n");
        }
    }

    private static void menuInicio(){
        System.out.printf("Bienvenido a ElectroMart que desea hacer: \n");
        System.out.println("\t 1.Agregar articulo");
        System.out.println("\t 2.Modificar descripcion del articulo");
        System.out.println("\t 3.Mostrar articulos");
        System.out.println("\t 4.Mostrar articulos completo");
        System.out.println("\t 0. Salir");
        System.out.println("Opcion ->");
    }
}
