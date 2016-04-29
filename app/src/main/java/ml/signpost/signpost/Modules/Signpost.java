package ml.signpost.signpost.Modules;

import java.util.List;

import ml.signpost.signpost.Models.Post;
import ml.signpost.signpost.Models.Sign;
import ml.signpost.signpost.Models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Trevor on 4/10/16.
 */
public interface Signpost {

    @GET("user/{username}")
    Call<List<User>> getUser (
        @Path("username") String username
    );

    @GET("user/{username}/signs")
    Call<List<Sign>> signsForUser (
            @Path("username") String username
    );

    @GET("post/{id}/signs")
    Call<List<Sign>> signsForPost (
            @Path("id") int id
    );

    @GET("post/title/{title}")
    Call<List<Post>> postFromTitle (
            @Path("title") String title
    );

    @GET("post/{lat}/{lng}/{rad}")
    Call<List<Post>> locationPosts(
            @Path("lat") double lat,
            @Path("lng") double lng,
            @Path("rad") double i);

    @GET("posts")
    Call<List<Post>> allPosts();

    @GET("post/title/{title}/signs")
    Call<List<Sign>> signsForPost(
        @Path("title") String title
    );

    @POST("signs")
    Call<Sign> addSign(@Body Sign sign);
}
