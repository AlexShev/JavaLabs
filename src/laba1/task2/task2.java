package laba1.task2;

import java.util.HashSet;
import java.util.Set;

public class task2
{
    // some code to run
    public static void main(String[] args)
    {
        String[] alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
        String[] bob = new String[]{"boar", "clap", "mere", "lend", "near", "peat", "pure", "more", "plan", "soap"};
        System.out.println( 0 == task2.mutations(alice, bob, "maze", 0)); // Alice goes  first, Alice   wins
        System.out.println( 1 == task2.mutations(alice, bob, "send", 0)); // Alice goes  first, Bob     wins
        System.out.println( 1 == task2.mutations(alice, bob, "boat", 0)); // Alice fails first, Bob     wins
        System.out.println(-1 == task2.mutations(alice, bob, "apse", 0)); // Alice fails first, neither wins
        System.out.println( 1 == task2.mutations(alice, bob, "neat", 1)); // Bob   goes  first, Bob     wins
        System.out.println( 0 == task2.mutations(alice, bob, "soar", 1)); // Bob   goes  first, Alice   wins
        System.out.println( 0 == task2.mutations(alice, bob, "more", 1)); // Bob   fails first, Alice   wins
        System.out.println(-1 == task2.mutations(alice, bob, "calm", 1)); // Bob   fails first, neither wins
    }

    /**
     * game of words
     * @param alice - array of words in Alice's memory (10 <= n <= 2000)
     * @param bob - array of words in Bob's memory (same size as alice)
     * @param word - string of the initial challenge word
     * @param first - integer of whom begins: 0 for Alice, 1 for Bob
     * @return who win (0 if Alice wins, 1 if Bob wins, -1 if both fail)
     */
    public static int mutations(String[] alice, String[] bob, String word, int first)
    {
        String[] firstPlayer, secondPlayer;

        //
        if (first == 0)
        {
            firstPlayer = alice;
            secondPlayer = bob;
        }
        else
        {
            firstPlayer = bob;
            secondPlayer = alice;
        }

        Set<String> used = new HashSet<>(alice.length);
        used.add(word);

        String currWord = word;
        boolean isNewWordFirst = false;
        boolean isNewWordSecond = false;

        for (int i = 0; i < firstPlayer.length; i++)
        {
            String temp = findSimilarWords(firstPlayer, currWord, used);

            if (temp != null)
            {
                currWord = temp;
                isNewWordFirst = true;
                isNewWordSecond = false;
            }

            temp = findSimilarWords(secondPlayer, currWord, used);

            if (temp != null)
            {
                currWord = temp;
                isNewWordSecond = true;
            }

            if (!isNewWordFirst && !isNewWordSecond)
            {
                return -1;
            }
            else if (isNewWordFirst && !isNewWordSecond)
            {
                return first == 0 ? 0 : 1;
            }
            else if (!isNewWordFirst && isNewWordSecond)
            {
                return first == 1 ? 0 : 1;
            }
            else
            {
                isNewWordFirst = false;
            }
        }

        return -1;
    }

    private static String findSimilarWords(String[] player, String currWord, Set<String> used)
    {
        for (var w : player)
        {
            if (isUniqueLettersInWord(w) && isSimilarWords(currWord, w) && !used.contains(w))
            {
                used.add(w);

                return w;
            }
        }

        return null;
    }

    private static boolean isUniqueLettersInWord(String word)
    {
        for (int i = 0; i < word.length(); i++)
        {
            for (int j = i + 1; j < word.length(); j++)
            {
                if (word.charAt(i) == word.charAt(j))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSimilarWords(String first, String second)
    {
        byte counterIdenticalChars = 0;

        for (int i = 0; i < first.length(); i++)
        {
            if (first.charAt(i) == second.charAt(i))
            {
                ++counterIdenticalChars;
            }
        }
        
        return counterIdenticalChars == 3;
    }
}