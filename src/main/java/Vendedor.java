import java.util.List;

public class Vendedor {
    private String nombreVendedor;
    private List<Item> inventario;
    private String ciudad;
    private double impuesto;
    private double porcentajeDesgaste;


    public Vendedor(String nombreVendedor, List<Item> itemList, String ciudad, double impuesto, double porcentajeDesgaste) {
        this.nombreVendedor = nombreVendedor;
        this.inventario = inventario;
        this.ciudad = ciudad;
        this.impuesto = impuesto;
        this.porcentajeDesgaste = porcentajeDesgaste;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getPorcentajeDesgaste() {
        return porcentajeDesgaste;
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
    public void añadirItem (Item item) {
        this.inventario.add(item);
        item.setPrice(item.getPrice() * (1 - porcentajeDesgaste));
    }
    public void venderItem(Comprador comprador, Item item) {
        if(this.inventario.contains(item)) {
            double precioImpuestos;
            precioImpuestos = item.getPrice() * (1 + this.impuesto);
            comprador.añadirItem(item, precioImpuestos);
            this.inventario.remove(item);
        }
    }

}
