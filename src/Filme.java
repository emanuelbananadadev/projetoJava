public class Filme {
    public int id;
    public Genero genero;
    public String titulo;
    public String sinopse;
    public int classificacao;
    public int ano;
    public String status;

    public Filme(int id, Genero genero, String titulo, String sinopse, int classificacao, int ano, String status) {
        this.id = id;
        this.genero = genero;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.classificacao = classificacao;
        this.ano = ano;
        this.status = status;
    }

    
}
