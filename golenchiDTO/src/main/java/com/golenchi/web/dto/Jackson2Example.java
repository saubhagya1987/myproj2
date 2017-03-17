package com.golenchi.web.dto;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson2Example {

	public static void main(String[] args) {
		Jackson2Example obj = new Jackson2Example();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		GolenchiRequest golenchiRequest = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("D:\\Golenchi\\Golenchi_docs\\JSON\\golenchi.json"), golenchiRequest);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(golenchiRequest);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(golenchiRequest);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private GolenchiRequest createDummyObject() {
		GolenchiRequest gr = new GolenchiRequest();
		
		CompanyDto companyDto = createCompanyDto(new CompanyDto());
		UserDto userDto = createUserDto(new UserDto());
		System.out.println("Class :::: "+UserDto.class);
		gr.setCompanyDto(companyDto);
		gr.setUserDto(userDto);
		return gr;

	}

	private UserDto createUserDto(UserDto userDto) {
		userDto.setFirstName("Pradeep");
		userDto.setLastName("Kumar");
		userDto.setPassword("ireslab@123");
		return userDto;
	}

	private CompanyDto createCompanyDto(CompanyDto companyDto) {
		companyDto.setCity("Noida");
		companyDto.setCompanyAddress("H-122, Sector-63");
		companyDto.setCompanyCode("IRL");
		companyDto.setCompanyName("Ireslab Infotech Pvt. Ltd.");
		companyDto.setCompanyUrl("http://www.ireslab.com/");
		companyDto.setCountry("INDIA");
		companyDto.setEmailAddress("info@ireslab.com");
		//companyDto.setModifiedBy(modifiedBy);
		companyDto.setState("Uttar Pradesh");
		companyDto.setSubscriptionCode("GOFREE");
		companyDto.setZip(Integer.parseInt("201301"));
		/*companyDto.setFirstName("Pradeep");
		companyDto.setLastName("Kumar");
		companyDto.setPassword("ireslab@123");*/
		return companyDto;
	}

}
