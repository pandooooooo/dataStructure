import array.MoveZeroes;
import org.testng.annotations.Test;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:03 AM
 */
public class TestLeetcode {
    @Test
    public void testLeetcode(){
        int[] nums = new int[]{0,1,0,0,2,3,4,0,5};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.solution1(nums);

        System.out.println(1);
    }
}
