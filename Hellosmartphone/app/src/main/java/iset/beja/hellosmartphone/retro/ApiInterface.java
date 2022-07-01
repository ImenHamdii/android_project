package iset.beja.hellosmartphone.retro;

import java.util.List;

import iset.beja.hellosmartphone.model.Smartphone;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("smartphone.php")
    Call<List<Smartphone>> getSmartphones();


}
