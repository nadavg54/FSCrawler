package imp;

import abstraction.linesource.ILineSource;
import imp.matchers.BasicLineMatcher;
import imp.matchers.MultiLineSourceMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FileSearcherTest {

    @Test
    public void testSourceHasString(){

        List<String> lines = new ArrayList<>();
        lines.add("first line ");
        lines.add("second line for test");
        TestFileSource testFileSource = new TestFileSource(lines);

        MultiLineSourceMatcher test = new MultiLineSourceMatcher(new BasicLineMatcher("test"), testFileSource);

        Assertions.assertTrue(test.matches());
    }

    @Test
    public void testSourceDoesntHaveString(){

        List<String> lines = new ArrayList<>();
        lines.add("first line ");
        lines.add("second line without the word");
        TestFileSource testFileSource = new TestFileSource(lines);

        MultiLineSourceMatcher test = new MultiLineSourceMatcher(new BasicLineMatcher("test"), testFileSource);

        Assertions.assertFalse(test.matches());
    }



    class TestFileSource implements ILineSource{

        List<String> lines;
        int currLine = 0;

        public TestFileSource(List<String> lines) {
            this.lines = lines;
        }

        @Override
        public String getNextLine() {
            if(currLine == lines.size()){
                return null;
            }
            return lines.get(currLine++);
        }

        @Override
        public Collection<String> getAllLines() {
            return lines;
        }

        @Override
        public void closeSource() {

        }
    }
}