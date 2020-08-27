/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symboleo.symboleo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sit Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symboleo.symboleo.SitName#getSitName <em>Sit Name</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.SitName#getOState <em>OState</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.SitName#getPState <em>PState</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.SitName#getCState <em>CState</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.SitName#getOEvent <em>OEvent</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.SitName#getCEvent <em>CEvent</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.SitName#getPEvent <em>PEvent</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getSitName()
 * @model
 * @generated
 */
public interface SitName extends EObject
{
  /**
   * Returns the value of the '<em><b>Sit Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sit Name</em>' attribute.
   * @see #setSitName(String)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getSitName_SitName()
   * @model
   * @generated
   */
  String getSitName();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.SitName#getSitName <em>Sit Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sit Name</em>' attribute.
   * @see #getSitName()
   * @generated
   */
  void setSitName(String value);

  /**
   * Returns the value of the '<em><b>OState</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>OState</em>' containment reference.
   * @see #setOState(oState)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getSitName_OState()
   * @model containment="true"
   * @generated
   */
  oState getOState();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.SitName#getOState <em>OState</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>OState</em>' containment reference.
   * @see #getOState()
   * @generated
   */
  void setOState(oState value);

  /**
   * Returns the value of the '<em><b>PState</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>PState</em>' containment reference.
   * @see #setPState(pState)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getSitName_PState()
   * @model containment="true"
   * @generated
   */
  pState getPState();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.SitName#getPState <em>PState</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>PState</em>' containment reference.
   * @see #getPState()
   * @generated
   */
  void setPState(pState value);

  /**
   * Returns the value of the '<em><b>CState</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>CState</em>' containment reference.
   * @see #setCState(cState)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getSitName_CState()
   * @model containment="true"
   * @generated
   */
  cState getCState();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.SitName#getCState <em>CState</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>CState</em>' containment reference.
   * @see #getCState()
   * @generated
   */
  void setCState(cState value);

  /**
   * Returns the value of the '<em><b>OEvent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>OEvent</em>' containment reference.
   * @see #setOEvent(oEvent)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getSitName_OEvent()
   * @model containment="true"
   * @generated
   */
  oEvent getOEvent();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.SitName#getOEvent <em>OEvent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>OEvent</em>' containment reference.
   * @see #getOEvent()
   * @generated
   */
  void setOEvent(oEvent value);

  /**
   * Returns the value of the '<em><b>CEvent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>CEvent</em>' containment reference.
   * @see #setCEvent(cEvent)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getSitName_CEvent()
   * @model containment="true"
   * @generated
   */
  cEvent getCEvent();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.SitName#getCEvent <em>CEvent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>CEvent</em>' containment reference.
   * @see #getCEvent()
   * @generated
   */
  void setCEvent(cEvent value);

  /**
   * Returns the value of the '<em><b>PEvent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>PEvent</em>' containment reference.
   * @see #setPEvent(pEvent)
   * @see org.xtext.example.symboleo.symboleo.SymboleoPackage#getSitName_PEvent()
   * @model containment="true"
   * @generated
   */
  pEvent getPEvent();

  /**
   * Sets the value of the '{@link org.xtext.example.symboleo.symboleo.SitName#getPEvent <em>PEvent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>PEvent</em>' containment reference.
   * @see #getPEvent()
   * @generated
   */
  void setPEvent(pEvent value);

} // SitName
