public class AnotaPedido extends AbstractState<Cozinheiro> {
    public AnotaPedido(Cozinheiro cozinheiro) {
        super(cozinheiro);
    }

    @Override
    public void execute() {
        Restaurante restaurante = getCharacter().getRestaurante();

        if (restaurante.temPedido() && restaurante.getPedidoAtual().getStatus() == StatusPedido.FEITO) {
            restaurante.getPedidoAtual().setStatus(StatusPedido.ANOTADO);
            getCharacter().printStats("Pedido anotado! ");
            getCharacter().setState(new Cozinha(getCharacter()));
        }else {
            getCharacter().printStats("Aguardando pedido... ");
        }
    }
}
