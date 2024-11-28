public class FilmeAtor extends Base<FilmeAtor> {
    private int idFilmeAtor;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;

    public FilmeAtor(Ator ator, Filme filme, String personagem, boolean principal) {
        super("filmeator.txt");
        this.idFilmeAtor = getProximoId();
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
    }

    
}