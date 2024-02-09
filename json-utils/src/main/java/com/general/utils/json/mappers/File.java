package com.general.utils.json.mappers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class provides utility methods for handling JSON files.
 */
public class File {
    /**
     * Maps JSON file to JsonNode.
     *
     * @param filePath The path to the JSON file.
     * @return JsonNode representing the JSON data.
     * @throws IOException if an I/O error occurs while reading the file or parsing the JSON.
     */
    public static JsonNode mapToJson(final String filePath) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(jsonData);
    }
}
