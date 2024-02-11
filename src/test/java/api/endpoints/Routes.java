package api.endpoints;

/* Swagger URL --> https://petstore.swagger.io/v2/
 * Create user(post) url --- https://petstore.swagger.io/v2/users
 * Get user(get)url -------- https://petstore.swagger.io/v2/users/{username}
 * Update user(put)url------ https://petstore.swagger.io/v2/users/{username}
 * Delete user(delete)url--- https://petstore.swagger.io/v2/users/{username}
 */

public class Routes {

	public static String base_url ="https://petstore.swagger.io/v2";
	
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	
}
