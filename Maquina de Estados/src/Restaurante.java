public class Restaurante {
    private Pedido pedidoAtual = null;

    public Pedido getPedidoAtual() {
        return pedidoAtual;
    }

    public void setPedidoAtual(Pedido pedido) {
        this.pedidoAtual = pedido;
    }

    public boolean temPedido() {
        return pedidoAtual != null;
    }
}