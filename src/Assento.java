public class Assento {
    private int idAssento;
    private TipoAssento tipoAssento;

    public Assento(TipoAssento tipo) {
        this.tipoAssento = tipo;
    }

    public int getIdAssento() {
        return this.idAssento;
    }

    public void setIdAssento(int id) {
        this.idAssento = id;
    }

    public TipoAssento getTipo() {
        return this.tipoAssento;
    }

    public void setTipo(TipoAssento tipo) {
        this.tipoAssento = tipo;
    }
}
