package org.example;

import entities.Evento;
import dao.EventoDAO;
import dao.EventoDAOImpl;

import java.util.Date;


public class Application {



        public static void main(String[] args) {

            EventoDAO eventoDAO = new EventoDAOImpl();


            Evento evento = new Evento();
            evento.setTitolo("Concerto");
            evento.setDataEvento(new Date());
            evento.setDescrizione("Concerto di musica classica");

            evento.setNumeroMassimoPartecipanti(100);


            eventoDAO.save(evento);
            System.out.println("Evento salvato con successo. ID: " + evento.getId());


            Evento eventoRecuperato = eventoDAO.getById(evento.getId());
            if (eventoRecuperato != null) {
                System.out.println("Evento recuperato: " + eventoRecuperato.getTitolo());
            } else {
                System.out.println("Nessun evento trovato con l'ID specificato.");
            }


            eventoDAO.delete(evento);
            System.out.println("Evento eliminato.");


            eventoDAO.close();
        }
    }
