/*
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symboleo;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class SymboleoStandaloneSetup extends SymboleoStandaloneSetupGenerated {

	public static void doSetup() {
		new SymboleoStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
