package ml.signpost.signpost.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ml.signpost.signpost.Activities.MainActivity;
import ml.signpost.signpost.Models.Post;
import ml.signpost.signpost.Modules.Signpost;
import ml.signpost.signpost.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPopularFragment extends Fragment implements PostRecyclerViewAdapter.OnRowClickListener {


    @Bind(R.id.fragment_main_popular_recycler_view)
    RecyclerView mRecyclerView;
    private PostRecyclerViewAdapter mAdapter;
    private static MainPopularFragment sInstance;

    public static MainPopularFragment newInstance() {

        if (sInstance == null) {
            MainPopularFragment fragment = new MainPopularFragment();
            Bundle args = new Bundle();

            fragment.setArguments(args);
            sInstance = fragment;
            return sInstance;
        } else {
            return sInstance;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        super.onCreateView(inflater, container, savedInstanceState);

        View rootview = inflater.inflate(R.layout.fragment_main_popular, container, false);

        ButterKnife.bind(this, rootview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final ArrayList<Post> list = new ArrayList<>();
        mAdapter = new PostRecyclerViewAdapter(list, this);
        mRecyclerView.setAdapter(mAdapter);

        ArrayList<Post> posts = ((MainActivity) getActivity()).getPosts();

        mAdapter.addItems(posts);

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onRowClick(Post post) {
        Toast.makeText(getContext(), "congrats you clicked a row", Toast.LENGTH_SHORT).show();
    }
}