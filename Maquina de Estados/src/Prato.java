public enum Prato {
    FEIJOADA(10),
    HAMBURGUER(5);
    //adicionar mais pedidos aqui
    
    private final int tempoPreparo;

    Prato(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

}