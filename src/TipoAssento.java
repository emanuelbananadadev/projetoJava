public class TipoAssento {
    private int idTipoAssento;
    private String descricao;
    private String status;

    public TipoAssento(String descricao) {
        this.descricao = descricao;
        this.status  = "Ativo";
    }

    public int getIdTipoAssento() {
        return this.idTipoAssento;
    }

    public void setIdTipoAssento(int id) {
        this.idTipoAssento = id;
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
