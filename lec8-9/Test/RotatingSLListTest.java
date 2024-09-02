package Test;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import src.RotatingSLList;

import java.util.ArrayList;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class RotatingSLListTest {


    @Test
   // @Tag("rotate once")
    @DisplayName("test rotate once")
    public void testRotateOnce() {
        RotatingSLList<Integer> rsll = new RotatingSLList<>();
        ArrayList<Integer> arrayOfRotating = new ArrayList<>();

        // origin 87 39 25 3
        rsll.addFirst(3);
        rsll.addFirst(25);
        ;
        rsll.addFirst(39);
        rsll.addFirst(87);


        //after rotating we expect 3 87 39 25
        arrayOfRotating.add(3);
        arrayOfRotating.add(87);
        arrayOfRotating.add(39);
        arrayOfRotating.add(25);

        rsll.rotate();
       assertThat(rsll.toList()).isEqualTo(arrayOfRotating);

    }

    @Test
   // @Tag("rotate twice")
    @DisplayName("test rotate twice")
    public void testRotateTwice() {
        RotatingSLList<Integer> rsll = new RotatingSLList<>();
        ArrayList<Integer> arrayOfRotating = new ArrayList<>();

        // origin 87 39 25 3
        rsll.addFirst(3);
        rsll.addFirst(25);
        ;
        rsll.addFirst(39);
        rsll.addFirst(87);


        //after rotating we expect  25 3 87 39

        arrayOfRotating.add(25);
        arrayOfRotating.add(3);
        arrayOfRotating.add(87);
        arrayOfRotating.add(39);

        rsll.rotate();
        rsll.rotate();
        assertThat(arrayOfRotating).isEqualTo(rsll.toList());
    }
}
