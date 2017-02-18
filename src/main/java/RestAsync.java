import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.List;

public class RestAsync {
    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RiderService riderService = retrofit.create(RiderService.class);


        /**
         * Ejemplo de GET All Riders
         */
        Call<List<Rider>> call = riderService.getAllRider();
        call.enqueue(new Callback<List<Rider>>() {
            @Override
            public void onResponse(Call<List<Rider>> call, Response<List<Rider>> response) {
                System.out.println("Status code: " + response.code() + System.lineSeparator() +
                        "GET all riders: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Rider>> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });
    }
}