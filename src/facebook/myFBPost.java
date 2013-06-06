package facebook;

import java.util.ArrayList;
import java.util.LinkedList;

import com.restfb.types.Post;

public class myFBPost {
	
	public Post self;
	
	public myFBPost(Post p) {
		self = p;
	}

	@Override
	public String toString() {
		if(self.getMessage() == null)
			return null;
		
		String message = self.getMessage();
		message = message.substring(0, Math.min(message.length(), 50));
		return (self.getLikesCount() == null ? 0 : self.getLikesCount()) + " likes: " + message + "...";
	}
	
	public static String formatToOutput(String str){
		return str.replaceAll("(.{30})", "$1\n");
	}
	
}
