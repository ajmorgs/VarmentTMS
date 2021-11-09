package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Ticket;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ITicketRetrofitDao {

    @GET("/perl/mobile/viewplantsjsonarray.pl")
    Call<List<Ticket>> getTickets();
}
