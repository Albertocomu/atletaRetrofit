import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class RestSynchronous {

    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RiderService riderService = retrofit.create(RiderService.class);

        //get all riders
        Call<List<Rider>> call = riderService.getAllRider();
        Response<List<Rider>> response = call.execute();

        if (response.isSuccessful()) {
            List<Rider> riderList = response.body();
            System.out.println("Status code: " + response.code() + System.lineSeparator() +
                    "GET all riders: " + riderList);
        } else {
            System.out.println("Status code: " + response.code() +
                    "Message error: " + response.errorBody());
        }

        //get rider by id
        Call<Rider> call2 = riderService.getRider(3L);
        Response<Rider> response2 = call2.execute();
        if (response2.isSuccessful()) {
            Rider a = response2.body();
            System.out.println("Status code: " + response2.code() + System.lineSeparator() +
                    "GET rider: " + a);
        } else {
            System.out.println("Status code: " + response2.code() +
                    "Message error: " + response2.errorBody());
        }

        //add rider
        Rider alfredo = new Rider("Alfredo", "Profe", "Spain");
        Call<Rider> call3 = riderService.createRider(alfredo);
        Response<Rider> response3 = call3.execute();
        if (response3.isSuccessful()) {
            Rider riderCreated = response3.body();
            System.out.println("POST \n " +
                    "Code: " + response3.code() + "\n" + riderCreated);

            //delete rider
            Call<Void> callDelete = riderService.deleteRider(riderCreated.getId());
            Response<Void> responseDelete = callDelete.execute();
            System.out.println("DELETE \n Code: " + responseDelete.code());


        } else {
            System.out.println("Status code: " + response3.code() +
                    "Message error: " + response3.errorBody());
        }

        //update rider
        Call<Rider> callGetRider = riderService.getRider(1L);
        Response<Rider> responseGetRider = callGetRider.execute();
        Rider rider = responseGetRider.body();

        if (responseGetRider.isSuccessful()) {
            System.out.println("GET (id) \n " +
                    "Code: " + responseGetRider.code() + "\n" + responseGetRider.body());
        }
        rider.setNacionalidad("Galicia");
        Call<Rider> callChange = riderService.updateRider(rider);
        Response<Rider> responseChange = callChange.execute();

        System.out.println("PUT (id) \n " +
                "Code: " + responseChange.code() + "\n" + responseChange.body());

        //comprobacion
        Call<List<Rider>> call4 = riderService.getAllRider();
        Response<List<Rider>> response4 = call4.execute();

        if (response.isSuccessful()) {
            List<Rider> riderList = response.body();
            System.out.println("Status code: " + response4.code() + System.lineSeparator() +
                    "GET all riders: " + riderList);
        } else {
            System.out.println("Status code: " + response4.code() +
                    "Message error: " + response4.errorBody());
        }


    }
}
