package imp.worker;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestData {

    private String fileName;

    private String pattern;
}
