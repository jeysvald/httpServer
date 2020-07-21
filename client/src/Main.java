import data.MessageInfo;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Network server = new Network("http://localhost:8080");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        new Thread(new Listener()).start();
        while(true) {
            String message = in.nextLine();
            server.addMessage(name, message);
        }
    }
}
