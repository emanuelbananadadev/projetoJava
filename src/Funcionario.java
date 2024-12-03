import java.time.LocalDateTime;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private int matricula;
    private LocalDateTime horarioTrabalho;
    private FuncionarioBase base;

    public Funcionario(String cpf, String nome, String email) {
        
        super(cpf, nome, email);
        this.base = new FuncionarioBase();
        this.matricula = base.getProximoId();
        this.horarioTrabalho = LocalDateTime.now();

        
    }

    public Funcionario() {
        super("","","");
        this.base = new FuncionarioBase();
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public LocalDateTime getHorarioTrabalho() {
        return this.horarioTrabalho;
    }

    public void setHorarioTrabalho(LocalDateTime horario) {
        this.horarioTrabalho = horario;
    }

    public boolean salvar() {
        String linha = this.matricula + ";" + this.getCpf() + ";" + this.getNome() + ";" + this.getEmail() + ";" + this.horarioTrabalho;
        return base.cadastrar(linha);
    }

    public ArrayList<String[]> listarFuncionarios() {
        return base.listar();
    }

    public Funcionario consultarFuncionario(String nomeProcurado) {
        Funcionario funcionarioEncontrado = base.consultar(nomeProcurado);
        return funcionarioEncontrado != null ? funcionarioEncontrado : criarObjetoVazio();
    }

    public Funcionario criarObjetoVazio() {
        return new Funcionario("", "", "");
    }

    public String toString() {
        return this.getCpf() + this.getNome() + this.getEmail();
    }
}
