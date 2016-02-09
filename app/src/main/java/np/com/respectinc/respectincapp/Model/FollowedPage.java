package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;

/**
 * Created by prabin on 2/8/16.
 */
public class FollowedPage implements Serializable {

    private String id;

    public FollowedPage() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
