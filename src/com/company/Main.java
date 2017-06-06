
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] golos = new String[100];//массив слов на гласную букву
        int j= 0;

      //  String text = in.nextLine();

        StringBuffer sb = new StringBuffer(in.nextLine());//входная строка
        StringBuffer temp = new StringBuffer("");//строка для вывода
        char[] delimiters = new char[]{'.', ',', ' ', '?', '!', '-', '\t', '\n', '\r'}; //массив разделительных знаков

        //Подсчет лексем в строке

        int lexemeCount = 0;
        int lastLexemeStart = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (charIsDelimiter(sb.charAt(i), delimiters)) {
                if (i - lastLexemeStart > 0) {
                    lexemeCount++;
                }
                lastLexemeStart = i + 1;
            } else if (i == sb.length() - 1) {
                lexemeCount++;
            }
        }
        //Распределение строки в массив строк
        String[] masOfLexemes = new String[lexemeCount];
        lexemeCount = 0;
        lastLexemeStart = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (charIsDelimiter(sb.charAt(i), delimiters)) {
                if (i - lastLexemeStart > 0) {
                    masOfLexemes[lexemeCount] = sb.substring(lastLexemeStart, i);
                    lexemeCount++;
                }
                lastLexemeStart = i + 1;
            } else if (i == sb.length() - 1) {
                masOfLexemes[lexemeCount] = sb.substring(lastLexemeStart, i + 1);
            }
        }
        //распределение в массив слов на гласную букву
        for(int i = 0; i < masOfLexemes.length; ++i) {
            String str = masOfLexemes[i];
            if (str.length()!=1){
            if(str.charAt(0) == 97 || str.charAt(0) == 101 || str.charAt(0) == 105 || str.charAt(0) == 111 || str.charAt(0) == 117 || str.charAt(0) == 121) {
                golos[j] = str;
                ++j;
            }
            }
        }
        //сортировка по второй букве
        for(int p = 0; p < j; ++p) {
            for(int k = p + 1; k < j; ++k) {
                if(golos[k].charAt(1) < golos[p].charAt(1)) {
                    String t = golos[p];
                    golos[p] = golos[k];
                    golos[k] = t;
                }
            }
        }
        //запись в строку для вывода
        System.out.println(" ");
        for(int i = 0; i < j; ++i) {
            temp.append(golos[i]).append(" ");
        }
        //вывод
        System.out.println(temp);
    }
    //функция проверки на символ
    private static boolean charIsDelimiter(char c, char[] delimiters) {
        for (int i = 0; i < delimiters.length; i++) {
            if (c == delimiters[i]) {
                return true;
            }
        }
        return false;
    }
}
