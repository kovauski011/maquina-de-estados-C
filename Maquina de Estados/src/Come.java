public class Come extends AbstractState<Cliente> {
    public Come(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void enter() {
         System.out.println("Cliente: Hora de comer!");
         getCharacter().setTempoComendo(0);
    }

    @Override
    public void execute() {
        getCharacter().setTempoComendo(getCharacter().getTempoComendo() + 1);
        getCharacter().printStats("Comendo... (" + getCharacter().getTempoComendo() + "s)");

        if (getCharacter().getTempoComendo() >= 3) {
            getCharacter().setState(new FicaComFome(getCharacter()));
        }
    }

    @Override
    public void leave() {
        getCharacter().zerarFome();
        getCharacter().getRestaurante().setPedidoAtual(null);
         System.out.println("Cliente: to cheio!");
    }
}