
import java.util.List;
public class Ciudad {
    private String nombre;
    private List<Vendedor> vendedoresList;
    private List<Comprador> compradorList;

    public Ciudad(String nombre, List<Vendedor> vendedoresList, List<Comprador> compradorList) {
        this.nombre = nombre;
        this.vendedoresList = vendedoresList;
        this.compradorList = compradorList;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vendedor> getVendedoresList() {
        return vendedoresList;
    }

    public List<Comprador> getCompradorList() {
        return compradorList;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVendedoresList(List<Vendedor> vendedoresList) {
        this.vendedoresList = vendedoresList;
    }

    public void setCompradorList(List<Comprador> compradorList) {
        this.compradorList = compradorList;
    }
}
