package main;

import imp.matchers.FileMatcher;
import imp.FileNamesRetriever;

public class App {
    public static void main(String[] args) {

        try{

            FileMatcher fileMatcher = new FileMatcher("/home/ngampel/IdeaProjects/FSCrawler/src/main/resources/text_files/textfile","test");
            System.out.println(fileMatcher.matches());

            FileNamesRetriever textFileNamesRetriever = new FileNamesRetriever("/home/ngampel/IdeaProjects/");
            System.out.println(String.join(" ",textFileNamesRetriever.getTextFiles()));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
}
