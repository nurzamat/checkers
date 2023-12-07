import java.util.HashMap;

public class BoardController {
    private Board model;
    private BoardView view;

    HashMap<Character, Integer> letterMap = new HashMap<>();

    public BoardController(Board model, BoardView view)
    {
        this.model = model;
        this.view = view;

        letterMap.put('a', 0);
        letterMap.put('b', 1);
        letterMap.put('c', 2);
        letterMap.put('d', 3);
        letterMap.put('e', 4);
        letterMap.put('f', 5);
        letterMap.put('g', 6);
        letterMap.put('h', 7);
    }

    public void init() {
        model.init();
    }
    public void move(String input) {
        if(input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("Incorrect parameters");
        input = input.replace(" ", "");
        int jFrom = letterMap.get(input.charAt(0));
        int iFrom = Integer.parseInt(String.valueOf(input.charAt(1))) - 1;

        int iTo = Integer.parseInt(String.valueOf(input.charAt(3))) - 1;
        int jTo = letterMap.get(input.charAt(2));

        model.move(iFrom, jFrom, iTo, jTo);
    }
    public void updateView()
    {
        view.drawBoard(model.getCell());
    }

}
