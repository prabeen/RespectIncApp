package np.com.respectinc.respectincapp.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.JsonParseException;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import np.com.respectinc.respectincapp.Model.DefaultResponse;
import np.com.respectinc.respectincapp.Model.Profile;
import np.com.respectinc.respectincapp.Model.ProfileCollection;
import np.com.respectinc.respectincapp.Model.User;
import np.com.respectinc.respectincapp.Model.UserCollection;
import np.com.respectinc.respectincapp.R;
import np.com.respectinc.respectincapp.controller.ProfileController;
import np.com.respectinc.respectincapp.framework.DividerItemDecoration;
import np.com.respectinc.respectincapp.utility.JsonUtils;
import np.com.respectinc.respectincapp.utility.LoggerUtils;

/**
 * Created by prabin on 10/8/15.
 */
public class ProfileActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProfileCollection profileCollection;
    private ProfileController controller;
    private RecyclerView recyclerView;
    private AQuery aQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LoggerUtils.log("onCreate Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        setTitle("Respect Inc");


        initAQuery();
        controller = new ProfileController(this);

        recyclerView = (RecyclerView) findViewById(R.id.profile_activity_recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProfileAdapter profileCollectionAdapter = new ProfileAdapter(this);
        recyclerView.setAdapter(profileCollectionAdapter);
        profileCollectionAdapter.notifyDataSetChanged();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.profile_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);


        fetchProfileData();




/*        List<ProfileCollection> profileCollection= controller.getDataFromPreferences();
        if(profileCollection==null){
            fetchProfileData();
        }else{
            notifyDataChanged(profileCollection);
        }*/


    }


    private void initAQuery() {
        aQuery = new AQuery(this);
    }


    private void notifyDataChanged(ProfileCollection profileCollection) {
        this.profileCollection = profileCollection;
        LoggerUtils.log("group in notify data changed " + profileCollection);
        ProfileAdapter profileCollectionAdapter = new ProfileAdapter(this);
        recyclerView.setAdapter(profileCollectionAdapter);
        profileCollectionAdapter.notifyDataSetChanged();
    }

    /**
     * This method is called when swipe refresh is pulled down
     */
    @Override
    public void onRefresh() {
        LoggerUtils.log("swipe happening....");
        fetchProfileData();
    }


    private void fetchProfileData() {
        AsyncDataGrabber asyncDataGrabber = new AsyncDataGrabber();
        asyncDataGrabber.execute();
    }


    public class AsyncDataGrabber extends AsyncTask<Void, Void, DefaultResponse> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // showing refresh animation before making http call
            swipeRefreshLayout.setRefreshing(true);
            Toast.makeText(ProfileActivity.this, "Downloading new Data...", Toast.LENGTH_LONG).show();

        }

        @Override
        protected DefaultResponse doInBackground(Void... params) {
            return controller.sendProfileFetchRequest();
        }


        @Override
        protected void onPostExecute(DefaultResponse defaultResponse) {
            swipeRefreshLayout.setRefreshing(false);
            if (defaultResponse != null) {
                switch (defaultResponse.getCode()) {
                    case 200: {
                        try {
                            ProfileCollection profileCollection = JsonUtils.toObject(defaultResponse.getMessage(), ProfileCollection.class);

                            if (profileCollection != null) {
                                notifyDataChanged(profileCollection);
                                Toast.makeText(ProfileActivity.this, "Download Complete...", Toast.LENGTH_LONG).show();
                            }
                        } catch (JsonParseException ex) {
                            LoggerUtils.log("error at json parsing " + ex.getMessage());
                        }
                        break;
                    }
                    case 500: {
                        Toast.makeText(ProfileActivity.this, defaultResponse.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    default: {
                        break;
                    }
                }

            } else {
                Toast.makeText(ProfileActivity.this, "No Connection!", Toast.LENGTH_LONG).show();
            }

        }
    }


    private class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private Context context;
        private LayoutInflater layoutInflater;

        public ProfileAdapter(Context ctx) {
            this.context = ctx;
            this.layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = layoutInflater.inflate(R.layout.profile_row, viewGroup, false);
            ItemHolder itemHolder = new ItemHolder(view);
            return itemHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            ItemHolder itemHolder = (ItemHolder) viewHolder;
            if (profileCollection != null) {
                Profile profile = profileCollection.getObjects().get(position);
              /*  String creatorName = profile.getCreatorId().getName();*/
                String creatorName = profile.getCreatorId();
                String feedMessage = profile.getMessage();
                String noOfLikesAndComment = "";
                if (profile.getLikes() != null && profile.getComments() != null) {
                    noOfLikesAndComment = "Likes " + profile.getLikes().size() + "  Comments " + profile.getComments().size();
                }

                String firstName = "";
                String lastName = "";
                UserCollection userCollection = controller.getUserCollection();
                if (userCollection != null) {
                    List<User> users = userCollection.getObjects();
                    for (User user : users) {
                        if (user.getId().equals(profile.getCreatorId())) {
                            firstName = user.getFirstName();
                            lastName = user.getLastName();
                            creatorName = firstName + " " + lastName;
                        }
                    }
                }

                itemHolder.txtViewCreatorName.setText(creatorName);
                // itemHolder.txtViewCreatorName.setText(creatorName);
                itemHolder.txtViewFeedMessage.setText(feedMessage);
                itemHolder.txtViewNoOfLikesAndComments.setText(noOfLikesAndComment);
                ImageView imageView = itemHolder.imgViewPhotos;

                RecyclerView recyclerView = itemHolder.staggeredRecyclerView;

                // recyclerView.setHasFixedSize(true);
                recyclerView.addItemDecoration(new DividerItemDecoration(ProfileActivity.this, DividerItemDecoration.VERTICAL_LIST));
                recyclerView.setItemAnimator(new DefaultItemAnimator());


                if ((profile.getFeedType()).equals("photo")) {
                    List<String> photos = profile.getPhoto();
                    if (photos != null) {
                        if (photos.size() > 0) {
                            // aQuery.recycle(imageView).image(photos.get(0)).visible();
                            LoggerUtils.log("photos size is " + photos.size());
                            int col = 1;
                            if (photos.size() > 2) {
                                col = 2;
                            }

                            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(col, StaggeredGridLayoutManager.VERTICAL);
                            recyclerView.setLayoutManager(staggeredGridLayoutManager);
                            StaggeredRecyclerViewAdapter rcAdapter = new StaggeredRecyclerViewAdapter(ProfileActivity.this, photos);
                            recyclerView.setAdapter(rcAdapter);
                            // rcAdapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    imageView.setVisibility(View.GONE);;
                    recyclerView.setLayoutManager(new LinearLayoutManager(ProfileActivity.this));
                    StaggeredRecyclerViewAdapter rcAdapter = new StaggeredRecyclerViewAdapter(ProfileActivity.this, new ArrayList<String>());
                    recyclerView.setAdapter(rcAdapter);
                    //rcAdapter.notifyDataSetChanged();
                }

            }
        }


        @Override
        public int getItemCount() {
            if (profileCollection != null) {
                return profileCollection.getObjects().size();
            }
            return 0;
        }


    }


    private class ItemHolder extends RecyclerView.ViewHolder {
        TextView txtViewCreatorName;
        TextView txtViewFeedMessage;
        TextView txtViewNoOfLikesAndComments;
        ImageView imgViewPhotos;
        RecyclerView staggeredRecyclerView;

        public ItemHolder(View itemView) {
            super(itemView);
            txtViewCreatorName = (TextView) itemView.findViewById(R.id.task1_txtViewCreatorName);
            txtViewFeedMessage = (TextView) itemView.findViewById(R.id.task1_txtViewFeedMessage);
            txtViewNoOfLikesAndComments = (TextView) itemView.findViewById(R.id.task1_txtViewNoOfLikesAndComments);
            imgViewPhotos = (ImageView) itemView.findViewById(R.id.task1_imageViewPhotos);
            staggeredRecyclerView = (RecyclerView) itemView.findViewById(R.id.stagger_recyclerview);
        }
    }


    private class PhotoStaggeredViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        ImageView photo;

        public PhotoStaggeredViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cv = (CardView) itemView.findViewById(R.id.staggeredgrid_card_view);
            photo = (ImageView) itemView.findViewById(R.id.row_photo);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }
    }

    private class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<String> photos;
        private Context ctx;
        private LayoutInflater layoutInflater;


        public StaggeredRecyclerViewAdapter(Context context, List<String> photos) {
            LoggerUtils.log("tsfsdf" + photos.size());
            this.photos = photos;
            ctx = context;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View layoutView = this.layoutInflater.inflate(R.layout.staggeredgrid_row, parent, false);
            PhotoStaggeredViewHolder rcv = new PhotoStaggeredViewHolder(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            PhotoStaggeredViewHolder viewHolder = (PhotoStaggeredViewHolder) holder;
            ImageView imageView = viewHolder.photo;
            CardView cv = viewHolder.cv;
            if (photos != null) {
                if (photos.size() > 0) {
                    LoggerUtils.log("photos url " + photos.get(position));
                    aQuery.recycle(imageView).image(photos.get(position), true, true);
                    // aQuery.recycle(imageView).image(photos.get(0)).visible();
                }
            }
        }

        @Override
        public int getItemCount() {
            if (photos == null) {
                return 0;
            }
            return photos.size();
        }


    }


}
