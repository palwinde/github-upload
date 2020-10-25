package com.adidas.stepDefinitions;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;

import com.adidas.apiEngine.EndPoints;
import com.adidas.apiEngine.data.CONSTANTS;
import com.adidas.apiEngine.model.Category;
import com.adidas.apiEngine.model.Pet;
import com.adidas.apiEngine.model.PetStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


/** Represents Step Definition Class 
 * This is mapped to E2E.feature
 * file as it is mapped to it 
 * by gherkin language
 * for given when and then statements
 * It test different scenarios
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class Steps {

	private Response response;
	private static Pet pet;
	static Category cat;
	static TreeMap<String, String> m = new TreeMap<String, String>();
	static TreeMap<String, String> tag = new TreeMap<String, String>();

	
	@Given("^The valid user logon to aplication succesfully$")
	public void validUserLogon() {
		EndPoints.LogonUser(CONSTANTS.USERID, CONSTANTS.PASSWORD);
	}
//static block to intialise variables common to all instances
	static {
		cat = new Category(CONSTANTS.CATEGORY_ID, CONSTANTS.CATEGORY_NAME);
		m = new TreeMap<String, String>();
		m.put("name", CONSTANTS.PHOTOURL_NAME);

		tag = new TreeMap<String, String>();
		tag.put("id", CONSTANTS.TAG_ID);
		tag.put("name", CONSTANTS.TAG_NAME);

		pet = new Pet(2, cat, CONSTANTS.NAME, m, tag, CONSTANTS.PETSTATUS);
	}

	@When("^User add pet to store$")
	public void addPetToStore() {

		response = EndPoints.addPet(pet);
	}

	@Then("^pet is added succesfully$")
	public void petIsAdded() {
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@When("^user check pets for given status$")
	public void checkAvailablePets() {
		PetStatus status = PetStatus.available;
		response = EndPoints.findPetsByStatus(status);

	}

	@Then("^valid result is displayed successfully$")
	public void petsAvailable() {
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@When("^user update the pet status$")
	public void updatetePet() {

		response = EndPoints.updatePet(pet, PetStatus.sold);

	}

	@Then("^that pet is updated successfully$")
	public void petIsUpdated() {
		Assert.assertEquals(response.getStatusCode(), 200);

		String jsonString = response.asString();
		Map pet5 = JsonPath.given(jsonString).get();
		System.out.println(pet5);

	}

	@When("^user delete the pet from store$")
	public void deletePet() {
		// delete updated/sold pet from store
		response = EndPoints.deletePet(pet);

	}

	@Then("^that pet is deleted successfully$")
	public void petIsDeleted() {
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}