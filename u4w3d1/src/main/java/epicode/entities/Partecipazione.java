package epicode.entities;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoPartecipazione stato;

    // Constructors
    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Event evento, StatoPartecipazione stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }


}
