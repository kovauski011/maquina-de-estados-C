public class Cliente implements Character {
    private int fome = 0;
    private int tempoComendo = 0;
    private final Restaurante restaurante;

    private State<Cliente> state = new FicaComFome(this);

    public Cliente(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public int getFome() {
        return fome;
    }

    public void addFome(int valor) {
        this.fome += valor;
        this.fome = Math.max(this.fome, 0);
    }

    public void zerarFome() {
        this.fome = 0;
    }

    public int getTempoComendo() {
        return tempoComendo;
    }

    public void setTempoComendo(int tempoComendo) {
        this.tempoComendo = tempoComendo;
    }

    @Override
    public void update() {
        state.execute();
    }

    public void setState(State<Cliente> novoEstado) {
        this.state.leave();
        this.state = novoEstado;
        novoEstado.enter();
    }

    @Override
    public void printStats(String estado) {
        System.out.println("\n CLIENTE");
        System.out.println(estado);
        System.out.println("Fome: " + fome);
    }
}