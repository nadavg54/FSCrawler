package app;

import imp.DirectoryTree;
import imp.worker.FileNameWorker;
import imp.TreeCrawler;
import imp.matchers.FileMatcher;
import imp.FileNamesRetriever;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class App {

    static final String HOME_DIR = "/home/ngampel";

    public static void main(String[] args) {

        try{

            //testOneFile();
            long start = System.currentTimeMillis();
            Map<String,Boolean> backingMap = new ConcurrentHashMap<>();
            Set<String> res = Collections.newSetFromMap(backingMap);
            TreeCrawler treeCrawler = new TreeCrawler();
            DirectoryTree directoryTree = new DirectoryTree(HOME_DIR + "/junk/redis");
            BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
            ExecutorService executorService = new ThreadPoolExecutor(1,1,0,TimeUnit.MILLISECONDS,tasks);
            treeCrawler.crawl(directoryTree,new FileNameWorker(executorService,"retries",res));
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS);
            System.out.println("res is " + res);
            long exetime = System.currentTimeMillis() - start;
            System.out.println("exe time " + exetime);
            System.exit(0);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    private static void testOneFile() throws Exception {
        FileMatcher fileMatcher = new FileMatcher("/home/ngampel/IdeaProjects/FSCrawler/src/main/resources/text_files/textfile","test");
        System.out.println(fileMatcher.matches());

        FileNamesRetriever textFileNamesRetriever = new FileNamesRetriever("/home/ngampel/IdeaProjects/");
        System.out.println(String.join(" ",textFileNamesRetriever.getTextFiles()));
    }
}
