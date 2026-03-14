package tests.java.main;

import jobs.Astrologian;
import jobs.Bard;
import jobs.Job;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileLoaderTest {
    @TempDir
    Path tempDir;

    @Test
    public void testLoadFileParsesCorrectly() throws IOException {
        File tempFile = tempDir.resolve("fake_spells.txt").toFile();
        FileWriter fw = new FileWriter(tempFile);
        fw.write("#ASTROLOGIAN\n");
        fw.write("Star\n");
        fw.write("#RED MAGE\n");
        fw.write("Verflare\n");
        fw.write("Verholy\n");
        fw.write("#END");
        fw.close();

        Job testJob = new Astrologian();

        ArrayList<String> rdmSpells = testJob.loadFromFile(tempFile.getAbsolutePath(), "Red Mage");

        assertEquals(2, rdmSpells.size(), "There should be exactly 2 Red Mage");
        assertTrue(rdmSpells.contains("Verflare"), "Should contain Verflare");
        assertTrue(rdmSpells.contains("Verholy"), "Should contain Verholy");
        assertFalse(rdmSpells.contains("Star"), "Should not contain Star");
    }

    @Test
    public void testJobNotFound() throws IOException {
        File tempFile = tempDir.resolve("fake_spells.txt").toFile();
        FileWriter fw = new FileWriter(tempFile);
        fw.write("#ASTROLOGIAN\n");
        fw.write("Star\n");
        fw.write("#RED MAGE\n");
        fw.write("Verflare\n");
        fw.write("Verholy\n");
        fw.write("#END");
        fw.close();

        Job testJob = new Bard();
        ArrayList<String> brdSpells = testJob.loadFromFile(tempFile.getAbsolutePath(), "Bard");
        assertTrue(brdSpells.isEmpty(), "Should be empty");
    }

    @Test
    public void testFileNotFound() throws IOException {
        String tempFile = tempDir.resolve("fake_spells.txt").toString();
        Job testJob = new Bard();
        ArrayList<String> brdSpells = testJob.loadFromFile(tempFile, "Bard");
        assertEquals(0, brdSpells.size(), "It should be empty if the file cannot be found");
    }
}
