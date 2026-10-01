public class Cozinheiro implements Character {
    private int tempoPreparo = 0;
    private final Restaurante restaurante;

    private State<Cozinheiro> state = new AnotaPedido(this);

    public Cozinheiro(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    @Override 
    public void update() {
        state.execute();
    }

    public void setState(State<Cozinheiro> novoEstado) {
        this.state.leave();
        this.state = novoEstado;
        novoEstado.enter();
    }

    @Override 
    public void printStats(String estado) {
        System.out.println("\nCOZINHEIRO");
        System.out.println(estado);
        if (restaurante.temPedido()) {
            System.out.println("Pedido: " + restaurante.getPedidoAtual().getPrato());
        } else {
            System.out.println("Pedido: nenhum");
        }
    }

}
