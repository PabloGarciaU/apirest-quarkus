package api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/listadejuegos")
public class GamesResource {
    @GET
    public Games listacompleta(){
        return new Games("Dota2","11101999","70");
    }
}
