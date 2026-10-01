public class FicaComFome extends AbstractState<Cliente> {
    public FicaComFome(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void enter() {
         System.out.println("Cliente: to de boa por enquanto");
    }

    @Override
    public void execute() {
        getCharacter().addFome(1); //adiciona fome
        getCharacter().printStats("to ficando com fome");
        
        if (getCharacter().getFome() >= 10) { //se a fome for maior q 10 troca de estado
            getCharacter().setState(new FazPedido(getCharacter()));
        }
    }
}