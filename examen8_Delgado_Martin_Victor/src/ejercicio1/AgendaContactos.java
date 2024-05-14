package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class AgendaContactos {

    private List<Persona> personas; //lista de personas

    public AgendaContactos() {
        personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void aniadir(Persona nueva) {
        if (nueva == null) {
            throw new NullPointerException("El objeto persona no puede ser nulo.");
        }
        personas.add(nueva);
    }

    public int numContactos() {
        return personas.size();
    }

    public Persona buscarPorID(int id) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getIdentificador() == id) {
                return personas.get(i);
            }

        }
        return null;
    }



    @Override
    public String toString() {
        String listado = "";

        if (personas.isEmpty()) {
            listado = "La agenda está vacía";
        } else {
            for (Persona c : personas) {
                listado = listado + c.toString() + "\n";
            }
        }
        return listado;
    }

}
