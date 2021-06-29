package imp;

import abstraction.ITree;
import abstraction.ITreeCrawler;
import imp.worker.RequestData;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class TreeCrawler implements ITreeCrawler {

    final static Logger logger = Logger.getLogger(TreeCrawler.class);

    Queue<ITree> nextToVisit = new LinkedList<>();

    @Override
    public void crawl(ITree root, Consumer<Object> consumer) throws Exception{

        nextToVisit.add(root);
        //should handle symbolic links?
        while(nextToVisit.size() != 0){
            ITree tree = nextToVisit.poll();

            consumer.accept(tree.getVal());
            // get files and add to global workers pool
            nextToVisit.addAll(tree.getChildren());
        }
    }
}
