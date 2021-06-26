package imp.matchers;

import abstraction.matchers.ILineMatcher;

public class BasicLineMatcher implements ILineMatcher {

    private final String m_sToMatch;

    public BasicLineMatcher(String toMatch) {
        m_sToMatch = toMatch;
    }

    @Override
    public boolean matches(String s) {
        return s.contains(m_sToMatch);
    }
}
