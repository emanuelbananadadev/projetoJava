public abstract class Pessoa  {
    private String cpf;
    private String nome;
    private String email;

    public Pessoa(String cpf, String nome, String email) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new NullPointerException("O nome do funcionário não pode ser nulo ou vazio.");
            }
            this.nome = nome;

            if (cpf == null || cpf.isEmpty()) {
                throw new NullPointerException("O CPF do funcionário não pode ser nulo ou vazio.");
            }
            this.cpf = cpf;

        } catch (NullPointerException e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return this.cpf + this.nome + this.email;
    }


}
