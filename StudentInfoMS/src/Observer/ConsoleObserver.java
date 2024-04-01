package Observer;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

public class ConsoleObserver implements Observer {
    private final PrintWriter writer;
    private static final String LOGS_DIRECTORY = "logs";
    private static final DateTimeFormatter DATE_FOLDER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("HH-mm-ss");

    private Path logFilePath;

    private boolean isFileNameInitialized = false;

    public ConsoleObserver() {
        this.writer = new PrintWriter(System.out, true);
    }

    @Override
    public void update(String message) {
        writer.println(message);
        writer.flush();

        if (!isFileNameInitialized) {
            LocalDateTime now = LocalDateTime.now();
            String dateFolder = DATE_FOLDER.format(now.toLocalDate());
            String timestamp = TIMESTAMP.format(now);
            String logFileName = timestamp + ".log";
            Path logFileDir = Paths.get(LOGS_DIRECTORY, dateFolder);

            try {
                Files.createDirectories(logFileDir);
                logFilePath = logFileDir.resolve(logFileName);
                Files.createFile(logFilePath);
                isFileNameInitialized = true;
            } catch (IOException e) {
                System.err.println("Error creating log file: " + e.getMessage());
            }
        }

        String msg = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " - " + message + System.lineSeparator();

        try {
            Files.write(logFilePath, msg.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
