package ru.nsu.fit.ejsvald.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.ejsvald.server.MessagesList;
import ru.nsu.fit.ejsvald.server.data.MessageInfo;

@RestController
public class DefaultController {
    private final MessagesList messagesList = new MessagesList();
    @GetMapping("/getMessages/{num}")
    public MessageInfo getMessages(@PathVariable("num") int num) {
        synchronized (messagesList) {
            return messagesList.getFrom(num);
        }
    }
    @PostMapping("/postMessage/{name}/{message}")
    public void addMessage(@PathVariable String name, @PathVariable String message) {
        synchronized (messagesList) {
            messagesList.add(name, message);
        }
    }
}
