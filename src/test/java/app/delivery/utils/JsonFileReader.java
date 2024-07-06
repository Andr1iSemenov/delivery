package app.delivery.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonFileReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static <T> T readFromFile(String filePath, Class<T> type) throws IOException {
        return objectMapper.readValue(type.getResourceAsStream(filePath), type);
    }
}
