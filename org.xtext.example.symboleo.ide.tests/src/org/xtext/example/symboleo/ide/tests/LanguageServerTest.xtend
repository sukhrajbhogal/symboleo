package org.xtext.example.symboleo.ide.tests

import org.eclipse.xtext.testing.AbstractLanguageServerTest
import org.eclipse.core.runtime.Assert

class LanguageServerTest extends AbstractLanguageServerTest {
	
	new() {
		super("symboleo")
	}
	
	@Test
	def void test01_initialization() {
		val capabilities = initialize().capabilities 
		Assert.assertTrue{
			capabilities.definitionProvider && capabilities.documentFormattingProvider)
		}
	}
}