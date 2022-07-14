package com.provenir.robobob.storage;

import java.io.*;
import java.util.*;

/**
 * The type File storage.
 */
public class FileStorage extends BaseStorage{

    private String filePath;

    /**
     * Instantiates a new File storage.
     *
     * @param filePath the file path
     */
    public FileStorage(String filePath){
        this.filePath = filePath;
    }

    /**
     * Gets file path.
     *
     * @return the file path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets file path.
     *
     * @param filePath the file path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getQuestionList() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filePath);
        List<String> stringList = readFromInput(inputStream);
        return parseStringList(stringList);
    }

    /**
     * Read lines from InputStream.
     *
     * @param inputStream The InputStream to read from.
     * @return The List of strings read from the inputStream.
     */
    private List<String> readFromInput(InputStream inputStream) {
        List<String> stringList = new ArrayList<>(Collections.emptyList());
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    /**
     * Takes the list of strings and parses it into a list of Question and Answers.
     * @param stringList The string list to parse.
     * @return Returns the list of Questions and Answers.
     */
    private Map<String, String> parseStringList(List<String> stringList) {
        Map<String, String> questionList = new HashMap<>();
        for (String line : stringList) {
            String[] parts = line.split("\\|");
            questionList.put(parts[0], parts[1]);
        }
        return questionList;
    }
}
