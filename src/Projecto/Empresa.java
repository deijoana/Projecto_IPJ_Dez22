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
 * Classe onde estão armazenados todos os dados da aplicação bem como a maioria dos métodos que são chamados para aceder à informação necessária para a execução da aplicação
 *
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
    private final List<PreReserva> listaPreReservas;

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
        this.reservasIdGenerator = 0;
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
     * Método que obtém a informação do utilizador que está logado na aplicação.
     *
     * @return Objecto do tipo Utilizador
     */
    public Utilizador getLoggeduser() {
        return loggeduser;
    }

    /**
     * Método que define o novo Utilizador que está logado na aplicação.
     *
     * @param loggeduser Objecto utilizador que representa e guarda toda a informação do novo utilizador logado
     */
    public void setLoggeduser(Utilizador loggeduser) {
        this.loggeduser = loggeduser;
    }

    /**
     * Método que adiciona um autocarro à lista de autocarros, se não existir nenhuma instância nessa lista com igual matrícula. Guarda as alterações no ficheiro de objectos.
     *
     * @param matricula representa a matrícula do autocarro a ser adicionado
     * @param marca     representa a marca do autocarro a ser adicionado
     * @param modelo    representa o modelo do autocarro a ser adicionado
     * @param lotacao   representa a lotação do autocarro a ser adicionado
     * @return Objecto da classe Autocarro ou null se já houver correspondência para a matrícula na lista de autocarros
     */
    public Autocarro adicionarAutocarro(String matricula, String marca, String modelo, int lotacao) {

        for (Autocarro a : this.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                return null;
            }
        }

        Autocarro novoAutocarro = new Autocarro(matricula, marca, modelo, lotacao);
        this.listaAutocarros.add(novoAutocarro);
        escreveFicheiro();  // guarda as alterações no ficheiro de objectos

        return novoAutocarro;
    }

    /**
     * Método que edita os atributos do autocarro se houver correspondência para a matrícula dada como parâmetro. Guarda as alterações no ficheiro de objectos.
     *
     * @param matricula   representa a matrícula do autocarro a ser editado
     * @param novaMarca   representa a marca do autocarro a ser editado
     * @param novoModelo  representa o modelo do autocarro a ser editado
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
     * Método que remove o autocarro da lista de autocarros se houver correspondência para a matrícula dada como parâmetro. Guarda as alterações no ficheiro de objectos.
     *
     * @param matricula representa a matrícula do autocarro a ser removido
     */
    public void removerAutocarroECancelaReservas(String matricula, LocalDate data) {
        List<Autocarro> autocarros = this.listaAutocarros.stream().filter(it -> Objects.equals(matricula, it.getMatricula())).toList();

        if (autocarros.isEmpty()) {
            throw new IllegalArgumentException("Não existe autocarro na lista de autocarros desponiveis com a matricula " + matricula);
        }

        // não podemos apagar autocarros que tenham viagens a decorrer de momento,
        // isto é. em que date recebida como parametro esteja entre data de partida e data de chagara inclusive!!!

        var algumDosAutocarrosARemoverPossuiViagemADecorrer = this.listaReservas
                .stream()
                .filter(reserva -> autocarros.contains(reserva.getBus()))
                .anyMatch(reserva -> reserva.estaADecorrerEm(data));

        if (algumDosAutocarrosARemoverPossuiViagemADecorrer) {
            throw new IllegalStateException("O autocarro com a matricula %s não pode ser removide na data '%s', porque possui viagens a decorrer!");
        }

        for (Autocarro autocarro : autocarros) {
            // Cancelamento das reservas do autocarro
            listaReservas
                    .stream()
                    .filter(it -> Objects.equals(it.getBus(), autocarro))
                    .filter(it -> it.getDataPartida().isAfter(data))
                    .forEach(reserva -> this.cancelarReserva(reserva, data));

            // remover autocarro da lista de autocarros disponiveis para fazer novas reservas
            listaAutocarros.remove(autocarro);
        }

        escreveFicheiro();
    }


    /**
     * Método que adiciona um motorista à lista de motoristas, se não existir nenhuma instância nessa lista com um NIF igual. Guarda as alterações no ficheiro de objectos.
     *
     * @param email representa o email do motorista a ser adicionado
     * @param nome  representa o nome do motorista a ser adicionado
     * @param nif   representa o nif do motorista a ser adicionado
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
     * Método que edita os atributos do motorista se houver correspondência para o nif dado como parâmetro. Guarda as alterações no ficheiro de objectos.
     *
     * @param email representa o email do motorista a ser editado
     * @param nome  representa o nome do motorista a ser editado
     * @param nif   representa o nif do motorista a ser editado
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
     *
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
     * Método que obtém a lista de motoristas.
     *
     * @return A lista de motoristas.
     */
    public List<Motorista> getListaMotoristas() {
        return listaMotoristas;
    }

    /**
     * Método que adiciona um cliente à lista de utilizadores, desde que não haja correspondência na lista de utilizadores para o email usado
     *
     * @param email
     * @param nome
     * @param telefone
     * @param nif
     * @param morada
     * @param tipoDeSubscricao
     * @param modoDePagamento
     * @param palavraPasse
     * @return objeto da classe Cliente ou null se já houver correspondência com o email na lista de utilizadores
     */
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

    /**
     * Método que edita o cliente se o NIF introduzido tiver correspondência na lista de utilizadores o o Tipo de Utilizador for um Cliente.
     *
     * @param email    O novo email do cliente.
     * @param nome     O novo nome do cliente.
     * @param telefone O novo número de telefone do cliente.
     * @param nif      O NIF do cliente a ser editado.
     * @param morada   A nova morada do cliente.
     * @return {@code true} se o cliente foi editado com sucesso, {@code false} se o NIF não tiver correspondência.
     */
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


    /**
     * Método que remove o cliente da lista de clientes se houver correspondência para o nif dado como parâmetro. Guarda as alterações no ficheiro de objectos.
     *
     * @param nif O NIF do cliente a ser removido.
     * @return {@code true} se o cliente foi removido com sucesso, {@code false} caso contrário.
     */
    public boolean removerCliente(String nif) {
        List<Cliente> clientes = getTodoOsClientesPorNif(nif);

        if (clientes.isEmpty()) {
            return false;
        }

        for (Cliente cliente : clientes) {
            LocalDate now = LocalDate.now();
            List<Reserva> reservasDoCliente = getReservasDoCliente(cliente);

            for (Reserva reserva : reservasDoCliente) {
                cancelarReserva(reserva, now);
            }

            listaNegraClientes.add(cliente);
        }

        escreveFicheiro();

        return true;
    }

    /**
     * Retorna uma lista de reservas associadas ao cliente passado como parâmetro.
     *
     * @param cliente O cliente cujas reservas serão retornadas
     * @return Uma lista de reservas associadas ao cliente passado como parâmetro
     */
    private List<Reserva> getReservasDoCliente(Cliente cliente) {
        return listaReservas.stream().filter(r -> Objects.equals(cliente, r.getClient())).toList();
    }

    /**
     * Método que altera a password de um utilizador.
     *
     * @param passwordAntiga          A password atual do utilizador.
     * @param passwordNova            A nova password do utilizador.
     * @param confirmacaoPasswordNova A confirmação da nova password do utilizador.
     * @return O código de resultado da alteração da password:
     * 1 - A password atual está incorreta.
     * 2 - A nova password e a sua confirmação não são iguais.
     * 3 - A nova password é igual à password atual.
     * 4 - A confirmação da nova password está incorreta.
     * 5 - A password foi alterada com sucesso.
     */
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

        loggeduser.setPalavraPasse(passwordNova);

        escreveFicheiro();
        return 5;
    }


    /**
     * Método que obtém a lista de clientes.
     *
     * @return A lista de clientes.
     */
    public List<Utilizador> listaDeClientes() {
        return this.listaUtilizadores.stream().filter(
                        user -> user.tipoUtilizador.equals("Cliente")
                )
                .toList();
    }

    /**
     * Método que obtém o histórico de reservas de um cliente.
     *
     * @return A lista de reservas passadas do cliente.
     */
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

    /**
     * Método que obtém a lista de reservas e pré-reservas futuras de um cliente.
     *
     * @return A lista de reservas e pré-reservas futuras do cliente.
     */

    public List<String> listaReservasCliente() {
        // método que mostra todas as reservas e pré-reservas futuras de um dado cliente

        List<String> listaReserva = new ArrayList<>();

        for (Reserva r : this.listaReservas) {
            if (r.getClient().equals(this.loggeduser)) {
                if (r.getDataPartida().isAfter(LocalDate.now())) {
                    // if (r.getEstadoReserva().equals("1"))
                    listaReserva.add(r.toString());
                }
            }
        }

        for (PreReserva p : this.listaPreReservas) {
            if (p.getCliente().equals(this.loggeduser)) {
                if (p.getDataPartida().isAfter(LocalDate.now())) {
                    listaReserva.add(p.toString());
                }






       /* return empresa.listaReservas.stream().filter(
                        user -> user.getClient().equals(empresa.loggeduser)
                ).filter(user -> user.getDataPartida().isAfter(LocalDate.now()))
                .toList();
*/
            }
        }
        return listaReserva;
    }

    /**
     * Método que retorna a lista de notificações do utilizador atualmente autenticado, caso seja um cliente.
     *
     * @return A lista de notificações do utilizador atualmente autenticado, ou uma lista vazia caso o utilizador atualmente autenticado não seja um cliente
     */
    public List<String> listaNotificacoes() {
        List<String> listaNotes = new ArrayList<>();

        if (this.loggeduser instanceof Cliente) {
            Cliente c = (Cliente) this.loggeduser;
            listaNotes = c.getListaNotificacoes();
        }
        return listaNotes;
    }

    /**
     * Método que obtém a lista de autocarros reservados num dado mês e a respetiva data.
     *
     * @param ano O ano da reserva.
     * @param mes O mês da reserva.
     * @return A lista de autocarros reservados e as suas respectivas datas de partida e regresso.
     */

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

    /**
     * Método que obtém a lista de reservas canceladas num dado mês e a respetiva data.
     *
     * @param ano O ano da reserva cancelada.
     * @param mes O mês da reserva cancelada.
     * @return A lista de reservas canceladas.
     */

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

    /**
     * Método que obtém a avaliação das reservas de um dado mês.
     *
     * @param ano O ano das reservas.
     * @param mes O mês das reservas.
     * @return A avaliação das reservas do mês, incluindo o número de reservas e o volume de negócios.
     */

    public String avaliarReservaMensal(String ano, int mes) {
        int valorAno = Integer.parseInt(ano);

        int count = 0;
        double volume = 0;

        for (Reserva r : listaReservas) {
            if (r.getDataPartida().getYear() == valorAno && r.getDataPartida().getMonthValue() == mes) {
                count++;
                volume = volume + r.getCusto();
            }
        }

        return String.format("No %s mês de %s há registo de %d reservas, perfazendo um total de %.2f €", mes, ano, count, volume);
    }

    /**
     * Método que obtém o dia do ano com mais reservas.
     *
     * @param ano O ano das reservas a considerar.
     * @return O dia do ano com mais reservas.
     */
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

    /**
     * Método que obtém o total de clientes.
     *
     * @return O total de clientes.
     */
    public int totalClientes() {
        int soma = 0;

        for (Utilizador u : this.listaUtilizadores) {
            if (u instanceof Cliente) {
                soma++;
            }
        }
        return soma;
    }

    /**
     * Método que obtém o total de motoristas.
     *
     * @return O total de motoristas.
     */
    public int totalMotoristas() {
        int soma = 0;

        for (Motorista m : this.listaMotoristas) {
            if (m instanceof Motorista) {
                soma++;
            }
        }
        return soma;
    }

    /**
     * Obtém que obtém o total de autocarros.
     *
     * @return O total de autocarros.
     */
    public int totalAutocarros() {
        int soma = 0;

        for (Autocarro a : this.listaAutocarros) {
            if (a instanceof Autocarro) {
                soma++;
            }
        }
        return soma;

    }

    /**
     * Método que Encontra o(s) autocarro(s) mais requisitado(s).
     *
     * @return As estatísticas do(s) autocarro(s) mais requisitado(s), incluindo o número de requisições e os autocarros em questão.
     */
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

    /* /**
     * Método que obtém o cliente com mais reservas.
     *
     * @return O cliente com mais reservas.
     */
   /* public Utilizador clienteComMaisReservas() {

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
*/

    /**
     * Método obtém uma lista com o(s) cliente(s) com mais reservas
     *
     * @return lista com informação do(s) cliente(s) com mais reservas
     */
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

                }
                if (contador >= maximo) {
                    maximo = contador;
                    clMaxReservas.add(c);
                }
                contador = 0;
            }
        }
        return clMaxReservas;
    }


    /**
     * Método que cria uma nova pre-reserva com os parâmetros passados e adiciona à lista de pre-reservas existentes.
     *
     * @param cliente        O cliente que está a fazer a pre-reserva.
     * @param dataPartida    A data de partida da viagem associada à pre-reserva.
     * @param dataRegresso   A data de regresso da viagem associada à pre-reserva.
     * @param numPassageiros O número de passageiros da viagem associada à pre-reserva.
     * @return A pre-reserva criada.
     */
    public PreReserva fazerPreReserva(Cliente cliente,
                                      LocalDate dataPartida,
                                      LocalDate dataRegresso,
                                      int numPassageiros
    ) {
        PreReserva preReserva = new PreReserva(cliente, dataPartida, dataRegresso, numPassageiros);

        listaPreReservas.add(preReserva);

        escreveFicheiro();

        return preReserva;
    }


    /**
     * Este método permite ao cliente efetuar uma reserva de um autocarro, verificando a disponibilidade do mesmo e de um motorista. Guarda as alterações no ficheiro de objectos.
     * Caso não exista um autocarro disponível para os critérios indicados, e o cliente for premium, o método tenta cancelar
     * uma reserva de um cliente normal, para depois criar a reserva do cliente premium.
     *
     * @param client         O cliente que está a fazer a reserva
     * @param dataPartida    A data de partida da viagem
     * @param dataRegresso   A data de regresso da viagem
     * @param numPassageiros O número de passageiros da viagem
     * @param localOrigem    O local de origem da viagem
     * @param localDestino   O local de destino da viagem
     * @param distancia      A distância da viagem
     * @param pagamento      O pagamento da viagem
     * @return A reserva criada
     * @throws IllegalArgumentException Caso não exista um autocarro ou motorista disponível
     */
    public Reserva fazerReserva(Cliente client,
                                LocalDate dataPartida,
                                LocalDate dataRegresso,
                                int numPassageiros,
                                String localOrigem,
                                String localDestino,
                                double distancia,
                                Pagamento pagamento
    ) {
        try {
            Autocarro autocarro = getAutocarroLivre(dataPartida, dataRegresso, numPassageiros);
            Motorista motorista = procurarDisponibilidadeMotorista(dataPartida, dataRegresso);

            if (autocarro != null && motorista != null) {
                System.out.printf("Encontrado Motorista %s e Autocarro %s disponivel para nova reserva%n", motorista.getNifMotorista(), autocarro.getMatricula());
                return criarNovaReserva(autocarro, motorista, client, dataPartida, dataRegresso, numPassageiros, localOrigem, localDestino, distancia, pagamento);
            }

            System.out.println("Não foi encontrado autocarro disponivel para os critérios pretendidos!");

            if (client.isPremium()) {
                Reserva reservaExistente = getReservaDeClientNormalQuePossaSerCancelada(dataPartida, dataRegresso, numPassageiros);

                if (reservaExistente != null) {

                    System.out.printf("Existe uma reserva '%s' de um cliente Normal que pode ser cancelada\n",
                            reservaExistente.getId());

                    autocarro = reservaExistente.getBus();
                    motorista = reservaExistente.getDriver();

                    cancelarReserva(reservaExistente.getId(), LocalDate.now());

                    reservaExistente.getClient().addNotificacao(" A sua reserva " + reservaExistente.getId() + "foi cancelada. Se aplicável, receberá o reembolso devido pelo mesmo método com que efectuou o pagamento da reserva");

                    System.out.println("Reserva Cancelada!!!");

                    return criarNovaReserva(
                            autocarro,
                            motorista,
                            client,
                            dataPartida, dataRegresso, numPassageiros, localOrigem, localDestino, distancia, pagamento);

                }
            }

            throw new IllegalArgumentException("Não existe autocarro ou motorista disponivel, se pretender pode fazer fazer uma pré-reserva!");

        } finally {
            escreveFicheiro();
        }
    }


    /**
     * Método que obtém uma reserva de um cliente normal que possa ser cancelada.
     *
     * @param dataPartida    a data de partida da nova reserva
     * @param dataRegresso   a data de regresso da nova reserva
     * @param numPassageiros o número de passageiros da nova reserva
     * @return a reserva encontrada ou null caso não exista reserva que possa ser cancelada
     */
    private Reserva getReservaDeClientNormalQuePossaSerCancelada(LocalDate dataPartida, LocalDate dataRegresso,
                                                                 int numPassageiros) {
        LocalDate dataPartidaPlusTwoDays = dataPartida.plusDays(2);
        return this.listaReservas.stream()
                .filter(reserva -> reserva.getClient().isNormal())
                .filter(reserva -> reserva.getBus().getLotacao() >= numPassageiros)
                .filter(reserva -> reserva.isBetween(dataPartidaPlusTwoDays, dataRegresso))
                .min(Comparator.comparing(Reserva::getNumPassageiros))
                .orElse(null);
    }

    /**
     * Este método permite obter um autocarro disponível para uma determinada reserva.
     *
     * @param dataPartida    A data de partida da reserva.
     * @param dataRegresso   A data de regresso da reserva.
     * @param numPassageiros O número de passageiros da reserva.
     * @return O autocarro disponível para a reserva, se existir, ou {@code null} caso não exista.
     */
    private Autocarro getAutocarroLivre(LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros) {

        return this.listaAutocarros.stream()
                .filter(autocarro -> autocarro.getLotacao() >= numPassageiros)
                .filter(autocarro -> naoExistReservaNoPeriodoParaOAutocarro(autocarro, dataPartida, dataRegresso))
                .sorted(Comparator.comparing(Autocarro::getLotacao)).findFirst().orElse(null);
    }


    // um autocarro esta livre entre duas dasta se e so se:
    // não existe reserva para ele entre essas duas datas

    /**
     * Verifica se não existem reservas para um determinado autocarro no período especificado.
     *
     * @param auto O autocarro a verificar
     * @param d1   A data de início do período
     * @param d2   A data de fim do período
     * @return true se não existirem reservas para o autocarro no período, false caso contrário
     */
    boolean naoExistReservaNoPeriodoParaOAutocarro(Autocarro auto, LocalDate d1, LocalDate d2) {
        // se não existirem reservas para o autocarro

        long count = this.listaReservas.stream()
                .filter(r -> r.isBetween(d1, d2))
                .filter(r -> r.getBus().equals(auto)).count();
        return count == 0L;
    }


    /**
     * Método que cria uma nova reserva de autocarro.
     *
     * @param bus            O autocarro a ser reservado.
     * @param driver         O motorista responsável pelo autocarro.
     * @param client         O cliente que está a fazer a reserva.
     * @param dataPartida    A data de partida do autocarro.
     * @param dataRegresso   A data de regresso do autocarro.
     * @param numPassageiros O número de passageiros na reserva.
     * @param localOrigem    O local de origem da viagem.
     * @param localDestino   O local de destino da viagem.
     * @param distancia      A distância da viagem.
     * @return A reserva criada.
     */
    private Reserva criarNovaReserva(Autocarro bus,
                                     Motorista driver,
                                     Cliente client,
                                     LocalDate dataPartida,
                                     LocalDate dataRegresso,
                                     int numPassageiros,
                                     String localOrigem,
                                     String localDestino,
                                     double distancia,
                                     Pagamento pagamento
    ) {

        if (pagamento == null)
            throw new IllegalArgumentException("O pagamento presisa ser definido, para criar nova reserva");

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
                distancia,
                pagamento);

        listaReservas.add(novaReserva);

        return novaReserva;
    }


    /**
     * Método que gera um novo ID para uma reserva de autocarro.
     *
     * @return O novo ID gerado.
     */
    private String generateNovoIdDeReserva() {
        return "" + (++this.reservasIdGenerator);
    }


    /**
     * Método que cancela uma reserva de autocarro a partir da visão do cliente.
     *
     * @param idReserva          O ID da reserva a cancelar.
     * @param dataDeCancelamento A data de cancelamento da reserva.
     * @return O reembolso gerado pelo cancelamento da reserva.
     * @throws IllegalArgumentException Se o cliente não for quem criou a reserva.
     */
    public Reembolso cancelarReservaFromView(String idReserva, LocalDate dataDeCancelamento) {
        Reserva reserva = getReserva(idReserva);

        if (!reserva.getClient().equals(loggeduser)) {
            throw new IllegalArgumentException("O cliente pode apenas cancelar reservas criadas por si próprio");
        }
        return cancelarReserva(reserva, dataDeCancelamento);
    }

    /**
     * Método que cancela uma reserva de autocarro.
     *
     * @param idReserva          O ID da reserva a cancelar.
     * @param dataDeCancelamento A data de cancelamento da reserva.
     * @return O reembolso gerado pelo cancelamento da reserva.
     */
    private Reembolso cancelarReserva(String idReserva, LocalDate dataDeCancelamento) {
        Reserva reserva = getReserva(idReserva);
        Reembolso reembolso = cancelarReserva(reserva, dataDeCancelamento);
        return reembolso;
    }

    /**
     * Método que adiciona uma reserva cancelada à lista de reservas canceladas. Guarda as alterações no ficheiro de objectos.
     *
     * @param idReserva O ID da reserva cancelada.
     */
    public void addReservaCancelada(String idReserva) {
        Reserva r = getReserva(idReserva);
        this.listaReservasCanceladas.add(r);
        escreveFicheiro();
    }

    /**
     * Método que adiciona uma reserva cancelada à lista de reservas canceladas. Guarda as alterações no ficheiro de objectos.
     *
     * @param r A reserva cancelada.
     */
    public void addReservaCancelada(Reserva r) {
        this.listaReservasCanceladas.add(r);
        escreveFicheiro();
    }

    /**
     * Método que cancela uma reserva de autocarro. Guarda as alterações no ficheiro de objectos.
     *
     * @param reserva            A reserva a cancelar.
     * @param dataDeCancelamento A data de cancelamento da reserva.
     * @return O reembolso gerado pelo cancelamento da reserva.
     */
    private Reembolso cancelarReserva(Reserva reserva, LocalDate dataDeCancelamento) {
        Reembolso reembolso = reserva.cancelar(dataDeCancelamento);
        removeReserva(reserva);
        listaReservasCanceladas.add(reserva);

        List<PreReserva> preReservas =
                getPreReservasQuePodemPassarAReserva(reserva.getDataPartida(),
                        reserva.getDataRegresso(),
                        reserva.getLotacaoMax());
        preReservas.forEach(PreReserva::notificaCliente);

        escreveFicheiro();
        return reembolso;
    }

    /**
     * Método que retorna uma lista de pre-reservas que cumprem os seguintes critérios:
     * A data de partida da pre-reserva é posterior ou igual à data de partida passada como parâmetro.
     * A data de regresso da pre-reserva é anterior ou igual à data de regresso passada como parâmetro.
     * O número de passageiros da pre-reserva é menor ou igual à lotação máxima passada como parâmetro.
     *
     * @param dataPartida  A data de partida a ser comparada com as datas de partida das pre-reservas.
     * @param dataRegresso A data de regresso a ser comparada com as datas de regresso das pre-reservas.
     * @param lotacaoMax   A lotação máxima a ser comparada com o número de passageiros das pre-reservas.
     * @return Uma lista de pre-reservas que cumprem os critérios descritos acima.
     */

    private List<PreReserva> getPreReservasQuePodemPassarAReserva(LocalDate dataPartida, LocalDate dataRegresso,
                                                                  int lotacaoMax) {
        return listaPreReservas.stream()
                .filter(preReserva -> !preReserva.getDataPartida().isBefore(dataPartida))
                .filter(preReserva -> !preReserva.getDataRegresso().isAfter(dataRegresso))
                .filter(preReserva -> preReserva.getNumPassageiros() <= lotacaoMax)
                .toList();
    }

    /**
     * Método que obtém uma reserva pelo seu ID.
     *
     * @param idReserva O ID da reserva a obter.
     * @return A reserva com o ID especificado.
     * @throws IllegalArgumentException Se não existir nenhuma reserva com o ID especificado.
     */
    private Reserva getReserva(String idReserva) {
        Reserva reserva = findReservaPorId(idReserva);
        if (reserva == null) {
            throw new IllegalArgumentException("Não existe nenhuma reserva com o id " + idReserva);
        }
        return reserva;
    }

    /**
     * Método que remove uma reserva da lista de reservas.
     *
     * @param reserva A reserva a ser removida.
     * @return Verdadeiro se a reserva for removida com sucesso, falso caso contrário.
     */
    private boolean removeReserva(Reserva reserva) {
        return this.listaReservas.remove(reserva);
    }

    /**
     * Método que procura uma reserva pelo seu ID.
     *
     * @param idReserva O ID da reserva a procurar.
     * @return A reserva com o ID especificado, ou null se não for encontrada.
     */
    private Reserva findReservaPorId(String idReserva) {
        for (Reserva item : this.listaReservas) {
            if (Objects.equals(idReserva, item.getId())) {
                return item;
            }
        }
        return null;
    }


    /**
     * Método que calcula o custo de uma viagem de autocarro.
     *
     * @param numPassageiros O número de passageiros na viagem.
     * @param distancia      A distância da viagem.
     * @return O custo da viagem.
     */
    public double calcularCustoViagem(int numPassageiros, double distancia) {
        double custo;
        custo = distancia * 0.55 + 1.2 * numPassageiros;
        return custo;
    }


    /**
     * Método que procura um autocarro disponível para uma viagem.
     * Itera pela lista de autocarros e verifica primeiramente se tem lotação suficiente para a viagem especificada.
     * Se não tiver salta para o autocarro seguinte da lista.
     * De seguida itera pela lista de reservas e verifica se uma reserva coincide com a data de partida e data de regresso de uma viagem.
     * Se coincidir a reserva não é elegível e salta para o autocarro seguinte da lista.
     * Se as datas não coincidirem o autocarro é elegível e é adicionado a uma lista de autocarros disponíveis.
     * De seguida percorre a lista de autocarros disponíveis e seleciona aquele que tem a lotação mais ajustada ao número de passageiros da viagem.
     *
     * @param dataPartida    A data de partida da viagem.
     * @param dataRegresso   A data de regresso da viagem.
     * @param numPassageiros O número de passageiros na viagem.
     * @return O autocarro disponível e com a lotação mais ajustada à viagem, ou null se nenhum for encontrado.
     */

    public Autocarro procurarDisponibilidadeAutocarro(LocalDate dataPartida, LocalDate dataRegresso,
                                                      int numPassageiros) {
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


    /**
     * Método que procura um motorista disponível para a viagem especificada.
     * Itera pela lista de motoristas e de seguida itera pela lista de reservas e verifica se o motorista que está a ser verificado
     * não está associado a uma reserva em datas coincidentes com as pretendidas.
     * Se coincidir salta para o próximo motorista da lista de motoristas.
     * Se não coincidir, esse motorista está disponível para ser alocado a essa viagem.
     *
     * @param dataPartida  A data de partida da viagem.
     * @param dataRegresso A data de regresso da viagem.
     * @return O motorista disponível para a viagem, ou null se não houver nenhum.
     */
    public Motorista procurarDisponibilidadeMotorista(LocalDate dataPartida, LocalDate dataRegresso) {
        // salta para o proximo se verdadeiro
        Motorista escolhido = null;

        for (Motorista m : this.listaMotoristas) {
            boolean saltaMotorista = false;

            for (Reserva r : this.listaReservas) {
                if ((r.getDataPartida().isBefore(dataPartida) && r.getDataRegresso().isAfter(dataPartida)) && r.getDriver().equals(m) ||
                        (dataPartida.isBefore(r.getDataPartida()) && dataRegresso.isAfter(r.getDataRegresso())) && r.getDriver().equals(m) ||
                        (dataRegresso.isAfter(r.getDataPartida()) && dataRegresso.isBefore(r.getDataRegresso())) && r.getDriver().equals(m) ||
                        (r.getDataPartida().isEqual(dataPartida) && r.getDriver().equals(m) || r.getDataRegresso().isEqual(dataRegresso)) && r.getDriver().equals(m) ||
                        (r.getDataPartida().isEqual(dataRegresso) && r.getDriver().equals(m) || r.getDataRegresso().isEqual(dataPartida)) && r.getDriver().equals(m)) {
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


    /**
     * Método que realiza o login de um utilizador.
     *
     * @param emailUtilizador O email do utilizador a fazer login.
     * @param palavraPasse    A palavra-passe do utilizador a fazer login.
     * @return O utilizador que fez login, ou null se o login falhar.
     */
    public Utilizador fazerLogin(String emailUtilizador, String palavraPasse) {
        for (Utilizador u : this.listaUtilizadores) {
            if (u.getEmail().equals(emailUtilizador) && u.getPalavraPasse().equals(palavraPasse)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Método que escreve um objeto num ficheiro.
     *
     * @param nome    O nome do ficheiro onde o objeto será escrito.
     * @param objecto O objeto a ser escrito no ficheiro.
     */
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

    /**
     * Método que escreve a informação deste objeto num ficheiro.
     */
    void escreveFicheiro() { // writeMySelfInFIle
        escreveFicheiro(AUTOCARROS_AOR, this);
    }


    /**
     * Método que lê o ficheiro de objetos. Não havendo nunhuma informação no ficheiro, cria o ficheiro e adiciona o administrador "sénior" definido por default.
     *
     * @param nomeDoFicheiro
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
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

    /**
     * Método que define o nome do ficheiro onde onde as informações devem ser guardados.
     *
     * @param nomeDoFicheiro O novo nome do ficheiro.
     */
    private void setAUTOCARROS_AOR(String nomeDoFicheiro) {
        this.AUTOCARROS_AOR = nomeDoFicheiro;
    }

    /**
     * Método que verifica se email inserido é válido.
     *
     * @param email O email a validar.
     * @return true se o email é válido, false caso contrário.
     */
    /**
     * Método que verifica se email inserido é válido.
     *
     * @param email O email a validar.
     * @return true se o email é válido, false caso contrário.
     */
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

    /**
     * Método que verifica se um dado input fornecido é válido ou não.
     *
     * @param input
     * @return true se o input for válido, false caso contrário.
     */
    public boolean validarDados(String input) {
        // método que valida se caixa de texto de dado está preenchida ou não
        String vazio = "";
        if (input.trim().equals(vazio)) {
            return false;
        }
        return true;
    }

    /**
     * Método que Valida o índice selecionado nas ComboBoxes de subscrição e pagamento.
     *
     * @param subscricao índice selecionado na ComboBox de subscrição
     * @param pagamento  índice selecionado na ComboBox de pagamento
     * @return 1 se ambos os índices são válidos (diferentes de 0), 0 caso contrário
     */
    public int validarComboBoxIndex(int subscricao, int pagamento) {

        if (subscricao == 0 || pagamento == 0) {
            return 0;
        }
        return 1;
    }


    /**
     * Este método verifica se um dado input, especificado pelo parâmetro pagamento, é válido ou não.
     *
     * @param pagamento O input a ser verificado
     * @return 0 se o input for inválido (ou seja, se o valor do input for 0), caso contrário, retorna 1.
     */
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

    /**
     * Método que verifica se um número de telefone fornecido é válido ou não.
     *
     * @param telefone O número de telefone a ser verificado.
     * @return {@code true} se o número de telefone for válido, {@code false} caso contrário.
     */
    public boolean validarTelefone(String telefone) {
        String telefoneRegex = "^(\\+351|00351)?(9|3|2)(\\d{8})";

        Pattern pat = Pattern.compile(telefoneRegex);
        if (telefone == null) {
            return false;
        }

        return pat.matcher(telefone.trim()).matches();
    }

    /**
     * Método que verifica se o NIF fornecido é válido ou não.
     *
     * @param nif o NIF a ser validado
     * @return true se o NIF é válido, false caso contrário
     */
    public boolean validarNIF(String nif) {
        String nifRegex = "[\\d][0-9]{8}";

        Pattern pat = Pattern.compile(nifRegex);
        if (nif == null)
            return false;
        return pat.matcher(nif.trim()).matches();
    }

    /**
     * Método que valida se a matricula fornecida segue o formato válido.
     *
     * @param matricula a matricula a ser validada
     * @return true se a matricula for válida, false caso contrário
     */
    public boolean validarMatricula(String matricula) {
        String matriculaRegex = "^[a-zA-Z-0-9][a-zA-Z-0-9][-][a-zA-Z-0-9][a-zA-Z-0-9][-][a-zA-Z-0-9][a-zA-Z-0-9]$";

        Pattern pat = Pattern.compile(matriculaRegex);
        if (matricula == null)
            return false;
        return pat.matcher(matricula.trim()).matches();
    }

    /**
     * Método que valida um valor de ano no século XXI.
     *
     * @param ano O valor de ano a ser validado.
     * @return true se o valor de ano é válido, false caso contrário.
     */
    public boolean validarAno(String ano) {
        // método que valida apenas valores de anos no século XXI

        String anoRegex = "^[2][0][0-9][0-9]$";

        Pattern pat = Pattern.compile(anoRegex);
        if (anoRegex == null) {
            return false;
        }
        return pat.matcher(ano.trim()).matches();
    }


    /**
     * Método que valida um valor de CVC (código de verificação de cartão).
     *
     * @param cvc O valor de CVC a ser validado.
     * @return true se o valor de CVC é válido, false caso contrário.
     */
    public boolean validarCVC(String cvc) {

        String cvcRegex = "^[0-9][0-9][0-9]$";

        Pattern pat = Pattern.compile((cvcRegex));
        if (cvcRegex == null) {
            return false;
        }
        return pat.matcher(cvc.trim()).matches();
    }

    /**
     * Método que valida um valor de número de cartão de crédito.
     *
     * @param numCC O valor de número de cartão de crédito a ser validado.
     * @return true se o valor de número de cartão de crédito é válido, false caso contrário.
     */
    public boolean validarnumCC(String numCC) {
        String nifRegex = "[\\d][0-9]{15}";

        Pattern pat = Pattern.compile(nifRegex);
        if (numCC == null)
            return false;
        return pat.matcher(numCC.trim()).matches();
    }

    /**
     * Método que valida uma data no formato LocalDate.
     *
     * @param localDate A data a ser validada.
     * @return true se a data é válida e posterior à data atual, false caso contrário.
     */
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

    /**
     * Método que que regista um novo administrador.
     *
     * @param email        O email do administrador.
     * @param nome         O nome do administrador.
     * @param telefone     O telefone do administrador.
     * @param nif          O NIF do administrador.
     * @param morada       A morada do administrador.
     * @param palavraPasse A palavra-passe do administrador.
     * @return O novo administrador se o registo for bem-sucedido, null caso contrário.
     */
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

    /**
     * Método que permite cancelar uma reserva por indisponibilidade de autocarro. Guarda as alterações no ficheiro de objectos.
     *
     * @param matricula A matrícula do autocarro relacionado com a reserva.
     * @return void
     */
    public void cancelarReservaSemBus(String matricula) {

        for (Reserva r : this.listaReservas) {
            if (r.getBus().getMatricula().equals(matricula)) {
                addReservaCancelada(r);
                removeReserva(r);

                r.getClient().addNotificacao("A sua reserva " + r.getId() + " foi cancelada por indisponibilidade de autocarro. " +
                        "Se aplicável, receberá o reembolso devido pelo mesmo método de pagamento usado no momento da reserva");

            }
            escreveFicheiro();
        }
    }


    /**
     * Método que verifica se um cliente pertence à lista negra.
     *
     * @param user O utilizador a verificar.
     * @return true se o utilizador pertence à lista negra, false caso contrário.
     */
    public boolean clientePertenceAListaNegra(Utilizador user) {

        for (Utilizador u : this.listaNegraClientes) {
            if (u.equals(user)) return true;

        }
        return false;
    }


    /**
     * Método que valida se as datas de partida e de regresso são válidas.
     *
     * @param dataPartida  A data de partida.
     * @param dataRegresso A data de regresso.
     * @return true se as datas são válidas, false caso contrário.
     */
    public boolean validarDatas(LocalDate dataPartida, LocalDate dataRegresso) {
        LocalDate dataP = dataPartida;
        LocalDate dataR = dataRegresso;

        if (dataR.isEqual(dataP) || dataR.isAfter(dataP))
            return true;
        return false;
    }

    /**
     * Método que marca as notificações de um cliente como lidas, através do seu NIF.
     *
     * @param nif O NIF do cliente cujas notificações serão marcadas como lidas.
     */
    public void marcarNotificacoesDeClientComoLidas(String nif) {
        List<Cliente> clientes = getTodoOsClientesPorNif(nif);

        if (!clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                cliente.marcarNotificacoesComoLidas();
            }
            escreveFicheiro();
        }
    }

    /**
     * Método que retorna uma lista de clientes que possuem o NIF passado como parâmetro.
     *
     * @param nif O NIF a ser utilizado para pesquisa de clientes
     * @return Uma lista de clientes que possuem o NIF passado como parâmetro
     */
    public List<Cliente> getTodoOsClientesPorNif(String nif) {
        List<Cliente> list = new ArrayList<>();
        for (Utilizador it : getTodosUtilizadoresPorNif(nif)) {
            if (it instanceof Cliente c) {
                list.add(c);
            }
        }
        return list;

    }

    /**
     * Método que retorna uma lista de utilizadores que possuem o NIF passado como parâmetro.
     *
     * @param nif O NIF a ser utilizado para pesquisa de utilizadores
     * @return Uma lista de utilizadores que possuem o NIF passado como parâmetro
     */
    private List<Utilizador> getTodosUtilizadoresPorNif(String nif) {
        List<Utilizador> list = new ArrayList<>();
        for (Utilizador it : listaUtilizadores) {
            if (Objects.equals(nif, it.getNif())) {
                list.add(it);
            }
        }
        return list;
    }

    /**
     * Método que obtém a lista de pré-reservas da empresa
     *
     * @return lista com as pré-reservas da empresa
     */
    public List<PreReserva> getListaPreReservas() {
        return listaPreReservas;
    }

    /**
     * Método que filtra as reservas canceladas do cliente com sessão iniciada da lista de reservas canceladas da empresa
     *
     * @return lista de reservas canceladas
     */
    public List<Reserva> listagemHistoricoReservasCanceladas() {
        return listaReservasCanceladas.stream()
                .filter(it -> Objects.equals(it.getClient(), this.loggeduser))
                .toList();
    }
}