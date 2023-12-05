import java.util.List;

public class Mercader extends Vendedor {
    private static final int MAX_ITEMS = 7;
    private static final double IMPUESTO = 0.04;
    private static final double PORCENTAJE_DESGASTE = 0.0;

    public Mercader(String nombreVendedor, List<Item> itemList, String ciudad) {
        super(nombreVendedor, itemList, ciudad, IMPUESTO, PORCENTAJE_DESGASTE, MAX_ITEMS);
    }
    @Override
    public void añadirItem(Item item) {
        if (this.getInventario().size() < MAX_ITEMS){
            this.getInventario().add(item);
            item.setPrice(item.getPrice() * (1 - PORCENTAJE_DESGASTE));
        } else {
            throw new IllegalArgumentException("Inventario lleno! El vendedor no puede comprar el artículo.");
        }
    }
    @Override
    public void venderItem(Comprador comprador, Item item) {
        if (this.getInventario().contains(item)) {
            double precioImpuestos;
            precioImpuestos= item.getPrice() * (1 + IMPUESTO);
            comprador.añadirItem(item, precioImpuestos);
            this.getInventario().remove(item);
        }
    }
}
