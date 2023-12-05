public class Item {
    private String nombreComprador;
    private String tipo;
    private double price;
    private double porcentajeDesgaste;

    public Item(String nombreComprador, String tipo, double price, double porcentajeDesgaste) {
        this.nombreComprador = nombreComprador;
        this.tipo = tipo;
        this.price = price;
        this.porcentajeDesgaste = porcentajeDesgaste;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrice() {
        return price;
    }

    public double getPorcentajeDesgaste() {
        return porcentajeDesgaste;
    }

    public void setNombre(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPorcentajeDesgaste(double porcentajeDesgaste) {
        this.porcentajeDesgaste = porcentajeDesgaste;
    }
}
