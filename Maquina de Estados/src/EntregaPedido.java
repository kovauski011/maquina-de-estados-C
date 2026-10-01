public class EntregaPedido extends AbstractState<Cozinheiro> {
    public EntregaPedido(Cozinheiro cozinheiro) {
        super(cozinheiro);
    }

    @Override
    public void execute() {
        Pedido pedido = getCharacter().getRestaurante().getPedidoAtual();

        if (pedido.getStatus() == StatusPedido.PRONTO) {
            pedido.setStatus(StatusPedido.ENTREGUE);
            getCharacter().printStats("Pedido entregue! ");
            getCharacter().setState(new AnotaPedido(getCharacter()));
        } 
    }
}