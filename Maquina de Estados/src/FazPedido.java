import java.util.Random;

public class FazPedido extends AbstractState<Cliente> {
    private static final Random random = new Random();

    public FazPedido(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void enter() {
        Prato[] cardapio = Prato.values();
        Prato escolhido = cardapio[random.nextInt(cardapio.length)];

        Pedido pedido = new Pedido(escolhido);
        getCharacter().getRestaurante().setPedidoAtual(pedido);

         System.out.println("Cliente: garçom! quero uma " + escolhido + "!");

    }

    @Override
    public void execute() {
        Pedido pedido = getCharacter().getRestaurante().getPedidoAtual();
        getCharacter().printStats("Esperando o pedido (" + pedido.getStatus() + ")...");

        if (pedido.getStatus() == StatusPedido. ENTREGUE) {
            getCharacter().setState(new Come(getCharacter()));
        }
    }
}