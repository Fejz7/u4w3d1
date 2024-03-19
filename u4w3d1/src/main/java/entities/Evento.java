package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;

    private Date dataEvento;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    private int numeroMassimoPartecipanti;


    public void setTitolo(String concerto) {

    }

    public void setDataEvento(Date date) {

    }

    public void setDescrizione(String concertoDiMusicaClassica) {

    }

    public void setNumeroMassimoPartecipanti(int i) {

    }

    public String getTitolo() {
        return null;
    }

    public String getId() {
        return null;
    }
}
