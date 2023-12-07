import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Board model = new Board();
        BoardView view = new BoardView();
        BoardController controller = new BoardController(model, view);
        controller.init();
        controller.updateView();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates in format column row column row, example b3a4");
        String coordinates;
        while(scanner.hasNextLine()) {
            try{
                coordinates = scanner.nextLine();  // Read user input
                controller.move(coordinates);
                controller.updateView();
            }
            catch (Exception e){
                System.out.println("Error occured, incorrect move");
            }
        }
    }

}
