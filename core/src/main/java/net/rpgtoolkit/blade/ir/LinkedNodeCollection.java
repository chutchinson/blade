package net.rpgtoolkit.blade.ir;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedNodeCollection<T extends Node>
    implements NodeCollection<T> {

  private final Node parent;
  private final List<T> nodes;

  public LinkedNodeCollection(Node parent) {
    if (parent == null)
      throw new IllegalArgumentException();
    this.parent = parent;
    this.nodes = new LinkedList<>();
  }

  public Node getParent() {
    return this.parent;
  }

  public int size() {
    return this.nodes.size();
  }

  public T get(int index) {
    return this.nodes.get(index);
  }

  public void add(T node) {
    if (node != null) {
      node.setParent(this.parent);
      this.nodes.add(node);
    }
  }

  public void remove(T node) {
    if (this.nodes.remove(node)) {
      node.setParent(null);
    }
  }

  public void clear() {
    for (final T node : this.nodes) {
      node.setParent(null);
    }
    this.nodes.clear();
  }

  public void accept(NodeVisitor visitor) {
    for (final T node : this.nodes) {
      node.accept(visitor);
    }
  }

  @Override
  public Iterator<T> iterator() {
    return this.nodes.iterator();
  }

}
