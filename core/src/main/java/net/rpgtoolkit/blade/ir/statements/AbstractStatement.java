package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.AbstractNode;
import net.rpgtoolkit.blade.ir.SourceRange;
import net.rpgtoolkit.blade.ir.Statement;

public abstract class AbstractStatement extends AbstractNode implements Statement {

  public AbstractStatement(SourceRange range) {
    super(range);
  }

}
