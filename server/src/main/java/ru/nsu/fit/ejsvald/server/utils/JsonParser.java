package ru.nsu.fit.ejsvald.server.utils;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class JsonParser {
    public static JsonObject parse(String jsonData) {
       return Json.createReader(new StringReader(jsonData)).readObject();
        //return Json.createReader(new ByteArrayInputStream(jsonData.getBytes(StandardCharsets.UTF_8))).readObject();
    }
}
