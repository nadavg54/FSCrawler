package abstraction;

import java.io.IOException;
import java.util.List;

public interface ITree {
    List<ITree> getChildren() throws IOException;
    Object getVal() throws Exception;
}
