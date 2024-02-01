package api;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

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
    @Tag(name = "Consultar Juegos", description = "Obtiene la lista de todos los juegos")
    public List<Games> getAllGames() {
        return gamesRepository.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = "Consultar Juego por ID", description = "Obtiene un juego por su ID")
    public Games getGameById(@Parameter(description = "ID del juego a consultar", required = true) @PathParam("id") Long id) {
        return gamesRepository.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Tag(name = "Crear Juego", description = "Crea un nuevo juego")
    public void createGame(Games game) {
        gamesRepository.persist(game);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Tag(name = "Actualizar Juego", description = "Actualiza un juego existente")
    public void updateGame(
            @Parameter(description = "ID del juego a actualizar", required = true) @PathParam("id") Long id,
            Games updatedGame) {
        Games game = gamesRepository.findById(id);
        if (game != null) {
            game.nombre = updatedGame.nombre;
            game.fecha = updatedGame.fecha;
            game.puntuacion = updatedGame.puntuacion;
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Tag(name = "Eliminar Juego", description = "Elimina un juego por su ID")
    public void deleteGame(@Parameter(description = "ID del juego a eliminar", required = true) @PathParam("id") Long id) {
        gamesRepository.deleteById(id);
    }
}