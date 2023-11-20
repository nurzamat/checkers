
public class Checkers {

    int rows = 8;
    int columns = 8;
    String[][] board = new String[rows][columns];
    String w = "w";
    String b = "b";

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
    }

    public void move(int iFrom, int jFrom, int iTo, int jTo){
        String figure = board[iFrom][jFrom];
        if(figure == null || figure.isEmpty())
            throw new IllegalArgumentException("No such figure");
        if(board[iTo][jTo] != null && !board[iTo][jTo].trim().isEmpty())
            throw new IllegalArgumentException("Incorrect moving");

        board[iFrom][jFrom] = "";
        board[iTo][jTo] = figure;

        drawBoard();
    }

    public void drawBoard(){
        System.out.println("   1 2 3 4 5 6 7 8");
        StringBuilder sb = new StringBuilder();
        String cell;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(j==0)
                    sb.append(i+1+" |");
                cell = board[i][j];
                if(cell != null && !cell.isEmpty())
                    sb.append(cell + "|");
                else sb.append(" |");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
