/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symboleo.symboleo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Negation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symboleo.symboleo.Negation#isNegated <em>Negated</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.Negation#getAtomicExpression <em>Atomic Expression</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getNegation()
 * @model
 * @generated
 */
public interface Negation extends EObject
{
  /**
   * Returns the value of the '<em><b>Negated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Negated</em>' attribute.
   * @see #setNegated(boolean)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getNegation_Negated()
   * @model
   * @generated
   */
  boolean isNegated();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.Negation#isNegated <em>Negated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Negated</em>' attribute.
   * @see #isNegated()
   * @generated
   */
  void setNegated(boolean value);

  /**
   * Returns the value of the '<em><b>Atomic Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atomic Expression</em>' containment reference.
   * @see #setAtomicExpression(Atom)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getNegation_AtomicExpression()
   * @model containment="true"
   * @generated
   */
  Atom getAtomicExpression();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.Negation#getAtomicExpression <em>Atomic Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atomic Expression</em>' containment reference.
   * @see #getAtomicExpression()
   * @generated
   */
  void setAtomicExpression(Atom value);

} // Negation
