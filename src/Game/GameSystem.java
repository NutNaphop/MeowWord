package Game;


import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 *
 * @author Windows 10
 */
public class GameSystem {

    private Map<Integer, Map<String, String>> WordList;
    private int Hi_score;
    private List<Integer> numberList;
    private int currentIndex;
    private FileHandler fl;
    private static Clip clip;
    private static Clip backgroundMusicClip ; 
    
    public GameSystem() {
        fl = new FileHandler();
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
        for (int i = 1; i <= fl.getLenght(); i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
//        System.out.println(numberList.size());
        currentIndex = 0;
    }

    public int getNextRandomNumber() {
        if (currentIndex < numberList.size()) {
            return numberList.get(currentIndex++);
        } else {
//            System.out.println("OUT");
            return -1; // Indicate that all numbers have been used
        }
    }

    public static void playSound(String soundFilePath) {
        try {
            clip = AudioSystem.getClip();
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playBackgroundMusic(String soundFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath));
            backgroundMusicClip = AudioSystem.getClip();
            backgroundMusicClip.open(audioInputStream);
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopBackgroundMusic() {
        if (backgroundMusicClip != null && backgroundMusicClip.isRunning()) {
            backgroundMusicClip.stop();
        }
    }

    public static void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void Delay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

class Ingame extends GameSystem {

    private JRootPane Screen;
    private String thWord;
    private String EngWord1;
    private String EngWord2;
    private String answer;
    private int score , hiscore;
    
    public int genQuestion() {
        int index_question = getNextRandomNumber();
        System.out.println(index_question);
        if (index_question == -1) {
//            System.out.println("Out");
            return -1;
        }
        try {
            Map<Integer, Map<String, String>> wordListMap = getWordList();
            Map<String, String> innerMap = wordListMap.get(index_question);
            wordListMap.remove(index_question);
            thWord = innerMap.get("THword");
            EngWord1 = innerMap.get("ENGword1");
            EngWord2 = innerMap.get("ENGword2");
            answer = innerMap.get("Answer");
        } catch (NullPointerException e) {
            System.out.println("Can not find a key");
            System.out.println(e);
        }
        return 1;
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

    public void setPanel(JRootPane jp) {
        Screen = jp;
    }

    public int getScore() {
        return score;
    }

    public JRootPane getPanel() {
        return Screen;
    }

    public void increaseScore() {
        score++;
    }

    public boolean checkAns(String ans) {
        Ingame ig = new Ingame();
//        System.out.println(answer);
        if (ans.equals(answer)) {
            increaseScore();
//            System.out.println("True");
            return true;
        }
//        System.out.println("False");
        return false;
    }

    public void gameOver(JRootPane jp, String score) {
//        JOptionPane.showMessageDialog(jp.getParent(), "Hello");
        Object[] options = {"OK"};
        hiscore = (Integer.parseInt(score) > getHiScore())? Integer.parseInt(score) : getHiScore() ; 
        int a = JOptionPane.showOptionDialog(
                jp.getParent(),
                "Game Over" + "\nYour Score : " + score + "\nHigh-Score : " + hiscore,
                "It's end!!!",
                JOptionPane.YES_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,
                options,
                options[0]
        );
        if (a == 0 || a == -1) {
            if (Integer.parseInt(score) > getHiScore()) {
                FileHandler.WriteHighScore(score); // Write New Hi - Score
            }
        }
    }

    public void gameOver() {
        Object[] options = {"OK"};
        hiscore = (score > getHiScore()) ? score : getHiScore() ; 
        int a = JOptionPane.showOptionDialog(
                this.Screen,
                "Game Over" + "\nYour Score : " + score + "\nHigh-Score : " + hiscore,
                "It's end!!!",
                JOptionPane.YES_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,
                options,
                options[0]
        );
        System.out.println(a);
    }

    public void winGame(JRootPane jp, String score) {
        Object[] options = {"OK"};
        int a = JOptionPane.showOptionDialog(
                jp.getParent(),
                "Congratulation You Win!!!" + "\nYour Score : " + score + "\nHigh-Score : " + getHiScore(),
                "Game is ending!!!",
                JOptionPane.YES_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,
                options,
                options[0]
        );
        if (a == 0 || a == -1) {
            if (Integer.parseInt(score) > getHiScore()) {
                FileHandler.WriteHighScore(score); // Write New Hi - Score
            }
        }
    }
}

class Animation {

    private int init_x_player, init_y_player;
    private int init_x_enemy, init_y_enemy;
    private int x_player, y_player;
    private int x_enemy, y_enemy;
    private int isCol;
    private Timer timer;
    private volatile int animationState;
    private Ingame ig;
    private JFrame jf;

    public void setInit(JLabel player, JLabel enemy) {
        ig = new Ingame();
        jf = new JFrame();
        init_x_player = player.getX();
        init_y_player = player.getY();
        init_x_enemy = enemy.getX();
        init_y_enemy = enemy.getY();
        System.out.println(init_x_enemy);
    }

    public void setPosition() {
        x_player = init_x_player;
        y_player = init_y_player;
        x_enemy = init_x_enemy;
        y_enemy = init_y_enemy;
    }

    public void setEnemy(int x) {
        x_enemy = x;
    }

    public boolean calculateDistance(JLabel player, JLabel enemy) {
        int player_dis = player.getX() + 10;
        int enemy_dis = enemy.getX();
        if (player_dis >= enemy_dis) {
            System.out.println("Game Over");
            return true;
        }
        return false;
    }

    public void playAnimation(JLabel player, JLabel enemy, JRootPane jp, String score, JFrame jf) {
        timer = new Timer(1000, e -> moveEnemy(player, enemy, (Timer) e.getSource(), jp, score, jf));
        startAnimation();

    }

    public void startAnimation() {
        animationState = 1;
        timer.start();
    }

    public void stopAndResetAnimation() {
        timer.stop();
        x_enemy = init_x_enemy;
    }

    public void moveEnemy(JLabel player, JLabel enemy, Timer timer, JRootPane jp, String score, JFrame jf) {
        x_enemy -= 30;
        enemy.setBounds(x_enemy, y_enemy, enemy.getWidth(), enemy.getHeight());

        isCol = calculateDistance(player, enemy) ? 1 : 0;
        if (isCol > 0) {
            animationState = 0;
            timer.stop();
            GameSystem.playSound("resources\\Sound\\GameOverBeep.wav");
            GameSystem.playSound("resources\\Sound\\gameOverCat.wav");
            ig.gameOver(jp.getRootPane(), String.valueOf(score));
            System.out.println("OVER");
            HomeJFrame hf = new HomeJFrame();
            jf.dispose();
            GameSystem.stopSound();
            GameSystem.stopSound();
            hf.show();
        }
    }
}

//class Main {
//
//    public static void main(String[] args) {
//        Ingame ga = new Ingame();
//        ga.RandomNumberGenerator();
//        ga.genQuestion();
//
//    }
//}
