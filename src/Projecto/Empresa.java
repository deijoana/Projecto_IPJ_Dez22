package Projecto;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {

    // atributo que especifica a versão do documento/ficheiro de objectos para prevenir que ocorra InvalidClassException
    private static final long serialVersionUID = 2877785672008532764L;
    private List<Utilizador> listaUtilizadores;
    private List<Autocarro> listaAutocarros;
    private List<Motorista> listaMotoristas;

    private List<Cliente> listaClientes;
    private List listaNegraClientes;
    private List<Reserva> listaReservas;
    private List listaPreReservas;

    // user logado
    private Utilizador loggeduser;

    public Utilizador getLoggeduser() {
        return loggeduser;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setLoggeduser(Utilizador loggeduser) {
        this.loggeduser = loggeduser;
    }

    // Nome atribuído ao ficheiro de objectos responsável por guardar toda a informação da instância empresa da Classe empresa
    // Definiu-se como static porque este dado não deverá nunca ser alterado
    private String AUTOCARROS_AOR = "autocarros_aor";

    //Instância de Administrador "sénior" para poder entrar na aplicação ao iniciar a execução do programa.
    //Definiu-se como static porque esta instância é de importância máxima e não deverá ser alterada em qualquer circunstância
    static final Administrador administrador = new Administrador(
            "Tiago Sousa",
            "228923824",
            "Rua António Jardim",
            "910424769",
            "tiagosousa@aor.pt",
            "Administrador",
            "12345"
    );



    public Empresa() {
        this.listaUtilizadores = new ArrayList<>();
        this.listaMotoristas = new ArrayList<>();
        this.listaAutocarros = new ArrayList<>();
        this.listaNegraClientes = new ArrayList<Cliente>();
        this.listaReservas = new ArrayList<Reserva>();
        this.listaPreReservas = new ArrayList<Reserva>();
    }

    public List getListaUtilizadores() {
        return listaUtilizadores;
    }

    public void setListaUtilizadores(List listaUtilizadores) {
        this.listaUtilizadores = listaUtilizadores;

    }

    // método que adiciona um autocarro à lista de autocarros, se não existir nenhuma instância nessa lista como igual matrícula
    public Autocarro adicionarAutocarro(String matricula, String marca, String modelo, int lotacao, Empresa empresa) {
        // código que substitui numa linha um ciclo for:each
        for (Autocarro a : empresa.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                return null;
            }
        }
        //if (empresa.listaAutocarros.stream().anyMatch(autocarro -> autocarro.getMatricula().equals(matricula))) {
        //  return null;
        //}

        Autocarro novoAutocarro = new Autocarro(matricula, marca, modelo, lotacao);
        empresa.listaAutocarros.add(novoAutocarro);
        escreveFicheiro(AUTOCARROS_AOR, empresa);  // guarda as alterações no ficheiro de objectos

        return novoAutocarro;
    }

    // método que permite ao Administrador editar os atributos de um autocarro

    public boolean editarAutocarro(
            String matricula,
            String novaMarca,
            String novoModelo,
            int novaLotacao,
            Empresa empresa
    ) {

        for (Autocarro a : empresa.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                a.setMarca(novaMarca);
                a.setModelo(novoModelo);
                a.setLotacao(Integer.parseInt(String.valueOf(novaLotacao)));

                escreveFicheiro(AUTOCARROS_AOR, empresa);
                return true;
            }
        }
        return false;
    }

    public boolean removerAutocarro(String matricula, Empresa empresa) {

        for (Autocarro a : empresa.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                empresa.listaAutocarros.remove(a);
                escreveFicheiro(AUTOCARROS_AOR, empresa);
                return true;
            }
        }
        return false;
    }

    public Motorista adicionarMotorista(String email, String nome, String nif, Empresa empresa) {
        for (Motorista m : empresa.listaMotoristas) {
            if (m.getNifMotorista().equals(nif)) {
                return null;
            }

        }
        Motorista novoMotorista = new Motorista(nome, email, nif);
        empresa.listaMotoristas.add(novoMotorista);
        escreveFicheiro((AUTOCARROS_AOR), empresa);
        return novoMotorista;
    }

    public boolean editarMotorista(String email, String nome, String nif, Empresa empresa) {
        // Será usado o nif como identificador do motorista, dado que este nunca altera ao longo da vida

        for (Motorista m : empresa.listaMotoristas) {
            if (m.getNifMotorista().equals(nif)) {
                m.setEmailMotorista(email);
                m.setNomeMotorista(nome);
                escreveFicheiro(AUTOCARROS_AOR, empresa);
                return true;

            }

        }

        return false;
    }

    public boolean removerMotorista( String nif, Empresa empresa) {
        // Será usado o nif como identificador do motorista, dado que este nunca altera ao longo da vida

        for (Motorista m : empresa.listaMotoristas) {
            if (m.getNifMotorista().equals(nif)) {
                empresa.listaMotoristas.remove(m);
                escreveFicheiro(AUTOCARROS_AOR, empresa);
                return true;
            }
        }


        return false;
    }
    public boolean editarCliente(String email, String nome, String telefone, String nif, String morada, String tipoSubscricao, String pagamentoSubscricao, String password, Empresa empresa) {
        // Será usado o nif como identificador do cliente, dado que este nunca altera ao longo da vida

        for (Utilizador client : empresa.listaUtilizadores) {
            if (client.getNif().equals(nif) && client.tipoUtilizador.equals("Cliente")) {
                client.setEmail(email);
                client.setNome(nome);
                client.setTelefone(telefone);
                client.setMorada(morada);
                escreveFicheiro(AUTOCARROS_AOR, empresa);
                return true;

            }

        }

        return false;
    }

    // método que adiciona um novo cliente à lista de utilizadores ao fazer um novo registo
    // só adiciona se não houver nenhuma instância com o mesmo email
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
                return null;  // significa que já existe uma conta para o email usado
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

    // método que percorre a lista de utilizadores e filtra todos os que são clientes
    public List<Utilizador> listaDeClientes(Empresa empresa) {
        return empresa.listaUtilizadores.stream().filter(
                        user -> user.tipoUtilizador.equals("Cliente")
                )
                .toList();
    }

    // método para as estatísticas que contabiliza o total de clientes
    public int totalClientes(Empresa empresa){
        int soma = 0;

        for (Utilizador u : empresa.listaUtilizadores) {
            if(u instanceof Cliente){
                soma++;
            }
        }
        return soma;
    }

    // método para as estatísticas que contabiliza motoristas
    public int totalMotoristas(Empresa empresa){
        int soma = 0;

        for (Motorista m : empresa.listaMotoristas) {
            if (m instanceof Motorista) {
                soma++;
            }
        }
        return soma;
    }

    // método para as estatísticas que contabiliza autocarros
    public int totalAutocarros(Empresa empresa){
        int soma = 0;

        for (Autocarro a : empresa.listaAutocarros) {
            if (a instanceof Autocarro) {
                soma++;
            }
        }
       return soma;

    }

    //método para um Cliente fazer uma reserva
    public Reserva fazerReserva(Autocarro bus,
                                Motorista driver,
                                Cliente client,
                                LocalDate dataPartida,
                                LocalDate dataRegresso,
                                int numPassageiros,
                                String localOrigem,
                                String localDestino,
                                double distancia,
                                Empresa empresa)
     {
        Reserva novaReserva = new Reserva(
                bus,
                driver,
                client,
                dataPartida,
                dataRegresso,
                numPassageiros,
                localOrigem,
                localDestino,
                distancia);

        empresa.listaReservas.add(novaReserva);
        escreveFicheiro(AUTOCARROS_AOR, empresa);

        return novaReserva;

    }

    //método para procurar disponilidade de autocarro
    public Autocarro procurarDisponibilidadeAutocarro(LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros, Empresa empresa){
        boolean saltaAutocarro = false; // salta para o proximo se verdadeiro
        Autocarro escolhido = null;

        for ( Autocarro a : empresa.listaAutocarros) {
            if (a.getLotacao() >= numPassageiros) { // autocarro elegivel, pois tem lotação suficiente

                for (Reserva reservaO : empresa.listaReservas) {
                    if(reservaO.getBus() == a &&
                            (reservaO.getDataPartida().isBefore(dataPartida) && reservaO.getDataRegresso().isAfter(dataPartida)) ||
                            (dataPartida.isBefore((reservaO.getDataPartida())) && dataRegresso.isAfter(reservaO.getDataRegresso()))) {//
                                saltaAutocarro = true; // reserva ocupa um periodo não elegivel
                    }
                }
            }
            if (!saltaAutocarro) { // não existe impedimento de escolher este autocarro, logo este serve
                escolhido = a;
                break;
            } else {
                saltaAutocarro = false; // este autocarro não serve pois há uma reserva naquelas datas
            }
        }
        return escolhido;
    }

    //método para procurar disponilidade de motorista
    public Motorista procurarDisponibilidadeMotorista(LocalDate dataPartida, LocalDate dataRegresso,  Empresa empresa){
        boolean saltaMotorista = false; // salta para o proximo se verdadeiro
            Motorista escolhido = null;
            for (Motorista m : empresa.listaMotoristas) {
                for (Reserva reservaO : empresa.listaReservas) {
                    if ((reservaO.getDataPartida().isBefore(dataPartida) && reservaO.getDataRegresso().isAfter(dataPartida)) ||
                    (dataPartida.isBefore((reservaO.getDataPartida())) && dataRegresso.isAfter(reservaO.getDataRegresso()))) {//
                        saltaMotorista = true;
                    }
                }
            if (!saltaMotorista) { // não existe impedimento de escolher este autocarro, logo este serve
                escolhido = m;
                break;
            } else {
                saltaMotorista = false; // este autocarro não serve pois há uma reserva naquelas datas
            }
        }
        return escolhido;
    }
    // método que devolve o utilizador que corresponde aos dados inseridos no painel de Login
    public Utilizador fazerLogin(String emailUtilizador, String palavraPasse, Empresa empresa) {
        for (Utilizador u : empresa.listaUtilizadores) {
            if (u.getEmail().equals(emailUtilizador) && u.getPalavraPasse().equals(palavraPasse)) {
                return u;
            }
        }
        return null;
    }

    //método usado para escrever o ficheiro de objectos
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

    public void setAUTOCARROS_AOR(String AUTOCARROS_AOR) {
        this.AUTOCARROS_AOR = AUTOCARROS_AOR;
    }

    // método usado para ler o ficheiro de objectos. Não havendo, cria o ficheiro e adiciona o administrador "sénior" definido por default
    public static Empresa leFicheiro(String nomeDoFicheiro) throws IOException, ClassNotFoundException {

        Empresa empresa = null;

        FicheiroDeObjetos fdo = new FicheiroDeObjetos();
        if (fdo.ficheiroExiste(nomeDoFicheiro)) {
            if (fdo.abreLeitura(nomeDoFicheiro)) {
                fdo.abreLeitura(nomeDoFicheiro);
                empresa = (Empresa) fdo.leObjecto();
                empresa.setAUTOCARROS_AOR(nomeDoFicheiro);

                fdo.fechaLeitura();
            }


        } else {

            empresa = new Empresa();
            empresa.listaUtilizadores.add(administrador);
            escreveFicheiro(nomeDoFicheiro,empresa);
        }

        return empresa;
    }

    // método que valida se o email inserido é válido
    public boolean validarEmail(String email, Empresa empresa) {
        int count = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') count++;
        }
        if (count == 1) {
            return true;
        } else return false;

    }

    public boolean validarDados(String dado, Empresa empresa) {
        // método que valida se caixa de texto de dado está preenchida ou não
        String vazio = "";
        if (dado.equals(vazio)) {
            return false;
        }
        return true;
    }

    // método que adiciona um novo administrador à lista de utilizadores ao fazer um novo registo
    // só adiciona se não houver nenhuma instância com o mesmo email
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

    public List<Motorista> getListaMotoristas() {
        return listaMotoristas;
    }

    public void setListaMotoristas(List<Motorista> listaMotoristas) {
        this.listaMotoristas = listaMotoristas;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }


}