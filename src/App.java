import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Genero genero = new Genero();
        Filme filme = new Filme();
        Ator ator = new Ator();
        FilmeAtor filmeAtor = new FilmeAtor();
        Funcionario funcionario = new Funcionario();

        // Instâncias de classes usadas sem menus
        Sala sala = new Sala();
        Assento assento = new Assento();
        SalaAssento salaAssento = new SalaAssento();
        TipoAssento tipoAssento = new TipoAssento();
        Ingresso ingresso = new Ingresso();

       int opcao;

       do {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1- Gerenciar Filmes");
        System.out.println("2- Gerenciar Atores");
        System.out.println("3- Gerenciar Funcionário");
        System.out.println("4- Gerenciar Infra estrutura");
        System.out.println("0- Sair");
        System.out.println("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao) {
            case 1:
                menuFilme(scanner, filme, genero);
                break;
            case 2:
                menuAtor(scanner, ator, filme, filmeAtor);
                break;
            case 3:
                menuFuncionario(scanner, funcionario);
                break;
        
            case 0:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
        }

       } while (opcao != 0);

       scanner.close();
    }



 private static void menuFilme(Scanner scanner, Filme filme, Genero genero) {
    int opcao;

    do {
        System.out.println("\n=== Gerenciar Filmes ===");
        System.out.println("1- Cadastrar Filme");
        System.out.println("2- Listar Filmes");
        System.out.println("3- Editar Filme");
        System.out.println("0- Voltar ao menu principal");
        System.out.println("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao) {
            case 1:
                System.out.println("Digite o título do filme: ");
                String titulo = scanner.nextLine();

                System.out.println("Digite a classificação indicativa: ");
                int classificacao = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite a descrição do gênero: ");
                String descricaoGenero = scanner.nextLine();

                Genero generoFilme = genero.consultarGenero(descricaoGenero);
                if(generoFilme.getId() == 0) {
                    System.out.println("Gênero não encontrado. Criando novo gênero...");
                    generoFilme = new Genero(descricaoGenero);
                    if(generoFilme.salvar()) {
                        System.out.println("Novo gênero criado com sucesso!");
                    } else {
                        System.out.println("Erro ao criar novo gênero. Filme não cadastrado");
                        break;
                    }
                }

                Filme novoFilme = new Filme(titulo, classificacao, generoFilme);
                if(novoFilme.salvar()) {
                    System.out.println("Filme cadastrado com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar o filme");
                }
                break;
            case 2:
                ArrayList<String[]> filmesListar = filme.listarFilmes();
                System.out.println("\n=== Lista de Filmes ===");
                for(String[] f : filmesListar) {
                    System.out.println(String.format("Id: %s | Título: %s | Classificação: %s | Status: %s%n", f[0], f[1], f[2],f[4]));
                }
                break;
            case 3:
                ArrayList<String[]> filmesEditar = filme.listarFilmes();
                System.out.println("\n=== Lista de Filmes ===");
                for(String[] f : filmesEditar) {
                    System.out.println(String.format("Id: %s | Título: %s | Classificação: %s | Status: %s", f[0], f[1], f[2], f[4]));
                }

                System.out.println("\nDigite o Id do filme a ser editado: ");
                int idFilmeEditar = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o novo título: ");
                String novoTitulo = scanner.nextLine();

                if (filme.editarFilme(idFilmeEditar, novoTitulo)) {
                    System.out.println("Filme editado com sucesso!");
                } else {
                    System.out.println("Erro ao editar o filme. Certifique-se de que o Id está correto");
                } 
                break;

            case 0:
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida!");
        }

    } while (opcao != 0);
}

private static void menuAtor(Scanner scanner, Ator ator, Filme filme, FilmeAtor filmeAtor) {
    int opcao;

    do {
        System.out.println("\n=== Gerenciar Atores ===");
        System.out.println("1- Cadastrar Ator");
        System.out.println("2- Listar Atores");
        System.out.println("3- Vincular Ator a Filme");
        System.out.println("4- Editar Ator");
        System.out.println("0- Voltar ao menu principal");
        System.out.println("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao) {
            case 1:
                System.out.println("Digite o nome do ator: ");
                String nomeAtor = scanner.nextLine();

                System.out.println("Digite o CPF do ator: ");
                String cpfAtor = scanner.nextLine();

                System.out.println("Digite o e-mail do ator: ");
                String emailAtor = scanner.nextLine();

                Ator novoAtor = new Ator(nomeAtor, cpfAtor, emailAtor);
                if (novoAtor.salvar()) {
                    System.out.println("Ator cadastrado com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar o ator");
                }
                break;

            case 2:
                ArrayList<String[]> atoresListar = ator.listarAtores();
                System.out.println("\n=== Lista de Atores ===");
                for (String[] a : atoresListar) {
                    System.out.println(String.format("Id: %s | Nome: %s | CPF: %s | E-mail: %s", a[0], a[1], a[2], a[3]));
                }
                break;

            case 3:
                System.out.println("Digite o nome do ator a vincular ao filme: ");
                String nomeAtorVincular = scanner.nextLine();
                Ator atorVincular = new Ator().consultarAtor(nomeAtorVincular);
                if (atorVincular == null) {
                    System.out.println("Ator não encontrado.");
                    break;
                }

                System.out.println("Digite o título do filme para vincular o ator: ");
                String tituloFilmeVincular = scanner.nextLine();
                Filme filmeVincular = new Filme().consultarFilme(tituloFilmeVincular);
                if (filmeVincular == null) {
                    System.out.println("Filme não encontrado.");
                    break;
                }

                System.out.println("Digite o personagem do ator nesse filme: ");
                String personagem = scanner.nextLine();

                System.out.println("Ele é o personagem principal? (true/false): ");
                boolean principal = scanner.nextBoolean();
                scanner.nextLine();

                FilmeAtor novoFilmeAtor = new FilmeAtor(atorVincular, filmeVincular, personagem, principal);
                if (novoFilmeAtor.salvar()) {
                    System.out.println("Ator vinculado ao filme com sucesso!");
                } else {
                    System.out.println("Erro ao vincular ator ao filme.");
                }
                break;

            case 4:
                System.out.println("Digite o Id do ator a ser editado: ");
                int idAtorEditar = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o novo e-mail: ");
                String novoEmailAtor = scanner.nextLine();

                if (ator.editarRegistro(idAtorEditar, novoEmailAtor)) {
                    System.out.println("Ator editado com sucesso!");
                } else {
                    System.out.println("Erro ao editar o ator. Certifique-se de que o Id está correto");
                }
                break;

            case 0:
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("Opção inválida!");
        }

    } while (opcao != 0);



 }

 private static void menuFuncionario(Scanner scanner, Funcionario funcionario) {
    int opcao;
    do {
        System.out.println("\n=== Gerenciar Funcionários ===");
        System.out.println("1- Cadastrar Funcionário");
        System.out.println("2- Listar Funcionários");
        System.out.println("0- Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome do funcionário: ");
                String nomeFuncionario = scanner.nextLine();
                System.out.print("Digite o cpf do funcionário: ");
                String cpfFuncionario = scanner.nextLine();
                System.out.println("Digite o email do funcionário: ");
                String emailFuncionario = scanner.nextLine();

                Funcionario novoFuncionario = new Funcionario(nomeFuncionario, cpfFuncionario, emailFuncionario);
                if (novoFuncionario.salvar()) {
                    System.out.println("Funcionário cadastrado com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar o funcionário.");
                }
                break;
            case 2:
                ArrayList<String[]> funcionariosListar = funcionario.listarFuncionarios();
                System.out.println("\n=== Lista de Funcionários ===");
                for (String[] f : funcionariosListar) {
                    System.out.println(String.format("Id: %s | Nome: %s | E-mail: %s", f[0], f[1], f[2]));
                }
                break;
           
            case 0:
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida!");
        }

    } while (opcao != 0);
}


private static void inicializarInfraestrutura(Sala sala, Assento assento, SalaAssento salaAssento, TipoAssento tipoAssento) {
    System.out.println("\n=== Inicializando Infraestrutura ===");

    Sala novaSala = new Sala(100, "Sala VIP");
    if (novaSala.salvar()) {
        System.out.println("Sala criada: " + novaSala.getDescricao());
    }
    TipoAssento tipo1 = new TipoAssento("Premium");
    TipoAssento tipo2 = new TipoAssento("Normal");
    tipo1.salvar();
    tipo2.salvar();

    Assento assento1 = new Assento(tipo1);
    Assento assento2 = new Assento(tipo2);
    assento1.salvar();
    assento2.salvar();

    SalaAssento salaAssento1 = new SalaAssento(assento1, novaSala);
    SalaAssento salaAssento2 = new SalaAssento(assento2, novaSala);
    salaAssento1.salvar();
    salaAssento2.salvar();

    System.out.println("Infraestrutura inicializada com sucesso.");
}

private static void processarIngressos(Ingresso ingresso) {
    System.out.println("\n=== Processando Ingressos ===");
    Sala sala = new Sala(150, "4dx");
    Genero generoSaw = new Genero("Gor");
    Filme filmeIngresso = new Filme("Jogos Mortais", 18, generoSaw);
    Funcionario funcionarioIngresso = new Funcionario("123", "Carlos", "carlos@email.com");
    
    Sessao sessao = new Sessao(LocalDateTime.now(), filmeIngresso, sala, funcionarioIngresso);
    TipoAssento tipoAssento = new TipoAssento("Cadeira que vibra");
    Assento assento = new Assento(tipoAssento);
    SalaAssento salaAssento = new SalaAssento(assento, sala);


    Ingresso novoIngresso = new Ingresso(50.0, salaAssento, sessao);
    if (novoIngresso.salvar()) {
        System.out.println("Ingresso registrado: " + novoIngresso.getSessao().getFilme().getTitulo());
    }

    // Listar ingressos
    ArrayList<String[]> ingressos = ingresso.listarIngressos();
    System.out.println("\n=== Lista de Ingressos ===");
    for (String[] i : ingressos) {
        System.out.println(String.format("Id: %s | Filme: %s | Sala: %s | Assento: %s | Preço: %.2f", i[0], i[1], i[2], i[3], Double.parseDouble(i[4])));
    }

    inicializarInfraestrutura(sala, assento, salaAssento, tipoAssento);
    processarIngressos(ingresso);
}





 
}
