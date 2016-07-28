/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.Identifier;
import net.rpgtoolkit.blade.ir.NodeVisitor;
import net.rpgtoolkit.blade.ir.SourceRange;

public class ErrorHandlerStatement extends AbstractStatement {

  public enum ErrorHandlerKind {
    RESUME,
    THROW,
    JUMP
  }

  private ErrorHandlerKind kind;
  private Identifier label;

  public ErrorHandlerStatement(SourceRange range, ErrorHandlerKind kind) {
    super(range);
    this.setKind(kind);
  }

  public ErrorHandlerKind getKind() {
    return this.kind;
  }

  public void setKind(ErrorHandlerKind kind) {
    this.kind = kind;
  }

  public Identifier getLabel() {
    return this.label;
  }

  public void setLabel(Identifier label) {
    if (label != null) {
      this.label = label;
      this.kind = ErrorHandlerKind.JUMP;
    }
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

}
