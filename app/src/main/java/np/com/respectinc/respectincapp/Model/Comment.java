package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prabin on 2/8/16.
 */
public class Comment implements Serializable {

    private CreatorDetail creatorDetail;
    private String comments;
    private String createdTime;
    private String id;
    private List<Integer> like;

    public Comment() {
    }

    public List<Integer> getLike() {
        return like;
    }

    public void setLike(List<Integer> like) {
        this.like = like;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public CreatorDetail getCreatorDetail() {
        return creatorDetail;
    }

    public void setCreatorDetail(CreatorDetail creatorDetail) {
        this.creatorDetail = creatorDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
