package CodingProblem;

/**
 * Created by arun.gupta on 10/07/16.
 *
 *
 *
 * There is a compressed string eg. ”ab2c3”, the string has lowercase characters and numbers. We can uncompress the given string as follows: whenever we get a number “n” in the string, the portion of the string before the number will repeat “n” times. So in the above example, we get a 2, so string will become “ababc3”, now we get a 3, so final string will be “ababcababcababc”.
 Given a compressed string and a number k, you have to output the k’th character in the uncompressed string.

 1 <= length of string <= 1500
 1 <= n <= 1000
 1 <= k < 2^31
 example:
 input: ab2c3 10
 output: c



 Solution :

 ab2c3 10
 ((2*2)+1)*3 > 10
 So it is somewhere in the (2*2)+1 chunk. 10%5 = 0 (or 5) = 5
 Ignoring the info in the 4 chunk, we take the 5th. So the answer is c.

 A more complex example:
 ab10c9de5 53
 ((2*10) + 1) *9 > 53
 Consider [(2*10) + 1] chunk. It will be the 53 % 21 = 11th
 (2*10) > 11
 Conside the [2] chunk. It will be the 11%2 = 1st character
 = a

 Example:

 One done by me :
 ab13cd12d12    196

 ((2*13) + 2)*13 > 196

 336 % 196 == 140%28 == 0 which is last of ab13cd12 = which is C so ans is C
 */
public class DataCompression {
    // TODO Complete
}
