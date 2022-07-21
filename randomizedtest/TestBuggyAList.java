package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public  void testThreeAddThreeRemove(){
        AListNoResizing<Integer>cor = new AListNoResizing<>();
        AListNoResizing<Integer>bug = new AListNoResizing<>();
        cor.addLast(5);
        cor.addLast(10);
        cor.addLast(15);
        bug.addLast(5);
        bug.addLast(10);
        bug.addLast(15);
        assertEquals(cor.size(),bug.size());
        assertEquals(cor.removeLast(),bug.removeLast());
        assertEquals(cor.removeLast(),bug.removeLast());
        assertEquals(cor.removeLast(),bug.removeLast());
    }


    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>(); //new
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);  //new
                broken.addLast(randVal);   //new
                //L.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                assertEquals(correct.size(),broken.size());
                //下面的情况判断了size<4的情况
            }else if (correct.size() == 0) {
                continue;
            } else if (operationNumber == 2) {
                // getLast
                assertEquals(correct.getLast(), broken.getLast());
            } else if (operationNumber == 3) {
                //removeLast
                assertEquals(correct.removeLast(), broken.removeLast());
            }
        }
    }
}
