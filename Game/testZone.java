package Game;


public class testZone {
    public static void main(String[] args)throws Exception{
        DBcon d = new DBcon() ; 
        d.showData(d.getWordList());
    }
}
