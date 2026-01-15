package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppleProcessor {

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
