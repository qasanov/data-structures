package linkedlist;

import com.qasanov.ds.linkedlist.SinglyLinkedList;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();;

    @Before
    public void setUp() throws Exception {
        linkedList.removeAll();
        linkedList.insert(new Integer(9));
        linkedList.insert(new Integer(7));
        linkedList.insert(new Integer(5));
        linkedList.insert(new Integer(4));
        linkedList.insert(new Integer(3));
    }

    @Test
    public void insertNewElementToNonEmptyList() {
        linkedList.insert(new Integer(1));
        assertThat(linkedList.getTail()).isEqualTo(new Integer(1));
    }

    @Test
    public void insertFirstElementToEmptyList() {
        linkedList.removeAll();
        linkedList.insert(new Integer(11));
        assertThat(linkedList.getHead()).isEqualTo(linkedList.getTail());
    }

    @Test
    public void insertElementAfter() {
        int size = linkedList.size();
        linkedList.insert(new Integer(7), new Integer(6));
        assertThat(linkedList.size()).isEqualTo(++size);
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void getHeadElementFromEmptyList() {
        linkedList.removeAll();
        Integer head = linkedList.getHead();
        assertThat(head).isNull();
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void getTailElementFromEmptyList() {
        linkedList.removeAll();
        Integer tail = linkedList.getTail();
        assertThat(tail).isNull();
    }

    @Test
    public void getHead() {
        Integer head = linkedList.getHead();
        assertThat(head).isEqualTo(new Integer(9));
    }

    @Test
    public void getTail() {
        assertThat(linkedList.getTail()).isEqualTo(3);
        linkedList.insert(new Integer(1));
        assertThat(linkedList.getTail()).isEqualTo(1);
    }

    @Test
    public void sizeOfList() {
        int size = linkedList.size();
        assertThat(size).isEqualTo(5);
    }

    @Test
    public void removeLastElementFromList() {
        linkedList.insert(new Integer(2));
        linkedList.insert(new Integer(1));
        linkedList.remove();
        assertThat(linkedList.getTail()).isEqualTo(new Integer(2));
    }

    @Test
    public void removeElementFromEmptyList() {
        linkedList.removeAll();
        linkedList.remove();
        assertThat(linkedList.size()).isEqualTo(0);
    }

    @Test
    public void removeElementFromOneSizeList() {
        linkedList.removeAll();
        linkedList.insert(new Integer(0));
        linkedList.remove();
        assertThat(linkedList.size()).isEqualTo(0);
    }
}