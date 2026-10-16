package domein;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class Node<T extends Serializable> implements Serializable {

	private final T data;
    @Setter private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

}