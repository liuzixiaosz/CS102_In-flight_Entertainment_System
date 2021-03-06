package fileutils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileContent {
    private String mFileContent;

    public String getContent() {
        return this.mFileContent;
    }


    public void readFile(String file, String charSet) {
        StringBuilder sb = new StringBuilder("");
        InputStreamReader isr;
        BufferedReader br;
        int charsRead;
        int buffer_size = 1000;
        char[] buffer = new char[buffer_size];
        try (
                FileInputStream input = new FileInputStream(file)
        ) {
            isr = new InputStreamReader(input, charSet);
            while ((charsRead = isr.read(buffer, 0, buffer_size)) != -1) {
                sb.append(new String(java.util.Arrays.copyOfRange(buffer,
                        0, charsRead)));
            }
            this.mFileContent = sb.toString();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}