import java.util.ArrayList;

public class FilmeAtor extends Base<FilmeAtor> {
    private int idFilmeAtor;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;

    public FilmeAtor(Ator ator, Filme filme, String personagem, boolean principal) {
        super("filmeator.txt");
        this.idFilmeAtor = getProximoId();
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
    }

    public FilmeAtor() {
        super("filmeator.txt");
    }

    public int getIdFilmeAtor() {
        return this.idFilmeAtor;
    }

    public void setIdFilmeAtor(int id) {
        this.idFilmeAtor = id;
    }

    public Ator getAtor() {
        return this.ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Filme getFilme() {
        return this.filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getPersonagem() {
        return this.personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public boolean getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public boolean salvar() {
        String linha = this.idFilmeAtor + ";" + this.ator.getNome() + ";" + this.filme.getTitulo() + ";" + this.personagem + ";" + this.principal;
        return cadastrar(linha);
    }

    public ArrayList<String[]> listarFilmesAtor() {
        return listar();
    }

    public boolean editarGenero(int idProcurado, String novoPersonagem) {
        return editar(idProcurado, novoPersonagem);
    }

    public FilmeAtor consultarFilmeAtor(String personagemProcurado) {
        FilmeAtor filmeAtorEncontrado = consultar(personagemProcurado);

        if(filmeAtorEncontrado != null) {
            return filmeAtorEncontrado;
        }

        return new FilmeAtor();
    }

    @Override
    protected FilmeAtor converterLinha(String[] partes) {
        int id = Integer.parseInt(partes[0]);
        String nomeAtor = partes[1];
        String tituloFilme = partes[2];
        String personagem = partes[3];
        boolean principal = Boolean.parseBoolean(partes[4]);

        Ator ator = new Ator().consultarAtor(nomeAtor);
        Filme filme = new Filme().consultarFilme(tituloFilme);

        if(ator == null || filme == null) {
            System.out.println("Erro: Ator ou Filme não encontrados para linha: " + String.join(";", partes) );
            return criarObjetoVazio();
        }

        FilmeAtor filmeAtor = new FilmeAtor(ator, filme, personagem, principal);
        filmeAtor.setIdFilmeAtor(id);
        return filmeAtor;
    }


    @Override 
    protected FilmeAtor criarObjetoVazio() {
        return new FilmeAtor();
    }

    public String toString() {
        return this.idFilmeAtor + this.ator.getNome() + this.filme.getTitulo() + this.personagem;
    }


    
}