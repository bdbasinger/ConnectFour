package four;

public class ApplicationRunner {
    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        new ResetListener(game);
    }
}