package ru.job4j.collection;

import java.util.Iterator;

public class TestRevertLinked {
    public static void main(String[] args) {
     RevertLinked<Integer> revertLinked = new RevertLinked();
     revertLinked.add(1);
     revertLinked.add(2);
     revertLinked.add(3);
        Iterator iterator = revertLinked.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------------------");
     revertLinked.revert();
        Iterator iterator1 = revertLinked.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
