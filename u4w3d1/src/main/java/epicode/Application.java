package epicode;

import com.github.javafaker.Faker;
import epicode.dao.EventsDAO;
import epicode.dao.PersonaDAO;
import epicode.dao.PartecipazioneDAO;
import epicode.entities.Event;
import epicode.entities.Persona;
import epicode.entities.Partecipazione;
import epicode.entities.TipoEvento;
import epicode.entities.StatoPartecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d1");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        EventsDAO eventsDAO = new EventsDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        Random rndm = new Random();

        // Aggiungere 20 eventi casuali
        for (int i = 0; i < 20; i++) {
            Event evento = new Event(
                    faker.chuckNorris().fact(),
                    LocalDate.of(rndm.nextInt(2023, 2025),
                            rndm.nextInt(1, 13),
                            rndm.nextInt(1, 29)),
                    faker.lorem().fixedString(50),
                    rndm.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO,
                    rndm.nextInt(1, 1000));
            eventsDAO.save(evento);

            // Aggiungere partecipanti casuali agli eventi
            int numPartecipanti = rndm.nextInt(1, 6);
            for (int j = 0; j < numPartecipanti; j++) {
                Persona persona = new Persona(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.date().birthday().toInstant().atZone(LocalDate.now().atStartOfDay().getZone()).toLocalDate(),
                        faker.bool().bool() ? Genere.M : Genere.F);
                personaDAO.save(persona);

                Partecipazione partecipazione = new Partecipazione(persona, evento, StatoPartecipazione.DA_CONFERMARE);
                partecipazioneDAO.save(partecipazione);
            }
        }

        // Esempio di utilizzo: trovare un evento per ID e stampare le sue partecipazioni
        Event foundEvent = eventsDAO.getById(6);
        if (foundEvent != null) {
            System.out.println("Evento trovato: " + foundEvent);
            System.out.println("Partecipanti:");
            for (Partecipazione partecipazione : foundEvent.getPartecipazioni()) {
                System.out.println(partecipazione.getPersona().getNome() + " " + partecipazione.getPersona().getCognome());
            }
        } else {
            System.out.println("Evento non trovato");
        }

        // Chiusura dell'EntityManager
        em.close();
        emf.close();
    }
}
