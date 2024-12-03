import java.util.ArrayList;

public class TipoAssento extends Base<TipoAssento> {
    private int idTipoAssento;
    private String descricao;
    private String status;

    public TipoAssento(String descricao) {
        super("tipoAssento.txt");
        this.idTipoAssento = getProximoId();
        this.descricao = descricao;
        this.status  = "Ativo";
    }

    public TipoAssento() {
        super("tipoAssento.txt");
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

    public boolean salvar() {
        TipoAssento existente = consultar(this.descricao);
        if(existente.getIdTipoAssento() != 0) {
            System.out.println("Erro: Tipo de assento com essa descrição já existe");
            return false;            
        }

        String linha = this.idTipoAssento + ";" + this.descricao + ";" + this.status;
        return cadastrar(linha);
    }

    public ArrayList<String[]> listarTiposAssentos() {
        return listar();
    }

    public boolean editarTipoAssento(int idProcurado, String novaDescricao) {
        return editar(idProcurado, novaDescricao);
    }

    public TipoAssento consultarTipoAssento(String descricaoProcurada) {
        return consultar(descricaoProcurada);
    }

    @Override
    protected TipoAssento converterLinha(String[] partes) {
        try{
            int idTipoAssento = Integer.parseInt(partes[0]);
            String descricao = partes[1];
            String status = partes[2];
            
            TipoAssento tipoAssento = new TipoAssento(descricao);
            
            tipoAssento.setIdTipoAssento(idTipoAssento);
            tipoAssento.setStatus(status);

            return tipoAssento;
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter linha: " + e.getMessage());
            return criarObjetoVazio();
        }

    }

    @Override
    protected TipoAssento criarObjetoVazio() {
        return new TipoAssento();
    }

    public String toString() {
        return this.idTipoAssento + this.descricao + this.status;
    }
}
