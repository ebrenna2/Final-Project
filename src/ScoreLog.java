import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreLog {
    private final List<Entry> entries;
    private static final String LOGFILE = "leaderboard_log.txt";

    public ScoreLog() {
        entries = new ArrayList<>();

    }

    public void addEntry(String name, int score) {
        Entry entry = new Entry(name, score);
        entries.add(entry);
        Collections.sort(entries, Collections.reverseOrder());

        // Log the entry to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOGFILE, true))) {
            writer.write(String.format("%s: %d\n", name, score));
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
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

        @Override
        public int compareTo(Entry other) {
            return Integer.compare(score, other.score);
        }

        public int getScore() {
            return score;
        }
    }
}
