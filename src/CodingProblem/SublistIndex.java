package CodingProblem;

import java.util.*;

/**
 * Created by arun.gupta on 02/08/16.
 * <p>
 * Collections.indexOfSubList() method returns the starting position of the first occurrence of the specified target
 * list  within the specified source list, or -1 if there is no such occurrence. -
 */
public class SubListIndex {
    public static void main(String a[]) {

        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c");
        list.add("c++");
        list.add("unix");
        list.add("perl");
        list.add("php");
        list.add("javascript");
        list.add("ruby");
        list.add(".net");
        list.add("jdbc");
        list.add("servlets");

        List<String> subList = new ArrayList<String>();
        subList.add("php");
        subList.add("javascript");
        subList.add("ruby");

        System.out.println("Index of sublist: " + Collections.indexOfSubList(list, subList));


        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("1");
        list1.add("2");
        list1.add("7");
        list1.add("6");

        List<String> subList1 = new ArrayList<String>();
        subList1.add("1");
        subList1.add("2");
        subList1.add("7");

        System.out.println("Index of sublist: " + indexOfSubList(list1, subList1));
        subList1.add("9");
        System.out.println("Index of sublist: " + indexOfSubList(list1, subList1));

    }

    public static int indexOfSubList(List<?> source, List<?> target) {
        int sourceSize = source.size();
        int targetSize = target.size();
        //
        int maxCandidate = sourceSize - targetSize;
        ListIterator<?> si = source.listIterator();
        nextCand:
        for (int candidate = 0; candidate <= maxCandidate; candidate++) {
            ListIterator<?> ti = target.listIterator();
            for (int i = 0; i < targetSize; i++) {
                if (!eq(ti.next(), si.next())) {
                    // Back up source iterator to next candidate
                    for (int j = 0; j < i; j++)
                        si.previous();
                    continue nextCand;
                }
            }
            return candidate;
        }
        return -1;  // No candidate matched the target
    }

    static boolean eq(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }
}
