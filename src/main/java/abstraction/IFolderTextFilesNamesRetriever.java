package abstraction;

import java.io.IOException;
import java.util.Collection;

public interface IFolderTextFilesNamesRetriever {

    Collection<String> getTextFiles() throws IOException;

    Collection<String> getDirs() throws IOException;
}
