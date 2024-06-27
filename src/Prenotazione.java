public class Prenotazione {

    private Camera camera;
    private Cliente cliente;

    public Prenotazione(Camera camera, Cliente cliente) {

        setCamera(camera);
        setCliente(cliente);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {

        return "camera: " + camera + "\ncliente: " + cliente;
    }
}
