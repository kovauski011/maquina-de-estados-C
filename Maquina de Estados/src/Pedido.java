public class Pedido {
    private final Prato prato;
    private StatusPedido status = StatusPedido.FEITO;

    public Pedido(Prato prato) {
        this.prato = prato;
    }

    public Prato getPrato() {
        return prato;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}