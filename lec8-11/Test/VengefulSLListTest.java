package Test;

import org.junit.jupiter.api.Test;
import src.VengefulSLList;

import java.util.ArrayList;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class VengefulSLListTest {


    @Test
    public void testEmptyLost() {
        VengefulSLList<Integer> vel = new VengefulSLList<>();
        ArrayList<Integer> arrayOfVengeful = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) vel.addLast(i);

        }

        assertThat(vel.getLostItems().toList()).isEqualTo(arrayOfVengeful);

    }

    @Test
    public void testAllLost() {

        VengefulSLList<Integer> vel = new VengefulSLList<>();
        ArrayList<Integer> arrayOfVengeful = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) vel.addLast(i);

        }
        for (int i = 9; i >= 0; i--) {
            if (i % 2 == 0) arrayOfVengeful.add(i);

        }

        // remove all elements should traversal the original size especially while you are adding or remove elements
        // REMEMBER THS CURRENT SIZE WILL CHANGE
        int size = vel.size();
        for (int i = 0; i < size; i++) vel.removeLast();
        assertThat(vel.getLostItems().toList()).isEqualTo(arrayOfVengeful);
    }

    @Test
    public void testCommonLost() {
        VengefulSLList<Integer> vel = new VengefulSLList<>();
        ArrayList<Integer> arrayOfVengeful = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) vel.addLast(i);

        }
        vel.removeLast();
        vel.removeLast();
        arrayOfVengeful.add(10);
        arrayOfVengeful.add(8);
        assertThat(vel.getLostItems().toList()).isEqualTo(arrayOfVengeful);

    }


}
