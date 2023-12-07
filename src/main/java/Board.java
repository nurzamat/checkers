import java.util.HashMap;

public class Board {
    int rows = 8;
    int columns = 8;
    String[][] cell = new String[rows][columns];
    String w = "x";
    String b = "o";

    public void init() {
        cell[0][1]=w;
        cell[0][3]=w;
        cell[0][5]=w;
        cell[0][7]=w;
        cell[1][0]=w;
        cell[1][2]=w;
        cell[1][4]=w;
        cell[1][6]=w;
        cell[2][1]=w;
        cell[2][3]=w;
        cell[2][5]=w;
        cell[2][7]=w;
        cell[5][0]=b;
        cell[5][2]=b;
        cell[5][4]=b;
        cell[5][6]=b;
        cell[6][1]=b;
        cell[6][3]=b;
        cell[6][5]=b;
        cell[6][7]=b;
        cell[7][0]=b;
        cell[7][2]=b;
        cell[7][4]=b;
        cell[7][6]=b;
    }

    public void move(int iFrom, int jFrom, int iTo, int jTo){
        String figure = cell[iFrom][jFrom];
        if(figure == null)
            throw new IllegalArgumentException("No such figure");
        if(iFrom == iTo || jFrom == jTo)
            throw new IllegalArgumentException("Incorrect move");
        if(cell[iTo][jTo] != null)
            throw new IllegalArgumentException("Incorrect move");

        if(figure.equals(w)){
            if(iTo<=iFrom)
                throw new IllegalArgumentException("Incorrect move");
        }

        if(figure.equals(b)){
            if(iTo>=iFrom)
                throw new IllegalArgumentException("Incorrect move");
        }

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

            if(cell[iOpponent][jOpponent].equals(figure))
                throw new IllegalArgumentException("Incorrect move");
            else cell[iOpponent][jOpponent]=null;

        }

        cell[iFrom][jFrom] = null;
        cell[iTo][jTo] = figure;

    }

    public String[][] getCell(){
        return this.cell;
    }
}
