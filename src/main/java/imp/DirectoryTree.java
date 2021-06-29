package imp;

import abstraction.ITree;
import org.apache.log4j.Logger;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DirectoryTree implements ITree, Closeable {

    private String rootDir;
    final static Logger logger = Logger.getLogger(DirectoryTree.class);

    private FileNamesRetriever fileNamesRetriever;

    public DirectoryTree(String rootDir) {
        this.rootDir = rootDir;
        this.fileNamesRetriever = new FileNamesRetriever(rootDir);
    }


    @Override
    public List<ITree> getChildren() throws IOException {
        List<ITree> res = new ArrayList<>();
        Collection<String> dirs = fileNamesRetriever.getDirs();
        logger.info("dirs " + dirs);
        for(String dir:dirs){
            res.add(new DirectoryTree(dir));
        }
        return res;
    }

    @Override
    public Object getVal() throws Exception{

        return fileNamesRetriever.getTextFiles();
    }

    @Override
    public void close() throws IOException {

    }
}
