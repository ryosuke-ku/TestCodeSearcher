package filenamelistsample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ReadFile {
private static String fileName = "C:\\Users\\ryosuke-ku\\Desktop\\TestCodeSearcher\\TestCodeMap.txt"; //読み込みファイル名
    public static void main(String[] args) throws IOException{
    int k=0;
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

    BufferedReader br = new BufferedReader(
    new FileReader(fileName));
    TreeMap<String,String> tm = new TreeMap<String,String>();
    String line;
        while((line = br.readLine()) != null){
        //１：ファイルから文字列を読み込む

        String[] words = line.split(",|\\s");
        //２：文字列から単語を抽出する

            for(int i=0; i<words.length-1; i=i+2){
                tm.put(words[i],words[i+1]);
            }
        }
            for(int i=0; i<lines.size(); i++){
                System.out.println("["+i+"] " + tm.get(lines.get(i)));
                if(tm.get(lines.get(i))!=null){
                    k++;
                }
            }
        System.out.println("テストファイルの数: "+ k);
    }
}

