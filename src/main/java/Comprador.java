import java.util.List;
public class Comprador {
    private String nombreComprador;
    private List<Item> itemListComprados;
    private String ciudad;

    public Comprador(String nombreComprador, List<Item> itemListComprados, String ciudad) {
        this.nombreComprador = nombreComprador;
        this.itemListComprados = itemListComprados;
        this.ciudad = ciudad;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public List<Item> getItemListComprados() {
        return itemListComprados;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public void setItemListComprados(List<Item> itemListComprados) {
        this.itemListComprados = itemListComprados;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void añadirItem(Item item, double precio) {
        this.itemListComprados.add(item);
        item.setPrice(precio);
    }
}
