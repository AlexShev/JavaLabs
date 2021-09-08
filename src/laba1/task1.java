package laba1;
// https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/java
public class task1 {
    public static void main(String[] args)
    {
        String temp = encode("   ()(   ");
        System.out.println(temp);
        System.out.println(temp.equals("))))())))"));
    }

    static String encode(String word)
    {
        char[] buffer = new char[word.length()]; // word.toCharArray();
        boolean[] flags = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++)
        {
            if (!flags[i])
            {
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

                buffer[i] = (isUniq) ? '(' : ')';
            }
        }

        return String.valueOf(buffer);
    }
}
