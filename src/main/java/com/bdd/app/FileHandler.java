package com.bdd.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class FileHandler implements Handler {

    private String fileName;

    private String content;


    @Override
    public void handle() throws Exception {
        System.out.println("Выберите действие:");
        System.out.println("1 - Записать одну строку в файл");
        System.out.println("2 - Записать список строк в файл");
        System.out.println("3 - Создать директорию");
        System.out.println("4 - Удалить директорию");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                writeStringToFile();
                break;
            case 2:
                writeStringsToFile();
                break;
            case 3:
                createDirectory();
                break;
            case 4:
                deleteDirectory();
                break;
            default:
                throw new Exception("Некорректное значение");
        }
    }

    public void readFileNameFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        setFileName(scanner.next());
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void writeToFile() throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append(content);
        }
    }

    private void writeStringToFile() throws IOException {
        readFileNameFromConsole();
        System.out.println("Введите строку:");
        setContent(new Scanner(System.in).next());
        writeToFile();
    }

    private void writeStringsToFile() throws IOException {
        readFileNameFromConsole();
        System.out.println("Введите строки(точка - окончание ввода):");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next();
        StringBuilder sb = new StringBuilder();
        while (data != null && !data.equals(".")) {
            sb.append(data).append("\n");
            data = scanner.next();
        }
        setContent(sb.toString());
        writeToFile();
    }

    private void createDirectory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя директории");
        String dirName = scanner.next();
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Директория существует.");
        } else if (dir.mkdirs()) {
            System.out.println("Директория создана.");
        } else {
            System.out.println("Директория не создана.");
        }
    }

    private void deleteDirectory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя директории");
        String dirName = scanner.next();
        File dir = new File(dirName);
        if (dir.exists()) {
            if (dir.isDirectory()) {
                try {
                    Files.deleteIfExists(dir.toPath());
                    System.out.println("Директория удалена.");
                } catch (IOException e) {
                    System.out.println("Невозможно удалить директорию");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Указанный файл не является дирректрией.");
            }
        } else {
            System.out.println("Директории не существует.");
        }
    }
}