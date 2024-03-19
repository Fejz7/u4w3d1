package org.example;

import entities.Evento;

import java.io.PrintStream;
import java.util.Date;

public class Application {
        public static <EventDAO> void main(String[] args) {
            EventDAO eventDAO = new EventDAO();


            Evento evento = new Evento();
            evento.setTitolo("Concerto");
            evento.setDataEvento(new Date());
            evento.setDescrizione("Concerto di musica classica");
            Object TipoEvento = null;
            evento.setDataEvento(TipoEvento.PUBBLICO);
            evento.setNumeroMassimoPartecipanti(100);


            eventDAO.save(evento);
            System.out.println("Evento salvato con successo. ID: " + evento.getId());


            Evento eventoRecuperato = eventDAO.getById(evento.getId());
            if (eventoRecuperato != null) {
                System.out.println("Evento recuperato: " + eventoRecuperato.getTitolo());
            } else {
                System.out.println("Nessun evento trovato con l'ID specificato.");
            }


            eventDAO.delete(evento);
            PrintStream out = System.out;

        }}
