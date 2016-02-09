package np.com.respectinc.respectincapp.Model;

/**
 * Created by prabin on 2/8/16.
 */
public class CreatorDetail {
    private String commenterId;
    private String profilePhoto;
    private String commenterName;


    public CreatorDetail(){

    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(String commenterId) {
        this.commenterId = commenterId;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
