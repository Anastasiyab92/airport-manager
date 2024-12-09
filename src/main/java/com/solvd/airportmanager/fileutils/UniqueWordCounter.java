package com.solvd.airportmanager.fileutils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueWordCounter {

    private static final Logger LOGGER = LogManager.getLogger(UniqueWordCounter.class);

    public static void countUniqueWords(File inputFile, File outputFile) {
        try {
            String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
            String[] words = StringUtils.split(content, " \n\r\t.,;:!?()[]\"'");
            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
            FileUtils.writeStringToFile(outputFile, "Count unique words: " + uniqueWords.size(), StandardCharsets.UTF_8);
            LOGGER.info("Count unique words: {}", uniqueWords.size());
        } catch (IOException e) {
            LOGGER.error("Error while working with files: ", e);
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/Nabokov_Lolita.txt");
        File outputFile = new File("src/main/resources/unique_words_count.txt");
        UniqueWordCounter.countUniqueWords(inputFile, outputFile);
    }
}
