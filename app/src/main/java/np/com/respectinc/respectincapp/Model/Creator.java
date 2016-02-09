package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;

/**
 * Created by prabin on 2/8/16.
 */
public class Creator implements Serializable {

    private String id;
    private String name;
    private String profilePhoto;


    public Creator() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
