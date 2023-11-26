package Blind75;

/**
 * The type Jumping game.
 */
public class JumpingGame {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] jumps = {3,2,1,0,4};
        JumpingGame jumpingGame = new JumpingGame();
        System.out.println("The person "+(jumpingGame.canJump(jumps)?"can ":"cannot ")+" ");
    }

    /**
     * Can jump boolean.
     *
     * @param nums the nums
     * @return the boolean
     */
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        boolean canReach = true;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int finalReach = Math.min(j + nums[i], nums.length);
            while (j < finalReach) {
                dp[j] += 1;
                j++;
            }
            if (i > 0 && dp[i - 1] == 0) {
                canReach = false;
                break;
            }

        }
        return canReach;
    }
}
