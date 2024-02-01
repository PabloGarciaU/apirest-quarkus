package api;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class GamesRepository implements PanacheRepositoryBase<Games, Long> {

    public List<Games> getAllGames() {
        return listAll();
    }

    public Games getGameById(Long id) {
        return findById(id);
    }

    public void createGame(Games game) {
        persist(game);
    }

    public void updateGame(Long id, Games updatedGame) {
        Games game = findById(id);
        if (game != null) {
            game.nombre = updatedGame.nombre;
            game.fecha = updatedGame.fecha;
            game.puntuacion = updatedGame.puntuacion;
        }
    }

    public void deleteGame(Long id) {
        deleteById(id);
    }
}