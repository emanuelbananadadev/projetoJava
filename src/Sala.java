import java.util.ArrayList;

public class Sala extends Base<Sala> {
    private int idSala;
    private int capacidadeSala;
    private String descricao;
    private String status;

    public Sala(int capacidade, String descricao) {
        super("sala.txt");
        this.idSala = getProximoId();
        this.capacidadeSala = capacidade;
        this.descricao = descricao;
        this.status = "Ativo";
    }

    public Sala() {
        super("sala.txt");
    }

    public int getIdSala() {
        return this.idSala;
    }

    public void setIdSala(int id) {
        this.idSala = id;
    }

    public int getCapacidade() {
        return this.capacidadeSala;
    }

    public void setCapacidade(int capacidade) {
        this.capacidadeSala = capacidade;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean salvar() {
        Sala existente = consultar(this.descricao);
        if(existente.getIdSala() != 0 && existente != null) {
            System.out.println("Erro: Sala com essa descrição já existe");
            return false;
        }

        String linha = this.idSala + ";" + this.capacidadeSala + ";" + this.descricao + ";" + this.status;
        return cadastrar(linha);
    }
    
    public ArrayList<String[]> listarSalas() {
        return listar();
    }

    public boolean editarSala(int idProcurado, String novaDescricao) {
        return editar(idProcurado, novaDescricao);
    }

    public Sala consultarSala(String descricaoProcurada) {
        return consultar(descricaoProcurada);
    }

    @Override
    protected Sala converterLinha(String[] partes) {
        int idSala = Integer.parseInt(partes[0]);
        int capacidadeSala = Integer.parseInt(partes[1]);
        String descricao = partes[2];
        String status = partes[3];

        Sala sala = new Sala(capacidadeSala, descricao);
        sala.setIdSala(idSala);
        sala.setStatus(status);

        return sala;
    }

    @Override
    protected Sala criarObjetoVazio() {
        return new Sala();
    }

    public String toString() {
        return this.idSala + this.capacidadeSala + this.descricao;
    }
}
