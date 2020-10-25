package com.adidas.apiEngine;

/** Represents Route Class 
 * to give the arument for
 * get, put,post,delete
 * methods of rest assured api
 * used in framework
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/



public class Route {

	private static final String PET = "/pet";
    private static final String USER = "/user";
    private static final String VERSION = "/v2";
    
    /** Represents the update pet method
     *  @return String path
 	*/
   public static String updatePetStatus() {
	   return VERSION+PET;
   }
   /** Represents the find pet method
    *  @return String path
	*/
    public static String findPetsByStatus(){ 
    	return VERSION+PET + "/findByStatus";
    }
    /** Represents the add pet method
     *  @return String path
	*/
 
    public static String addPet() {
    	return VERSION+PET;
    }
    /** Represents the deletePet method
     *  @argument id of pet to be deleted
     *  @return String path
	*/
 
 
    public static String deletePet(int i){ 
    	 return VERSION+PET+"/"+i;
    }
 
 
    public static String getUserByName(String userId){
    	return USER +  "/getUserByName" + "/" + userId; 

}
    
    /** Represents the logonuser method
     *  @argument userid
     *  @return String path
	*/
 
    public static String logonUser(String userId) {
    	
    		
    		return USER +  "/login"+ "/" + userId;
    }
    
}