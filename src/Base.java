import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Base<T> {
    protected String filePath;

    public Base(String fileName) {
        this.filePath = "./src/bd/" + fileName;
    }

    public boolean cadastrar(String linha) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(linha);
            bw.newLine();

            bw.close();
            return true;
        } catch(IOException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<String[]> listar() {
        ArrayList<String[]> dados = new ArrayList<>();

        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String linha;
            while((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    dados.add(partes);
                } else {
                    System.out.println("Linha mal formatada ignorada: " + linha);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return dados;
    }

    public boolean editar(int idProcurado, String novaDescricao) {
        ArrayList<String[]> registros = listar();
        boolean encontrado = false;

        for(String[] registro : registros) {
            if(Integer.parseInt(registro[0]) == idProcurado) {
                registro[1] = novaDescricao;
                encontrado = true;
                break;
            }
        }

        if(encontrado) {
            try {
                FileWriter fw = new FileWriter(this.filePath);
                BufferedWriter bw = new BufferedWriter(fw);

                for(String[] registro : registros) {
                    bw.write(String.join(";", registro));
                    bw.newLine();
                }

                bw.close();

                return true;
            } catch (IOException e) {
                System.out.println("Erro ao salvar os dados atualizados: " + e.getMessage());
                return false;
            }
        } else {
            System.out.println("Id não encontrado");
            return false;
        }

    }

    public T consultar(int idProcurado, String descricaoProcurada) {
            ArrayList<String[]> registros = listar();

            for(String[] registro : registros) {
                int idAtual = Integer.parseInt(registro[0]);
                String descricaoAtual = registro[1];

                if(idAtual == idProcurado && descricaoAtual.equals(descricaoProcurada)) {
                    return converterLinha(registro);
                }
            }
            return criarObjetoVazio();
        } 

        protected abstract T converterLinha(String[] partes);
        protected abstract T criarObjetoVazio();
    }



