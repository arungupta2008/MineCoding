package CodingProblem.ArrayProblem;

/**
 * Created by arun.gupta on 12/08/16.
 *
 *
 *
 Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 How do you find an element in the rotated array efficiently? You may assume no duplicate exists in the array.




 Solution :: Explaination

 I have updated the problem description to assume that there exists no duplicate in the array. Some readers have noted that
 the below code does not work for input with duplicates. For example, for input “1 2 1 1 1 1”, the binary search method below
 would not work, as there is no way to know if an element exists in the array without going through each element one by one.



 At first look, we know that we can do a linear search in O(n) time. But linear search does not need the elements to be sorted in any way.

 First, we know that it is a sorted array that’s been rotated. Although we do not know where the rotation pivot is, there is a property we can take advantage of. Here, we make an observation that a rotated array can be classified as two sub-array that is sorted (i.e., 4 5 6 7 0 1 2 consists of two sub-arrays 4 5 6 7 and 0 1 2.

 Do not jump to conclusion that we need to first find the location of the pivot and then do binary search on both sub-arrays. Although this can be done in O(lg n) time, this is not necessary and is more complicated.

 In fact, we don’t need to know where the pivot is. Look at the middle element (7). Compare it with the left most (4) and right most element (2). The left most element (4) is less than (7). This gives us valuable information — All elements in the bottom half must be in strictly increasing order. Therefore, if the key we are looking for is between 4 and 7, we eliminate the upper half; if not, we eliminate the bottom half.

 When left index is greater than right index, we have to stop searching as the key we are finding is not in the array.

 Since we reduce the search space by half each time, the complexity must be in the order of O(lg n). It is similar to binary search but is somehow modified for this problem. In fact, this is more general than binary search, as it works for both rotated and non-rotated arrays.



 */
public class RotatedArraySearch {
    public static void main(String[] args) {
//        int []  input = {1,2,3,4,5,6,7,8,9,10,11};
//        int key = 9;
//        findKey(input, key);

        int []  input1 = {6,7,8,9,10,11,1,2,3,4,5};
        int key1 = 9;
        findKey(input1, key1);
    }

    private static void findKey(int[] input, int key) {
        int L = 0;
        int R = input.length -1;
        while (L < R){
            int M = L + ((R-L)/2);
            if(input[M] == key){
                System.out.println("Found key at Location "+M);
            }
            // IF Right Hand side Values sorted
            if(input[M] <= input[R]){
                if(input[M] < key && input[R] >= key)
                    L = M+1;
                else
                    R = M-1;
            }else {
                if(input[L] <= key && input[M] > key)
                    R = M-1;
                else L = M +1;
            }

        }
    }
}
