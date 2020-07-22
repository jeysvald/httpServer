package ru.nsu.fit.ejsvald.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.ejsvald.server.MessagesList;
import ru.nsu.fit.ejsvald.server.UsersDB;
import ru.nsu.fit.ejsvald.server.data.MessageInfo;
import ru.nsu.fit.ejsvald.server.utils.JsonParser;

import javax.json.JsonObject;

@RestController
public class DefaultController {

    private final MessagesList messagesList = new MessagesList();
    private final UsersDB usersDB = new UsersDB();

    @RequestMapping(value = "/getMessage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "Accept=application/json")
    public MessageInfo getMessages(@RequestBody String jsonData) {
        JsonObject jsonObj = JsonParser.parse(jsonData);
        int num = jsonObj.getInt("number");
        String login = jsonObj.getString("login");
        String password = jsonObj.getString("password");
        boolean hasLoggedIn = usersDB.authentication(login, password);
        if (hasLoggedIn) {
            synchronized (messagesList) {
                return messagesList.getFrom(num);
            }
        }
        return new MessageInfo(num, "login error");
    }

    @RequestMapping(value = "/addMessage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "Accept=application/json")
    public void addMessage(@RequestBody String jsonData) {
        JsonObject jsonObj = JsonParser.parse(jsonData);
        String message = jsonObj.getString("message");
        String login = jsonObj.getString("login");
        String password = jsonObj.getString("password");
        if (!usersDB.authentication(login, password)) {
            return;
        }
        synchronized (messagesList) {
            messagesList.addMessage(login, message);
        }
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "Accept=application/json")
    public String signIn(@RequestBody String jsonData) {
        JsonObject jsonObj = JsonParser.parse(jsonData);
        String login = jsonObj.getString("login");
        String password = jsonObj.getString("password");
        boolean hasLoggedIn = usersDB.authentication(login, password);
        if (hasLoggedIn) {
            messagesList.addInfo(login + " has been connected");
            return "true";//исправить
        }
        return "false";
    }
}
