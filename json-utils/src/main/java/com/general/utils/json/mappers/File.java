package com.general.utils.json.mappers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * This class provides utility methods for handling JSON files.
 */
@Slf4j
public class File {
    /**
     * Maps JSON file to JsonNode.
     *
     * @param filePath The path to the JSON file.
     * @return JsonNode representing the JSON data.
     * @throws IOException if an I/O error occurs while reading the file or parsing the JSON.
     */
    public static Optional<JsonNode> mapToJson(final String filePath) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
            ObjectMapper objectMapper = new ObjectMapper();
            return Optional.of(objectMapper.readTree(jsonData));
        } catch (IOException e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }
}
