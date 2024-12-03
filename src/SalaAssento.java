import java.util.ArrayList;

public class SalaAssento extends Base<SalaAssento> {
    private int idSalaAssento;
    private Assento assento;
    private Sala sala;

    public SalaAssento(Assento assento, Sala sala) {
        super("salaAssento.txt");
        this.idSalaAssento = getProximoId();
        this.assento = assento;
        this.sala = sala;
    }

    public SalaAssento() {
        super("salaAssento.txt");
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

    public boolean salvar() {
        if(this.assento == null || this.assento.getTipo() == null || this.sala == null) {
            System.out.println("Erro: Assento ou Sala inválidos");
            return false;
        }

        SalaAssento existente = consultar(this.assento.getTipo().getDescricao());

        if(existente.getIdSalaAssento() != 0) {
            System.out.println("Erro: Sala assento com essa descrição já existe");
            return false;
        }

        String linha = this.idSalaAssento + ";" + this.assento.getTipo().getDescricao() + ";" + this.sala.getDescricao();

        return cadastrar(linha);
    }

    public ArrayList<String[]> listarSalAssentos() {
       return listar();
    }

    public SalaAssento consultarSalaAssento(String descricaoProcurada) {
        return consultar(descricaoProcurada);
    }

    @Override
    protected SalaAssento converterLinha(String[] partes) {
        int idSalaAssento = Integer.parseInt(partes[0]);
        int idAssento = Integer.parseInt(partes[1]);
        int idSala = Integer.parseInt(partes[2]);

        Assento assento = new Assento();
        assento.setIdAssento(idAssento);

        Sala sala = new Sala();
        sala.setIdSala(idSala);

        SalaAssento salaAssento = new SalaAssento(assento, sala);
        salaAssento.setIdSalaAssento(idSalaAssento);

        return salaAssento;
    }

    @Override
    protected SalaAssento criarObjetoVazio() {
        return new SalaAssento();
    }

    public String toString() {
        return this.idSalaAssento + this.sala.getDescricao();
    }
}
