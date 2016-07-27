/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

import net.rpgtoolkit.blade.ir.attributes.NodeAttribute;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Collection of unique attributes attached to an IR node.
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class NodeAttributeCollection
  implements Iterable<NodeAttribute> {

  protected final Map<Integer, NodeAttribute> attributes;

  public NodeAttributeCollection() {
    this.attributes = new HashMap<>();
  }

  /**
   * Checks if a node attribute with the given ID is contained in the collection.
   *
   * @param id node attribute ID
   * @return true if attribute exists, else false
   */
  public boolean contains(int id) {
    return this.attributes.containsKey(id);
  }

  /**
   * Returns an attribute with the given ID, if the attribute exists in the collection.
   *
   * @see NodeAttribute
   * @param id node attribute ID
   * @return NodeAttribute instance if the attribute exists, else null
   */
  public NodeAttribute get(int id) {
    return this.attributes.get(id);
  }

  /**
   * Puts the given node attribute into the collection. If an attribute with the same
   * ID already exists, the attribute is replaced.
   *
   * @see NodeAttribute
   * @param attr node attribute to insert
   */
  public void put(NodeAttribute attr) {
    if (attr == null)
      throw new IllegalArgumentException();
    this.attributes.put(attr.getId(), attr);
  }

  /**
   * Removes the given node attribute from the collection. If the attribute is not contained
   * in the collection no action is performed.
   *
   * @param attr node attribute to remove
   */
  public void remove(NodeAttribute attr) {
    if (attr == null)
      throw new IllegalArgumentException();
    this.attributes.remove(attr.getId());
  }

  /**
   * Removes a node attribute from the collection with the given ID. If the attribute is
   * not contained in the collection no action is performed.
   *
   * @param id
   */
  public void remove(int id) {
    this.attributes.remove(id);
  }

  /**
   * Removes all node attributes from the collection.
   */
  public void clear() {
    this.attributes.clear();
  }

  /**
   * Returns an iterator for the node attributes in the collection.
   *
   * @return iterator
   */
  @Override
  public Iterator<NodeAttribute> iterator() {
    return this.attributes.values().iterator();
  }

}
