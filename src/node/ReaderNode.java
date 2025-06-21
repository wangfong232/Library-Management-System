
package node;

import model.Reader;

/**
 *
 * @author qp
 */
public class ReaderNode {
    public Reader info;
    public ReaderNode next;

    public ReaderNode(Reader info) {
       this.info = info;
        this.next = null;
    }
    
}
