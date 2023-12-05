import java.util.*;
import java.util.stream.Collectors;

public class Main_Aplicacion {
    private static Scanner sc = new Scanner(System.in);
    private static List<Vendedor> vendedorList;
    private static List<Comprador> compradorList;

    public static void main(String[] args) {
        vendedorList = new ArrayList<>();
        compradorList = new ArrayList<>();

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
                    mostrarItemBarato();
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
    public static void crearVendedor(){
        System.out.println("Ingrese el nombre del vendedor:");
        String nombreVendedor = sc.nextLine();

        System.out.println("Ingrese la ciudad del vendedor:");
        String ciudadVendedor = sc.nextLine();

        System.out.println("Ingrese el tipo de vendedor (Campesino, Ladron, Mercader):");
        String tipoVendedor = sc.nextLine();

        Vendedor nuevoVendedor = null;
        switch (tipoVendedor.toLowerCase()) {
            case "campesino":
                nuevoVendedor = new Campesino(nombreVendedor, new ArrayList<>(), ciudadVendedor);
                break;
            case "ladron":
                nuevoVendedor = new Ladron(nombreVendedor, new ArrayList<>(), ciudadVendedor);
                break;
            case "mercader":
                nuevoVendedor = new Mercader(nombreVendedor, new ArrayList<>(), ciudadVendedor);
                break;
            default:
                System.out.println("Tipo de vendedor no válido.");
                return;
        }

        vendedorList.add(nuevoVendedor);
        System.out.println("Vendedor creado con éxito.");
    }
    public static void añadirItemVendedor() {
        String nombreVendedor;
        String nombreItem;
        String tipoItem;
        double precioItem;
        double desgasteItem;

        System.out.println("Ingrese el nombre del vendedor:");
        nombreVendedor = sc.nextLine();

        Vendedor vendedor = vendedorList.stream()
                .filter(v -> v.getNombreVendedor().equals(nombreVendedor))
                .findFirst()
                .orElse(null);

        if (vendedor == null) {
            System.out.println("Vendedor no encontrado.");
            return;
        }
        System.out.println("Ingrese el nombre del item: ");
        nombreItem = sc.nextLine();

        System.out.println("Ingrese el tipo del item: ");
        tipoItem = sc.nextLine();

        System.out.println("Ingrese el precio del item: ");
        precioItem = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingrese el porcentaje de desgaste del item: ");
        desgasteItem = sc.nextDouble();
        sc.nextLine();

        Item nuevoItem = new Item(nombreItem, tipoItem, precioItem, desgasteItem);
        try {
            vendedor.añadirItem(nuevoItem);
            System.out.println("Item añadido.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void mostrarItemBarato(){
        String nombreCiudad;

        System.out.println("Ingrese el nombre de la ciudad:");
        nombreCiudad = sc.nextLine();

        List<Item> itemsCiudad = vendedorList.stream()
                .filter(v -> v.getCiudad().equals(nombreCiudad))
                .flatMap(v -> v.getInventario().stream())
                .collect(Collectors.toList());

        Item itemMasBarato = itemsCiudad.stream()
                .min(Comparator.comparing(Item::getPrice))
                .orElse(null);

        if (itemMasBarato == null) {
            System.out.println("No se encontraron items en la ciudad indicada.");
        } else {
            System.out.println("El item más barato en " + nombreCiudad + ", es: " + itemMasBarato.getNombreComprador() +
                    ", con un precio de: " + itemMasBarato.getPrice() + ".");
        }
    }
    public static void consultarItemVendedor() {
        String nombreVendedor;
        System.out.println("Ingrese el nombre del vendedor: ");
        nombreVendedor = sc.nextLine();

        Vendedor vendedor = vendedorList.stream()
                .filter(v -> v.getNombreVendedor().equals(nombreVendedor))
                .findFirst()
                .orElse(null);

        if (vendedor == null) {
            System.out.println("Vendedor no encontrado.");
            return;
        }
        vendedor.getInventario().forEach(item -> System.out.println(item.getNombreComprador()));
    }
    public static void crearComprador(){
        String nombreComprador;
        String ciudadComprador;

        System.out.println("Ingrese el nombre del comprador: ");
        nombreComprador = sc.nextLine();

        System.out.println("Ingrese la ciudad del comprador: ");
        ciudadComprador = sc.nextLine();

        Comprador nuevoComprador = new Comprador(nombreComprador, new ArrayList<>(), ciudadComprador);
        compradorList.add(nuevoComprador);
        System.out.println("Comprador creado.");
    }
    public static void realizarCompraItem(){
        String nombreComprador;
        String nombreVendedor;
        String nombreItem;

        System.out.println("Ingrese el nombre del comprador: ");
        nombreComprador = sc.nextLine();

        Comprador comprador = compradorList.stream()
                .filter(c -> c.getNombreComprador().equals(nombreComprador))
                .findFirst()
                .orElse(null);

        if (comprador == null) {
            System.out.println("Comprador no encontrado.");
            return;
        }

        System.out.println("Ingrese el nombre del vendedor: ");
        nombreVendedor = sc.nextLine();

        Vendedor vendedor = vendedorList.stream()
                .filter(v -> v.getNombreVendedor().equals(nombreVendedor))
                .findFirst()
                .orElse(null);

        if (vendedor == null) {
            System.out.println("Vendedor no encontrado.");
            return;
        }
        System.out.println("Ingrese el nombre del item: ");
        nombreItem = sc.nextLine();

        Item item = vendedor.getInventario().stream()
                .filter(i -> i.getNombreComprador().equals(nombreItem))
                .findFirst()
                .orElse(null);

        if (item == null) {
            System.out.println("Item no encontrado.");
            return;
        }
        try {
            vendedor.venderItem(comprador, item);
            System.out.println("Compra realizada.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void consultarItemComprador() {
        String nombreComprador;

        System.out.println("Ingrese el nombre del comprador: ");
        nombreComprador = sc.nextLine();

        Comprador comprador = compradorList.stream()
                .filter(c -> c.getNombreComprador().equals(nombreComprador))
                .findFirst()
                .orElse(null);

        if (comprador == null) {
            System.out.println("Comprador no encontrado.");
            return;
        }
        comprador.getItemListComprados().forEach(item -> System.out.println(item.getNombreComprador()));
    }
    public static void consultarVendedoresEnCiudad() {
        String nombreCiudad;

        System.out.println("Ingrese el nombre de la ciudad: ");
        nombreCiudad = sc.nextLine();

        vendedorList.stream()
                .filter(v -> v.getCiudad().equals(nombreCiudad))
                .forEach(vendedor -> System.out.println(vendedor.getNombreVendedor()));
    }
    public static void consultarCompradoresEnCiudad() {
        String nombreCiudad;

        System.out.println("Ingrese el nombre de la ciudad: ");
        nombreCiudad = sc.nextLine();

        compradorList.stream()
                .filter(c -> c.getCiudad().equals(nombreCiudad))
                .forEach(comprador -> System.out.println(comprador.getNombreComprador()));
    }
    public static void mostrarItemTipoPrecioAsc() {
        String tipoItem;

        System.out.println("Ingrese el tipo de item: ");
        tipoItem = sc.nextLine();

        vendedorList.stream()
                .flatMap(vendedor -> vendedor.getInventario().stream())
                .filter(item -> item.getTipo().equals(tipoItem))
                .sorted(Comparator.comparing(Item::getPrice))
                .forEach(item -> System.out.println(item.getNombreComprador() + " : " + item.getPrice()));
    }
}

