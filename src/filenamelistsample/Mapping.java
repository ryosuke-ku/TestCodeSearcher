package filenamelistsample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mapping {

    public static void main(String args[]) throws IOException {

        String file_path = "C:\\Users\\ryosuke-ku\\Desktop\\Java_Practice\\test.txt";
        List<String> lines = new ArrayList<String>();

        // 1行ずつファイルを読み込んで list に格納する
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.substring(line.lastIndexOf("/")+1 , line.length());
                lines.add(line);
            }
      }
      System.out.println(lines);
        return;
    }
}