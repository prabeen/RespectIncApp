package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;

/**
 * Created by prabin on 2/8/16.
 */
public class Follower implements Serializable {

    private String id;

    public Follower(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
