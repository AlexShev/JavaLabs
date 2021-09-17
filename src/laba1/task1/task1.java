package laba1.task1;

import java.util.Scanner;

public class task1
{
    // some code to run
    public static void main(String[] args)
    {
        System.out.println(encode((new Scanner(System.in)).next()));
    }

    /**
     * analyzes the repetition of characters in a string
     * @param word string for analysis
     * @return bracket representation of the input string
     *         '(' - the letter is unique, ')' - the letter is repeated
     */

    static String encode(String word)
    {
        if (word == null)
        {
            return null;
        }

        // array for storing brackets
        char[] buffer = new char[word.length()];
        // array of flags, so as not to process previously considered characters
        boolean[] flags = new boolean[word.length()];

        // for each letter, a repetition is searched for
        // if this letter was considered earlier, then we skip it
        for (int i = 0; i < word.length(); i++)
        {
            if (!flags[i])
            {
                // flag of the uniqueness of the symbol
                boolean isUniq = true;

                for (int index = i + 1; index < word.length(); index++)
                {
                    char curr = Character.toLowerCase(word.charAt(i));

                    if (curr == Character.toLowerCase(word.charAt(index)))
                    {
                        flags[index] = true;
                        buffer[index] = ')';
                        isUniq = false;
                    }
                }

                // be careful about changing this code
                buffer[i] = (isUniq) ? '(' : ')';
            }
        }

        return String.valueOf(buffer);
    }
}
