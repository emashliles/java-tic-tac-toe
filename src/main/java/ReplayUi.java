import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ReplayUi {

    private final Scanner scanner;

    public ReplayUi(InputStream in) {
        scanner = new Scanner(in);
        scanner.useDelimiter("\n");
    }

    public boolean replay(PrintStream out) {
        out.print("Replay? y/n ");

        String selection = scanner.nextLine();

        while (!selection.equals("y") && !selection.equals("n")) {
            out.print("Please try that again y/n");
            selection = scanner.nextLine();
        }

        return chosenOption(selection);
    }

    private boolean chosenOption(String selection) {
        if(selection.equals("y")) {
            return true;
        }
        return false;
    }
}
