package edge;

import vertex.Vertex;
/**
 * Commentie.
 * @author goerwa
 *
 */
public class CommentTie extends DirectedEdge {
  // Abstraction function:
  // AF(Edge) = {edge|label != null && source ！= null && target ！= null
  // && weight >= 0 && type of
  // source, target = person}.
  //
  // Representation invariant:
  // label cannot be null
  // Neither source nor target can be null
  // weight is more than or equals 0
  // type of two vertices is person
  //
  // Safety from rep exposure:
  // All fileds are private
  // the get methods can prevent sharing data with clients.
  /**
   * to construct.
   * @param label
   * label of edge
   * @param weight
   * weight of edge
   */
  public CommentTie(final String label, final double weight) {
    super(label, weight);
    checkRep();
  }
  /**
   * to construct.
   * @param src
   * source of edge
   * @param arg
   * target of edge
   * @param weight
   * weight of edge
   */
  public CommentTie(final Vertex src, final Vertex arg, final double weight) {
    super(src, arg, weight);
    checkRep();
  }
  /**
   * to construct.
   * @param label
   * label of edge
   * @param src
   * source of edge
   * @param arg
   * target of edge
   * @param weight
   * weight of edge
   */
  public CommentTie(final String label, final Vertex src, final Vertex arg,
      final double weight) {
    super(label, src, arg, weight);
    checkRep();
  }
  /**
   * checkrep to assert weight is [0,1]
   * and type of vertices is person.
   */
  private void checkRep() {
    assert this.getweight() >= 0.0 && this.getweight() <= 1.0;
    assert this.getsource().tellclass().equals("Person");
    assert this.gettarget().tellclass().equals("Person");
  }

  @Override
  public final String tellclass() {
    return "CommentTie";
  }

  @Override
  public final boolean equals(final Object e) {
    if (e == null) {
      return false;
    }
    Edge edge = (Edge) e;
    if (edge.tellclass().equals(this.tellclass())) {
      if (edge.getsource().equals(this.getsource())
          && edge.gettarget().equals(this.gettarget())) {
        return true;
      }
    }
    return false;
  }
}
