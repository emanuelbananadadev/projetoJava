import java.util.ArrayList;

public class Ator extends Pessoa {
    private int registro;
    private static Base<Ator> base = new Base<>("ator.txt") {
        @Override
        protected Ator converterLinha(String[] partes) {
            String cpf = partes[1];
            String nome = partes[2];
            String email = partes[3];
            return new Ator(cpf, nome, email);
        }

        @Override
        protected Ator criarObjetoVazio() {
            return new Ator();
        }
    };

    public Ator(String cpf, String nome, String email) {
        super(cpf, nome, email);
        this.registro = base.getProximoId();
    }

    public Ator() {
        super("","","");
        this.registro = 0;
    }

    public int getRegistro() {
        return this.registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public boolean salvar() {
        String linha = this.registro + ";" + this.getCpf() + ";" + this.getNome() + ";" + this.getEmail();
        return base.cadastrar(linha);
    }

    public  ArrayList<String[]> listarAtores() {
       return base.listar();
    }

    public boolean editarRegistro(int idProcurado, String novoEmail) {
        return base.editar(idProcurado, novoEmail);
    }

    public Ator consultarAtor(String nomeProcurado) {
        return base.consultar(nomeProcurado);
    }

    public Ator criarObjetoVazio() {
        return new Ator("", "", "");
    }

    public String toString() {
        return this.registro + this.getNome() + this.getCpf();
    }

}
