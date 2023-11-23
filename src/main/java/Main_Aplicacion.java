import java.util.List;
import java.util.Scanner;

public class Main_Aplicacion {
    private static Scanner sc = new Scanner(System.in);
    private List<Vendedor> vendedorList;
    private List<Comprador> compradorList;

    public Main_Aplicacion(List<Vendedor> vendedorList, List<Comprador> compradorList) {
        this.vendedorList = vendedorList;
        this.compradorList = compradorList;
    }

    public static void main(String[] args) {
        Main_Aplicacion aplicacion = new Main_Aplicacion();
        int opcion;
        int salir;

        do {
            System.out.println("Ingrese una de las siguientes opciones del menu: \n" +
                    "1. Crear un vendedor.\n" +
                    "2. Añadir un item al inventario de un vendedor.\n" +
                    "3. Mostrar el ítem más barato de todos los vendedores de una ciudad\n" +
                    "4. Consultar los ítems de un vendedor.\n" +
                    "5. Crear un comprador.\n" +
                    "6. Realizar la compra de un ítem.\n" +
                    "7. Consultar los ítems de un Comprador.\n" +
                    "8. Consultar todos los vendedores que hay en una ciudad.\n" +
                    "9. Consultar todos los compradores que hay en una ciudad.\n" +
                    "3. Mostrar todos los ítems de un determinado tipo ordenados por precio (asc).\n"+
                    "11. Salir del menu.\n");
            opcion = sc.nextInt();
            sc.nextLine();

            if(opcion > 0 && opcion < 11) {
                System.out.println("Ha escogido la opcion " + opcion + ".");
            }

                switch (opcion) {

                case 1:
                    crearVendedor();
                    break;
                case 2:
                    añadirItemVendedor();
                    break;
                case 3:
                    mostrarItemDeCiudad();
                    break;
                case 4:
                    consultarItemVendedor();
                    break;
                case 5:
                    crearComprador();
                    break;
                case 6:
                    realizarCompraItem();
                    break;
                case 7:
                    consultarItemComprador();
                    break;
                case 8:
                    consultarVendedoresEnCiudad();
                    break;
                case 9:
                    consultarCompradoresEnCiudad();
                    break;
                case 10:
                    mostrarItemTipoPrecioAsc();
                    break;
                case 11:
                    System.out.println("Saliendo del menu.");
                    break;
                    //salir = sc.nextInt();
                default:
                    System.out.println("La opcion escogida no es valida.");
                    break;
            }
        } while (opcion != 11);

    }

    public static void crearVendedor() {

    }
    public static void añadirItemVendedor() {

    }
    public static void mostrarItemDeCiudad() {

    }
    public static void consultarItemVendedor() {

    }
    public static void crearComprador() {

    }
    public static void realizarCompraItem() {

    }
    public static void consultarItemComprado() {

    }
    public static void consultarItemComprador() {

    }
    public static void consultarVendedoresEnCiudad() {

    }
    public static void consultarCompradoresEnCiudad() {

    }
    public static void mostrarItemTipoPrecioAsc() {

    }

}

