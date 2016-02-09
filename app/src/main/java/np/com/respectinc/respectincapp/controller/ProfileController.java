package np.com.respectinc.respectincapp.controller;

import android.content.Context;

import com.github.kevinsawicki.http.HttpRequest;

import np.com.respectinc.respectincapp.Model.ProfileCollection;
import np.com.respectinc.respectincapp.Model.UserCollection;
import np.com.respectinc.respectincapp.TestData1;
import np.com.respectinc.respectincapp.TestData2;
import np.com.respectinc.respectincapp.config.AppConfig;
import np.com.respectinc.respectincapp.Model.DefaultResponse;
import np.com.respectinc.respectincapp.utility.JsonUtils;
import np.com.respectinc.respectincapp.utility.LoggerUtils;

/**
 * Created by prabin on 2/7/16.
 */
public class ProfileController {

    private Context context;
    private UserController userController;
    private UserCollection userCollection;


    public ProfileController(Context context) {
        this.context = context;
    }


    private void sendUserRequest() {
    /*    userController = new UserController(context);
        DefaultResponse dResponse = userController.sendUserRequest();
        if (dResponse != null) {
            userCollection = JsonUtils.toObject(dResponse.getMessage(), UserCollection.class);
            LoggerUtils.log("usercollelction");
        }*/

        userCollection = JsonUtils.toObject(TestData2.data, UserCollection.class);
    }


    public DefaultResponse sendProfileFetchRequest() {
        DefaultResponse defaultResponse = null;
        sendUserRequest();
        defaultResponse = new DefaultResponse(200, TestData1.testData);
       /* try {

            //fetch user data
            sendUserRequest();

            HttpRequest httpRequest = HttpRequest
                    .get(AppConfig.PROFILE_FETCH_URL).authorization("JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImVtYWlsIjoibWFuaXNoYWFAZ21haWwuY29tIiwiZmlyc3ROYW1lIjoibWFuaXNoIiwibGFzdE5hbWUiOiJtYWhhcmphbiIsInVzZXJUeXBlIjoiR2VuZXJhbCIsIm5pY2tOYW1lIjoiIiwiaXNWZXJpZmllZCI6ZmFsc2UsInByb2ZpbGVQaG90byI6IiIsImNvdmVyUGhvdG8iOiIiLCJyUG9pbnRzIjowLCJmb2xsb3dpbmdzIjpbXSwiZm9sbG93ZXJzIjpbXSwiZm9sbG93ZWRQYWdlcyI6W3siaWQiOiI1NWZiZDM1NDc1YjlkODM5Njk0ZGM2NGQifV0sImNyZWF0ZWRBdCI6IjIwMTUtMTAtMDdUMTI6MTQ6NDEuNzg4WiIsInVwZGF0ZWRBdCI6IjIwMTUtMTAtMDdUMTI6MTQ6NDEuNzg4WiIsImlkIjoiNTYxNTBjYjFiYTRiMmQxODFkMWQxNjQ4In0sImlhdCI6MTQ0NDIyMDA4MX0.zzMYZXpHXKmtcG8HJuYU3KRxY0fKGHSTOPvgABKY4b8")
                    .contentType(AppConfig.CONTENT_TYPE).trustAllCerts()
                    .trustAllHosts().acceptJson().bufferSize(10000);



     *//*   HttpRequest httpRequest = HttpRequest
                    .post(AppConfig.TEST_URL)
                    .contentType(AppConfig.CONTENT_TYPE)
                    .accept(AppConfig.ACCEPT_TYPE).trustAllCerts()
                    .trustAllHosts().send(JsonUtils.toString(""));*//*


            LoggerUtils.log("Status Code = " + httpRequest.code());
            if (httpRequest.ok()) {
                String response = httpRequest.body();
                LoggerUtils.log("task 1 data \\n" + response);
                if (response != null) {
                    defaultResponse = new DefaultResponse(200, response);
                    return defaultResponse;
                }
            }


        } catch (HttpRequest.HttpRequestException ex) {
            LoggerUtils.log("error....  " + ex.getMessage());
            defaultResponse = new DefaultResponse(500,
                    "Unable to connect with server.Please try again.");
            return defaultResponse;
        }

*/
        return defaultResponse;
    }


    public UserCollection getUserCollection() {
        return userCollection;
    }


}
