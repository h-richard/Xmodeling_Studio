package xmodeling.contents;

import java.text.MessageFormat;

public class XtextContent implements FileContent {
	
	@Override
	public String getContentFor(String projectName, String projectClass) {
		return null;
	}
	
	public String getContentFor(String projectName, String projectClass, String modelPath) {
		return MessageFormat.format(
			"""
			grammar org.xtext.{0} with org.eclipse.xtext.common.Terminals
			
			import "platform:/resource/{1}"
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			
			Xmod_Action returns Xmod_Action:
				''Action'' name=EString '''{''' operations+=Xmod_OperationCall (operations+=Xmod_OperationCall)* '''}''';
			
			Xmod_OperationDef returns Xmod_Operation:
				name=EString''(''( parametersTag+=EString ( "," parametersTag+=EString )* )?'')''
					''on'' objectTag=EString (''returns'' returnTag=EString)?
					(exceptions+=Xmod_Exception (exceptions+=Xmod_Exception)* )?;
			
			Xmod_OperationCall returns Xmod_Operation:
				''call'' Xmod_OperationDef '';'';
			
			Xmod_Exception returns Xmod_Exception:
				''onError'' (kind=Xmod_ExceptionKind_Unfiltered | kind=Xmod_ExceptionKind_Filtered ''(''filter=EString'')'')
				(''call'' calledOperation=Xmod_OperationDef)? ''then'' reaction=Xmod_ExceptionReaction;
			
			enum Xmod_ExceptionReaction:
				continue | skip | exit;
			
			enum Xmod_ExceptionKind:
				other = ''other'' |
				unknownNamespace = ''unknownNamespace'' |
				objectNotFound = ''objectNotFound'' |
				methodNotFound = ''methodNotFound'' |
				parametersNotMatching = ''parametersNotMatching'' |
				returnTypeNotMatching = ''returnTypeNotMatching'' |
				methodException = ''methodException'';
			
			Xmod_ExceptionKind_Filtered returns Xmod_ExceptionKind:
				''methodException'';
			
			Xmod_ExceptionKind_Unfiltered returns Xmod_ExceptionKind:
				''other'' | ''unknownNamespace'' | ''objectNotFound'' | ''methodNotFound'' | ''parametersNotMatching'' | ''returnTypeNotMatching'';
			
			EString returns ecore::EString:
				STRING | ID;
			""",
		projectName, modelPath);
	}

}
