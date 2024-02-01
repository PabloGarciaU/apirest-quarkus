package api;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Tag(name = "Games", description = "API para gestionar juegos")
@Path("/games")
public class GamesResource {

    @Inject
    GamesRepository gamesRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listadejuegos")
    public List<Games> getAllGames() {
        return gamesRepository.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listadejuegos")
    public void createGame(Games game) {
        gamesRepository.persist(game);
    }

    @DELETE
    @Path("/listadejuegos/{id}")
    @Transactional
    public void deleteGame(@PathParam("id") Long id) {
        gamesRepository.deleteById(id);
    }
}