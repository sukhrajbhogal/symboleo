/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symboleo.symboleo.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.symboleo.symboleo.Atom;
import org.xtext.example.symboleo.symboleo.EventProp;
import org.xtext.example.symboleo.symboleo.Interval;
import org.xtext.example.symboleo.symboleo.Point;
import org.xtext.example.symboleo.symboleo.SitProp;
import org.xtext.example.symboleo.symboleo.SymboleoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symboleo.symboleo.impl.AtomImpl#getEventProposition <em>Event Proposition</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.impl.AtomImpl#getSituationProposition <em>Situation Proposition</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.impl.AtomImpl#getPoint <em>Point</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.impl.AtomImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.xtext.example.symboleo.symboleo.impl.AtomImpl#getBool <em>Bool</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AtomImpl extends MinimalEObjectImpl.Container implements Atom
{
  /**
   * The cached value of the '{@link #getEventProposition() <em>Event Proposition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventProposition()
   * @generated
   * @ordered
   */
  protected EventProp eventProposition;

  /**
   * The cached value of the '{@link #getSituationProposition() <em>Situation Proposition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSituationProposition()
   * @generated
   * @ordered
   */
  protected SitProp situationProposition;

  /**
   * The cached value of the '{@link #getPoint() <em>Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPoint()
   * @generated
   * @ordered
   */
  protected Point point;

  /**
   * The cached value of the '{@link #getInterval() <em>Interval</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterval()
   * @generated
   * @ordered
   */
  protected Interval interval;

  /**
   * The default value of the '{@link #getBool() <em>Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBool()
   * @generated
   * @ordered
   */
  protected static final String BOOL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBool() <em>Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBool()
   * @generated
   * @ordered
   */
  protected String bool = BOOL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AtomImpl()
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
    return SymboleoPackage.Literals.ATOM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EventProp getEventProposition()
  {
    return eventProposition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEventProposition(EventProp newEventProposition, NotificationChain msgs)
  {
    EventProp oldEventProposition = eventProposition;
    eventProposition = newEventProposition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__EVENT_PROPOSITION, oldEventProposition, newEventProposition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setEventProposition(EventProp newEventProposition)
  {
    if (newEventProposition != eventProposition)
    {
      NotificationChain msgs = null;
      if (eventProposition != null)
        msgs = ((InternalEObject)eventProposition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.ATOM__EVENT_PROPOSITION, null, msgs);
      if (newEventProposition != null)
        msgs = ((InternalEObject)newEventProposition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.ATOM__EVENT_PROPOSITION, null, msgs);
      msgs = basicSetEventProposition(newEventProposition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__EVENT_PROPOSITION, newEventProposition, newEventProposition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SitProp getSituationProposition()
  {
    return situationProposition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSituationProposition(SitProp newSituationProposition, NotificationChain msgs)
  {
    SitProp oldSituationProposition = situationProposition;
    situationProposition = newSituationProposition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__SITUATION_PROPOSITION, oldSituationProposition, newSituationProposition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSituationProposition(SitProp newSituationProposition)
  {
    if (newSituationProposition != situationProposition)
    {
      NotificationChain msgs = null;
      if (situationProposition != null)
        msgs = ((InternalEObject)situationProposition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.ATOM__SITUATION_PROPOSITION, null, msgs);
      if (newSituationProposition != null)
        msgs = ((InternalEObject)newSituationProposition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.ATOM__SITUATION_PROPOSITION, null, msgs);
      msgs = basicSetSituationProposition(newSituationProposition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__SITUATION_PROPOSITION, newSituationProposition, newSituationProposition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Point getPoint()
  {
    return point;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPoint(Point newPoint, NotificationChain msgs)
  {
    Point oldPoint = point;
    point = newPoint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__POINT, oldPoint, newPoint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPoint(Point newPoint)
  {
    if (newPoint != point)
    {
      NotificationChain msgs = null;
      if (point != null)
        msgs = ((InternalEObject)point).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.ATOM__POINT, null, msgs);
      if (newPoint != null)
        msgs = ((InternalEObject)newPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.ATOM__POINT, null, msgs);
      msgs = basicSetPoint(newPoint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__POINT, newPoint, newPoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Interval getInterval()
  {
    return interval;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInterval(Interval newInterval, NotificationChain msgs)
  {
    Interval oldInterval = interval;
    interval = newInterval;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__INTERVAL, oldInterval, newInterval);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInterval(Interval newInterval)
  {
    if (newInterval != interval)
    {
      NotificationChain msgs = null;
      if (interval != null)
        msgs = ((InternalEObject)interval).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.ATOM__INTERVAL, null, msgs);
      if (newInterval != null)
        msgs = ((InternalEObject)newInterval).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymboleoPackage.ATOM__INTERVAL, null, msgs);
      msgs = basicSetInterval(newInterval, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__INTERVAL, newInterval, newInterval));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getBool()
  {
    return bool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBool(String newBool)
  {
    String oldBool = bool;
    bool = newBool;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.ATOM__BOOL, oldBool, bool));
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
      case SymboleoPackage.ATOM__EVENT_PROPOSITION:
        return basicSetEventProposition(null, msgs);
      case SymboleoPackage.ATOM__SITUATION_PROPOSITION:
        return basicSetSituationProposition(null, msgs);
      case SymboleoPackage.ATOM__POINT:
        return basicSetPoint(null, msgs);
      case SymboleoPackage.ATOM__INTERVAL:
        return basicSetInterval(null, msgs);
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
      case SymboleoPackage.ATOM__EVENT_PROPOSITION:
        return getEventProposition();
      case SymboleoPackage.ATOM__SITUATION_PROPOSITION:
        return getSituationProposition();
      case SymboleoPackage.ATOM__POINT:
        return getPoint();
      case SymboleoPackage.ATOM__INTERVAL:
        return getInterval();
      case SymboleoPackage.ATOM__BOOL:
        return getBool();
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
      case SymboleoPackage.ATOM__EVENT_PROPOSITION:
        setEventProposition((EventProp)newValue);
        return;
      case SymboleoPackage.ATOM__SITUATION_PROPOSITION:
        setSituationProposition((SitProp)newValue);
        return;
      case SymboleoPackage.ATOM__POINT:
        setPoint((Point)newValue);
        return;
      case SymboleoPackage.ATOM__INTERVAL:
        setInterval((Interval)newValue);
        return;
      case SymboleoPackage.ATOM__BOOL:
        setBool((String)newValue);
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
      case SymboleoPackage.ATOM__EVENT_PROPOSITION:
        setEventProposition((EventProp)null);
        return;
      case SymboleoPackage.ATOM__SITUATION_PROPOSITION:
        setSituationProposition((SitProp)null);
        return;
      case SymboleoPackage.ATOM__POINT:
        setPoint((Point)null);
        return;
      case SymboleoPackage.ATOM__INTERVAL:
        setInterval((Interval)null);
        return;
      case SymboleoPackage.ATOM__BOOL:
        setBool(BOOL_EDEFAULT);
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
      case SymboleoPackage.ATOM__EVENT_PROPOSITION:
        return eventProposition != null;
      case SymboleoPackage.ATOM__SITUATION_PROPOSITION:
        return situationProposition != null;
      case SymboleoPackage.ATOM__POINT:
        return point != null;
      case SymboleoPackage.ATOM__INTERVAL:
        return interval != null;
      case SymboleoPackage.ATOM__BOOL:
        return BOOL_EDEFAULT == null ? bool != null : !BOOL_EDEFAULT.equals(bool);
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
    result.append(" (bool: ");
    result.append(bool);
    result.append(')');
    return result.toString();
  }

} //AtomImpl
