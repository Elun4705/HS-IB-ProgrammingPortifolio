import java.util.Arrays;

public class ChessArray {
    public static void main(String[] args) {
       
        String[][] location = 
        {
            {"BPawn", "10", "20"},
            {"BPawn", "20", "20"},
            {"BPawn", "30", "20"},
            {"BPawn", "40", "20"},
            {"BPawn", "50", "20"},
            {"BPawn", "60", "20"},
            {"BPawn", "70", "20"},
            {"BPawn", "80", "20"},
            {"BCastle", "10", "10"},
            {"BKnight", "20", "10"},
            {"BBishop", "30", "10"},
            {"BKing", "40", "10"},
            {"BQueen", "50", "10"},
            {"BBishop", "60", "10"},
            {"BKnight", "70", "10"},
            {"BCastle", "80", "10"}
        };

        System.out.println(Arrays.deepToString(location));
    }
 }