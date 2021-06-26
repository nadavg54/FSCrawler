package abstraction;

import java.util.function.Consumer;

public interface ITreeCrawler {
    void crawl(ITree root, Consumer<Object> c) throws Exception;
}
