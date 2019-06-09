package com.bdd.app;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileHandlerSteps {

    @Дано("У меня есть объект типа FileHandler")
    public void уМеняЕстьОбъектТипаFileHandler() {
        TestContext.instance = new FileHandler();
    }

    @Когда("Пользователь вводит {string} и вводит {string}")
    public void пользовательВводитИВводит(String fileName, String fileBody) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        TestContext.instance.setFileName(fileName);
        TestContext.instance.setContent(fileBody);
        TestContext.body = fileBody;
        TestContext.fileName = fileName;
        TestContext.instance.writeToFile();
    }

    @Тогда("Программа создает файл с указанным именем и содержащим строку")
    public void программаСоздаетФайлСУказаннымИменемИСодержащимСтроку() throws IOException {
        String actual = new String(Files.readAllBytes(Paths.get(TestContext.fileName)));
        assertEquals(TestContext.body, actual);
    }
}
