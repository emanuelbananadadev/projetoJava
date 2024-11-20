import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Genero {
    private int id;
    private String status;
    private String descricao;

    public Genero(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean inserir() {
        try {
            FileWriter fw = new FileWriter("./src/bd/genero.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(this.id + ";" + this.descricao + ";" + this.status);
            bw.newLine();

            bw.close();

            return true;

        } catch (Exception exception) {
            System.out.println("Erro ao acessar o arquivo");
            return false;
        }

    }

    public void listar() {
        try {
            FileReader fr = new FileReader("./src/bd/genero.txt");
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> lista = new ArrayList<>();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                for (String parte : partes) {
                    lista.add(parte);
                }
            }

            for (String nome : lista) {
                System.out.println(nome);
            }

            br.close();

            System.out.println(lista);

        } catch (Exception exception) {
            System.out.println("Erro");
        }
    }

}
