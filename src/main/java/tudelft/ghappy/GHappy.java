package tudelft.ghappy;

public class GHappy {

    private static final char G = 'g';

    public boolean gHappy(String str) {
        assert str!=null;
        final int length = str.length();

        int i = 0;
        while (i < length) {
            if (str.charAt(i) == G) {
                int j = i + 1;
                while (j < length && str.charAt(j) == G) {
                    ++j;
                }
                if (j == i + 1) {
                    return false;
                }
                i = j;
            } else {
                ++i;
            }
        }
        return true;

    }
}
