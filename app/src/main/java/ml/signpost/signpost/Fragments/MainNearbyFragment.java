package ml.signpost.signpost.Fragments;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import ml.signpost.signpost.Activities.MainActivity;
import ml.signpost.signpost.Activities.PostActivity;
import ml.signpost.signpost.Models.Post;
import ml.signpost.signpost.R;

public class MainNearbyFragment extends Fragment implements PostRecyclerViewAdapter.OnRowClickListener {

    public static final String ARG_POST = "post";
    @Bind(R.id.fragment_main_nearby_layout)
    RecyclerView mRecyclerView;

    private PostRecyclerViewAdapter mAdapter;
    private static MainNearbyFragment sInstance;
    private Location mLastLocation;

    public static MainNearbyFragment newInstance() {

      //  if (sInstance == null) {
            MainNearbyFragment fragment = new MainNearbyFragment();
            Bundle args = new Bundle();

            fragment.setArguments(args);
            sInstance = fragment;
            return sInstance;
      //  } else {
      //      return sInstance;
     //   }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        super.onCreateView(inflater, container, savedInstanceState);

        View rootview = inflater.inflate(R.layout.fragment_main_nearby, container, false);

        ButterKnife.bind(this, rootview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final ArrayList<Post> list = new ArrayList<>();
        //get location
        mLastLocation = ((MainActivity)getActivity()).getmLastLocation();

        mAdapter = new PostRecyclerViewAdapter(list, this, mLastLocation);
        mRecyclerView.setAdapter(mAdapter);

        ArrayList<Post> posts = ((MainActivity) getActivity()).getPosts();

        mAdapter.addItems(posts);

        setHasOptionsMenu(true);

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onRowClick(Post post) {
        // Toast.makeText(getContext(), "congrats you clicked a row", Toast.LENGTH_SHORT).show();

        //create new activity
        Intent intent = new Intent(getActivity(), PostActivity.class);
        intent.putExtra(ARG_POST, post);
        startActivity(intent);
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        menu.add(0, 0, 0, "Login");
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId()==0){
//            //take to login fragment
//            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.activity_main_relative_layout, LoginFragment.newInstance());
//            ft.addToBackStack(null);
//            ft.commit();
//            return true;
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//    }
}