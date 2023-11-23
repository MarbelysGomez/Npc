import java.util.List;

public class Campesino extends Vendedor {

    public Campesino(String nombreComprador, List<Item> inventario, String ciudad, double impuesto, double porcentajeDesgaste) {
        super(nombreComprador, inventario, ciudad, 0.02, 0.15);
    }

    @Override
    public String getNombreComprador() {
        return super.getNombreComprador();
    }

    @Override
    public List<Item> getInventario() {
        return super.getInventario();
    }

    @Override
    public String getCiudad() {
        return super.getCiudad();
    }

    @Override
    public double getImpuesto() {
        return super.getImpuesto();
    }

    @Override
    public double getPorcentajeDesgaste() {
        return super.getPorcentajeDesgaste();
    }

    @Override
    public void setNombreComprador(String nombreComprador) {
        super.setNombreComprador(nombreComprador);
    }

    @Override
    public void setInventario(List<Item> inventario) {
        super.setInventario(inventario);
    }

    @Override
    public void setCiudad(String ciudad) {
        super.setCiudad(ciudad);
    }

    @Override
    public void setImpuesto(double impuesto) {
        super.setImpuesto(impuesto);
    }

    @Override
    public void setPorcentajeDesgaste(double porcentajeDesgaste) {
        super.setPorcentajeDesgaste(porcentajeDesgaste);
    }
}
