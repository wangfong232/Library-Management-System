package node;

import model.Book;

/**
 *
 * @author qp
 */
public class BookNode {

    public Book info;
    public BookNode next;

    public BookNode(Book info) {
        this.info = info;
        this.next = null;
    }

    @Override
    public String toString() {
        return info.toString();
    }

}
