package imp.matchers;

import abstraction.matchers.IMultiLinesMatcher;
import imp.FileSource;

public class FileMatcher implements IMultiLinesMatcher {

    private String filename;
    private String text;
    public FileMatcher(String filename, String text) {
        this.filename = filename;
        this.text = text;
    }

    @Override
    public boolean matches() throws Exception{
        FileSource fileSource = new FileSource(filename);
        MultiLineSourceMatcher multiLineSourceMatcher = new MultiLineSourceMatcher(new BasicLineMatcher(text), fileSource);
        return multiLineSourceMatcher.matches();
    }
}
