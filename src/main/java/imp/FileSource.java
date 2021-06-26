package imp;

import abstraction.linesource.ILineSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileSource implements ILineSource {



    private BufferedReader internalReader;

    public FileSource(String fileName) throws FileNotFoundException {
        this.internalReader = new BufferedReader(new FileReader(fileName));
    }

    @Override
    public String getNextLine() {
        try {
            return internalReader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Collection<String> getAllLines() {
        List<String> lines = new ArrayList<>();
        String line;
        try{

            while((line = internalReader.readLine()) != null){
                lines.add(line);
            }
        }
        catch (IOException e){
            return null;
        }

        return lines;
    }

    @Override
    public void closeSource() {
        try {
            internalReader.close();
        } catch (IOException e) {
            return;
        }
    }
}

