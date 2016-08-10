package CodingProblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arun.gupta on 04/08/16.
 *
 * input :: PMLPMMMLPMLPMML  --- ans -----
 *
 * input :: PL - 100000000
 *
 * A Robot Understands 3 commands Pick (P) move (M) and Lower (L)
 *
 * 1. there are always block in Stash means Pick will always get the block.
 * 2. If robot already Holds the block, Pickup will reset the Position of Robot.
 * 3. Robot will not go beyond block 9
 * 4. Lowering block on a pile of 15 does nothing.
 * 5. Lowering without a block does nothing.
 * 6. Robot Ignores command which is other than P or L or M
 *
 * Given a String find How many blocks are collected in each pile from 0 to 9 and stack size will be max 1-F
 *
 * Atlassian
 */
public class RobotHandMovementProblem {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String _instructions;
        try {
            _instructions = in.nextLine();
        } catch (Exception e) {
            _instructions = null;
        }

        System.out.println(compute(_instructions));
    }

    private static String compute(String instructions) {
        List<Long> blockCount = new ArrayList<>(10);
        for (int i=0;i<10; i++) {
            blockCount.add(0L);
        }
        int currentPos = 0;
        boolean holdingBlock = false;
        for (int i=0; i<instructions.length(); i++) {
            char command = instructions.charAt(i);
            if (command == 'P') {
                holdingBlock = true;
                currentPos = 0;
            }
            else if (command == 'M') {
                currentPos++;
            }
            else if (command == 'L') {
                if (!holdingBlock) {
                    continue;
                }
                if (currentPos > 9) {
                    currentPos = 9;
                }
                if (blockCount.get(currentPos) < 15) {
                    long cnt = blockCount.get(currentPos);
                    blockCount.set(currentPos, cnt+1);
                    holdingBlock = false;
                }
            }
        }
        String result = "";
        for (int i=0; i<10; i++) {
            if (blockCount.get(i) > 9) {
                char c = 'A';
                c += blockCount.get(i)%10;
                result += c;
            }
            else {
                result += blockCount.get(i);
            }
        }
        return result;
    }
}
