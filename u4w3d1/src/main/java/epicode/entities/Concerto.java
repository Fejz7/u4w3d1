package epicode.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends Event {
    @Enumerated(EnumType.STRING)
    private GenereMusica genere;
    private boolean inStreaming;

    public Concerto() {
        // Costruttore vuoto per JPA
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location luogoEvento, GenereMusica genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, luogoEvento);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereMusica getGenere() {
        return genere;
    }

    public void setGenere(GenereMusica genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
