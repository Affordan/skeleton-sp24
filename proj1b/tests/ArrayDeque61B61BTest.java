import jh61b.utils.Reflection;
import org.apache.hc.core5.annotation.Internal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.truth.Truth.*;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61B61BTest {

    @Test
    @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
    void noNonTrivialFields() {
        List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                .toList();

        assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
    }

    ;

    @Test
    @DisplayName("Convert deque to list with more elements")
    void ArrayDequeToListWithFullElements() {
       ArrayDeque61B<Integer> adeque = new ArrayDeque61B<>();

         /*  1 2 3 4 5 6 7 8 9 10 */
         /*  5 6 7 7 8 0 0 5 4 3 */
        adeque.addLast(8);
        adeque.addFirst(7);
        adeque.addLast(0);
        adeque.addLast(0);
        adeque.addLast(5);
        adeque.addFirst(7);
        adeque.addFirst(6);
        adeque.addFirst(5);
        adeque.addLast(4);
        adeque.addLast(3);

        List<Integer> li =Arrays.asList( 5 ,6, 7, 7, 8, 0, 0, 5, 4, 3);

        assertThat(adeque.toList()).isEqualTo(li);

    }


    @DisplayName("addLast but elements over the end bound.")
    void addLastElementsOutOfSize() {
        ArrayDeque61B<Integer> adeque = new ArrayDeque61B<>();
        List<Integer> li = Arrays.asList(5, 6, 7, 8, 0, 5, 4, 3);
        adeque.addLast(5);
        adeque.addLast(6);
        adeque.addLast(7);
        adeque.addLast(8);
        adeque.addLast(0);
        //assertThat(adeque.get())
    }

    @Test
    @DisplayName("resize double size of original array")
    void resizeDoubleSize() {
        ArrayDeque61B<Integer> adeque = new ArrayDeque61B<>();

        adeque.addLast(8);
        adeque.addFirst(7);
        adeque.addLast(0);
        adeque.addLast(0);
        adeque.addLast(5);
        adeque.addFirst(7);
        adeque.addFirst(6);
        adeque.addFirst(5);
        adeque.addLast(4);
        adeque.addLast(3);
        assertThat(adeque.getCapacity()).isEqualTo(16);
    }

    @Test
    @DisplayName("testOfGetElementsFromDeque")
    void testGetElements()
    {
         ArrayDeque61B<Integer> adeque = new ArrayDeque61B<>();

         /*  1 2 3 4 5 6 7 8 9 10 */
         /*  5 6 7 7 8 0 0 5 4 3 */
        adeque.addLast(8);
        adeque.addFirst(7);
        adeque.addLast(0);
        adeque.addLast(0);
        adeque.addLast(5);
        adeque.addFirst(7);
        adeque.addFirst(6);
        adeque.addFirst(5);
        adeque.addLast(4);
        adeque.addLast(3);
        assertThat(adeque.get(5)).isEqualTo(8);
        assertThat(adeque.get(1)).isEqualTo(5);
        assertThat(adeque.get(10)).isEqualTo(3);

    }

    @Test
    @DisplayName("testRemoveFirstFromDeque")
    void testRemoveFirst()
    {
          ArrayDeque61B<Integer> adeque = new ArrayDeque61B<>();

         /*  1 2 3 4 5 6 7 8 9 10 */
         /*  5 6 7 7 8 0 0 5 4 3 */
        adeque.addLast(8);
        adeque.addFirst(7);
        adeque.addLast(0);
        adeque.addLast(0);
        adeque.addLast(5);
        adeque.addFirst(7);
        adeque.addFirst(6);
        adeque.addFirst(5);
        adeque.addLast(4);
        adeque.addLast(3);
        assertThat(adeque.removeFirst()).isEqualTo(5);
        assertThat(adeque.size()).isEqualTo(9);
    }

    @Test
    @DisplayName("testRemoveLastFromDeque")
    void testRemoveLast()
    {
          ArrayDeque61B<Integer> adeque = new ArrayDeque61B<>();

         /*  1 2 3 4 5 6 7 8 9 10 */
         /*  5 6 7 7 8 0 0 5 4 3 */
        adeque.addLast(8);
        adeque.addFirst(7);
        adeque.addLast(0);
        adeque.addLast(0);
        adeque.addLast(5);
        adeque.addFirst(7);
        adeque.addFirst(6);
        adeque.addFirst(5);
        adeque.addLast(4);
        adeque.addLast(3);
        assertThat(adeque.removeLast()).isEqualTo(3);
        assertThat(adeque.size()).isEqualTo(9);
    }



}
