package Projecto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Empresa implements Serializable {
    public static final String AUTOCARROS_AOR = "autocarros_aor";
    private List<Utilizador> listaUtilizadores;
    private List<Autocarro> listaAutocarros = new ArrayList<>();
    private List<Motorista> listaMotoristas = new ArrayList<>();
    private List listaAdministradores = new ArrayList<Administrador>();
    private List listaClientes = new ArrayList<Cliente>();
    private List listaNegraClientes = new ArrayList<Cliente>();
    private List listaReservas = new ArrayList<Reserva>();
    private List listaPreReservas = new ArrayList<Reserva>();

    Administrador administrador = new Administrador(
            "Tiago Sousa",
            228923824,
            "Rua António Jardim",
            "910424769",
            "tiagosousa@aor.pt",
            "Administrador",
            "12345"
    );

    public Empresa() throws IOException, ClassNotFoundException {
        this.listaUtilizadores = new ArrayList<>();

        List<Utilizador> utilizadoresCarregados = (List<Utilizador>) this.leFicheiro(AUTOCARROS_AOR);
        if (utilizadoresCarregados.size() == 0) {
            this.listaUtilizadores.add(administrador);
            this.escreveFicheiro(AUTOCARROS_AOR, this.listaUtilizadores);
        } else {
            this.listaUtilizadores = utilizadoresCarregados;
        }
    }

    public List getListaUtilizadores() {
        return listaUtilizadores;
    }

    public void setListaUtilizadores(List listaUtilizadores) {
        this.listaUtilizadores = listaUtilizadores;
    }

    public List getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public List getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Utilizador registarCliente(
            String email,
            String nome,
            String telefone,
            long nif,
            String morada,
            String tipoDeSubscricao,
            String modoDePagamento,
            String palavraPasse
    ) {

        for (Utilizador u: this.listaUtilizadores) {
            if (u.getEmail().equals(email)) {
                return null;
            }
        }

       Cliente novoCliente = new Cliente(
               nome,
               nif,
               morada,
               telefone,
               email,
               "Cliente",
               palavraPasse,
               tipoDeSubscricao,
               modoDePagamento
       );



        this.escreveFicheiro(AUTOCARROS_AOR, this.listaUtilizadores.add(novoCliente));

        return novoCliente;
    }

    public Utilizador login(String emailUtilizador, String palavraPasse) {
        for (Utilizador u: this.listaUtilizadores) {
            if (u.getEmail().equals(emailUtilizador) && u.getPalavraPasse().equals(palavraPasse)) {
                return u;
            }
        }
        return null;
    }

    public void addAutocarro(Autocarro bus) {
        listaAutocarros.add(bus);
    }

    private void escreveFicheiro(String nome, Object objecto) {
        FicheiroDeObjetos fdo = new FicheiroDeObjetos();

        try {
            fdo.abreEscrita(nome);
            fdo.escreveObjecto(objecto);
            fdo.fechaEscrita();
        } catch (Exception e) {
            System.out.println("Erro a escrever o objecto: " + objecto.toString());
        }
    }

    private Object leFicheiro(String nomeDoFicheiro) throws IOException, ClassNotFoundException {
        Object objeto = new ArrayList<>();
        FicheiroDeObjetos fdo = new FicheiroDeObjetos();
        if (fdo.ficheiroExiste(nomeDoFicheiro)) {
            if (fdo.abreLeitura(nomeDoFicheiro)) {
                fdo.abreLeitura(nomeDoFicheiro);
                objeto = fdo.leObjecto();
                fdo.fechaLeitura();
            }
        }
        return objeto;
    }
}
