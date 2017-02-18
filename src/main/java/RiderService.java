import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RiderService {

    @GET("/riders")
    Call<List<Rider>> getAllRider();

    @GET("/riders/{id}")
    Call<Rider> getRider(@Path("id") Long id);

    @GET("/ridersError")
    Call<List<Rider>> getError();

    @POST("/riders")
    Call<Rider> createRider(@Body Rider Rider);
    
    @PUT("/riders")
    Call<Rider> updateRider(@Body Rider Rider);

    @DELETE("/riders/{id}")
    Call<Void> deleteRider(@Path("id") Long id);

}
