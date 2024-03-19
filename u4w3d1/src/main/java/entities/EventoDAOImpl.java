package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EventoDAOImpl implements EventoDAO {
    private EntityManager entityManager;

    public EventoDAOImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestioneEventiPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Evento evento) {
        entityManager.getTransaction().begin();
        entityManager.persist(evento);
        entityManager.getTransaction().commit();
    }

    @Override
    public Evento getById(Long id) {
        return entityManager.find(Evento.class, id);
    }

    @Override
    public void delete(Evento evento) {
        entityManager.getTransaction().begin();
        entityManager.remove(evento);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        entityManager.close();
    }
}
