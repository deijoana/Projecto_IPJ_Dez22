package Projecto;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.*;
import java.util.regex.Pattern;

public class Empresa implements Serializable {

    // atributo que especifica a versão do documento/ficheiro de objectos para prevenir que ocorra InvalidClassException
    private static final long serialVersionUID = 1L;
    private String AUTOCARROS_AOR = "autocarros_aor";
    private List<Utilizador> listaUtilizadores;
    private List<Autocarro> listaAutocarros;
    private List<Motorista> listaMotoristas;

    private List<Cliente> listaClientes;
    private List listaNegraClientes;

    private List<Reserva> listaReservas;
    /**
     * na altura de criar reserva, será usado para gerar o id da nova reserva, incrementando o valor...
     */
    private int reservasIdGenerator = 0;

    private List listaPreReservas;

    // user logado
    private Utilizador loggeduser;

    public List<Autocarro> getListaAutocarros() {
        return listaAutocarros;
    }

    public Utilizador getLoggeduser() {
        return loggeduser;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setLoggeduser(Utilizador loggeduser) {
        this.loggeduser = loggeduser;
    }

    /**
     Nome atribuído ao ficheiro de objectos responsável por guardar toda a informação da instância empresa da Classe empresa
     *Definiu-se como static porque este dado não deverá nunca ser alterado
     *private String AUTOCARROS_AOR = "autocarros_aor";
     */



    /**
    // Instância de Administrador "sénior" para poder entrar na aplicação ao iniciar a execução do programa.
    //Definiu-se como static porque esta instância é de importância máxima e não deverá ser alterada em qualquer circunstância
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
    /**
     * Método que adiciona um autocarro à lista de autocarros, se não existir nenhuma instância nessa lista como igual matrícula.
     * O método recebe como parâmetros a matrícula
    */

     public Autocarro adicionarAutocarro(String matricula, String marca, String modelo, int lotacao, Empresa empresa) {

        for (Autocarro a : empresa.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                return null;
            }
        }
        // código que substitui numa linha um ciclo for:each
        //if (empresa.listaAutocarros.stream().anyMatch(autocarro -> autocarro.getMatricula().equals(matricula))) {
        //  return null;
        //}

        Autocarro novoAutocarro = new Autocarro(matricula, marca, modelo, lotacao);
        empresa.listaAutocarros.add(novoAutocarro);
        escreveFicheiro();  // guarda as alterações no ficheiro de objectos

        return novoAutocarro;
    }

    // método que permite ao Administrador editar os atributos de um autocarro
    // Este método permite editar as informações de um autocarro da lista de autocarros e grava essa lista no ficheiro de objetos.


    /**
     * Método que permite ao Administrador editar os atributos de um autocarro.
     * O método corre a lista de autocarros da empresa e se a matrícula inserida pelo utilizador tiver correspondência é-lhe permitido
     * editar os atributos desse autocarro. De seguida grava a informação no ficheiro de objetos.
     * @param matricula
     * @param novaMarca
     * @param novoModelo
     * @param novaLotacao
     * @param empresa
     * @return se o resultado for true retorna o autocarro com as devidas alteraçõe se for false
     */
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

                escreveFicheiro();
                return true;
            }
        }
        return false;
    }

    /**
     * Este método permite remover um autocarro.
     * Percorre a lista de autocarros e verifica se a matrícula dada faz match com algum dos autocarros da lista.
     * Se se verificar esse match o autocarro é removido da lista e a atualização é gravada no ficheiro de objetos.
     * @param matricula
     * @param empresa
     * @return se devolver true o autocarro é removido.
     */
    //Este método permite remover um autocarro.
    //Percorre a lista de autocarros e verifica se a matrícula dada faz match com algum dos autocarros da lista.
    //Se se verificar esse match o autocarro é removido da lista e a atualização é gravada no ficheiro de objetos.
    public boolean removerAutocarro(String matricula, Empresa empresa) {

        for (Autocarro a : empresa.listaAutocarros) {
            if (a.getMatricula().equals(matricula)) {
                empresa.listaAutocarros.remove(a);
                escreveFicheiro();
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
        escreveFicheiro();
        return novoMotorista;
    }

    public boolean editarMotorista(String email, String nome, String nif, Empresa empresa) {
        // Será usado o nif como identificador do motorista, dado que este nunca altera ao longo da vida

        for (Motorista m : empresa.listaMotoristas) {
            if (m.getNifMotorista().equals(nif)) {
                m.setEmailMotorista(email);
                m.setNomeMotorista(nome);
                escreveFicheiro();

                return true;

            }

        }

        return false;
    }

    public boolean removerMotorista(String nif, Empresa empresa) {
        // Será usado o nif como identificador do motorista, dado que este nunca altera ao longo da vida

        for (Motorista m : empresa.listaMotoristas) {

            if (m.getNifMotorista().equals(nif)) {
                empresa.listaMotoristas.remove(m);
                escreveFicheiro();
                return true;
            }
        }

        return false;
    }

    public boolean editarCliente(String email, String nome, String telefone, String nif, String morada, Empresa empresa) {
        // Será usado o nif como identificador do cliente, dado que este nunca altera ao longo da vida

        for (Utilizador client : empresa.listaUtilizadores) {
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
        escreveFicheiro();

        return novoCliente;
    }

    //método para remover cliente usando o NIF -> percorremos a lista de utlizadores e verificamos se o NIF é igual
    //e se o tipo de Utilizador é cliente.
    public boolean removerCliente(String nif, Empresa empresa) {
        // Será usado o nif como identificador do cliente a remover, dado que este nunca altera ao longo da vida
        for (Utilizador client : empresa.listaUtilizadores) {
            if (client.getNif().equals(nif) && client.tipoUtilizador.equals("Cliente")) {
                empresa.listaUtilizadores.remove(client);
                empresa.listaNegraClientes.add(client); // adiciona o cliente a lista alternativa, porque este cliente mantém a possibilidade de fazer login
                escreveFicheiro();
                return true;
            }

        }
        return false;
    }

    public int alterarPassword(String passwordAntiga, String passwordNova, String confirmacaoPasswordNova, Empresa empresa) {


        if (!empresa.getLoggeduser().getPalavraPasse().equals(passwordAntiga)) {
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
    public List<Utilizador> listaDeClientes(Empresa empresa) {
        return empresa.listaUtilizadores.stream().filter(
                        user -> user.tipoUtilizador.equals("Cliente")
                )
                .toList();
    }

    public List<Reserva> listagemHistoricoReservas(Empresa empresa) {
        // método que mostra todas as reservas passadas de um dado cliente

        return empresa.listaReservas.stream().filter(
                        user -> user.getClient().equals(loggeduser)

                ).filter(user -> user.getDataPartida().isBefore(LocalDate.now()))
                .toList();

    }

    public List<Reserva> listaReservasCliente(Empresa empresa) {
        // método que mostra todas as reservas futuras de um dado cliente

        List<Reserva> listaReserva = new ArrayList<>();

        for (Reserva r : empresa.listaReservas) {
            if (r.getClient().equals(empresa.loggeduser)) {
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


    public List<String> listarAutocarrosReservados(String ano, String mes, Empresa empresa) {
        // método que lista todos os autocarros reservados num dado mês e a respectiva data

        int valorAno = Integer.parseInt(ano);
        int valorMes = Integer.parseInt(mes);
        List<String> listaAutocarrosReservados = new ArrayList<>();

        for (Reserva r : listaReservas) {
            if (r.getDataPartida().getYear() == valorAno && r.getDataPartida().getMonthValue() == valorMes) {
                listaAutocarrosReservados.add(r.getBus().toString() + " de " + r.getDataPartida() + " a " + r.getDataRegresso());

            }
        }
    /*    for (int i = 0; i < listaAutocarrosReservados.size(); i++) {
            System.out.println(listaAutocarrosReservados.get(i));
        }*/
        return listaAutocarrosReservados;
    }

    public String avaliarReservaMensal(String ano, int mes, Empresa empresa) {
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
        escreveFicheiro(AUTOCARROS_AOR, empresa);
        return listaReservaMensal = "No " + mes + "º mês de " + ano + " há registo de " + count + " reservas, perfazendo um total de " + volume + "€";
    }

    public LocalDate diaAnoMaisReservas(String ano, Empresa empresa) {

        int valorAno = Integer.parseInt(ano);
        LocalDate dia = LocalDate.of(valorAno, 01, 01);
        LocalDate diaMaisReservas = null;

        int count = 0;
        int countmax = 0;

        if (dia.isLeapYear()) {
            for (int i = 1; i < 367; i++) {
                count = 0;
                for (Reserva r : listaReservas) {
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
                for (Reserva r : listaReservas) {
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
        escreveFicheiro(AUTOCARROS_AOR, empresa);
        return diaMaisReservas;
    }

    // método para as estatísticas que contabiliza o total de clientes
    public int totalClientes(Empresa empresa) {
        int soma = 0;

        for (Utilizador u : empresa.listaUtilizadores) {
            if (u instanceof Cliente) {
                soma++;
            }
        }
        return soma;
    }

    // método para as estatísticas que contabiliza motoristas
    public int totalMotoristas(Empresa empresa) {
        int soma = 0;

        for (Motorista m : empresa.listaMotoristas) {
            if (m instanceof Motorista) {
                soma++;
            }
        }
        return soma;
    }

    // método para as estatísticas que contabiliza autocarros
    public int totalAutocarros(Empresa empresa) {
        int soma = 0;

        for (Autocarro a : empresa.listaAutocarros) {
            if (a instanceof Autocarro) {
                soma++;
            }
        }
        return soma;

    }

    //método que devolve o autocarro mais requisitado
    public AutocarrosMaisUtilizadosStats encontrarAutocarroMaisReq(Empresa empresa) {

        Autocarro autocarroMaisReq = null;

        int contador = 0;
        int maximo = 0;

        List<Autocarro> buss = new ArrayList<>();
        for (Autocarro a : empresa.listaAutocarros) {

            for (Reserva r : empresa.listaReservas) {
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

        for (Autocarro a : empresa.listaAutocarros) {
            int numeroDeOcorrencias = 0;
            for (Reserva r : empresa.listaReservas) {
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
    public Utilizador clienteComMaisReservas(Empresa empresa) {

        Utilizador clMaxReservas = null;

        int contador = 0;
        int maximo = 0;

        for (Utilizador c : empresa.listaUtilizadores) {
            if (c instanceof Cliente) {

                for (Reserva r : empresa.listaReservas) {
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

    /*
    Normal: Têm uma penalização de 50% sempre que cancelarem uma reserva até 7 dias consecutivos antes da partida.
     Após este prazo não existe reembolso. Esta subscrição não representa nenhum custo mensal acrescido.
2. Premium: Podem cancelar as reservas sem qualquer custo até 2 dias consecutivos antes da data da reserva.
Após este prazo não existe reembolso.
Os utilizadores premium têm prioridade na reserva, ou seja, sempre que um utilizador premium procurar uma reserva,
 apenas os autocarros de outros utilizadores premium devem ser considerados como reservados.
  Havendo reservas de utilizadores normais para as datas pretendidas, e mais nenhum autocarro disponível,
  deve ser cancelada a reserva mais recente do utilizador normal cujo autocarro satisfaz as necessidades do cliente premium,
   desde que este cancelamento seja no mínimo com 2 dias de antecedência.
    Quando uma reserva é cancelada, o cliente afetado deve receber uma notificação (mensagem no ecrã).
    Esta subscrição tem um custo mensal de 10€.
     */

    public Reserva fazerReserva(Cliente client,
                                LocalDate dataPartida,
                                LocalDate dataRegresso,
                                int numPassageiros,
                                String localOrigem,
                                String localDestino,
                                double distancia) {

        Autocarro autocarro = getAutocarroLivre(dataPartida, dataRegresso, numPassageiros);
        Motorista motorista = procurarDisponibilidadeMotorista(dataPartida, dataRegresso, this);

        Reserva reservaCriada = null;
        if (autocarro != null && motorista != null) {
            System.out.printf("Encontrado Motorista %s e Autocarro %s disponivel para nova reserva%n", motorista.getNifMotorista(), autocarro.getMatricula());
            reservaCriada = criarNovaReserva(autocarro, motorista, client, dataPartida, dataRegresso, numPassageiros, localOrigem, localDestino, distancia);

        } else if (motorista != null && client.isPremium()) {
            System.out.println("Não foi encontrado autocarro disponivel para os criterios pretendidos!");


            Reserva reservaExistente = getReservaDeClientNormalQuePossaSerCancelada(dataPartida, dataRegresso, numPassageiros);
            System.out.println("Existe uma reserva '%s' de um cliente Normal que pode ser cancelada".formatted(reservaExistente.getId()));

            Reembolso reembolso = cancelarReserva(reservaExistente.getId(), LocalDate.now());

            // TODO: enviar a mensagem para o client da reserva cancelada
            // reservaExistente.getClient().addNewNotifcation(new Notificacao(...));

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
    public Autocarro procurarDisponibilidadeAutocarro(LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros, Empresa empresa) {
        Autocarro escolhido = null;
        List<Autocarro> listaAutocarrosDisponiveis = new ArrayList<>();


        for (Autocarro a : empresa.listaAutocarros) {
            boolean saltaAutocarro = true; // salta para o proximo se verdadeiro
            // autocarro elegivel, pois tem lotação suficiente
            if (a.getLotacao() >= numPassageiros) {
                saltaAutocarro = false;
                for (Reserva r : empresa.listaReservas) {
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
    public Motorista procurarDisponibilidadeMotorista(LocalDate dataPartida, LocalDate dataRegresso, Empresa empresa) {
        // salta para o proximo se verdadeiro
        Motorista escolhido = null;

        for (Motorista m : empresa.listaMotoristas) {
            boolean saltaMotorista = false;

            for (Reserva r : empresa.listaReservas) {
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
    /*public boolean validarEmail(String email, Empresa empresa) {
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') count++;
        }
        if (count == 1) {
            return true;
        } else return false;
    }*/

    public boolean validarEmail(String email, Empresa empresa) {
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


    public boolean validarDados(String input, Empresa empresa) {
        // método que valida se caixa de texto de dado está preenchida ou não
        String vazio = "";
        if (input.trim().equals(vazio)) {
            return false;
        }
        return true;
    }

    public int validarComboBoxIndex(int subscricao, int pagamento, Empresa empresa) {

        if (subscricao == 0 || pagamento == 0) {
            return 0;
        }
        return 1;

    }

    public int validarComboBoxIndex(int pagamento, Empresa empresa) {

        if (pagamento == 0) {
            return 0;
        }
        return 1; // alguma comboBox foi selecionada

    }

    /*  public boolean validarPassword(String password, Empresa empresa){
          String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
          Pattern pat = Pattern.compile(passwordRegex);
          if (password == null) {
              return false;
          }
          return pat.matcher(password).matches();
      }
  */
    public boolean validarTelefone(String telefone, Empresa empresa) {
        String telefoneRegex = "^(\\+351|00351)?(9|3|2)(\\d{8})";

        Pattern pat = Pattern.compile(telefoneRegex);
        if (telefone == null) {
            return false;
        }

        return pat.matcher(telefone.trim()).matches();
    }

    public boolean validarNIF(String nif, Empresa empresa) {
        String nifRegex = "[\\d][0-9]{8}";

        Pattern pat = Pattern.compile(nifRegex);
        if (nif == null)
            return false;
        return pat.matcher(nif.trim()).matches();
    }

    public boolean validarMatricula(String matricula, Empresa empresa) {
        String matriculaRegex = "^[a-zA-Z-0-9][a-zA-Z-0-9][-][a-zA-Z-0-9][a-zA-Z-0-9][-][a-zA-Z-0-9][a-zA-Z-0-9]$";

        Pattern pat = Pattern.compile(matriculaRegex);
        if (matricula == null)
            return false;
        return pat.matcher(matricula.trim()).matches();
    }

    public boolean validarAno(String ano, Empresa empresa) {
        // método que valida apenas valores de anos no século XXI

        String anoRegex = "^[2][0][0-9][0-9]$";

        Pattern pat = Pattern.compile(anoRegex);
        if (anoRegex == null) {
            return false;
        }
        return pat.matcher(ano.trim()).matches();
    }

    public boolean validarCVC(String cvc, Empresa empresa) {

        String cvcRegex = "^[0-9][0-9][0-9]$";

        Pattern pat = Pattern.compile((cvcRegex));
        if (cvcRegex == null) {
            return false;
        }
        return pat.matcher(cvc.trim()).matches();
    }

    public boolean validarnumCC(String numCC, Empresa empresa) {
        String nifRegex = "[\\d][0-9]{15}";

        Pattern pat = Pattern.compile(nifRegex);
        if (numCC == null)
            return false;
        return pat.matcher(numCC.trim()).matches();
    }

    public boolean validarLocalDate(String localDate, Empresa empresa) {
        LocalDate data = LocalDate.parse(localDate.trim());

        if (LocalDate.now().isBefore(data))
            return true;
        return false;
    }



   /* public boolean validarDadoNumerico(String num, Empresa empresa) {
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
        escreveFicheiro();

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