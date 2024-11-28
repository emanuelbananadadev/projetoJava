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

    public int getProximoId() {
        ArrayList<String[]> registros = listar();

        return registros.size() + 1;
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
                dados.add(partes);
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

    public T consultar(String descricaoProcurada) {
            ArrayList<String[]> registros = listar();

            for(String[] registro : registros) {
                String descricaoAtual = registro[1];

                if(descricaoAtual.equalsIgnoreCase(descricaoProcurada)) {
                    return converterLinha(registro);
                }
            }
            System.out.println("Descrição não encontrada: " + descricaoProcurada);
            return criarObjetoVazio();
        } 

        protected abstract T converterLinha(String[] partes);
        protected abstract T criarObjetoVazio();
    }



