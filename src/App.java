public class App {
    public static void main(String[] args) throws Exception {
        Genero terror = new Genero(1, "terror", "ok");
        Genero romance = new Genero(2, "romance", "ok");
        Genero drama = new Genero(3, "drama", "ok");
        terror.inserir();
        romance.inserir();
        drama.inserir();

        terror.listar();
       
    }
}
