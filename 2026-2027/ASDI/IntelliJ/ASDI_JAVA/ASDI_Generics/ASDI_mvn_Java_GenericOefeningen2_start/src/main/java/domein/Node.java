package domein;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Node {

	private final String data;
    @Setter private Node next;

    public Node(String data) {
        this.data = data;
    }

}