/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

public interface NodeCollection<T extends Node>
    extends Iterable<T> {

  Node getParent();

  int size();

  T get(int index);

  void add(T node);

  void remove(T node);

  void clear();

  void accept(NodeVisitor visitor);

}
