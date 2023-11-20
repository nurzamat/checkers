import java.util.Scanner;

public class Main {

public static void main(String[] args){

    Checkers checkers = new Checkers();
    checkers.init();
    checkers.drawBoard();

    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter coordinates in format row1column1 row2column2 to move a figure");

    String coordinates = myObj.nextLine();  // Read user input
    String[] array = coordinates.split(" ");
    int iFrom = Integer.parseInt(String.valueOf(array[0].charAt(0))) - 1;
    int jFrom = Integer.parseInt(String.valueOf(array[0].charAt(1))) - 1;
    int iTo = Integer.parseInt(String.valueOf(array[1].charAt(0))) - 1;
    int jTo = Integer.parseInt(String.valueOf(array[1].charAt(1))) - 1;

    checkers.move(iFrom, jFrom, iTo, jTo);
}

}
