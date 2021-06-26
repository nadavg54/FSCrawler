package imp.matchers;

import abstraction.matchers.IMultiLinesMatcher;
import abstraction.matchers.ILineMatcher;
import abstraction.linesource.ILineSource;

public class MultiLineSourceMatcher implements
        IMultiLinesMatcher {


    private final ILineSource lineSource;

    private final ILineMatcher lineMatcher;


    public MultiLineSourceMatcher(ILineMatcher lineMatcher, ILineSource lineSource) {
        this.lineMatcher = lineMatcher;
        this.lineSource = lineSource;
    }


    @Override
    public boolean matches(){

        String line;
        while((line = lineSource.getNextLine()) != null){
            if(lineMatcher.matches(line)){
                return true;
            }
        }
        return false;
    }


}
