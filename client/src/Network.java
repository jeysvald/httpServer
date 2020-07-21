import com.fasterxml.jackson.databind.ObjectMapper;
import data.MessageInfo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network {
    private final String urlString;
    private int ok;
    private int notOk;
    public Network(String urlString) {
        this.urlString = urlString;
    }

    private String sendToBase(String urlString, String method) {
        URL url;
        HttpURLConnection connection = null;
        while (true) {
            try {
                url = new URL(urlString);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod(method);
                connection.setDoInput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                if (connection.getInputStream() != null) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String data = br.readLine();//FIXME: read all lines
                    //System.out.println("OK!");
                    ok++;
                    //System.out.println("ok: " + ok + " notOk: " +notOk);
                    return data;
                } else {
                    ok++;
                    //System.out.println("ok: " + ok + " notOk: " +notOk);
                    return null;
                }
            } catch (IOException e) {
                System.out.println("NOT OK!");
                notOk++;
                System.out.println("ok: " + ok + " notOk: " +notOk);
                //e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("TIMER ERROR!");
                    //e.printStackTrace();
                }
            }
        }
//        try {
//            Thread.currentThread().wait(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //System.out.println("OK!");
        //return null;
    }

    public MessageInfo getMessage(int number) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = sendToBase(urlString + "/getMessages/" + number, "GET");
        MessageInfo toReturn = null;
        if (jsonString == null) {
            return null;
        }
        try {
            toReturn = mapper.readValue(new StringReader(jsonString), MessageInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public void addMessage(String name, String message) {
        sendToBase(urlString + "/postMessage/" + name + "/" + message, "POST");
    }
}
