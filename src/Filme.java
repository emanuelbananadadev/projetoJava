import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Filme {
    private int idFilme;
    private String titulo;
    private int classificacao;
    private Genero genero;
    private String status;

    public Filme(int id, String titulo, int classificacao, Genero genero) {
        this.idFilme = id;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.status = "Ativo";
    }

    public int GetId() {
        return  this.idFilme;
    }

    public void setId(int id) {
        this.idFilme = id;
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

    public boolean cadastrar() {
        try {
            FileWriter fw = new FileWriter("./src/bd/filme.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            String linha = this.idFilme + ";" + this.titulo + ";" + this.classificacao + ";" + genero.getDescricao() + ";" + this.status;
            bw.write(linha);
            bw.newLine();
            bw.close();
            return true;
        } catch(IOException e) {
            System.out.println("Não foi possível cadastrar: " + e.getMessage());
            return false;
        }
    }


    
}
