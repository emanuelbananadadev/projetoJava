public class App {
    public static void main(String[] args) throws Exception {
        Genero genero1 =new Genero(1, "terror", "Ativo");
        Genero genero2 = new Genero(2, "drama", "Ativo");
        Genero genero3 = new Genero(3, "romance", "Ativo");

        genero1.inserir();
        genero2.inserir();
        genero3.inserir();

        genero1.listar();
       
    }
}
