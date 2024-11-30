public class SalaAssento {
    private int idSalaAssento;
    private Assento assento;
    private Sala sala;

    public SalaAssento(Assento assento, Sala sala) {
        this.assento = assento;
        this.sala = sala;
    }

    public int getIdSalaAssento() {
        return this.idSalaAssento;
    }

    public void setIdSalaAssento(int id) {
        this.idSalaAssento = id;
    }

    public Assento getAssento() {
        return this.assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
