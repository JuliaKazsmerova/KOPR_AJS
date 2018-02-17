
package ajs.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ajsPort", targetNamespace = "urn:ajs")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AjsPort {


    /**
     * 
     * @param addStudentRequestPart
     * @return
     *     returns ajs.client.AddStudentResponse
     * @throws StudentExists_Exception
     */
    @WebMethod(operationName = "AddStudent")
    @WebResult(name = "AddStudentResponse", targetNamespace = "urn:ajs", partName = "AddStudentResponsePart")
    public AddStudentResponse addStudent(
        @WebParam(name = "AddStudentRequest", targetNamespace = "urn:ajs", partName = "AddStudentRequestPart")
        AddStudentRequest addStudentRequestPart)
        throws StudentExists_Exception
    ;

}
