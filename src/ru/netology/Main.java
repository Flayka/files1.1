package ru.netology;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        File src = new File("C://Games", "src");
        if (src.mkdir()) {
            text.append("Директория src создана\n");
        }
        File res = new File("C://Games", "res");
        if (res.mkdir()) {
            text.append("Директория res создана\n");
        }
        File savegames = new File("C://Games", "savegames");
        if (savegames.mkdir()) {
            text.append("Директория savegames создана\n");
        }
        File temp = new File("C://Games", "temp");
        if (temp.mkdir()) {
            text.append("Директория temp создана\n");
        }

        File main = new File("C://Games/src", "main");
        if (main.mkdir()) {
            text.append("Директория main создана в папке src\n");
        }
        File test = new File("C://Games/src", "test");
        if (test.mkdir()) {
            text.append("Директория test создана в папке src\n");
        }

        File mainJava = new File("C://Games/src/main", "Main.java");
        try {
            if (mainJava.createNewFile()) {
                text.append("Файл Main.java создан в папке C://Games/src/main\n");
            }
        } catch (IOException e) {
            text.append("Ошибка. Файл Main.java не создан\n");
        }

        File utilsJava = new File("C://Games/src/main", "Utils.java");
        try {
            if (utilsJava.createNewFile()) {
                text.append("Файл Utils.java создан в папке C://Games/src/main\n");
            }
        } catch (IOException e) {
            text.append("Ошибка. Файл Utils.java не создан\n");
        }

        File drawables = new File("C://Games/res", "drawables");
        if (drawables.mkdir()) {
            text.append("Директория drawables создана в папке res\n");
        }
        File vectors = new File("C://Games/res", "vectors");
        if (vectors.mkdir()) {
            text.append("Директория vectors создана в папке res\n");
        }
        File icons = new File("C://Games/res", "icons");
        if (icons.mkdir()) {
            text.append("Директория icons создана в папке res\n");
        }
        File textTxt = new File("C://Games/temp", "text.txt");
        try {
            if (textTxt.createNewFile()) {
                text.append("Файл text.txt создан в папке tmp\n");
            }
        } catch (IOException e) {
            text.append("Ошибка. Файл text.txt не создан\n");
        }

        try {
            FileWriter writeTxt = new FileWriter("C://Games/temp/text.txt", false);
            writeTxt.write(text.toString());
            writeTxt.flush();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл text.txt\n");
        } finally {
            System.out.println("Информация записана в файл text.txt");
        }
    }
}
