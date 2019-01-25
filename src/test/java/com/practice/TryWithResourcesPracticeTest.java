package com.practice;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TryWithResourcesPracticeTest {

    private TryWithResourcesPractice tryWithResources;
    private File   firstlineFile;
    private File   nonExistantFile;
    private File   inFile;
    private File   outFile;
    private String defaultValue;
    private String pathToFirstline;
    private String pathToNonExistantFile;
    private String resultOfFirstLineFile;
    private String resultOfNonExistantFile;

    @Before
    public void setup() {
        firstlineFile           = new File("src/test/resources/firstline.txt");
        nonExistantFile         = new File("asfdasdfasdfasdfasdf.txt");
        defaultValue            = "no file here";
        pathToFirstline         = firstlineFile.getAbsolutePath();
        pathToNonExistantFile   = nonExistantFile.getAbsolutePath();
        resultOfFirstLineFile   = tryWithResources.firstLineOfFile(pathToFirstline, defaultValue);
        resultOfNonExistantFile = tryWithResources.firstLineOfFile(pathToNonExistantFile, defaultValue);
    }

    @Test
    public void firstLineTestFileExists() {
        assertNotNull(firstlineFile);
    }

    @Test
    public void firstLineOfFileLoadsTheRightLine() {
        assertEquals("I'm the first line", resultOfFirstLineFile);
    }

    @Test
    public void nonExistantFileReturnsDefaultValue() {
        assertEquals(defaultValue, resultOfNonExistantFile);
    }

    @Test
    public void copy() throws IOException {
        TryWithResourcesPractice.copy(
                new File("src/test/resources/in.txt").getAbsolutePath(),
                new File("src/test/resources/out.txt").getAbsolutePath());
        assertEquals(
                TryWithResourcesPractice.firstLineOfFile(
                        new File("src/test/resources/in.txt").getAbsolutePath(),
                        defaultValue
                ),
                TryWithResourcesPractice.firstLineOfFile(
                        new File("src/test/resources/out.txt").getAbsolutePath(),
                        defaultValue
                ));
    }
}