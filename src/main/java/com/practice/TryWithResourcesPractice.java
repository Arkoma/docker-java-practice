package com.practice;

import java.io.*;

public class TryWithResourcesPractice {
    static int BUFFER_SIZE = 16;
    public static String firstLineOfFile(String path, String defaultVal) {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
    public static void copy(String src, String dat) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dat)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
}
