package Projecto;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * Classe onde estão armazenados todos os dados da aplicação bem como a maioria dos métodos que são chamados para aceder à informação necessária para a execução da aplicação
 * @author Joana Ramalho
 * @author Tiago Sousa
 */

public class Empresa implements Serializable {

    // atributo que especifica a versão do documento/ficheiro de objectos para prevenir que ocorra InvalidClassException
    private static final long serialVersionUID = 1L;

    /**
     * Nome atribuído ao ficheiro de objectos responsável por guardar toda a informação da instância empresa da Classe empresa
     */
    private String AUTOCARROS_AOR = "autocarros_aor";
    private List<Utilizador> listaUtilizadores;
    private List<Autocarro> listaAutocarros;
    private List<Motorista> listaMotoristas;
    private List<Utilizador> listaNegraClientes;
    private List<Reserva> listaReservasCanceladas;
    private List<Reserva> listaReservas;

    /**
     * na altura de criar reserva, será usado para gerar o id da nova reserva; Vai incrementando o seu valor
     */
    private int reservasIdGenerator;
    private List listaPreReservas;

    /**
     * Guarda informação do utilizador que está logado
     */
    private Utilizador loggeduser;

    public Empresa() {
        this.listaUtilizadores = new ArrayList<>();
        this.listaMotoristas = new ArrayList<>();
        this.listaAutocarros = new ArrayList<>();
        this.listaNegraClientes = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        this.listaPreReservas = new ArrayList<>();
        this.listaReservasCanceladas = new ArrayList<>();
        this.reservasIdGenerator=0;
    }

    /**
     * Instância de Administrador "sénior", para poder entrar na aplicação ao iniciar a execução do programa
     * Definiu-se como static porque esta instância é de importância máxima e não deverá ser alterada em qualquer circunstância
     */
    static final Administrador administrador = new Administrador(
            "Tiago Sousa",
            "228923824",
            "Rua António Jardim",
            "910424769",
            "tiagosousa@aor.pt",
            "Administrador",
            "12345"

    );

    /**
     * Método que obtém a informação do utilizador que está logado na aplicação
     * @return Objecto do tipo Utilizador
     */
    public Utilizador getLoggeduser() {
        return loggeduser;
    }

    /**
     * Método que define o novo Utilizador que está logado na aplicação
     * @param loggeduser Objecto utilizador que representa e guarda toda a informação do novo utilizador logado
     */
    public void setLoggeduser(Utilizador loggeduser) {
        this.loggeduser = loggeduser;
    }

    /**
     * Método que adiciona um autocarro à lista de autocarros, se não existir nenhuma instância nessa lista com igual matrícula. Guarda as alterações no ficheiro de objectos
     * @param matricula representa a matrícula do autocarro a ser adicionado
     * @param marca representa a marca do autocarro a ser adicionado
     * @param modelo representa o modelo do autocarro a ser adicionado
     * @param lotacao representa a lotação do autocarro a ser adicionado
     * @return Objecto da classe Autocarro ou null se já houver correspondência para a matrícula na lista de autocarros
     */
     public Autocarro adicionarAutocarro(String matricula, String marca, String modelo, int lotacao) {

        for (Autocarro a : this.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                return null;
            }
        }
        // código que substitui numa linha um ciclo for:each
        //if (empresa.listaAutocarros.stream().anyMatch(autocarro -> autocarro.getMatricula().equals(matricula))) {
        //  return null;
        //}

        Autocarro novoAutocarro = new Autocarro(matricula, marca, modelo, lotacao);
        this.listaAutocarros.add(novoAutocarro);
        escreveFicheiro();  // guarda as alterações no ficheiro de objectos

        return novoAutocarro;
    }

    /**
     * Método que edita os atributos do autocarro se houver correspondência para a matrícula dada como parâmetro. Guarda as alterações no ficheiro de objectos
     * @param matricula representa a matrícula do autocarro a ser editado
     * @param novaMarca representa a marca do autocarro a ser editado
     * @param novoModelo representa o modelo do autocarro a ser editado
     * @param novaLotacao representa a lotação do autocarro a ser editado
     * @return true se houver correspondência para a matrícula e as informações do autocarro respectivo forem editadas. False se nenhuma correspondência for encontrada para a matrícula dada como parâmetro
     */
    public boolean editarAutocarro(
            String matricula,
            String novaMarca,
            String novoModelo,
            int novaLotacao
    ) {

        for (Autocarro a : this.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                a.setMarca(novaMarca);
                a.setModelo(novoModelo);
                a.setLotacao(Integer.parseInt(String.valueOf(novaLotacao)));

                escreveFicheiro();
                return true;
            }
        }
        return false;
    }

    /**
     * Método que remove o autocarro da lista de autocarros se houver correspondência para a matrícula dada como parâmetro. Guarda as alterações no ficheiro de objectos
     * @param matricula representa a matrícula do autocarro a ser removido
     * @return true se houver correspondência para a matrícula e o autocarro respectivo for removido. False se nenhuma correspondência for encontrada para a matrícula dada como parâmetro
     */
    public boolean removerAutocarro(String matricula) {

        for (Autocarro a : this.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                this.listaAutocarros.remove(a);
                escreveFicheiro();
                return true;
            }
        }
        return false;
    }


    /**
     * Método que adiciona um motorista à lista de motoristas, se não existir nenhuma instância nessa lista com igual NIF. Guarda as alterações no ficheiro de objectos
     * @param email representa o email do motorista a ser adicionado
     * @param nome representa o nome do motorista a ser adicionado
     * @param nif representa o nif do motorista a ser adicionado
     * @return Objecto da classe motorista ou null se já houver correspondência para o nif na lista de motoristas
     */
    public Motorista adicionarMotorista(String email, String nome, String nif) {
        for (Motorista m : this.listaMotoristas) {
            if (m.getNifMotorista().equals(nif)) {
                return null;
            }

        }
        Motorista novoMotorista = new Motorista(nome, email, nif);
        this.listaMotoristas.add(novoMotorista);
        escreveFicheiro();
        return novoMotorista;
    }

    /**
     * Método que edita os atributos do motorista se houver correspondência para o nif dado como parâmetro. Guarda as alterações no ficheiro de objectos
     * @param email representa o email do motorista a ser editado
     * @param nome representa o nome do motorista a ser editado
     * @param nif representa o nif do motorista a ser editado
     * @return true se houver correspondência para o nif e as informações do motorista respectivo forem editadas. False se nenhuma correspondência for encontrada para o nif dado como parâmetro
     */
    public boolean editarMotorista(String email, String nome, String nif) {
        // Será usado o nif como identificador do motorista, dado que este nunca altera ao longo da vida

        for (Motorista m : this.listaMotoristas) {
            if (m.getNifMotorista().equals(nif)) {
                m.setEmailMotorista(email);
                m.setNomeMotorista(nome);
                escreveFicheiro();

                return true;
            }
        }
        return false;
    }

    /**
     * Método que remove o motorista da lista de motoristas se houver correspondência para o nif dado como parâmetro. Guarda as alterações no ficheiro de objectos
     * @param nif representa o nif do motorista a ser removido
     * @return true se houver correspondência para o nif e o motorista respectivo for removido. False se nenhuma correspondência for encontrada para o nif dado como parâmetro
     */
    public boolean removerMotorista(String nif) {
        // Será usado o nif como identificador do motorista, dado que este nunca altera ao longo da vida

        for (Motorista m : this.listaMotoristas) {

            if (m.getNifMotorista().equals(nif)) {
                this.listaMotoristas.remove(m);
                escreveFicheiro();
                return true;
            }
        }
        return false;
    }

    /**
     * Método que adiciona um cliente à lista de utilizadores, desde que não haja correspondência na lista de utilizadores para o email usado
     * @param email
     * @param nome
     * @param telefone
     * @param nif
     * @param morada
     * @param tipoDeSubscricao
     * @param modoDePagamento
     * @param palavraPasse
     * @return
     */

    // método que adiciona um novo cliente à lista de utilizadores ao fazer um novo registo
    // só adiciona se não houver nenhuma instância com o mesmo email
    public Utilizador registarCliente(
            String email,
            String nome,
            String telefone,
            String nif,
            String morada,
            TipoSubscricao tipoDeSubscricao,
            String modoDePagamento,
            String palavraPasse
    ) {
        for (Utilizador u : this.listaUtilizadores) {
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

        this.listaUtilizadores.add(novoCliente);
        escreveFicheiro();

        return novoCliente;
    }


    public boolean editarCliente(String email, String nome, String telefone, String nif, String morada) {
        // Será usado o nif como identificador do cliente, dado que este nunca altera ao longo da vida

        for (Utilizador client : this.listaUtilizadores) {
            if (client.getNif().equals(nif) && client.tipoUtilizador.equals("Cliente")) {
                client.setEmail(email);
                client.setNome(nome);
                client.setTelefone(telefone);
                client.setMorada(morada);
                escreveFicheiro();
                return true;
            }
        }
        return false;
    }

    //método para remover cliente usando o NIF -> percorremos a lista de utlizadores e verificamos se o NIF é igual
    //e se o tipo de Utilizador é cliente.
    public boolean removerCliente(String nif) {
        // Será usado o nif como identificador do cliente a remover, dado que este nunca altera ao longo da vida
        for (Utilizador client : this.listaUtilizadores) {
            if (client.getNif().equals(nif) && client.tipoUtilizador.equals("Cliente")) {

                this.listaNegraClientes.add(client); // adiciona o cliente a lista alternativa, porque este cliente mantém a possibilidade de fazer login
                this.listaUtilizadores.remove(client);
                escreveFicheiro();
                return true;
            }

        }
        return false;
    }

    public int alterarPassword(String passwordAntiga, String passwordNova, String confirmacaoPasswordNova) {


        if (!this.getLoggeduser().getPalavraPasse().equals(passwordAntiga)) {
            return 1;
        }

        if (!passwordNova.equals(confirmacaoPasswordNova)) {
            return 2;
        }

        if (passwordNova.equals(passwordAntiga)) {
            return 3;
        }

        if (!passwordNova.equals(confirmacaoPasswordNova)) {
            return 4;
        }

        loggeduser.setPalavraPasse(passwordNova);
        return 5;
    }


/*
    public boolean alterarPalavraPass(String novaPass, String novaPass2, Empresa empresa) {

        for (Utilizador u : empresa.listaUtilizadores) {
            if (u.getPalavraPasse().equals(novaPass)) {
                return false;
            } else {
                u.setPalavraPasse(novaPass);
            }
        }
        return true;
    }
*/

    // método que percorre a lista de utilizadores e filtra todos os que são clientes
    public List<Utilizador> listaDeClientes() {
        return this.listaUtilizadores.stream().filter(
                        user -> user.tipoUtilizador.equals("Cliente")
                )
                .toList();
    }

    public List<Reserva> listagemHistoricoReservas() {
        // método que mostra todas as reservas passadas de um dado cliente

        List<Reserva> listaReserva = new ArrayList<>();

        for (Reserva r : this.listaReservas) {
            if (r.getClient().equals(this.loggeduser)) {
                if (r.getDataPartida().isBefore(LocalDate.now())) {
                    listaReserva.add(r);
                }
            }
        }

        return listaReserva;

      /*return empresa.listaReservas.stream().filter(
                        r -> r.getClient().equals(loggeduser)

                ).filter(user -> user.getDataPartida().isBefore(LocalDate.now()))
                .toList();*/

    }

    public List<Reserva> listaReservasCliente() {
        // método que mostra todas as reservas futuras de um dado cliente

        List<Reserva> listaReserva = new ArrayList<>();

        for (Reserva r : this.listaReservas) {
            if (r.getClient().equals(this.loggeduser)) {
                if (r.getDataPartida().isAfter(LocalDate.now())) {
                    listaReserva.add(r);
                }
            }
        }

        return listaReserva;




       /* return empresa.listaReservas.stream().filter(
                        user -> user.getClient().equals(empresa.loggeduser)
                ).filter(user -> user.getDataPartida().isAfter(LocalDate.now()))
                .toList();
*/
    }


    public List<String> listarAutocarrosReservados(String ano, String mes) {
        // método que lista todos os autocarros reservados num dado mês e a respectiva data

        int valorAno = Integer.parseInt(ano);
        int valorMes = Integer.parseInt(mes);
        List<String> listaAutocarrosReservados = new ArrayList<>();

        for (Reserva r : this.listaReservas) {
            if (r.getDataPartida().getYear() == valorAno && r.getDataPartida().getMonthValue() == valorMes) {
                listaAutocarrosReservados.add(r.getBus().toString() + " de " + r.getDataPartida() + " a " + r.getDataRegresso());

            }
        }
    /*    for (int i = 0; i < listaAutocarrosReservados.size(); i++) {
            System.out.println(listaAutocarrosReservados.get(i));
        }*/
        return listaAutocarrosReservados;
    }

    public List<Reserva> listarReservasCanceladas(String ano, String mes) {
        // método que lista todas as reservas canceladas num dado mês e a respectiva data

        int valorAno = Integer.parseInt(ano);
        int valorMes = Integer.parseInt(mes);

        List<Reserva> listaResCanceladas = new ArrayList<>();

        if (this.listaReservasCanceladas.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame("Lista de reservas canceladas"), "Não há nenhuma reserva cancelada");
        } else {
            for (Reserva r : this.listaReservasCanceladas) {
                if (r.getDataPartida().getYear() == valorAno && r.getDataPartida().getMonthValue() == valorMes) {
                    listaResCanceladas.add(r);
                }
            }
        }
        return listaResCanceladas;
    }

    public String avaliarReservaMensal(String ano, int mes) {
        int valorAno = Integer.parseInt(ano);

        String listaReservaMensal = "";
        int count = 0;
        double volume = 0;

        for (Reserva r : listaReservas) {
            if (r.getDataPartida().getYear() == valorAno && r.getDataPartida().getMonthValue() == mes) {
                count++;
                volume = volume + r.getCusto();
            }
        }

      /*  if (count == 0 || volume == 0) {
            listaReservaMensal = null;
        } else
            listaReservaMensal = "No mês " + mes + " do ano " + ano + " há registo de " + count + " reservas, perfazendo um total de " + volume + "€";
*/
        //   return listaReservaMensal;
        escreveFicheiro();
        return listaReservaMensal = "No " + mes + "º mês de " + ano + " há registo de " + count + " reservas, perfazendo um total de " + volume + "€";
    }

    public LocalDate diaAnoMaisReservas(String ano) {

        int valorAno = Integer.parseInt(ano);
        LocalDate dia = LocalDate.of(valorAno, 01, 01);
        LocalDate diaMaisReservas = null;

        int count = 0;
        int countmax = 0;

        if (dia.isLeapYear()) {
            for (int i = 1; i < 367; i++) {
                count = 0;
                for (Reserva r : this.listaReservas) {
                    if ((dia.isEqual(r.getDataPartida()) || dia.isAfter(r.getDataPartida())) && (dia.isEqual(r.getDataRegresso()) || dia.isBefore(r.getDataRegresso()))) {
                        count++;
                    }
                }
                if (count > countmax) {
                    countmax = count;
                    diaMaisReservas = dia;
                }
                dia = dia.plusDays(1);

            }

        } else {
            for (int i = 1; i < 366; i++) {
                count = 0;
                for (Reserva r : this.listaReservas) {
                    if ((dia.isEqual(r.getDataPartida()) || dia.isAfter(r.getDataPartida())) && (dia.isEqual(r.getDataRegresso()) || dia.isBefore(r.getDataRegresso()))) {
                        count++;
                    }
                }
                if (count > countmax) {
                    countmax = count;
                    diaMaisReservas = dia;
                }
                dia = dia.plusDays(1);
            }
        }
        escreveFicheiro();
        return diaMaisReservas;
    }

    // método para as estatísticas que contabiliza o total de clientes
    public int totalClientes() {
        int soma = 0;

        for (Utilizador u : this.listaUtilizadores) {
            if (u instanceof Cliente) {
                soma++;
            }
        }
        return soma;
    }

    // método para as estatísticas que contabiliza motoristas
    public int totalMotoristas() {
        int soma = 0;

        for (Motorista m : this.listaMotoristas) {
            if (m instanceof Motorista) {
                soma++;
            }
        }
        return soma;
    }

    // método para as estatísticas que contabiliza autocarros
    public int totalAutocarros() {
        int soma = 0;

        for (Autocarro a : this.listaAutocarros) {
            if (a instanceof Autocarro) {
                soma++;
            }
        }
        return soma;

    }

    //método que devolve o autocarro mais requisitado
    public AutocarrosMaisUtilizadosStats encontrarAutocarroMaisReq() {

        Autocarro autocarroMaisReq = null;

        int contador = 0;
        int maximo = 0;

        List<Autocarro> buss = new ArrayList<>();
        for (Autocarro a : this.listaAutocarros) {

            for (Reserva r : this.listaReservas) {
                if (r.getBus().equals(a)) {
                    contador++;
                }
                if (contador > maximo) {
                    maximo = contador;
                    autocarroMaisReq = a;
                }
            }
            contador = 0;

        }

        for (Autocarro a : this.listaAutocarros) {
            int numeroDeOcorrencias = 0;
            for (Reserva r : this.listaReservas) {
                if (r.getBus().equals(a)) {
                    numeroDeOcorrencias++;
                }
            }
            if (numeroDeOcorrencias == maximo)
                buss.add(a);
        }


        return new AutocarrosMaisUtilizadosStats(maximo, buss);
    }

    //método que devolve o cliente com mais reservas
    public Utilizador clienteComMaisReservas() {

        Utilizador clMaxReservas = null;

        int contador = 0;
        int maximo = 0;

        for (Utilizador c : this.listaUtilizadores) {
            if (c instanceof Cliente) {

                for (Reserva r : this.listaReservas) {
                    if (r.getClient().equals(c)) {
                        contador++;
                    }
                    if (contador > maximo) {
                        maximo = contador;
                        clMaxReservas = c;
                    }
                }
                contador = 0;
            }
        }
        return clMaxReservas;
    }

    public List<Utilizador> clienteComMaisReservasStats() {

        List<Utilizador> clMaxReservas = new ArrayList<>();

        int contador = 0;
        int maximo = 0;

        for (Utilizador c : this.listaUtilizadores) {
            if (c instanceof Cliente) {

                for (Reserva r : this.listaReservas) {
                    if (r.getClient().equals(c)) {
                        contador++;
                    }
                    if (contador > maximo) {
                        maximo = contador;
                        clMaxReservas.add(c);
                    }
                }
                contador = 0;
            }
        }
        return clMaxReservas;
    }


    public Reserva fazerReserva(Cliente client,
                                LocalDate dataPartida,
                                LocalDate dataRegresso,
                                int numPassageiros,
                                String localOrigem,
                                String localDestino,
                                double distancia) {

        Autocarro autocarro = getAutocarroLivre(dataPartida, dataRegresso, numPassageiros);
        Motorista motorista = procurarDisponibilidadeMotorista(dataPartida, dataRegresso);

        Reserva reservaCriada = null;
        if (autocarro != null && motorista != null) {
            System.out.printf("Encontrado Motorista %s e Autocarro %s disponivel para nova reserva%n", motorista.getNifMotorista(), autocarro.getMatricula());
            reservaCriada = criarNovaReserva(autocarro, motorista, client, dataPartida, dataRegresso, numPassageiros, localOrigem, localDestino, distancia);

        } else if (motorista != null && client.isPremium()) {
            System.out.println("Não foi encontrado autocarro disponivel para os criterios pretendidos!");


            Reserva reservaExistente = getReservaDeClientNormalQuePossaSerCancelada(dataPartida, dataRegresso, numPassageiros);
            System.out.println("Existe uma reserva '%s' de um cliente Normal que pode ser cancelada".formatted(reservaExistente.getId()));

            Reembolso reembolso = cancelarReserva(reservaExistente.getId(), LocalDate.now());

            reservaExistente.getClient().addNotificacao(" A sua reserva " + reservaExistente.getId() + "foi cancelada. Se aplicável, receberá o reembolso devido pelo mesmo método com que efectuou o pagamento da reserva");

            System.out.println("Reserva Cancelada!!!");

            reservaCriada = criarNovaReserva(
                    reservaExistente.getBus(),
                    motorista, client, dataPartida, dataRegresso, numPassageiros, localOrigem, localDestino, distancia);


        } else
            throw new IllegalArgumentException("Não existe autocarro ou motorista disponivel");

        escreveFicheiro();
        return reservaCriada;

    }

    private Reserva getReservaDeClientNormalQuePossaSerCancelada(LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros) {
        LocalDate dataPartidaPlusTwoDays = dataPartida.plusDays(2);
        return this.listaReservas.stream()
                .filter(reserva -> reserva.getClient().isNormal())
                .filter(reserva -> reserva.getBus().getLotacao() >= numPassageiros)
                .filter(reserva -> reserva.isBetween(dataPartidaPlusTwoDays, dataRegresso))
                .min(Comparator.comparing(reserva -> reserva.getNumPassageiros()))
                .orElse(null);
    }

    private Autocarro getAutocarroLivre(LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros) {

        return this.listaAutocarros.stream()
                .filter(autocarro -> autocarro.getLotacao() >= numPassageiros)
                .filter(autocarro -> naoExistReservaNoPeriodoParaOAutocarro(autocarro, dataPartida, dataRegresso))
                .sorted(Comparator.comparing(Autocarro::getLotacao)).findFirst().orElse(null);
    }


    // um autocarro esta libre entre duas dasta se e so se:
    // não existe reserva para ele entre essas duas datas

    boolean naoExistReservaNoPeriodoParaOAutocarro(Autocarro auto, LocalDate d1, LocalDate d2) {
        // se não existirem reservas para o autocarro

        long count = this.listaReservas.stream()
                .filter(r -> r.isBetween(d1, d2))
                .filter(r -> r.getBus().equals(auto)).count();
        return count == 0L;
    }


    //método para um Cliente fazer uma reserva
    private Reserva criarNovaReserva(Autocarro bus,
                                     Motorista driver,
                                     Cliente client,
                                     LocalDate dataPartida,
                                     LocalDate dataRegresso,
                                     int numPassageiros,
                                     String localOrigem,
                                     String localDestino,
                                     double distancia
    ) {


        String idNovaReserva = generateNovoIdDeReserva();

        System.out.println("nova reserva será criada com o id <" + idNovaReserva + ">");

        Reserva novaReserva = new Reserva(
                idNovaReserva,
                bus,
                driver,
                client,
                dataPartida,
                dataRegresso,
                numPassageiros,
                localOrigem,
                localDestino,
                distancia);

        listaReservas.add(novaReserva);
        // escreveFicheiro();

        return novaReserva;

    }

    private String generateNovoIdDeReserva() {
        return "" + (++this.reservasIdGenerator);
    }


    public Reembolso cancelarReservaFromView(String idReserva, LocalDate dataDeCancelamento) {
        Reserva reserva = getReserva(idReserva);

        if (!reserva.getClient().equals(loggeduser)) {
            throw new IllegalArgumentException("O cliente pode apenas cancelar reservas criadas por si proprio");
        }
        return cancelarReserva(reserva, dataDeCancelamento);
    }

    private Reembolso cancelarReserva(String idReserva, LocalDate dataDeCancelamento) {
        Reserva reserva = getReserva(idReserva);
        return cancelarReserva(reserva, dataDeCancelamento);
    }

    public void addReservaCancelada(String idReserva) {
        Reserva r = getReserva(idReserva);
        this.listaReservasCanceladas.add(r);
        escreveFicheiro();

    }

    public void addReservaCancelada(Reserva r) {
        this.listaReservasCanceladas.add(r);
        escreveFicheiro();

    }

    private Reembolso cancelarReserva(Reserva reserva, LocalDate dataDeCancelamento) {

        Reembolso reenbolse = reserva.cancelar(dataDeCancelamento);

        removeReserva(reserva);


        escreveFicheiro();

        return reenbolse;
    }


    private Reserva getReserva(String idReserva) {
        Reserva reserva = findReservaPorId(idReserva);
        if (reserva == null) {
            throw new IllegalArgumentException("Não existe nenhuma reserva com o id " + idReserva);
        }
        return reserva;
    }

    private boolean removeReserva(Reserva reserva) {
        return this.listaReservas.remove(reserva);
    }

    private Reserva findReservaPorId(String idReserva) {
        for (Reserva item : this.listaReservas) {
            if (Objects.equals(idReserva, item.getId())) {
                return item;
            }
        }
        return null;
    }

    public double calcularCustoViagem(int numPassageiros, double distancia) {
        double custo;
        custo = distancia * 0.55 + 1.2 * numPassageiros;
        return custo;
    }


    //método para procurar disponilidade de autocarro
    public Autocarro procurarDisponibilidadeAutocarro(LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros) {
        Autocarro escolhido = null;
        List<Autocarro> listaAutocarrosDisponiveis = new ArrayList<>();


        for (Autocarro a : this.listaAutocarros) {
            boolean saltaAutocarro = true; // salta para o proximo se verdadeiro
            // autocarro elegivel, pois tem lotação suficiente
            if (a.getLotacao() >= numPassageiros) {
                saltaAutocarro = false;
                for (Reserva r : this.listaReservas) {
                    if (r.getBus() == a) {
                        if ((r.getDataPartida().isBefore(dataPartida) && r.getDataRegresso().isAfter(dataPartida)) ||
                                (dataPartida.isBefore(r.getDataPartida()) && dataRegresso.isAfter(r.getDataRegresso())) ||
                                (dataRegresso.isAfter(r.getDataPartida()) && dataRegresso.isBefore(r.getDataRegresso())) ||
                                (r.getDataPartida().isEqual(dataPartida) || r.getDataRegresso().isEqual(dataRegresso))) {
                            // reserva não é elegivel
                            saltaAutocarro = true;
                        }
                    }
                }
            }
            if (!saltaAutocarro) { // não existe impedimento de escolher este autocarro, logo este serve
                listaAutocarrosDisponiveis.add(a);
                //escolhido = a;
                //break;
            } else {
                saltaAutocarro = false; // este autocarro não serve pois há uma reserva naquelas datas
            }
        }
        // assegura que o autocarro disponivel selecionado é que minimiza os lugares não usados na reserva
        escolhido = listaAutocarrosDisponiveis.get(0);
        for (Autocarro bus : listaAutocarrosDisponiveis) {
            if (bus.getLotacao() < escolhido.getLotacao()) {
                escolhido = bus;
            }
        }

        return escolhido;
    }


    //método para procurar disponilidade de motorista
    public Motorista procurarDisponibilidadeMotorista(LocalDate dataPartida, LocalDate dataRegresso) {
        // salta para o proximo se verdadeiro
        Motorista escolhido = null;

        for (Motorista m : this.listaMotoristas) {
            boolean saltaMotorista = false;

            for (Reserva r : this.listaReservas) {
                if ((r.getDataPartida().isBefore(dataPartida) && r.getDataRegresso().isAfter(dataPartida)) && r.getDriver().equals(m) ||
                        (dataPartida.isBefore(r.getDataPartida()) && dataRegresso.isAfter(r.getDataRegresso())) && r.getDriver().equals(m) ||
                        (dataRegresso.isAfter(r.getDataPartida()) && dataRegresso.isBefore(r.getDataRegresso())) && r.getDriver().equals(m) ||
                        (r.getDataPartida().isEqual(dataPartida) && r.getDriver().equals(m) || r.getDataRegresso().isEqual(dataRegresso)) && r.getDriver().equals(m)
                ) {
                    saltaMotorista = true;
                }
            }


            if (!saltaMotorista) { // não existe impedimento de escolher este motorista, logo este serve
                escolhido = m;
                break;
            }
        }
        return escolhido;
    }

    // método que devolve o utilizador que corresponde aos dados inseridos no painel de Login
    public Utilizador fazerLogin(String emailUtilizador, String palavraPasse) {
        for (Utilizador u : this.listaUtilizadores) {
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

    private void escreveFicheiro() { // writeMySelfInFIle
        escreveFicheiro(AUTOCARROS_AOR, this);
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
            escreveFicheiro(nomeDoFicheiro, empresa);
        }

        return empresa;
    }

    private void setAUTOCARROS_AOR(String nomeDoFicheiro) {
        this.AUTOCARROS_AOR = nomeDoFicheiro;
    }

// método que valida se o email inserido é válido
    /*public boolean validarEmail(String email) {
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') count++;
        }
        if (count == 1) {
            return true;
        } else return false;
    }*/

    public boolean validarEmail(String email) {
        //valida email inserido se obedecer às regras abaixo descritas
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email.trim()).matches();
    }


    public boolean validarDados(String input) {
        // método que valida se caixa de texto de dado está preenchida ou não
        String vazio = "";
        if (input.trim().equals(vazio)) {
            return false;
        }
        return true;
    }

    public int validarComboBoxIndex(int subscricao, int pagamento) {

        if (subscricao == 0 || pagamento == 0) {
            return 0;
        }
        return 1;

    }

    public int validarComboBoxIndex(int pagamento) {

        if (pagamento == 0) {
            return 0;
        }
        return 1; // alguma comboBox foi selecionada

    }

    /*  public boolean validarPassword(String password){
          String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
          Pattern pat = Pattern.compile(passwordRegex);
          if (password == null) {
              return false;
          }
          return pat.matcher(password).matches();
      }
  */
    public boolean validarTelefone(String telefone) {
        String telefoneRegex = "^(\\+351|00351)?(9|3|2)(\\d{8})";

        Pattern pat = Pattern.compile(telefoneRegex);
        if (telefone == null) {
            return false;
        }

        return pat.matcher(telefone.trim()).matches();
    }

    public boolean validarNIF(String nif) {
        String nifRegex = "[\\d][0-9]{8}";

        Pattern pat = Pattern.compile(nifRegex);
        if (nif == null)
            return false;
        return pat.matcher(nif.trim()).matches();
    }

    public boolean validarMatricula(String matricula) {
        String matriculaRegex = "^[a-zA-Z-0-9][a-zA-Z-0-9][-][a-zA-Z-0-9][a-zA-Z-0-9][-][a-zA-Z-0-9][a-zA-Z-0-9]$";

        Pattern pat = Pattern.compile(matriculaRegex);
        if (matricula == null)
            return false;
        return pat.matcher(matricula.trim()).matches();
    }

    public boolean validarAno(String ano) {
        // método que valida apenas valores de anos no século XXI

        String anoRegex = "^[2][0][0-9][0-9]$";

        Pattern pat = Pattern.compile(anoRegex);
        if (anoRegex == null) {
            return false;
        }
        return pat.matcher(ano.trim()).matches();
    }

    public boolean validarCVC(String cvc) {

        String cvcRegex = "^[0-9][0-9][0-9]$";

        Pattern pat = Pattern.compile((cvcRegex));
        if (cvcRegex == null) {
            return false;
        }
        return pat.matcher(cvc.trim()).matches();
    }

    public boolean validarnumCC(String numCC) {
        String nifRegex = "[\\d][0-9]{15}";

        Pattern pat = Pattern.compile(nifRegex);
        if (numCC == null)
            return false;
        return pat.matcher(numCC.trim()).matches();
    }

    public boolean validarLocalDate(String localDate) {
        LocalDate data = LocalDate.parse(localDate.trim());

        if (LocalDate.now().isBefore(data))
            return true;
        return false;
    }



   /* public boolean validarDadoNumerico(String num) {
   // método para validar se dados inseridos são numéricos. Não estava a executar bem
        String numRegex = "^\\d+$";
        Pattern pat = Pattern.compile(numRegex);
        if (numRegex == null)
            return false;
        return pat.matcher(numRegex.trim()).matches();
    }
*/

    // método que adiciona um novo administrador à lista de utilizadores ao fazer um novo registo
    // só adiciona se não houver nenhuma instância com o mesmo email
    public Utilizador registarAdministrador(
            String email,
            String nome,
            String telefone,
            String nif,
            String morada,
            String palavraPasse

    ) {

        for (Utilizador u : this.listaUtilizadores) {
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

        this.listaUtilizadores.add(novoAdministrador);
        escreveFicheiro();

        return novoAdministrador;
    }

    public List<Motorista> getListaMotoristas() {
        return listaMotoristas;
    }

    public void setListaMotoristas(List<Motorista> listaMotoristas) {
        this.listaMotoristas = listaMotoristas;
    }



    public void cancelarReservaSemBus(String matricula) {

        for (Reserva r : this.listaReservas) {
            if (r.getBus().getMatricula().equals(matricula)) {
                addReservaCancelada(r);
                removeReserva(r);

                r.getClient().addNotificacao("A sua reserva " + r.getId() + "foi cancelada por indisponibilidade de autocarro. Se aplicável, receberá o reembolso devido pelo mesmo método de pagamento usado no momento da reserva");

            }
            escreveFicheiro();
        }
    }

    public void cancelarReservaDeClienteRemovido(String nif) {

        List<Utilizador> listaClientes = listaDeClientes();
        Utilizador clienteRemovido = null;

        for (Utilizador u : listaClientes) {
            if (u.getNif().equals(nif)) {
                clienteRemovido = u;

            }
        }
        for (Reserva r : this.listaReservas) {
            if (r.getClient().equals(clienteRemovido)) {
                addReservaCancelada(r);
                r.getClient().addNotificacao("A sua conta de cliente foi removida. As reservas confirmadas que poderiam existir foram canceladas. Se aplicável, receberá o reembolso devido pelo mesmo método de pagamento usado no momento da reserva");
                removeReserva(r);

            }
        }
        escreveFicheiro();

    }

    public boolean clientePertenceAListaNegra(Utilizador user) {

        for (Utilizador u : this.listaNegraClientes) {
            if (u.equals(user)) return true;

        }
        return false;
    }


    public boolean validarDatas(LocalDate dataPartida, LocalDate dataRegresso) {
        LocalDate dataP = dataPartida;
        LocalDate dataR = dataRegresso;

        if (dataR.isEqual(dataP) || dataR.isAfter(dataP))
            return true;
        return false;
    }
}