public class Ingresso {
    private int idIngresso;
    private double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;

    public Ingresso(double valorPago, SalaAssento sala, Sessao sessao) {
        this.valorPago = valorPago;
        this.salaAssento = sala;
        this.sessao = sessao;

    }

    public int getIdSessao() {
        return this.idIngresso;
    }

    public void setIdSessao(int id) {
        this.idIngresso = id;
    }

    public double getValor() {
        return this.valorPago;
    }

    public void setValor(double valor) {
        this.valorPago = valor;
    }

    public SalaAssento getSala() {
        return this.salaAssento;
    }

    public void setSala(SalaAssento sala) {
        this.salaAssento = sala;
    }

    public Sessao getSessao() {
        return this.sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
}
