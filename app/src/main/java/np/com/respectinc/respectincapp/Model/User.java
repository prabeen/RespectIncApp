package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by prabin on 2/8/16.
 */
public class User implements Serializable {

    private String nickName;
    private String email;
    private String firstName;
    private String lastName;
    private String profilePhoto;
    private SocialProfile socialProfiles;
    private String deviceToken;
    private String userType;
    private boolean isVerified;
    private String coverPhoto;
    private int rPoints;
    private ArrayList<Following> followings;
    private ArrayList<Follower> followers;
    private ArrayList<FollowedPage> followedPages;
    private String createdAt;
    private String updatedAt;
    private String id;


    public User() {

    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
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

    public ArrayList<FollowedPage> getFollowedPages() {
        return followedPages;
    }

    public void setFollowedPages(ArrayList<FollowedPage> followedPages) {
        this.followedPages = followedPages;
    }

    public ArrayList<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<Follower> followers) {
        this.followers = followers;
    }

    public ArrayList<Following> getFollowings() {
        return followings;
    }

    public void setFollowings(ArrayList<Following> followings) {
        this.followings = followings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public int getrPoints() {
        return rPoints;
    }

    public void setrPoints(int rPoints) {
        this.rPoints = rPoints;
    }

    public SocialProfile getSocialProfiles() {
        return socialProfiles;
    }

    public void setSocialProfiles(SocialProfile socialProfiles) {
        this.socialProfiles = socialProfiles;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
