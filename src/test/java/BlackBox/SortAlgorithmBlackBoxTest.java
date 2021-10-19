package BlackBox;

import BlackBox.Setups.SortSetup;
import org.junit.Test;

public class SortAlgorithmBlackBoxTest extends SortSetup {

    @Test
    public void tests() {
        int[][][] options = new int[][][] {
            {{2, 1}, {1, 2}},
            {{0, 1, -1}, {-1, 0, 1}},
            {{Integer.MAX_VALUE, Integer.MIN_VALUE}, {Integer.MIN_VALUE, Integer.MAX_VALUE}},
            {{10, 2, 6, 1, 5, 9, 5, 3, 5, 8, 4, 7}, {1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10}},
            {null, null},
            {{}, {}},
        };
        for (int[][] option : options){
            int[] input = option[0];
            int[] expectedOutput = option[1];
            sortAlgorithmPUT.run(input, expectedOutput);
        }
    }

    @Test
    public void longTest() {
        int length = 100000;
        int[] input = new int[length];
        int[] expectedOutput = new int[length];
        for (int i = 0; i < length; i++) {
            expectedOutput[i] = i;
            input[i] = length - i - 1;
        }
        sortAlgorithmPUT.run(input, expectedOutput);
    }
}
