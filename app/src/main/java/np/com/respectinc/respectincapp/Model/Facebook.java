package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;

/**
 * Created by prabin on 2/8/16.
 */
public class Facebook implements Serializable {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String profilePhoto;


    public Facebook() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
