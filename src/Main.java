import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.scribe.model.Token;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.Post;
import com.restfb.types.User;
import java.lang.System;

public class Main {

	 private static final String NETWORK_NAME = "Facebook";
	 private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
	 private static final Token EMPTY_TOKEN = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Replace these with your own api key and secret
	    String appId = "130999860434656";
	    String appSecret = "1b111d48f62c87739508627c12ff7233";
	    
//		DefaultFacebookClient is the FacebookClient implementation
//		that ships with RestFB. You can customize it by passing in
//		custom JsonMapper and WebRequestor implementations, or simply
//		write your own FacebookClient instead for maximum control.

	    
	    AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(appId, appSecret);
	    System.out.println("AT: " + accessToken.toString());
	    FacebookClient facebookClient = new DefaultFacebookClient("CAAB3JMglluABAO1ctgO5sdycR7ZCoiCBQolKfDQalqKiGLaAdvZBa0gds" +
        		"SXk2xMNwZALmo2mtBJaXEFRZCF8tdv8kjjdZCkvZBvZCSZAFMKWHlM8kSfzIoGWR4ZALKTvd" +
        		"NxvDt3zQeyRZAv5032aqox4t1R38qq8JZBfWoZD");
//	    this.accessToken = accessToken.getAccessToken();

//	  	It's also possible to create a client that can only access
//	  	publicly-visible data - no access token required. 
//	  	Note that many of the examples below will not work unless you supply an access token! 

	    FacebookClient publicOnlyFacebookClient = new DefaultFacebookClient();
	    
	    User user = facebookClient.fetchObject("me", User.class);
	    System.out.println("User name: " + user.getName());
	    
	    
	    Connection<Post> publicSearch =
	    		  facebookClient.fetchConnection("search", Post.class,
	    		    Parameter.with("q", "watermelon"), Parameter.with("type", "post"));

	    		Connection<User> targetedSearch =
	    		  facebookClient.fetchConnection("me/home", User.class,
	    		    Parameter.with("q", "Mark"), Parameter.with("type", "user"));

	    		System.out.println("Public search: " + publicSearch.getData().get(0).getMessage());
	    		System.out.println("Posts on my wall by friends named Mark: " + targetedSearch.getData().size());
	    
//	    Page page = facebookClient.fetchObject("PPIJFER", Page.class);
//	    System.out.println("Page: " + page.getLink());
	    
//	    FacebookType publishMessageResponse = facebookClient.publish(
//	    		"PPIJFER/feed", 
//	    		FacebookType.class, 
//	    		Parameter.with("message", "Testing...")
//	    		);
	}

}
