package Projecto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {
    private static final long serialVersionUID = 2877785672008532764L;
    private List<Utilizador> listaUtilizadores;
    private List<Autocarro> listaAutocarros = new ArrayList<>();
    private List<Motorista> listaMotoristas = new ArrayList<>();
    private List listaAdministradores = new ArrayList<Administrador>();

    private List listaNegraClientes = new ArrayList<Cliente>();
    private List listaReservas = new ArrayList<Reserva>();
    private List listaPreReservas = new ArrayList<Reserva>();

    static final Administrador administrador = new Administrador(
            "Tiago Sousa",
            "228923824",
            "Rua António Jardim",
            "910424769",
            "tiagosousa@aor.pt",
            "Administrador",
            "12345"
    );

    static final String AUTOCARROS_AOR = "autocarros_aor";

    public Empresa(List<Utilizador> utilizadores) {
        this.listaUtilizadores = utilizadores;
    }

    public Empresa() {
        this.listaUtilizadores = new ArrayList<>();
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

    public Autocarro adicionarAutocarro(String matricula, String marca, String modelo, int lotacao, Empresa empresa) {
        if (empresa.listaAutocarros.stream().anyMatch(autocarro -> autocarro.getMatricula().equals(matricula))) {
            return null;
        }

/*        for (Autocarro a : empresa.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                return null;
            }
        }*/

        Autocarro novoAutocarro = new Autocarro(matricula, marca, modelo, lotacao);
        empresa.listaAutocarros.add(novoAutocarro);

        escreveFicheiro(AUTOCARROS_AOR, empresa);

        return novoAutocarro;
    }

    public Utilizador registarCliente(
            String email,
            String nome,
            String telefone,
            String nif,
            String morada,
            String tipoDeSubscricao,
            String modoDePagamento,
            String palavraPasse,
            Empresa empresa
    ) {
        for (Utilizador u : empresa.listaUtilizadores) {
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

        empresa.listaUtilizadores.add(novoCliente);
        escreveFicheiro(AUTOCARROS_AOR, empresa);

        return novoCliente;
    }

    public List<Utilizador> listaDeClientes(Empresa empresa) {
        return empresa.listaUtilizadores.stream().filter(
                        user -> user.tipoUtilizador.equals("Cliente")
                )
                .toList();
    }

    public Utilizador login(String emailUtilizador, String palavraPasse, Empresa empresa) {
        for (Utilizador u : empresa.listaUtilizadores) {
            if (u.getEmail().equals(emailUtilizador) && u.getPalavraPasse().equals(palavraPasse)) {
                return u;
            }
        }
        return null;
    }

    private static void escreveFicheiro(String nome, Object objecto) {
        FicheiroDeObjetos fdo = new FicheiroDeObjetos();

        try {
            fdo.abreEscrita(nome);
            fdo.escreveObjecto(objecto);
            fdo.fechaEscrita();
        } catch (Exception e) {
            System.out.println("Erro a escrever o objecto: " + objecto.toString());
        }
    }

    public static Empresa leFicheiro(String nomeDoFicheiro) throws IOException, ClassNotFoundException {
        Empresa empresa = new Empresa();

        FicheiroDeObjetos fdo = new FicheiroDeObjetos();
        if (fdo.ficheiroExiste(nomeDoFicheiro)) {
            if (fdo.abreLeitura(nomeDoFicheiro)) {
                fdo.abreLeitura(nomeDoFicheiro);
                empresa = (Empresa) fdo.leObjecto();

                fdo.fechaLeitura();
            }
        } else {
            empresa.listaUtilizadores.add(administrador);
            escreveFicheiro(AUTOCARROS_AOR, empresa);
        }

        return empresa;
    }

    public boolean validarEmail(String email) {
        int count = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') count++;
        }
        if (count == 1) {
            return true;
        } else return false;

    }

    public Utilizador registarAdministrador(
            String email,
            String nome,
            String telefone,
            String nif,
            String morada,
            String palavraPasse,
            Empresa empresa
    ) {

        for (Utilizador u : empresa.listaUtilizadores) {
            if (u.getEmail().equals(email)) {
                return null;
            }
        }

        Administrador novoAdministrador = new Administrador(
                nome,
                nif,
                morada,
                telefone,
                email,
                "Administrador",
                palavraPasse

        );

        empresa.listaUtilizadores.add(novoAdministrador);
        escreveFicheiro(AUTOCARROS_AOR, empresa);

        return novoAdministrador;
    }
}