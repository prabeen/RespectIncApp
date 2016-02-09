package np.com.respectinc.respectincapp.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prabin on 2/8/16.
 */
public class ProfileCollection implements Serializable {

    private boolean result;
    private int totalCount;
    private List<Profile> objects;

    public ProfileCollection(){

    }

    public List<Profile> getObjects() {
        return objects;
    }

    public void setObjects(List<Profile> objects) {
        this.objects = objects;
    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
