package abstraction.linesource;

import java.util.Collection;

public interface ILineSource {

    String getNextLine();
    Collection<String> getAllLines();
    void closeSource();
}
