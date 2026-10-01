public class Cozinha extends AbstractState<Cozinheiro> {
    public Cozinha(Cozinheiro cozinheiro) {
        super(cozinheiro);
    }

    @Override
    public void enter() {
        getCharacter().setTempoPreparo(0);
        System.out.println("Cozinheiro: Hora de cozinhar!");
    }

    @Override 
    public void execute() {
        Pedido pedido = getCharacter().getRestaurante().getPedidoAtual();
        int necessario = pedido.getPrato().getTempoPreparo();

        getCharacter().setTempoPreparo(getCharacter().getTempoPreparo() + 1);
        getCharacter().printStats("Cozinhando... " + getCharacter().getTempoPreparo() + "/" + necessario + "s");

        if (getCharacter().getTempoPreparo() >= necessario) {
            pedido.setStatus(StatusPedido.PRONTO);
            getCharacter().setState(new EntregaPedido(getCharacter()));
        }
    }

    @Override
    public void leave() {
        System.out.println("Cozinheiro: Pedido pronto!");
    }
}
