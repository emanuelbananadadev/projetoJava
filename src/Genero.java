import java.util.ArrayList;

public class Genero extends Base<Genero> {
    private int id;
    private String descricao;
    private String status;

    public Genero(int id, String descricao) {
        super("genero.txt");
        this.id = id;
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
        Genero existente = consultar(this.id, this.descricao);
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

    public Genero consultarGenero(int idProcurado, String descricaoProcurada) {
        Genero generoEncontrado = consultar(idProcurado, descricaoProcurada);

        if(generoEncontrado != null && generoEncontrado.getId() != 0) {
            return generoEncontrado;
        }

        return new Genero();
    }

    @Override
    protected Genero converterLinha(String[] partes) {
        int id = Integer.parseInt(partes[0]);
        String descricao =  partes[1];
        String status = partes[2];
        Genero genero = new Genero(id, descricao);
        genero.status = status;

        return genero;
    }

    @Override
    protected Genero criarObjetoVazio() {
        return new Genero();
    }
}
