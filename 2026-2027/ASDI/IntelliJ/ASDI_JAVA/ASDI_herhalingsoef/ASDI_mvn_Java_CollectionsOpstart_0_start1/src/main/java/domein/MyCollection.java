package domein;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

//OEF GENERICS VRAAG 5
public class MyCollection<T extends Reductiebon> {
    public Queue<T> queue = new ArrayDeque<>();

    public void addElement(T element) {
        queue.offer(element);
    }

    public T getElement() {
        return queue.poll();
    }

    public void addReeks(List<? extends T> list) {
        queue.addAll(list);
    }

    public double gemiddeldePercentage() {
        return queue.stream().mapToInt(Reductiebon::getPercentage).average().orElse(0.0);
    }


}

