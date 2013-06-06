package facebook;

import java.util.ArrayList;
import java.util.List;

import org.scribe.model.Token;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Comment;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FBClient extends DefaultFacebookClient{

	private static final String NETWORK_NAME = "Facebook";
	private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
	private static final Token EMPTY_TOKEN = null;
	
	public FBClient() {
	    String appId = "130999860434656";
	    String appSecret = "1b111d48f62c87739508627c12ff7233";
	    
//	    AccessToken accessToken = this.obtainAppAccessToken(appId, appSecret);
        
        this.accessToken = "CAACEdEose0cBAHjmK4nP8EKNFrMqCGca5UBYbJZBz6WZCKxppv9" +
        		"WIPUaeCh7hHXVZAyhMumxDZBoC8ma3JsBMGJGumVm3aVTucGwPihTikZBKIEkVZCnBz3qIphZByp8pX" +
        		"OC0cq9pCtN5OCyRY6sbZBCYlEcWVFL5mMZD";


//	    FacebookClient publicOnlyFacebookClient = new DefaultFacebookClient();

	}
	
	public User getUser(String name){
		return this.fetchObject(name, User.class);
	}
	
	public void publishMessage(String id, String message){
		FacebookType publishMessageResponse = this.publish(
	    		id + "/feed", 
	    		FacebookType.class, 
	    		Parameter.with("message", message)
	    		);
	}
	
	public Connection<Post> getPostConnection(String name){
		return this.fetchConnection(name + "/feed", 
				Post.class,
				Parameter.with("type", "post"));
	}
	
	public List<myFBComment> getCommentFromPost(String post_id){
	    List<myFBComment> comments = new ArrayList<myFBComment>();

	    Connection<Comment> allComments = this.fetchConnection(post_id+"/comments", Comment.class);
	    for(List<Comment> postcomments : allComments){
	        for (Comment comment : postcomments){
	        	comments.add(new myFBComment(comment));
	        }
	    }
	    return comments;
	}
	 
	public void postComment(String postID, String message){
		this.publish(postID + "/comments", String.class, Parameter.with("message", message));
	}
	 
}
