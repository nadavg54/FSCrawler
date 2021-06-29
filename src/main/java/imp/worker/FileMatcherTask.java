package imp.worker;

import imp.matchers.FileMatcher;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import java.util.Set;


@AllArgsConstructor
public class FileMatcherTask implements Runnable{

    private String filename;
    private String text;
    private Set<String> res;

    final static Logger logger = Logger.getLogger(FileMatcherTask.class);

    @Override
    public void run() {
        FileMatcher fileMatcher = new FileMatcher(filename,text);
        logger.info("checking file " + filename);
        try {
            if(fileMatcher.matches()){

                res.add(filename);
            }
        } catch (Exception e) {
            return;
        }
    }
}
