/*public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}import*/
import java.util.*;
public class Palindrome_Partitioning {

    public static void main(String[] args) {
        System.out.println("Palidrome Partioning");

        TUF obj=new TUF();
        String s = "aaaa";
        List < List < String >> ans = obj.partition(s);
        int n = ans.size();
        System.out.println("The Palindromic partitions are :-");
        System.out.print(" [ ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print("] ");
        }
        System.out.print("]");


        System.err.println(" learn palindrome Partitioning");


    }





}


class TUF {
    public static List < List < String >> partition(String s) {
        List < List < String >> res = new ArrayList < > ();
        List < String > path = new ArrayList < > ();
        partitionHelper(0, s, path, res);
        return res;
    }

    static void partitionHelper(int index, String s, List < String > path, List < List < String >> res) {
        if (index == s.length()) {
            res.add(new ArrayList < > (path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                partitionHelper(i + 1, s, path, res);
                System.err.print("index is  "+index +" i is "+i);
                System.out.print(path);
                path.remove(path.size() - 1);
                System.err.print("After remov e");;
                System.out.println(path);

            }
        }
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    /* public static void main(String args[]) {
        String s = "aabb";
        List < List < String >> ans = partition(s);
        int n = ans.size();
        System.out.println("The Palindromic partitions are :-");
        System.out.print(" [ ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print("] ");
        }
        System.out.print("]");


    }

 */
}
