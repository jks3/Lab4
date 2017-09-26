/*
 * The following code needs a lot of TLC. So give it some!
 *
 * 1. Fix all checkstyle errors
 * 2. Determine what it does (it's going to be tough before you finish #1)
 * 3. Improve the name of the methods and variables
 * 4. Add comments and Javadoc comments where needed
 * 5. Remove unnecessary comments as appropriate
 */
/**
 * Checks which substrings of a string is contained in another string
 * as well as substrings of the second string
 * Those substrings that are contained within the other string or its
 * substrings are then returned (includes multiple instances)
 */

public class ReclamationProject
{
    static String whichSubsCanBeFound(final String key, final String within) {
        String keyToCheckFor = key;
        String wordToCheckIn = within;
        /**
         * Switches values of arguments if the key is longer than the searched string to prevent
         * out of bounds error
         */
        if (keyToCheckFor.length() > wordToCheckIn.length()){
            String temp = keyToCheckFor; //Temp to store initial value of key
            keyToCheckFor = wordToCheckIn ;
            wordToCheckIn = temp;
            }
        String result = ""; //creates empty string to store result
    /**
     * The first loop changes the section of the key to be checked
     * The second and third change the section of within to be checked
     */
        for (int begIndOfKey = 0; begIndOfKey < keyToCheckFor.length(); begIndOfKey++) {
            for (int endIndOfWithin = keyToCheckFor.length() - begIndOfKey;
                    endIndOfWithin > 0; endIndOfWithin--) {
                for (int begIndOfWithin = 0;
                        begIndOfWithin < wordToCheckIn.length()- endIndOfWithin; begIndOfWithin++) {
                    result = (keyToCheckFor.regionMatches(begIndOfKey, wordToCheckIn,
                            begIndOfWithin, endIndOfWithin)
                            && endIndOfWithin >result.length()) ? keyToCheckFor.substring(begIndOfKey,
                                    begIndOfKey + endIndOfWithin) : result;
                        }
                }
        }
        return result;
     }
}
