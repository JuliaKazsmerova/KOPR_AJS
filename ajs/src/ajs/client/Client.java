package ajs.client;

public class Client {

	public static void main(String[] args) {
		AjsService service = new AjsService();
		AjsPort port = service.getAjsPort();
		
		AddStudentRequest request = new AddStudentRequest();
		request.setName("Ferko");
		request.setSurname("Sikovny");
		
		AddStudentResponse response = port.addStudent(request);
		System.out.println(response.getId());
		
	}

}
