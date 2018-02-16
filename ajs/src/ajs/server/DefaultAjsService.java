package ajs.server;

import javax.jws.WebService;

@WebService (endpointInterface="ajs.server.AjsPort",
targetNamespace="urn:ajs",
serviceName="ajsService",
portName="ajsPort",
wsdlLocation="ajs.wsdl")
public class DefaultAjsService {
	private StudentMysqlDao dao = Factory.INSTANCE.getStudentMysqlDao();
	
	public AddStudentResponse addStudent (AddStudentRequest request) {
		long id = dao.addStudent(request.getName(), request.getSurname());
		AddStudentResponse response = new AddStudentResponse();
		response.setId(id);
		return response;
	}
	
}
