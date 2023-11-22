import java.util.HashMap;

public class Checkers {

    int rows = 8;
    int columns = 8;
    String[][] board = new String[rows][columns];
    int[][] cell = new int[rows][columns];
    String w = "x";
    String b = "o";
    HashMap<Character, Integer> letterMap = new HashMap<>();

    public void init() {
        board[0][1]=w;
        board[0][3]=w;
        board[0][5]=w;
        board[0][7]=w;
        board[1][0]=w;
        board[1][2]=w;
        board[1][4]=w;
        board[1][6]=w;
        board[2][1]=w;
        board[2][3]=w;
        board[2][5]=w;
        board[2][7]=w;
        board[5][0]=b;
        board[5][2]=b;
        board[5][4]=b;
        board[5][6]=b;
        board[6][1]=b;
        board[6][3]=b;
        board[6][5]=b;
        board[6][7]=b;
        board[7][0]=b;
        board[7][2]=b;
        board[7][4]=b;
        board[7][6]=b;

        //0-white cell, 1-black cell
        cell[0][1]=1;
        cell[0][3]=1;
        cell[0][5]=1;
        cell[0][7]=1;
        cell[1][0]=1;
        cell[1][2]=1;
        cell[1][4]=1;
        cell[1][6]=1;
        cell[2][1]=1;
        cell[2][3]=1;
        cell[2][5]=1;
        cell[2][7]=1;
        cell[3][0]=1;
        cell[3][2]=1;
        cell[3][4]=1;
        cell[3][6]=1;
        cell[4][1]=1;
        cell[4][3]=1;
        cell[4][5]=1;
        cell[4][7]=1;
        cell[5][0]=1;
        cell[5][2]=1;
        cell[5][4]=1;
        cell[5][6]=1;
        cell[6][1]=1;
        cell[6][3]=1;
        cell[6][5]=1;
        cell[6][7]=1;
        cell[7][0]=1;
        cell[7][2]=1;
        cell[7][4]=1;
        cell[7][6]=1;

        letterMap.put('a', 0);
        letterMap.put('b', 1);
        letterMap.put('c', 2);
        letterMap.put('d', 3);
        letterMap.put('e', 4);
        letterMap.put('f', 5);
        letterMap.put('g', 6);
        letterMap.put('h', 7);
    }

    public void move(int iFrom, int jFrom, int iTo, int jTo){
        String figure = board[iFrom][jFrom];
        if(figure == null)
            throw new IllegalArgumentException("No such figure");
        if(iFrom == iTo || jFrom == jTo)
            throw new IllegalArgumentException("Incorrect move");
        if(board[iTo][jTo] != null)
            throw new IllegalArgumentException("Incorrect move");

        if(figure.equals(w)){
            if(iTo<=iFrom)
                throw new IllegalArgumentException("Incorrect move");
        }

        if(figure.equals(b)){
            if(iTo>=iFrom)
                throw new IllegalArgumentException("Incorrect move");
        }

        if(cell[iTo][jTo] == 0)
            throw new IllegalArgumentException("Incorrect move");

        int step = Math.abs(iFrom-iTo);
        if(step > 2)
            throw new IllegalArgumentException("Incorrect move");

        if(step == 2){
            //check for deletion
            int iOpponent;
            int jOpponent;
            if(iTo>iFrom)
                iOpponent = iFrom + 1;
            else iOpponent = iTo + 1;

            if(jTo>jFrom)
                jOpponent = jFrom + 1;
            else jOpponent = jTo + 1;

            if(board[iOpponent][jOpponent].equals(figure))
                throw new IllegalArgumentException("Incorrect move");
            else board[iOpponent][jOpponent]=null;

        }

        board[iFrom][jFrom] = null;
        board[iTo][jTo] = figure;

    }

    public void move(String input) {
        if(input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("Incorrect parameters");
        input = input.replace(" ", "");
        int jFrom = letterMap.get(input.charAt(0));
        int iFrom = Integer.parseInt(String.valueOf(input.charAt(1))) - 1;

        int iTo = Integer.parseInt(String.valueOf(input.charAt(3))) - 1;
        int jTo = letterMap.get(input.charAt(2));

        move(iFrom, jFrom, iTo, jTo);
    }

    public void drawBoard(){
        System.out.println("   a b c d e f g h");
        System.out.println("  -----------------");
        StringBuilder sb = new StringBuilder();
        String cell;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(j==0)
                    sb.append(i+1+" |");
                cell = board[i][j];
                if(cell != null)
                    sb.append(cell + "|");
                else sb.append(" |");
            }
            System.out.println(sb);
            sb.setLength(0);
        }

        System.out.println("  -----------------");
        System.out.println("   a b c d e f g h");
    }
}



