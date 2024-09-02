package Test;

import edu.princeton.cs.algs4.In;
import org.apache.hc.core5.annotation.Internal;
import org.junit.jupiter.api.Test;
import src.SLList;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import java.util.ArrayList;

public class SLListTest {

    @Test
    /* before we do any operation make sure the constructor works well */
    public void testDefaultConstructor() {
        SLList<Integer> sllDefaultConstructor = new SLList<>();
        ArrayList<Integer> arrayOfDefaultConstructor = new ArrayList<>();
        assertThat(sllDefaultConstructor.toList()).isEqualTo(arrayOfDefaultConstructor);

    }

    @Test
    public void testOneParameterConstructor() {

        SLList<Integer> sllWithOneParameterConstructor = new SLList<>(2);
        ArrayList<Integer> arrayOfOneParameterConstructor = new ArrayList<>();
        arrayOfOneParameterConstructor.add(2);
        assertThat(sllWithOneParameterConstructor.toList()).isEqualTo(arrayOfOneParameterConstructor);
    }


    @Test
    /* we expect the SLList returns a perfect ArrayList which makes it easy for our follows tests */
    public void testToList() {
        SLList<Integer> sll = new SLList<>(6);
        for (int i = 5; i >= 0; i--) sll.addFirst(i);

        ArrayList<Integer> arrayOfSLL = new ArrayList<>();
        for (int i = 0; i <= 6; i++)
            arrayOfSLL.add(i);

        assertThat(sll.toList()).isEqualTo(arrayOfSLL);
    }

    @Test
    public  void testRemoveLast()
    {
          SLList<Integer> sll = new SLList<>(6);
        for (int i = 5; i >= 0; i--) sll.addFirst(i);

        sll.removeLast();

        ArrayList<Integer> arrayOfSLL = new ArrayList<>();
        for (int i = 0; i <= 5; i++)
            arrayOfSLL.add(i);
        assertThat(sll.toList()).isEqualTo(arrayOfSLL);

    }
}
