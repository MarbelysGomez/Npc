import java.util.List;

public abstract class Vendedor {
    private String nombreVendedor;
    private List<Item> inventario;
    private String ciudad;
    private double impuesto;
    private double porcentajeDesgaste;
    private int max_items;

    public Vendedor(String nombreVendedor, List<Item> itemList, String ciudad, double impuesto, double porcentajeDesgaste, int max_items) {
        this.nombreVendedor = nombreVendedor;
        this.inventario = itemList;
        this.ciudad = ciudad;
        this.impuesto = impuesto;
        this.porcentajeDesgaste = porcentajeDesgaste;
        this.max_items = max_items;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public List<Item> getInventario() {
        return this.inventario;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public double getImpuesto() {
        return this.impuesto;
    }

    public double getPorcentajeDesgaste() {
        return this.porcentajeDesgaste;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public void setPorcentajeDesgaste(double porcentajeDesgaste) {
        this.porcentajeDesgaste = porcentajeDesgaste;
    }
    public abstract void añadirItem (Item item);
    public abstract void venderItem(Comprador comprador, Item item);

}
