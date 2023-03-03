import java.math.BigInteger;
import java.util.Random;

public class KarpRabin {

    private void explanation() {
        /*
         * The Karp-Rabin algorithm is a string searching algorithm that uses hash
         * functions to efficiently search for a pattern in a text. The algorithm works
         * by computing the hash value of the pattern and the hash values of all
         * substrings of the text with the same length as the pattern
         * Then, it compares the hash values of the pattern and the substrings to
         * determine if they match. If a match is found, the algorithm checks if the
         * pattern actually matches the substring by comparing the characters.
         * 
         * The Karp-Rabin algorithm is based on the observation that two strings with
         * the same hash value are likely to be equal. Therefore, the algorithm uses a
         * hash function to compute the hash value of a string, which is a numeric
         * representation of the string that can be used to compare it with other
         * strings.
         * 
         * In this implementation, we use the BigInteger class to handle large prime
         * numbers and hash values. The PRIME constant is a prime number used to reduce
         * the chance of collisions in the hash function.
         * 
         * The hash method computes the hash value of a string by iterating over its
         * characters and multiplying each character's ASCII value by a power of the
         * prime number and adding them up. The resulting sum is the hash value of the
         * string.
         * 
         * The search method implements the Karp-Rabin algorithm by first computing the
         * hash value of the pattern using the hash method. Then, it iterates over the
         * text and computes the hash values of all substrings with the same length as
         * the pattern using a rolling hash. A rolling hash is a hash function that can
         * efficiently update the hash value of a string when a character is added or
         * removed.
         * 
         * If a substring's hash value matches the pattern's hash value, the algorithm
         * checks if the pattern actually matches the substring by comparing their
         * characters. If a match is found, the method returns the index of the
         * substring in the text.
         * 
         * The generateRandomString method generates a random string of a given length
         * using the Random class.
         * 
         * Finally, the main method generates a random text and pattern, and measures
         * the time taken by the search method to find the pattern in the text. If the
         * pattern is found, the method prints its index in the text and the time taken
         * to find it. Otherwise, it prints a message saying that the pattern was not
         * found.
         * 
         * Overall, the Karp-Rabin algorithm is an efficient algorithm for searching for
         * patterns in large texts, especially when the pattern length is small compared
         * to the text length. However, it is not guaranteed to find all occurrences of
         * the pattern, and may produce false positives due to collisions in the hash
         * function.
         */
    }

    // A prime number used to reduce the chance of collisions in the hash function
    private static final BigInteger PRIME = BigInteger.valueOf(101);

    /**
     * Computes the hash value of a string using the Karp-Rabin algorithm
     * 
     * @param s the string to hash
     * @return the hash value of the string
     */
    public static BigInteger hash(String s) {
        BigInteger hash = BigInteger.ZERO;
        for (int i = 0; i < s.length(); i++) {
            hash = hash.multiply(PRIME).add(BigInteger.valueOf(s.charAt(i)));
        }
        return hash;
    }

    /**
     * Searches for a pattern in a text using the Karp-Rabin algorithm
     * 
     * @param text    the text to search in
     * @param pattern the pattern to search for
     * @return the index of the first occurrence of the pattern in the text, or -1
     *         if not found
     */
    public static int search(String text, String pattern) {
        BigInteger patternHash = hash(pattern);
        BigInteger rollingHash = BigInteger.ZERO;
        int patternLength = pattern.length();
        int textLength = text.length();
        int primeToPatternLength = PRIME.pow(patternLength).intValue();
        for (int i = 0; i < patternLength; i++) {
            rollingHash = rollingHash.multiply(PRIME).add(BigInteger.valueOf(text.charAt(i)));
        }
        for (int i = 0; i <= textLength - patternLength; i++) {
            if (rollingHash.equals(patternHash)) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    return i;
                }
            }
            if (i < textLength - patternLength) {
                rollingHash = rollingHash
                        .subtract(BigInteger.valueOf(text.charAt(i)).multiply(PRIME.pow(patternLength - 1)));
                rollingHash = rollingHash.multiply(PRIME).add(BigInteger.valueOf(text.charAt(i + patternLength)));
                rollingHash = rollingHash.mod(BigInteger.valueOf(primeToPatternLength));
                if (rollingHash.compareTo(BigInteger.ZERO) < 0) {
                    rollingHash = rollingHash.add(BigInteger.valueOf(primeToPatternLength));
                }
            }
        }
        return -1;
    }

    /**
     * Generates a random string of a given length
     * 
     * @param length the length of the string to generate
     * @return the generated string
     */
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + random.nextInt(26)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = generateRandomString(100000);
        String pattern = generateRandomString(10);
        long startTime = System.currentTimeMillis();
        int index = search(text, pattern);
        long endTime = System.currentTimeMillis();
        if (index == -1) {
            System.out.println("Pattern not found in text.");
        } else {
            System.out.println("Pattern found at index " + index + " in " + (endTime - startTime) + " milliseconds.");
        }
    }
}