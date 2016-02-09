package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;

/**
 * Created by prabin on 2/8/16.
 */
public class SocialProfile implements Serializable {

    private Facebook facebook;


    public SocialProfile() {

    }

    public Facebook getFacebook() {
        return facebook;
    }

    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }
}
