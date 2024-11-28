public class Ator extends Pessoa {
    private int registro;

    public Ator(int registro, String cpf, String nome, String email) {
        super(cpf, nome, email);
        this.registro = registro;
    }

    public int getRegistro() {
        return this.registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

}
