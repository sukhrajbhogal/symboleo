/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symboleo.symboleo.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.symboleo.symboleo.SymboleoPackage;
import org.xtext.example.symboleo.symboleo.oState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>oState</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symboleo.symboleo.impl.oStateImpl#getOblState <em>Obl State</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.impl.oStateImpl#getOblName <em>Obl Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class oStateImpl extends MinimalEObjectImpl.Container implements oState
{
  /**
   * The default value of the '{@link #getOblState() <em>Obl State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOblState()
   * @generated
   * @ordered
   */
  protected static final String OBL_STATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOblState() <em>Obl State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOblState()
   * @generated
   * @ordered
   */
  protected String oblState = OBL_STATE_EDEFAULT;

  /**
   * The default value of the '{@link #getOblName() <em>Obl Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOblName()
   * @generated
   * @ordered
   */
  protected static final String OBL_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOblName() <em>Obl Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOblName()
   * @generated
   * @ordered
   */
  protected String oblName = OBL_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected oStateImpl()
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
    return SymboleoPackage.Literals.OSTATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOblState()
  {
    return oblState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOblState(String newOblState)
  {
    String oldOblState = oblState;
    oblState = newOblState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.OSTATE__OBL_STATE, oldOblState, oblState));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOblName()
  {
    return oblName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOblName(String newOblName)
  {
    String oldOblName = oblName;
    oblName = newOblName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.OSTATE__OBL_NAME, oldOblName, oblName));
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
      case SymboleoPackage.OSTATE__OBL_STATE:
        return getOblState();
      case SymboleoPackage.OSTATE__OBL_NAME:
        return getOblName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SymboleoPackage.OSTATE__OBL_STATE:
        setOblState((String)newValue);
        return;
      case SymboleoPackage.OSTATE__OBL_NAME:
        setOblName((String)newValue);
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
      case SymboleoPackage.OSTATE__OBL_STATE:
        setOblState(OBL_STATE_EDEFAULT);
        return;
      case SymboleoPackage.OSTATE__OBL_NAME:
        setOblName(OBL_NAME_EDEFAULT);
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
      case SymboleoPackage.OSTATE__OBL_STATE:
        return OBL_STATE_EDEFAULT == null ? oblState != null : !OBL_STATE_EDEFAULT.equals(oblState);
      case SymboleoPackage.OSTATE__OBL_NAME:
        return OBL_NAME_EDEFAULT == null ? oblName != null : !OBL_NAME_EDEFAULT.equals(oblName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (oblState: ");
    result.append(oblState);
    result.append(", oblName: ");
    result.append(oblName);
    result.append(')');
    return result.toString();
  }

} //oStateImpl
