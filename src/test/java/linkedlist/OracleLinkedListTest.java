package linkedlist;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import static org.assertj.core.api.Assertions.assertThat;

public class OracleLinkedListTest {

    private final LinkedList<String> sampleList = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        sampleList.add("Assembly");
        sampleList.add("Fortran");
        sampleList.add("Pascal");
        sampleList.add("C");
        sampleList.add("C++");
        sampleList.add("Java");
        sampleList.add("C#");
        sampleList.add("Kotlin");
    }

    @Test
    public void addElementToHeadOfList() {
        sampleList.addFirst("PHP");
        assertThat(sampleList.getFirst()).isEqualTo("PHP");
    }

    @Test
    public void addElementToEndOfList() {
        sampleList.add("Go");
        assertThat(sampleList.getLast()).isEqualTo("Go");
    }

    @Test
    public void addElementAtSpecificIndex() {
        sampleList.add(2,"Clojure");
        assertThat(sampleList.get(2)).isEqualTo("Clojure");
    }

    @Test
    public void removeElementFromList() {
        int size = sampleList.size();
        sampleList.removeLast();
        assertThat(sampleList.size()).isEqualTo(--size);
    }

    @Test
    public void removeElementWithProvidedPredicate() {
        int size = sampleList.size();
        long count = sampleList.stream().filter(s -> s.toLowerCase().startsWith("c")).count();
        sampleList.removeIf(s->s.toLowerCase().startsWith("c"));
        assertThat(sampleList.size()).isEqualTo(size-count);
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void removeFromEmptyList() {
        sampleList.clear();
        sampleList.getFirst();
    }

    @Test
    public void searchElementInList() {
        sampleList.add("Scala");
        int indexOf = sampleList.indexOf("Scala");
        assertThat(indexOf).isEqualTo(sampleList.size() - 1);
    }

    @Test
    public void iterateListUsingJava8ForEach() {
        LinkedList<String> secondList = new LinkedList<>();
        sampleList.forEach(secondList::add);
        assertThat(sampleList.size()).isEqualTo(secondList.size());
    }

    @Test
    public void iterateListUsingIterator() {
        LinkedList<String> secondList = new LinkedList<>();
        Iterator<String> iterator = sampleList.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            secondList.add(element);
        }
        assertThat(sampleList.size()).isEqualTo(secondList.size());
    }

    @Test
    public void iterateListUsingListIterator() {
        LinkedList<String> secondList = new LinkedList<>();
        ListIterator<String> iterator = sampleList.listIterator(sampleList.size());
        while (iterator.hasPrevious()){
            String element = iterator.previous();
            secondList.add(element);
        }
        assertThat(sampleList.size()).isEqualTo(secondList.size());
    }

    @Test(expected = java.util.ConcurrentModificationException.class)
    public void failFast() {
        for (String s : sampleList) {
            sampleList.add( "Scala");
        }
    }
}
