import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Genero genero = new Genero();
       Filme filme = new Filme();

       int opcao;

       do {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1- Gerenciar Filmes");
        System.out.println("0- Sair");
        System.out.println("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao) {
            case 1:
                menuFilme(scanner, filme, genero);
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

//     private static void menuGenero(Scanner scanner, Genero genero) {
//         int opcao;

//         do {
//             System.out.println("\n=== Gerenciar Gêneros ===");
//             System.out.println("1- Cadastrar Gênero");
//             System.out.println("2- Listar Gêneros");
//             System.out.println("3- Editar Gênero");
//             System.out.println("0- Voltar ao menu principal");
//             System.out.println("Escolha uma opção: ");

//             opcao = scanner.nextInt();
//             scanner.nextLine();

//             switch(opcao) {
//                 case 1: 
//                     System.out.println("Digite o Id do gênero: ");
//                     int idGenero = scanner.nextInt();
//                     scanner.nextLine();

//                     System.out.println("Digite a descrição do gênero: ");
//                     String descricaoGenero = scanner.nextLine();

//                     Genero novoGenero = new Genero(idGenero, descricaoGenero);

//                     if(novoGenero.salvar()) {
//                         System.out.println("Gênero cadastrado com sucesso!");
//                     } else {
//                         System.out.println("Erro ao cadastrar o gênero");
//                     }
//                     break;
//                 case 2:
//                     ArrayList<String[]> generos = genero.listarGeneros();
//                     System.out.println("\n=== Lista de Gêneros ===");
//                     for(String[] g : generos) {
//                         System.out.println(String.format("Id: %s | Descrição: %s | Status: %s%n", g[0], g[1], g[2]));
//                     }
//                     break;
//                 case 3:
//                     System.out.println("Digite o Id do gênero a ser editado: ");
//                     int idGeneroEditar = scanner.nextInt();
//                     scanner.nextLine();

//                     System.out.println("Digite a nova descrição: ");
//                     String novaDescricaoGenero = scanner.nextLine();

//                     if(genero.editarGenero(idGeneroEditar, novaDescricaoGenero)) {
//                         System.out.println("Gênero editado com sucesso!");
//                     } else {
//                         System.out.println("Erro ao editar o gênero");
//                     }
//                     break;
//                 case 0:
//                     System.out.println("Voltando ao menu principal...");
//                     break;
//                 default:
//                     System.out.println("Opção inválida!");
//             }
//         } while(opcao != 0);
//  }

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
}
