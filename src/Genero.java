import java.util.ArrayList;

public class Genero extends Base<Genero> {
    private int id;
    private String descricao;
    private String status;

    public Genero(String descricao) {
        super("genero.txt");
        this.id = getProximoId();
        this.descricao = descricao;
        this.status = "Ativo";
    }

    public Genero() {
        super("genero.txt");
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean salvar() {
        Genero existente = consultar(this.descricao);
        if(existente.getId() != 0) {
            System.out.println("Erro: Id ou descrição já existem");
            return false;
        }

        String linha = this.id + ";" + this.descricao + ";" + this.status;
        return cadastrar(linha);
    }

    public ArrayList<String[]> listarGeneros() {
      return listar();
    }

    public boolean editarGenero(int idProcurado, String novaDescricao) {
        return editar(idProcurado, novaDescricao);
    }

    public Genero consultarGenero(String descricaoProcurada) {
        Genero generoEncontrado = consultar(descricaoProcurada);

        if(generoEncontrado != null) {
            return generoEncontrado;
        }

        return new Genero();
    }

    @Override
    protected Genero converterLinha(String[] partes) {
        String descricao =  partes[1];
        String status = partes[2];
        Genero genero = new Genero(descricao);
        genero.status = status;

        return genero;
    }

    @Override
    protected Genero criarObjetoVazio() {
        return new Genero();
    }

    public String toString() {
        return this.id + this.descricao + this.status;
    }
}
