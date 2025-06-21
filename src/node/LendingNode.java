
package node;

import model.Lending;

/**
 *
 * @author qp
 */
public class LendingNode {

    public Lending info;
    public LendingNode next;

    public LendingNode(Lending info) {
        this.info = info;
        this.next = null;
    }

}
