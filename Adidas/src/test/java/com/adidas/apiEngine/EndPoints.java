package com.adidas.apiEngine;

import org.apache.log4j.Logger;

import com.adidas.apiEngine.data.CONSTANTS;
import com.adidas.apiEngine.logs.LoggerClass;
import com.adidas.apiEngine.model.Pet;
import com.adidas.apiEngine.model.PetStatus;
import com.adidas.apiEngine.model.requests.AddPetsRequest;


import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/** Represents End Points Class 
 * to call various api methods
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class EndPoints {
	static Logger logger = LoggerClass.getLogger(EndPoints.class.getName());

	private static Response response;
    private static final String BASE_URL = "https://petstore.swagger.io";
    
    /** Represents the update pet method
     *  to change the status of given 
     *  pet
     *  @argument Pet, PetStatus
     *  @return Response object
	*/

    public static Response updatePet(Pet pet,PetStatus petStatus) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
       

        Response response = null;

        try {
    	  	request.body("{  \"id\": "+pet.getId()+",  \"category\": {    \"id\": "+pet.getCategory().getId()+",    \"name\": \""+pet.getCategory().getName()+"\"  },  \"name\": \""+pet.getName()+"\",  \"photoUrls\": [    \""+pet.getPhotoUrls().get("name")+"\"  ],  \"tags\": [    {      \"id\": "+pet.getTags().get("id")+",      \"name\": \""+pet.getTags().get("name")+"\"    }  ],  \"status\": \""+CONSTANTS.UPDATED_PETSTATUS+"\"}");

        	response = request.put(Route.updatePetStatus());

     
        } catch (Exception e) {
           logger.info(e);
        }



		return response;
		
		
    	
    }
    /** Represents the delete pet method
     *  to delete the given 
     *  pet
     *  @argument Pet
     *  @return Response object
	*/

    public static Response deletePet(Pet pet) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
      

        Response response = null;

        try {
    	

        	response = request.delete(Route.deletePet(pet.getId()));

     
        } catch (Exception e) {
            logger.info(e);

        }



		return response;
		
		
    	
    }
    /** Represents the get the pets
     * for given status of pets
     *  @argument  PetStatus
     *  @return Response object
	*/
    public static Response findPetsByStatus(PetStatus status) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
 
        request.header("Content-Type", "application/json");
        Response response = request.body("{  \"status\":\""+status+"\" }").get(Route.findPetsByStatus());
        return response;
    }
    /** Represents the add pet method
     *  to add the given 
     *  pet
     *  @argument Pet
     *  @return Response object
	*/
    public static Response addPet(Pet pet) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
     
        request.header("Content-Type", "application/json");
        
        Response response = request.body("{  \"id\": "+AddPetsRequest.addPet(pet).getId()+",  \"category\": {    \"id\": "+AddPetsRequest.addPet(pet).getCategory().getId()+",    \"name\": \""+AddPetsRequest.addPet(pet).getCategory().getName()+"\"  },  \"photoUrls\": [    \""+AddPetsRequest.addPet(pet).getPhotoUrls().get("name")+"\"  ],  \"tags\": [    {      \"id\": "+AddPetsRequest.addPet(pet).getTags().get("id")+",      \"name\": \""+AddPetsRequest.addPet(pet).getTags().get("name")+"\"    }  ],  \"status\": \""+AddPetsRequest.addPet(pet).getStatus()+"\"}").post(Route.addPet());
        return response;
    }
 
    /** Represents the logon method
     *  to user to be logged 
     *  for given username and password
     *  @argument username,password
     *  @return Response object
	*/
 
    public static Response LogonUser(String userId, String password) {
 
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
 
        request.header("Content-Type", "application/json");
    	response = request.body("{ \"userName\":\"" + userId+ "\", \"password\":\"" + password + "\"}")
				.get("/v2/user/login");

		
        return response;
    }
 
}
