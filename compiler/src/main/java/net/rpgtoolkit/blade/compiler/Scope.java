package net.rpgtoolkit.blade.compiler;

import net.rpgtoolkit.blade.ir.symbols.Symbol;

import java.util.HashMap;
import java.util.Map;

/**
 * Scoped symbol table.
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class Scope {

  private final Scope parent;
  private final Map<String, Symbol> symbols;

  /**
   * Creates a new scope.
   *
   * @param enclosing enclosing scope instance, or null if scope is not enclosed
   */
  public Scope(Scope enclosing) {
    this.parent = enclosing;
    this.symbols = new HashMap<>();
  }

  /**
   * Determines if the scope is a top-level (global) scope.
   * @return true if global scope, else false
   */
  public boolean isGlobalScope() {
    return (this.parent == null);
  }

  /**
   * Returns the enclosing scope if the scope is enclosed.
   *
   * @return Scope instance if this scope is enclosed, else null
   */
  public Scope getEnclosingScope() {
    return this.parent;
  }

  /**
   * Determines if this scope or the enclosing scope contains a symbol with the specified name.
   *
   * @param name symbol name
   * @return true if symbol was found in the scope or enclosing, else false
   */
  public boolean contains(String name) {
    if (symbols.containsKey(name))
      return true;
    if (parent != null)
      return parent.contains(name);
    return false;
  }

  /**
   * Inserts a symbol into the scope. If the symbol already exists no action is taken.
   *
   * @param sym symbol instance
   * @return true if symbol was inserted, else false
   * @throws IllegalArgumentException if (sym == null)
   */
  public boolean insert(Symbol sym) {

    if (sym == null)
      throw new IllegalArgumentException();

    final String name = sym.getName();

    if (contains(name))
      return false;

    symbols.put(name, sym);
    return true;

  }

  /**
   * Recursively searches for a symbol with the specified name contained in this scope or the enclosing scope.
   *
   * @param name symbol name (must be non-null)
   * @return symbol instance, or null if a symbol was not found.
   * @throws IllegalArgumentException if (name == null)
   */
  public Symbol lookup(String name)  {
    return lookup(name, true);
  }

  /**
   * Recursively searches for a symbol with the specified name and symbol type contained in this scope
   * or the enclosing scope.
   *
   * @param name symbol name
   * @param type symbol type class
   * @param <T> symbol runtime type
   * @return symbol instance, or null if symbol was not found.
   * @throws IllegalArgumentException if (name == null) or (type == null)
   */
  public <T extends Symbol> T lookupWithType(String name, Class<T> type) {
    if (name == null || type == null)
      throw new IllegalArgumentException();
    final Symbol sym = symbols.get(name);
    if (sym != null && type.isAssignableFrom(sym.getClass()))
      return (T) sym;
    if (parent != null)
      return parent.lookupWithType(name, type);
    return null;
  }

  /**
   * Searches for a symbol with the specified name contained in this scope. If the recurse flag is set
   * the search is performed recursively.
   *
   * @param name symbol name
   * @param recurse if true, recursively search, else search only this scope
   * @return symbol instance, or null if symbol was not found.
   * @throws IllegalArgumentException if (name == null)
   */
  public Symbol lookup(String name, boolean recurse) {
    if (name == null)
      throw new IllegalArgumentException();
    if (symbols.containsKey(name))
      return symbols.get(name);
    if (parent != null && recurse)
      return parent.lookup(name);
    return null;
  }

}
