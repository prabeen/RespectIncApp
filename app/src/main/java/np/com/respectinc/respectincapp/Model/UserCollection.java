package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prabin on 2/8/16.
 */
public class UserCollection implements Serializable {

    private String result;
    private String totalCount;
    private List<User> objects;

    public UserCollection() {

    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public List<User> getObjects() {
        return objects;
    }

    public void setObjects(List<User> objects) {
        this.objects = objects;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
