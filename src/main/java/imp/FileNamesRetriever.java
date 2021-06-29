package imp;

import abstraction.IFolderTextFilesNamesRetriever;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileNamesRetriever implements IFolderTextFilesNamesRetriever {

    private String dirName;
    private List<String> textFiles;
    private List<String> folders;
    final static Logger logger = Logger.getLogger(FileNamesRetriever.class);

    public FileNamesRetriever(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public Collection<String> getTextFiles() throws IOException {
        if(textFiles == null){
            getFiles();
        }
        return textFiles;
    }

    @Override
    public Collection<String> getDirs() throws IOException {
        if(folders == null){
            getFiles();
        }

        return folders;
    }



    private void getFiles(){
        File dir = new File(dirName);
        textFiles = new ArrayList<>();
        folders = new ArrayList<>();

        File[] files = dir.listFiles();
        for(File file:files) {
            String name = file.getName();
            if (file.isDirectory()) {
                folders.add(dir.getAbsolutePath() + "/" + name);
            } else {
                textFiles.add(dir.getAbsolutePath() + "/" + name);
            }
        }

        logger.info("file " + textFiles + " dirs " + folders);
    }
}
