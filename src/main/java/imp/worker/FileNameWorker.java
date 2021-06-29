package imp.worker;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Consumer;
@AllArgsConstructor
public class FileNameWorker implements Consumer<Object> {

    private ExecutorService queueFilesToCheck;
    private String text;
    private Set<String> res;

    @Override
    public void accept(Object o) {
        if(!(o instanceof List)) {
            return;
        }
        List<String> files = (List<String>) o;
        //here maybe u can filter 'binary' files with 'file' util of linux
        files.stream().forEach(file -> {
            queueFilesToCheck.execute(new FileMatcherTask(file,text,res));
        });

    }
}
