package facebook;

import com.restfb.types.Comment;

public class myFBComment {

	public Comment self;
	
	public myFBComment(Comment c) {
		self = c;
//        long likes = self.getLikeCount()==null ? (self.getLikes() == null ? 0 : self.getLikes()) : self.getLikeCount();
	}
	
	@Override
	public String toString() {
		String message = self.getMessage();
		message = message.substring(0, Math.min(message.length(), 25));
		return self.getLikeCount() + " likes: " + message + "...";
	}
}
