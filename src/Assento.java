import java.util.ArrayList;

public class Assento extends Base<Assento>{
    private int idAssento;
    private TipoAssento tipoAssento;

    public Assento(TipoAssento tipo) {
        super("assento.txt");
        this.idAssento = getProximoId();
        this.tipoAssento = tipo;
    }

    public Assento() {
        super("assento.txt");
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

    public boolean salvar() {
        if(this.tipoAssento == null || this.tipoAssento.getDescricao() == null) {
            System.out.println("Erro: Tipo de assento inválido");
            return false;
        }

        Assento existente = consultar(this.tipoAssento.getDescricao());
        if(existente.getIdAssento() != 0) {
            System.out.println("Erro: Assento com essa descrição já existe");
            return false;
        }

        String linha = this.idAssento + ";" + this.tipoAssento.getDescricao();
        return cadastrar(linha);
    }

    public ArrayList<String[]> listarAssentos() {
       return listar();
    }

    public boolean editarAssento(int idProcurado, String novaDescricao) {
        return editar(idProcurado, novaDescricao);
    }

    public Assento consultarAssento(String descricaoProcurada) {
        return consultar(descricaoProcurada);
    }

    @Override
    protected Assento converterLinha(String[] partes) {
        int idAssento = Integer.parseInt(partes[0]);
        String descricaoTipo = partes[1];

        TipoAssento tipoAssento = new TipoAssento();
        tipoAssento.setDescricao(descricaoTipo);

        Assento assento = new Assento(tipoAssento);
        assento.setIdAssento(idAssento);

        return assento;
    }

    @Override
    protected Assento criarObjetoVazio() {
        return new Assento();
    }

    public String toString() {
        return this.idAssento + this.tipoAssento.getDescricao();
    }
}
