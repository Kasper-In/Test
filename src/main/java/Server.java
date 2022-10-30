import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Server {

    private final int SERVER_PORT;


    public Server(int server_port) {
        SERVER_PORT = server_port;
    }

    public void start() {

        Gson gson = new Gson();
        Purchase purchase;
        Set<Category> categories = new HashSet<>();
        File fileCategories = new File("categories.tsv");
        try (BufferedReader inBuffer = new BufferedReader(new FileReader(fileCategories))) {
            List<String> fileInfo = inBuffer.lines().collect(Collectors.toList());
            for (String fileLine: fileInfo) {
                Category category = new Category(fileLine.split("\t")[1]);

                categories.add(category);
                category.addValue(fileLine.split("\t")[0]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Сервер стартовал на порту " + SERVER_PORT + "...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    String request = in.readLine();
                    purchase = gson.fromJson(request, Purchase.class);

                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер :(");
            e.printStackTrace();
        }
    }
}
