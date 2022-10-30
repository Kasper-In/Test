public class Main {

    public static void main(String[] args) {
        final int PORT = 8989;
        Server server = new Server(PORT);
        server.start();
    }
}
