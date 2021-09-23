package laba1.task3;

public class task3
{
    // some run
    public static void main(String[] args)
    {
        System.out.println(task3.rangeExtraction(new int[] {18,-16,-14,-11,-10,-9,-7,-6}));
        System.out.println("18,-16,-14,-11--9,-7,-6".equals(task3.rangeExtraction(new int[] {18,-16,-14,-11,-10,-9,-7,-6})));

        System.out.println("-3--1,2,10,15,16,18-20".equals(task3.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20})));
    }

    /**
     *  select ranges in a sequence of numbers
     * @param arr - sequence of numbers
     * @return string representation of a sequence of ranges
     */
    public static String rangeExtraction(int[] arr)
    {
        StringBuilder bulder = new StringBuilder();

        for (int i = 0; i < arr.length;)
        {
            int j = i;

            // find max index of current range
            while (j < arr.length - 1 && arr[j] + 1 == arr[j + 1]) { ++j; }

            // write left border of the interval
            bulder.append(arr[i]);

            // if interval size >= 3
            if (j - i > 1)
            {
                // write right border of the interval
                bulder.append('-');
                bulder.append(arr[j]);

                i = j + 1; // left border of new interval
            }
            else
            {
                ++i; // left border of new interval (nex int)
            }

            // to avoid writing unnecessary ','
            if(i <= arr.length - 1)
                bulder.append(',');
        }

        return bulder.toString();
    }
}
