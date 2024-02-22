package Observer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ConsoleObserver implements Observer {
    private final PrintWriter writer;

    public ConsoleObserver() {
        this.writer = new PrintWriter(System.out, true);//ljy
    }

    @Override
    public void update(String message) {
        writer.println(message);
        writer.flush();
    }
}
