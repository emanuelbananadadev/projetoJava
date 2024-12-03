import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sessao extends Base<Sessao> {
    private int idSessao;
    private LocalDateTime dataHoraSessao;
    private Filme filme;
    private Sala sala;
    private Funcionario funcionario;
    private String status;


    public Sessao(LocalDateTime dataHoraSessao, Filme filme, Sala sala, Funcionario funcionario) {
        super("sessao.txt");
        this.idSessao = getProximoId();
        this.dataHoraSessao = dataHoraSessao;
        this.filme = filme;
        this.sala = sala;
        this.funcionario = funcionario;
        this.status = "Ativo";
    }

    public Sessao() {
       super("sessao.txt");
    }

    public int getIdSessao() {
        return this.idSessao;
    }

    public void setIdSessao(int id) {
        this.idSessao = id;
    }

    public LocalDateTime getData() {
        return this.dataHoraSessao;
    }

    public void setData(LocalDateTime data) {
        this.dataHoraSessao = data;
    }

    public Filme getFilme() {
        return this.filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean salvar() {
        String linha = this.idSessao + ";" + this.dataHoraSessao.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + ";" + this.filme.getIdFilme() + ";" + this.sala.getIdSala() + ";" + this.funcionario.getMatricula() + ";" + this.status;

        return cadastrar(linha);
     }

     public ArrayList<String[]> listarSessoes() {
        return listar();
     }

     public Sessao consultarPorId(int idSessao) {
        ArrayList<String[]> registros = listar();

        for(String[] registro : registros) {
            if(Integer.parseInt(registro[0]) == idSessao) {
                return converterLinha(registro);
            }
        }

        return null;
     }

     public Sessao consultarPorDescricao(String tituloFilme, String descricaoSala) {
       ArrayList<String[]> registros = listar();

       for(String[] registro : registros) {
        Filme filmeAtual = new Filme().consultarFilme(tituloFilme);
        Sala salaAtual = new Sala().consultarSala(descricaoSala);

        if(filmeAtual != null && salaAtual != null 
        && filmeAtual.getIdFilme() == Integer.parseInt(registro[2]) 
        && salaAtual.getIdSala() == Integer.parseInt(registro[3])) {
            return converterLinha(registro);
        }

        }
        return null;

       }

     public boolean editarSessao(int idSessao, LocalDateTime novaDataHora) {
        ArrayList<String[]> registros = listar();
        boolean atualizado = false;

        for(String[] registro : registros) {
            if(Integer.parseInt(registro[0]) == idSessao) {
                registro[1] = novaDataHora.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                atualizado = true;
                break;
            }
        }

        if(atualizado) {
            return editar(idSessao, String.join(";", registros.get(idSessao - 1)));
        }

        return false;
     }

     @Override
     protected Sessao converterLinha(String[] partes) {
         LocalDateTime dataHoraSessao = LocalDateTime.parse(partes[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
         Filme filme = new Filme().consultarFilme(partes[2]);
         Sala sala = new Sala().consultarSala(partes[3]);
         Funcionario funcionario = new Funcionario().consultarFuncionario(partes[4]);
         String status = partes[5];

         Sessao sessao = new Sessao(dataHoraSessao, filme, sala, funcionario);
         sessao.setIdSessao(Integer.parseInt(partes[0]));
         sessao.setStatus(status);

         return sessao;
     }


     @Override
     protected Sessao criarObjetoVazio() {
         return new Sessao();
     }

     public String toString() {
        return this.idSessao + this.filme.getTitulo() + this.sala.getDescricao() + this.status;
     }
 
}
