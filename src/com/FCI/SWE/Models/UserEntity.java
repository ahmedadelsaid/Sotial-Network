package com.FCI.SWE.Models;

import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import java.util.ArrayList;
/**
 * <h1>User Entity class</h1>
 * <p>
 * This class will act as a model for user, it will holds user data
 * </p>
 *
 * @author Mohamed Samir
 * @version 1.0
 * @since 2014-02-12
 */
public class UserEntity {
	private String uname;
	private String fname;
	private String email;
	private String password;
	private String mss;
	private String fnames;

	/**
	 * Constructor accepts user data
	 * 
	 * @param name
	 *            user name
	 * @param email
	 *            user email
	 * @param password
	 *            user provided password
	 */
	/*public UserEntity(String uname, String email, String password) {
		this.uname = uname;
		this.email = email;
		this.password = password;

	}
	*/
	public UserEntity(String uname, String fnames, String mss) {
		this.uname = uname;
		this.fnames = fnames;
		this.mss = mss;

	}
	
	
	public UserEntity( String fnames) {
		
		this.fnames = fnames;
		

	}
	public UserEntity(String uname, String fname) {
		this.uname = uname;
		this.fname = fname;
		

	}

	public String getName() {
		return uname;
	}
	public String getfname() {
		return fname;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return password;
	}

	/**
	 * 
	 * This static method will form UserEntity class using json format contains
	 * user data
	 * 
	 * @param json
	 *            String in json format contains user data
	 * @return Constructed user entity
	 */
	public static UserEntity getUser(String json) {

		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			return new UserEntity(object.get("name").toString(), object.get(
					"email").toString(), object.get("password").toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 * This static method will form UserEntity class using user name and
	 * password This method will serach for user in datastore
	 * 
	 * @param name
	 *            user name
	 * @param pass
	 *            user password
	 * @return Constructed user entity
	 */

	public static UserEntity getUser(String name, String pass) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("name").toString());
			if (entity.getProperty("name").toString().equals(name)
					&& entity.getProperty("password").toString().equals(pass)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"name").toString(), entity.getProperty("email")
						.toString(), entity.getProperty("password").toString());
				return returnedUser;
			}
		}

		return null;
	}
	//-------------------------------------------------------------------
	public static UserEntity getsearch(String name) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			System.out.println(entity.getProperty("name").toString());
			if (entity.getProperty("name").toString().equals(name)) {
				UserEntity returnedUser = new UserEntity(entity.getProperty(
						"name").toString(), entity.getProperty("email")
						.toString(), entity.getProperty("password").toString());
				return returnedUser;
			}
		}

		return null;
	}

	/**
	 * This method will be used to save user object in datastore
	 * 
	 * @return boolean if user is saved correctly or not
	 */
	public Boolean saveUser() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("users", list.size() + 1);

		employee.setProperty("name", this.uname);
		employee.setProperty("email", this.email);
		employee.setProperty("password", this.password);
		datastore.put(employee);

		return true;

	}
	
	public Boolean acceptUser() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("friends");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		///employee.setProperty("name", this.name);
	
		for (Entity entity : pq.asIterable()) {
//System.out.println(entity.getProperty("Your_name").toString());
//System.out.println(entity.getProperty("friend_name").toString());

			if (entity.getProperty("Your_name").toString().equals("uname") && entity.getProperty("friend_name").toString().equals("fname"))
			{
				entity.setProperty("Status", "Accepted");
				datastore.put(entity);

			}
		}

		return true;

	}

	///------------------------------------------------------------------------------------------
	public Boolean addfriend() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("friends");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("friends", list.size() + 1);

		employee.setProperty("Your_name",this.uname);
		employee.setProperty("friend_name",this.fname);
		employee.setProperty("Status", "pinding");
		datastore.put(employee);

		return true;

	}
	//----------------------------------------------------------------------------------------mss
	public Boolean messageUser() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("Message");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("Message", list.size() + 1);

		employee.setProperty("name", this.uname);
		employee.setProperty("fname", this.fname);
		employee.setProperty("mss", this.mss);
		datastore.put(employee);

		return true;

	}

	
	//----------------------------------------------------------------------------------------mss
	public static String s="";
	public Boolean conv() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("CONV");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity employee = new Entity("CONV", list.size() + 1);
for(int i=0;i<fnames.length();i++)
{
	if(fnames.charAt(i)==';')
	{
		
		employee.setProperty("Sender", this.uname);
		employee.setProperty("fname", s);
		employee.setProperty("mss", this.mss);
		datastore.put(employee);
		s="";
	}
	else{
		
		s+=fnames.charAt(i);
	}
	


}  //baase;gggg;hhahah
		

		return true;

	}

	
}
