package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {

    private int n_question;
    private String thWord, engWord1, engWord2, answer;
    private Map<Integer, Map<String, String>> wordMapList;
    private int len;
    private int Highscore;

    public FileHandler() {
        try {
            ReadHighScore();
            wordMapList = new HashMap<>();

            String url = "jdbc:sqlite:resources/TextFile/WordDB.db";
            Connection conn = DriverManager.getConnection(url);
            String Sql = "Select * from test";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            while (rs.next()) {
                n_question = rs.getInt("ID");
                thWord = rs.getString("ThWord");
                engWord1 = rs.getString("Word1");
                engWord2 = rs.getString("Word2");
                answer = rs.getString("answer");
                storeData(n_question, thWord, engWord1, engWord2, answer);
                len++;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Cannot Connect to database Error : " + e);
        }

    }

    public void storeData(int n_quest, String thaiWord, String engWord1, String engWord2, String answer) {
        wordMapList.put(n_quest, new HashMap<>());
        wordMapList.get(n_quest).put("THword", thWord);
        wordMapList.get(n_quest).put("ENGword1", engWord1);
        wordMapList.get(n_quest).put("ENGword2", engWord2);
        wordMapList.get(n_quest).put("Answer", answer);
    }

    public Map getWordList() {
        return wordMapList;
    }

    public int getLenght() {
        return len;
    }

    public void showData(Map worObject) {
        for (Map.Entry<Integer, Map< String, String>> outerkey : wordMapList.entrySet()) {
            Map<String, String> valueMap = outerkey.getValue();
            for (String i : valueMap.keySet()) {
//                 System.out.println(i);
                System.out.println("Key " + outerkey.getKey() + " Subkey " + i + " Value " + valueMap.get(i));
            }
        }
    }

    public void ReadHighScore() {
        try {
            FileReader fr = new FileReader("resources/TextFile/HiScore.txt");
            BufferedReader br = new BufferedReader(fr);
            String lineText = br.readLine();
            Highscore = Integer.parseInt(lineText);
            lineText = br.readLine();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void WriteHighScore(String score) {
        try {
            FileWriter fw = new FileWriter("resources/TextFile/HiScore.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(score);
            System.out.println("Complete");
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getHiscore() {
        return Highscore;
    }
}

class Main {

    public static void main(String[] args) throws Exception {

        FileHandler cnb = new FileHandler();
        cnb.showData(cnb.getWordList());
        cnb.ReadHighScore();
    }
}
