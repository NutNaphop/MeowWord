package Game;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author Windows 10
 */
public class GameSystem {

    private Map<Integer, Map<String, String>> WordList;
    private int Hi_score;
    private List<Integer> numberList;
    private int currentIndex;
    
    public GameSystem() {
        FileHandler fl = new FileHandler();
        WordList = fl.getWordList();
        Hi_score = fl.getHiscore();
    }

    public void setHiscore(JLabel jb) {
        jb.setText(String.valueOf(Hi_score));
    }

    public int getHiScore() {
        return Hi_score;
    }

    public Map getWordList() {
        return WordList;
    }

    public void RandomNumberGenerator() {
        numberList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        System.out.println(numberList);
        currentIndex = 0;
    }

    public int getNextRandomNumber() {
        if (currentIndex < numberList.size()) {
            return numberList.get(currentIndex++);
        } else {
            return -1; // Indicate that all numbers have been used
        }
    }
}

class Ingame extends GameSystem {

    private String thWord;
    private String EngWord1;
    private String EngWord2;
    private String answer;
    private int score;

    public void genQuestion() {
        Map<Integer, Map<String, String>> wordListMap = getWordList();
        Map<String, String> innerMap = wordListMap.get(getNextRandomNumber());
        System.out.println(innerMap);
        thWord = innerMap.get("THword");
        EngWord1 = innerMap.get("ENGword1");
        EngWord2 = innerMap.get("ENGword2");
        answer = innerMap.get("Answer");
    }

    public void setEngButton1(JButton jb) {
//        System.out.println(EngWord1);
        jb.setText(EngWord1);
    }

    public void setEngButton2(JButton jb) {
        jb.setText(EngWord2);
    }

    public void setWord(JLabel jb) {
        jb.setText(thWord);
    }

    public void setScore(JLabel jb) {
        jb.setText(String.valueOf(score));
    }

    public void increaseScore() {
        score++;
    }

    public boolean checkAns(String ans) {
        Ingame ig = new Ingame();
//        System.out.println(answer);
        if (ans.equals(answer)) {
            increaseScore();
            System.out.println("True");
            return true;
        }
        System.out.println("False");
        return false;
    }

    public void gameOver(JRootPane jp , String score) {
//        JOptionPane.showMessageDialog(jp.getParent(), "Hello");
        Object[] options = {"OK"};
        int a = JOptionPane.showOptionDialog(
                jp.getParent(),
                "Game Over" + "\nYour Score : " + score + "\nHigh-Score : " + getHiScore(),
                "It's end!!!",
                JOptionPane.YES_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,
                options,
                options[0]
        );
        if (a == 0 || a == -1){
            if (Integer.parseInt(score) > getHiScore()){
                FileHandler.WriteHighScore(score); // Write New Hi - Score
            }
        }
    }
}

class Main {

    public static void main(String[] args) {
        Ingame ga = new Ingame();
        ga.RandomNumberGenerator();
        ga.genQuestion();

    }
}
