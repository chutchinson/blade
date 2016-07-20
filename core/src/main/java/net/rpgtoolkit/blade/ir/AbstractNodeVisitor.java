/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

import net.rpgtoolkit.blade.ir.expressions.*;
import net.rpgtoolkit.blade.ir.statements.*;

public abstract class AbstractNodeVisitor implements NodeVisitor {

    public void visit(CompilationUnit node) { }
    public void visit(Parameter node) { }
    public void visit(ClassDeclaration node) { }
    public void visit(ClassFieldDeclaration node) { }
    public void visit(FunctionDeclaration node) { }
    public void visit(Block node) { }
    public void visit(ReturnStatement node) { }
    public void visit(ConditionalStatement node)  { }
    public void visit(ExpressionStatement node) { }
    public void visit(LoopStatement node) { }
    public void visit(ForLoopStatement node) { }
    public void visit(FlowControlStatement node) { }
    public void visit(LabelStatement node) { }
    public void visit(Identifier node) { }
    public void visit(UnaryExpression node) { }
    public void visit(CallExpression node) { }
    public void visit(ConstantNumberExpression node) { }
    public void visit(ConstantStringExpression node) { }
    public void visit(ConstantBooleanExpression node) { }
    public void visit(AdditiveBinaryExpression node) { }
    public void visit(MultiplicativeBinaryExpression node) { }
    public void visit(RelationalBinaryExpression node) { }
    public void visit(ShiftBinaryExpression node) { }
    public void visit(LogicalBinaryExpression node) { }
    public void visit(BitwiseBinaryExpression node) { }
    public void visit(AssignmentExpression node) { }
    public void visit(IndexExpression node) { }
    public void visit(PostfixExpression node) { }

}
