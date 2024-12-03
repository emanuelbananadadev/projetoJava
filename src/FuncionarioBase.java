
public class FuncionarioBase extends Base<Funcionario> {
    public FuncionarioBase() {
        super("funcionarios.txt");
    }

    @Override
    protected Funcionario converterLinha(String[] partes) {
        int matricula = Integer.parseInt(partes[0]);
        String cpf = partes[1];
        String nome = partes[2];
        String email = partes[3];

        Funcionario funcionario = new Funcionario(cpf, nome, email);
        funcionario.setMatricula(matricula);
        return funcionario;
    }

    @Override
    protected Funcionario criarObjetoVazio() {
        return new Funcionario("", "", "");
    }
}
