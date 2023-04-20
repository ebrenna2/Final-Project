import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// This class is used to create the leaderboard gui, so it can be viewed by the player, has to do with writing out the file
public class ScoreLog {
    private final List<Entry> entries;
    private static final String LOGFILE = "leaderboard_log.txt";

    //creates an arraylist for the entries of all the users
    public ScoreLog() {
        entries = new ArrayList<>();

    }

    //adds the entry to the leaderboard, and formats how it's written out to the file (not in order, though just based on whoever played it (and the order they played it in).
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

    //gets the entries
    public List<Entry> getEntries() {
        return entries;
    }

    //reads the entries from the file
    public void readEntries() {
        Scanner fIn = null;
        try {
            fIn = new Scanner(new FileInputStream("leaderboard_log.txt")) ;
        } catch (FileNotFoundException e) {
            System.out.println("File not found... creating new file");
        }

        try {
            File logFile = new File("leaderboard_log.txt");
            logFile.createNewFile();
            fIn = new Scanner(logFile);
        }

        catch (IOException e) {
            System.out.println("Error creating file");
        }

        if(fIn != null)
        {
            while (fIn.hasNext()) {
                String line = fIn.nextLine();
                String[] splitLine = line.split(" ");
                String name = splitLine[0];
                int score = Integer.parseInt(splitLine[1]);
                Entry entry = new Entry(name, score);
                entries.add(entry);
            }
        }
        Collections.sort(entries, Collections.reverseOrder());
    }

    //creates the entry class
    public static class Entry implements Comparable<Entry> {
        private final String name;
        private final int score;

        //constructor for the entry class
        public Entry(String name, int score) {
            this.name = name;
            this.score = score;
        }

        //gets the person's name
        public String getName() {
            return name;
        }

        //compares the scores of the entries
        @Override
        public int compareTo(Entry other) {
            return Integer.compare(score, other.score);
        }

        //gets the score
        public int getScore() {
            return score;
        }
    }
}
