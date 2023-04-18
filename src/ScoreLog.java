import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ScoreLog {
    private final List<Entry> entries;
    private static final String LOGFILE = "scorelog.txt";

    public ScoreLog() {
        entries = new ArrayList<>();

    }

    public void addEntry(String name, int score) {
        Entry entry = new Entry(name, score);
        entries.add(entry);
        entries.sort(Collections.reverseOrder());

        // Log the entry to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOGFILE, true))) {
            writer.write(String.format("%s: %d\n", name, score));
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    // reads entries from the leaderboard_log.txt file and adds them to entries variable
    public void readEntries() {
        Scanner fIn = null;
        try {
            fIn = new Scanner(new FileInputStream("leaderboard_log.txt")) ;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        while (true) {
            assert fIn != null;
            if (!fIn.hasNext()) break;
            String line = fIn.nextLine();
            String[] splitLine = line.split(" ");
            String name = splitLine[0];
            int score = Integer.parseInt(splitLine[1]);
            Entry entry = new Entry(name, score);
            entries.add(entry);
        }
        entries.sort(Collections.reverseOrder());
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public static class Entry implements Comparable<Entry> {
        private final String name;
        private final int score;

        public Entry(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Entry other) {
            return Integer.compare(score, other.score);
        }
    }
}
