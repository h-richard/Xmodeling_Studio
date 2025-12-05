package xmodeling.contents;

import java.text.MessageFormat;

public class XtextContent implements FileContent {
	
	@Override
	public String getContentFor(String projectName, String projectClass) {
		return null;
	}
	
	public String getContentFor(String modelPath) {
		return MessageFormat.format(
			"""
			grammar org.xtext.Spice with org.eclipse.xtext.common.Terminals
			
			import "platform:/resource/{0}"
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
				
			XMod_Action returns XMod_Action:
				'Action' xmod_id=EString '{' operations+=XMod_OperationCall (operations+=XMod_OperationCall)* '}';
			
			XMod_OperationDef returns XMod_Operation:
				name=EString'('( parametersTag+=EString ( "," parametersTag+=EString )* )?')'
					'on' objectTag=EString ('returns' returnTag=EString)?
					(exceptions+=XMod_Exception (exceptions+=XMod_Exception)* )?;
					
			XMod_OperationCall returns XMod_Operation:
				'call' XMod_OperationDef ';';
					
			XMod_Exception returns XMod_Exception:
				'onError' (literal=XMod_ExceptionLiteral_Unfiltered | literal=XMod_ExceptionLiteral_Filtered '('filter=EString')') 
				('call' calledOperation=XMod_OperationDef 'then')? reaction=XMod_ExceptionReaction;
				
			enum XMod_ExceptionReaction:
				continue | skip | exit;
			
			enum XMod_ExceptionLiteral:
				other = 'other' | 
				unknownTag = 'unknownTag' | 
				objectNotFound = 'objectNotFound' | 
				methodNotFound = 'methodNotFound' | 
				parametersNotMatching = 'parametersNotMatching' | 
				returnTypeNotMatching = 'returnTypeNotMatching' | 
				methodException = 'methodException';
				
			XMod_ExceptionLiteral_Filtered returns XMod_ExceptionLiteral:
				'methodException';
			
			XMod_ExceptionLiteral_Unfiltered returns XMod_ExceptionLiteral:
				'other' | 'unknownTag' | 'objectNotFound' | 'methodNotFound' | 'parametersNotMatching' | 'returnTypeNotMatching';
			
			EString returns ecore::EString:
				STRING | ID;
			""",
		modelPath);
	}

}
