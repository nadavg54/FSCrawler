package imp;

import abstraction.ITree;
import abstraction.ITreeCrawler;
import imp.worker.RequestData;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class TreeCrawler implements ITreeCrawler {

    Queue<ITree> nextToVisit = new LinkedList<>();

    @Override
    public void crawl(ITree root, Consumer<Object> consumer) throws Exception{

        nextToVisit.add(root);
        //should handle symbolic links?
        while(nextToVisit.size() != 0){
            ITree tree = nextToVisit.poll();
            consumer.accept(root.getVal());
            // get files and add to global workers pool
            nextToVisit.addAll(tree.getChildren());
        }
    }
}
