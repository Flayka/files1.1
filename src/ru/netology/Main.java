package ru.netology;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        String path = File.separator + "Games";
        createDir(path, "src", text);
        createDir(path, "res", text);
        createDir(path, "savegames", text);
        createDir(path, "temp", text);
        createDir(path + File.separator + "src", "main", text);
        createDir(path + File.separator + "src", "test", text);

        createFile(path + File.separator + "src" + File.separator + "main", "Main.java", text);
        createFile(path + File.separator + "src" + File.separator + "main", "Utils.java", text);

        createDir(path + File.separator + "res", "drawables", text);
        createDir(path + File.separator + "res", "vectors", text);
        createDir(path + File.separator + "res", "icons", text);

        createFile(path + File.separator + "temp", "text.txt", text);

        try {
            FileWriter writeTxt = new FileWriter(path + File.separator + "temp" + File.separator + "text.txt", false);
            writeTxt.write(text.toString());
            writeTxt.flush();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл text.txt\n");
        } finally {
            System.out.println("Информация записана в файл text.txt");
        }
    }

    public static void createDir(String path, String nameDir, StringBuilder text) {
        File file = new File(path, nameDir);
        if (file.mkdir()) {
            text.append(String.format("Директория %s создана по адресу: %s\n", nameDir, path));
        }
    }

    public static void createFile(String path, String nameFile, StringBuilder text) {
        File mainJava = new File(path, nameFile);
        try {
            if (mainJava.createNewFile()) {
                text.append(String.format("Файл %s создан в папке %s\n", nameFile, path));
            }
        } catch (IOException e) {
            text.append(String.format("Ошибка. Файл %s не создан\n", nameFile));
        }
    }
}
