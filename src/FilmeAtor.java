public class FilmeAtor {
    private int idFilmeAtor;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;

    public FilmeAtor(Ator ator, Filme filme, String personagem, boolean principal) {
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
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

    
}