package xmodeling.contents;

import java.text.MessageFormat;

public class Xmod_ExceptionImplContent implements FileContent {
    @Override
    public String getContentFor(String projectName, String projectClass) {
        return MessageFormat.format(
            """
            /**
			 */
			package {0}.impl;
			
			import org.eclipse.emf.common.notify.Notification;
			import org.eclipse.emf.common.notify.NotificationChain;
			
			import org.eclipse.emf.ecore.EClass;
			import org.eclipse.emf.ecore.InternalEObject;
			
			import org.eclipse.emf.ecore.impl.ENotificationImpl;
			import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
			
			import {0}.{1}Package;
			import {0}.Xmod_Exception;
			import {0}.Xmod_ExceptionLiteral;
			import {0}.Xmod_ExceptionReaction;
			import {0}.Xmod_Operation;
			
			/**
			 * <!-- begin-user-doc -->
			 * An implementation of the model object ''<em><b>Xmod Exception</b></em>''.
			 * <!-- end-user-doc -->
			 * <p>
			 * The following features are implemented:
			 * </p>
			 * <ul>
			 *   <li>'{'@link {0}.impl.Xmod_ExceptionImpl#getLiteral <em>Literal</em>'}'</li>
			 *   <li>'{'@link {0}.impl.Xmod_ExceptionImpl#getFilter <em>Filter</em>'}'</li>
			 *   <li>'{'@link {0}.impl.Xmod_ExceptionImpl#getReaction <em>Reaction</em>'}'</li>
			 *   <li>'{'@link {0}.impl.Xmod_ExceptionImpl#getCalledOperation <em>Called Operation</em>'}'</li>
			 * </ul>
			 *
			 * @generated
			 */
			public class Xmod_ExceptionImpl extends MinimalEObjectImpl.Container implements Xmod_Exception '{'
				/**
				 * The default value of the '''{'@link #getLiteral() <em>Literal</em>'}''' attribute.
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @see #getLiteral()
				 * @generated
				 * @ordered
				 */
				protected static final Xmod_ExceptionLiteral LITERAL_EDEFAULT = Xmod_ExceptionLiteral.OK;
			
				/**
				 * The cached value of the '''{'@link #getLiteral() <em>Literal</em>'}''' attribute.
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @see #getLiteral()
				 * @generated
				 * @ordered
				 */
				protected Xmod_ExceptionLiteral literal = LITERAL_EDEFAULT;
			
				/**
				 * The default value of the '''{'@link #getFilter() <em>Filter</em>'}''' attribute.
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @see #getFilter()
				 * @generated
				 * @ordered
				 */
				protected static final String FILTER_EDEFAULT = null;
			
				/**
				 * The cached value of the '''{'@link #getFilter() <em>Filter</em>'}''' attribute.
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @see #getFilter()
				 * @generated
				 * @ordered
				 */
				protected String filter = FILTER_EDEFAULT;
			
				/**
				 * The default value of the '''{'@link #getReaction() <em>Reaction</em>'}''' attribute.
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @see #getReaction()
				 * @generated
				 * @ordered
				 */
				protected static final Xmod_ExceptionReaction REACTION_EDEFAULT = Xmod_ExceptionReaction.CONTINUE;
			
				/**
				 * The cached value of the '''{'@link #getReaction() <em>Reaction</em>'}''' attribute.
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @see #getReaction()
				 * @generated
				 * @ordered
				 */
				protected Xmod_ExceptionReaction reaction = REACTION_EDEFAULT;
			
				/**
				 * The cached value of the '''{'@link #getCalledOperation() <em>Called Operation</em>'}''' containment reference.
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @see #getCalledOperation()
				 * @generated
				 * @ordered
				 */
				protected Xmod_Operation calledOperation;
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				protected Xmod_ExceptionImpl() '{'
					super();
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				protected EClass eStaticClass() '{'
					return {1}Package.Literals.XMOD_EXCEPTION;
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public Xmod_ExceptionLiteral getLiteral() '{'
					return literal;
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public void setLiteral(Xmod_ExceptionLiteral newLiteral) '{'
					Xmod_ExceptionLiteral oldLiteral = literal;
					literal = newLiteral == null ? LITERAL_EDEFAULT : newLiteral;
					if (eNotificationRequired())
						eNotify(new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_EXCEPTION__LITERAL, oldLiteral, literal));
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public String getFilter() '{'
					return filter;
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public void setFilter(String newFilter) '{'
					String oldFilter = filter;
					filter = newFilter;
					if (eNotificationRequired())
						eNotify(new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_EXCEPTION__FILTER, oldFilter, filter));
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public Xmod_ExceptionReaction getReaction() '{'
					return reaction;
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public void setReaction(Xmod_ExceptionReaction newReaction) '{'
					Xmod_ExceptionReaction oldReaction = reaction;
					reaction = newReaction == null ? REACTION_EDEFAULT : newReaction;
					if (eNotificationRequired())
						eNotify(new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_EXCEPTION__REACTION, oldReaction, reaction));
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public Xmod_Operation getCalledOperation() '{'
					return calledOperation;
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				public NotificationChain basicSetCalledOperation(Xmod_Operation newCalledOperation, NotificationChain msgs) '{'
					Xmod_Operation oldCalledOperation = calledOperation;
					calledOperation = newCalledOperation;
					if (eNotificationRequired()) '{'
						ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_EXCEPTION__CALLED_OPERATION, oldCalledOperation, newCalledOperation);
						if (msgs == null) msgs = notification; else msgs.add(notification);
					'}'
					return msgs;
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public void setCalledOperation(Xmod_Operation newCalledOperation) '{'
					if (newCalledOperation != calledOperation) '{'
						NotificationChain msgs = null;
						if (calledOperation != null)
							msgs = ((InternalEObject)calledOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - {1}Package.XMOD_EXCEPTION__CALLED_OPERATION, null, msgs);
						if (newCalledOperation != null)
							msgs = ((InternalEObject)newCalledOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - {1}Package.XMOD_EXCEPTION__CALLED_OPERATION, null, msgs);
						msgs = basicSetCalledOperation(newCalledOperation, msgs);
						if (msgs != null) msgs.dispatch();
					'}'
					else if (eNotificationRequired())
						eNotify(new ENotificationImpl(this, Notification.SET, {1}Package.XMOD_EXCEPTION__CALLED_OPERATION, newCalledOperation, newCalledOperation));
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) '{'
					switch (featureID) '{'
						case {1}Package.XMOD_EXCEPTION__CALLED_OPERATION:
							return basicSetCalledOperation(null, msgs);
					'}'
					return super.eInverseRemove(otherEnd, featureID, msgs);
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public Object eGet(int featureID, boolean resolve, boolean coreType) '{'
					switch (featureID) '{'
						case {1}Package.XMOD_EXCEPTION__LITERAL:
							return getLiteral();
						case {1}Package.XMOD_EXCEPTION__FILTER:
							return getFilter();
						case {1}Package.XMOD_EXCEPTION__REACTION:
							return getReaction();
						case {1}Package.XMOD_EXCEPTION__CALLED_OPERATION:
							return getCalledOperation();
					'}'
					return super.eGet(featureID, resolve, coreType);
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public void eSet(int featureID, Object newValue) '{'
					switch (featureID) '{'
						case {1}Package.XMOD_EXCEPTION__LITERAL:
							setLiteral((Xmod_ExceptionLiteral)newValue);
							return;
						case {1}Package.XMOD_EXCEPTION__FILTER:
							setFilter((String)newValue);
							return;
						case {1}Package.XMOD_EXCEPTION__REACTION:
							setReaction((Xmod_ExceptionReaction)newValue);
							return;
						case {1}Package.XMOD_EXCEPTION__CALLED_OPERATION:
							setCalledOperation((Xmod_Operation)newValue);
							return;
					'}'
					super.eSet(featureID, newValue);
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public void eUnset(int featureID) '{'
					switch (featureID) '{'
						case {1}Package.XMOD_EXCEPTION__LITERAL:
							setLiteral(LITERAL_EDEFAULT);
							return;
						case {1}Package.XMOD_EXCEPTION__FILTER:
							setFilter(FILTER_EDEFAULT);
							return;
						case {1}Package.XMOD_EXCEPTION__REACTION:
							setReaction(REACTION_EDEFAULT);
							return;
						case {1}Package.XMOD_EXCEPTION__CALLED_OPERATION:
							setCalledOperation((Xmod_Operation)null);
							return;
					'}'
					super.eUnset(featureID);
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public boolean eIsSet(int featureID) '{'
					switch (featureID) '{'
						case {1}Package.XMOD_EXCEPTION__LITERAL:
							return literal != LITERAL_EDEFAULT;
						case {1}Package.XMOD_EXCEPTION__FILTER:
							return FILTER_EDEFAULT == null ? filter != null : !FILTER_EDEFAULT.equals(filter);
						case {1}Package.XMOD_EXCEPTION__REACTION:
							return reaction != REACTION_EDEFAULT;
						case {1}Package.XMOD_EXCEPTION__CALLED_OPERATION:
							return calledOperation != null;
					'}'
					return super.eIsSet(featureID);
				'}'
			
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
				 * @generated
				 */
				@Override
				public String toString() '{'
					if (eIsProxy()) return super.toString();
			
					StringBuilder result = new StringBuilder(super.toString());
					result.append(" (literal: ");
					result.append(literal);
					result.append(", filter: ");
					result.append(filter);
					result.append(", reaction: ");
					result.append(reaction);
					result.append('')'');
					return result.toString();
				'}'
			
			'}' //Xmod_ExceptionImpl
			""",
        projectName, projectClass);
    }
}
