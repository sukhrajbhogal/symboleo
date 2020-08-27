/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symboleo.symboleo.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.symboleo.symboleo.Junction;
import org.xtext.example.symboleo.symboleo.Negation;
import org.xtext.example.symboleo.symboleo.SymboleoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Junction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symboleo.symboleo.impl.JunctionImpl#getNegativeAtoms <em>Negative Atoms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JunctionImpl extends MinimalEObjectImpl.Container implements Junction
{
  /**
   * The cached value of the '{@link #getNegativeAtoms() <em>Negative Atoms</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNegativeAtoms()
   * @generated
   * @ordered
   */
  protected EList<Negation> negativeAtoms;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JunctionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SymboleoPackage.Literals.JUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Negation> getNegativeAtoms()
  {
    if (negativeAtoms == null)
    {
      negativeAtoms = new EObjectContainmentEList<Negation>(Negation.class, this, SymboleoPackage.JUNCTION__NEGATIVE_ATOMS);
    }
    return negativeAtoms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SymboleoPackage.JUNCTION__NEGATIVE_ATOMS:
        return ((InternalEList<?>)getNegativeAtoms()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SymboleoPackage.JUNCTION__NEGATIVE_ATOMS:
        return getNegativeAtoms();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SymboleoPackage.JUNCTION__NEGATIVE_ATOMS:
        getNegativeAtoms().clear();
        getNegativeAtoms().addAll((Collection<? extends Negation>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SymboleoPackage.JUNCTION__NEGATIVE_ATOMS:
        getNegativeAtoms().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SymboleoPackage.JUNCTION__NEGATIVE_ATOMS:
        return negativeAtoms != null && !negativeAtoms.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //JunctionImpl
