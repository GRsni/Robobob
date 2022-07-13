package com.provenir.robobob.storage;

import com.provenir.robobob.storage.types.QuestionAnswer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FileStorage extends BaseStorage{

    private String filePath;

    public FileStorage(String filePath){
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<QuestionAnswer> getQuestionList() {
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
    private List<QuestionAnswer> parseStringList(List<String> stringList) {
        List<QuestionAnswer> questionList = new ArrayList<>();
        for (String line : stringList) {
            String[] parts = line.split("\\|");
            questionList.add(new QuestionAnswer(parts[0], parts[1]));
        }
        return questionList;
    }
}