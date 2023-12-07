public class BoardView {

    public void drawBoard(String[][] board){
        System.out.println("   a b c d e f g h");
        System.out.println("  -----------------");
        StringBuilder sb = new StringBuilder();
        String cell;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
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
