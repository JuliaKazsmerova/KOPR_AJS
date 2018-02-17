package ajs.client;

public class Client {

	public static void main(String[] args) throws StudentExists_Exception {
		AjsService service = new AjsService();
		AjsPort port = service.getAjsPort();
		
		AddStudentRequest request = new AddStudentRequest();
		request.setName("Anna");
		request.setSurname("Mudra");
		
		AddStudentResponse response = port.addStudent(request);
		System.out.println(response.getId());
		
	}

}
