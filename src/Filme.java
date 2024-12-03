import java.util.ArrayList;

public class Filme extends Base<Filme> {
    private int idFilme;
    private String titulo;
    private int classificacao;
    private Genero genero;
    private String status;

    public Filme(String titulo, int classificacao, Genero genero) {
        super("filme.txt");
        this.idFilme = getProximoId();
        this.titulo = titulo;
        try {
            this.classificacao = classificacao;
        } catch (NumberFormatException e) {
            System.out.println("A classificação deve ser um número inteiro");
            this.classificacao = 0;
        }
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

        Filme existente = consultarFilme(this.titulo);
        if(existente.getIdFilme() != 0) {
            System.out.println("Erro: Id ou descrição já existem");
            return false;
        }

        String linha = this.idFilme + ";" + this.titulo + ";" + this.classificacao + ";" + this.genero.getDescricao() + ";"
                + this.status;
        return cadastrar(linha);
    }

    public ArrayList<String[]> listarFilmes() {
       return listar();
    }

    public boolean editarFilme(int idProcurado, String novoTitulo) {
        return editar(idProcurado, novoTitulo);
    }

    public Filme consultarFilme(String tituloProcurado) {
        Filme filmeEncontrado = consultar(tituloProcurado);

        if (filmeEncontrado != null) {
            return filmeEncontrado;
        }

        return criarObjetoVazio();
    }

    @Override
    protected Filme converterLinha(String[] partes) {
        
            if(partes.length != 5) {
                System.out.println("Linha mal formatada ignorada: " + String.join(";", partes));
                return criarObjetoVazio();
            }

            int id = Integer.parseInt(partes[0]);
            String titulo = partes[1];
            int classificacao = Integer.parseInt(partes[2]);
            String descricaoGenero = partes[3];
            String status = partes[4];

            Genero genero = new Genero().consultarGenero(descricaoGenero);

            if(genero.getId() == 0) {
                System.out.println("Gênero não encontrado: " + descricaoGenero);
                return criarObjetoVazio();
            }

            Filme filme = new Filme(titulo, classificacao, genero);
            filme.setIdFilme(id);
            filme.status = status;
            return filme;
       
    }

    @Override
    protected Filme criarObjetoVazio() {
        return new Filme();
    }

    public String toString() {
        return this.idFilme + this.titulo + this.genero.getDescricao();
    }
}
