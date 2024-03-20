package dao;

import entities.Evento;

public interface EventoDAO {
    void save(Evento evento);
    Evento getById(Long id);
    void delete(Evento evento);
    void close();
}
