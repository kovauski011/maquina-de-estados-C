import java.util.ArrayList;

public class StateMachine {
    private ArrayList<Character> characters = new ArrayList<>();

    public void run() {
        Restaurante restaurante = new Restaurante();

        characters.add(new Cliente(restaurante));
        characters.add(new Cozinheiro(restaurante));

        while (true) {
            for (Character c : characters) {
                c.update();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static void main(String[] args) {
        new StateMachine().run();
    }
}