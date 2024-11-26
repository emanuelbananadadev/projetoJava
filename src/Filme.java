import java.util.ArrayList;

public class Filme extends Base<Filme> {
    private int idFilme;
    private String titulo;
    private int classificacao;
    private Genero genero;
    private String status;

    public Filme(int idFilme, String titulo, int classificacao, Genero genero) {
        super("filme.txt");
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.status = "Ativo";
    }

    public Filme() {
        super("filme.txt");
    }

    public int getIdFilme() {
        return this.idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean salvar() {
        String linha = this.idFilme + ";" + this.titulo + ";" + this.classificacao + ";" + genero.getId() + ";" + this.status;
        return cadastrar(linha);
    }

    public ArrayList<String[]> listarFilmes() {
        return listar();
    }

    public boolean editarFilme(int idProcurado, String novoTitulo) {
        return editar(idProcurado, novoTitulo);
    }

    public Filme consultarFilme(int idProcurado, String tituloProcurado) {
       Filme filmeEncontrado = consultar(idProcurado, tituloProcurado);

       if (filmeEncontrado != null && filmeEncontrado.getIdFilme() != 0) {
        return filmeEncontrado;
       }

       return criarObjetoVazio();
    }

    @Override
    protected Filme converterLinha(String[] partes) {
        int id = Integer.parseInt(partes[0]);
        String titulo = partes[1];
        int classificacao = Integer.parseInt(partes[2]);
        int idGenero = Integer.parseInt(partes[3]);
        String status = partes[4];

        Genero genero = new Genero().consultarGenero(idGenero, null);
        Filme filme = new Filme(id, titulo, classificacao, genero);
        filme.status = status;

        return filme;
    }

    @Override
    protected Filme criarObjetoVazio() {
        return new Filme();
    }
}
