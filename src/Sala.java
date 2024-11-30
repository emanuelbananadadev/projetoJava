public class Sala {
    private int idSala;
    private int capacidadeSala;
    private String descricao;
    private String status;

    public Sala(int capacidade, String descricao) {
        this.capacidadeSala = capacidade;
        this.descricao = descricao;
        this.status = "Ativo";
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
}
