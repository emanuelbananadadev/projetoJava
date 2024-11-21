import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Genero genero1 = new Genero(1, "Drama");
        Genero genero2 = new Genero(2, "Terror");
        boolean resultado = genero1.inserir();
        genero2.inserir();

        if(resultado) {
            System.out.println("Gênero inserido com sucesso!");
        } else {
            System.out.println("Falha ao inserir gênero");
        }

        ArrayList<String> generos = genero1.listar();
        System.out.println(generos);

        if(!generos.isEmpty()) {
            System.out.println("Lista de gêneros: ");
            for(int i = 0; i < generos.size(); i+= 3) {
                System.out.println("Id: " + generos.get(i));
                System.out.println("Descrição: " + generos.get(i + 1));
                System.out.println("Status: " + generos.get( + 2));
                System.out.println("========================");
            }
        }

        Genero encontrado = genero1.consultar("Romance");
        if(encontrado.getId() != 0) {
            System.out.println("Gênero encontrado");
            System.out.println("Id: " + encontrado.getId());
            System.out.println("Descriçao: " + encontrado.getDescricao());
            System.out.println("Status: " + encontrado.getStatus());
        } else {
            System.out.println("Gênero não encontrado");
        }

        Genero generoEditado = new Genero();
        boolean editado = generoEditado.editar(1, "Romance");

        if(editado) {
            System.out.println("Gênero editado com sucesso!");
        } else {
            System.out.println("Falha ao editar o gênero");
        }

        ArrayList<String> listaAposEdicao = generoEditado.listar();
        for(int i = 0; i < listaAposEdicao.size(); i += 3) {
            System.out.println("Id: " + listaAposEdicao.get(i));
            System.out.println("Descrição: " + listaAposEdicao.get( + 1));
            System.out.println("Status: " + listaAposEdicao.get(i + 2));
            System.out.println("==================================");
        }
            
    }
}
