package com.co.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberRows = scanner.nextInt();
        String encoded = scanner.next();
        String decoded = decodeString(numberRows, encoded);
        System.out.println(decoded);
    }

    public static String decodeString(int numberOfRows, String encodedString){
        StringBuilder result = new StringBuilder();
        int columns = getColumn(numberOfRows, encodedString.length());
        int lines = columns - 1;

        char[][] parts = getParts(encodedString, numberOfRows, columns);

        int index = 0;
        while(index != lines) {
            int aux = index;
            for(int i = 0; i < numberOfRows; i++){
                if(aux < columns){
                    char value = parts[i][aux] == '_' ? ' ' : parts[i][aux];
                    result.append(value);
                    aux++;
                }

            }

            index++;
        }

        return result.toString();
    }

    public static int getColumn(int rows, int sizeString){
        int column = 0;
        while(column * rows != sizeString){
            column++;
        }
        return column;
    }

    public static char[][] getParts(String encoded, int rows, int columns){
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < encoded.length(); i += columns) {
            ret.add(encoded.substring(i, Math.min(encoded.length(), i + columns)));
        }

        char[][] result = new char[rows][columns];

        for(int i = 0; i < ret.size(); i++){
            for(int j = 0; j < columns; j++){
                result[i][j] = ret.get(i).charAt(j);
            }
        }

        return result;
    }
}
