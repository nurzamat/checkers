import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Checkers checkers = new Checkers();
        checkers.init();
        checkers.drawBoard();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates in format column row column row, example b3a4");
        String coordinates;
        while(scanner.hasNextLine()) {
            try{
                coordinates = scanner.nextLine();  // Read user input
                checkers.move(coordinates);
                checkers.drawBoard();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
