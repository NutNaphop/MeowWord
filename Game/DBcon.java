
package Game;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBcon {

    private int n_question;
    private String thWord, engWord1, engWord2, answer;
    private Map<Integer, Map<String, String>> wordMapList ;
    
    public DBcon() throws Exception{
        wordMapList = new HashMap<>() ;
        String url = "jdbc:sqlite:D:\\Naphop Coding\\Java\\Learning\\WordQuizGame\\test.db";
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


    public void showData(Map worObject) {
        for (Map.Entry<Integer, Map< String, String>> outerkey : wordMapList.entrySet()) {
            Map<String, String> valueMap = outerkey.getValue();
            for (String i : valueMap.keySet()) {
//                 System.out.println(i);
                System.out.println("Key " + outerkey.getKey() + " Subkey " + i + " Value " + valueMap.get(i));
            }
        }
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        DBcon cnb = new DBcon();
        cnb.showData(cnb.getWordList());
    }
}
