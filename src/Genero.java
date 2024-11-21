import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Genero {
    private int id;
    private String descricao;
    private String status;

    public Genero(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.status = "Ativo";
    }

    public Genero() {
        this.id = 0;
        this.descricao = "";
        this.status = "Ativo";
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

    public boolean inserir() {
        try{
            FileWriter fw = new FileWriter("./src/bd/genero.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            String linha = this.id + ";" + this.descricao + ";" + this.status;

            bw.write(linha);
            bw.newLine();

            bw.close();

            return true;
        } catch(IOException e) {
            System.out.println("Erro ao inserir gênero" + e.getMessage());
            return false;
        }
    }

    public ArrayList<String> listar() {
        ArrayList<String> lista = new ArrayList<>();

        try {
            FileReader fr = new FileReader("./src/bd/genero.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha; 
            while((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                for (String parte : partes) {
                    lista.add(parte);
                }
            }

            br.close();

            if(lista.isEmpty()) {
                System.out.println("Não existe nenhum dado para listar");
            }

        } catch(IOException e) {
            System.out.println("Erro ao listar gêneros: " + e.getMessage());
        }

        return lista;
    }

    public Genero consultar(String descricaoProcurada) {
        try{
            FileReader fr = new FileReader("./src/bd/genero.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if(partes[1].equals(descricaoProcurada)) {
                    int id = Integer.parseInt(partes[0]);
                    String descricao = partes[1];
                    br.close();

                    return new Genero(id, descricao);
                }
            }

            br.close();
        } catch(IOException e) {
            System.out.println("Erro ao consultar gênero: " + e.getMessage());
        }

        return new Genero();
    }

    public boolean editar(int idProcurado, String novaDescricao) {
        ArrayList<String> generos = new ArrayList<>();
        boolean encontrado = false;

        try {
            FileReader fr = new FileReader("./src/bd/genero.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if(Integer.parseInt(partes[0]) == idProcurado) {
                    partes[1] = novaDescricao;
                    encontrado = true;
                }

                generos.add(String.join(";",partes));
            }

            br.close();

            if(encontrado) {
                FileWriter fw = new FileWriter("./src/bd/genero.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);

                for(String genero : generos) {
                    bw.write(genero);
                    bw.newLine();
                }

                bw.close();
                return true;
            } else {
                System.out.println("Id não encontrado");
                return false;
            }
        } catch(IOException e) {
            System.out.println("Erro ao editar gênero: " + e.getMessage());
            return false;
        }
    }
}
