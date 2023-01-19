package com.testetecnicojava.api;


//import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//import com.testetecnicojava.api.dto.PersonDTO;
import com.testetecnicojava.api.services.PersonServices;

@SpringBootTest
class ApiApplicationTests {

	//PersonDTO personTest = new PersonDTO("Geicy Beatriz", "1995-06-02");

	@Test
	@DisplayName("Deve cadastrar uma pessoa")
	void createPerson() {
		PersonServices personServices = new PersonServices();
		//acho que terei de usar mockito
		
		//personServices.create(personTest);

		

	}

}
