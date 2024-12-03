import java.util.ArrayList;

public class Ingresso extends Base<Ingresso> {
    private int idIngresso;
    private double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;

    public Ingresso(double valorPago, SalaAssento sala, Sessao sessao) {
        super("ingresso.txt");
        this.idIngresso = getProximoId();
        this.valorPago = valorPago;
        this.salaAssento = sala;
        this.sessao = sessao;

    }

    public Ingresso() {
        super("ingresso.txt");
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

    public boolean salvar() {
        if(this.salaAssento == null || this.sessao == null) {
            System.out.println("Erro: Sala ou Sessão não podem ser nulas");
            return false;
        }

        Ingresso existente = consultar(this.salaAssento.getSala().getDescricao());
        if(existente.getIdSessao() != 0) {
            System.out.println("Erro: Sessão com essa descrição já existe");
            return false;
        }

        String linha = this.idIngresso + ";" + this.valorPago + ";" + this.salaAssento.getSala().getDescricao() + ";" + this.sessao.getSala().getDescricao();

        return cadastrar(linha);
    }

    public ArrayList<String[]> listarIngressos() {
        return listar();
    }

    public boolean editarIngresso(int idProcurado, String novaDescricao) {
        return editar(idProcurado, novaDescricao);
    }

    public Ingresso consultarSessao(String descricaoProcurada) {
        return consultar(descricaoProcurada);
    }


    @Override
    protected Ingresso converterLinha(String[] partes) {
        int idIngresso = Integer.parseInt(partes[0]);
        double valorPago = Double.parseDouble(partes[1]);
        SalaAssento salaAssento = new SalaAssento().consultarSalaAssento(partes[2]);
        Sessao sessao = new Sessao().consultarPorId(Integer.parseInt(partes[3]));

        Ingresso ingresso = new Ingresso(valorPago, salaAssento, sessao);
        ingresso.setIdSessao(idIngresso);
        

        return ingresso;
    }

    @Override
    protected Ingresso criarObjetoVazio() {
        return new Ingresso();
    }

    public String toString() {
        return  this.idIngresso + this.sessao.getSala().getDescricao();
    }
}
