import java.time.LocalDate;
import escritorio.Escritorio;
import pessoas.Advogado;
import pessoas.Cliente;
import processos.Processo;
import processos.Status;

public class Main {

    public static void main(String[] args) {
        Escritorio escritorio = new Escritorio();

        // --- Cadastro de Clientes ---
        System.out.println("CADASTRO DE CLIENTES");
        try {
            escritorio.adicionarCliente(new Cliente("João Silva", "12345678901", "(11) 1234-5678", "joao@email.com", "Engenheiro"));
            escritorio.adicionarCliente(new Cliente("Ana Oliveira", "98765432100", "(21) 4321-8765", "ana@email.com", "Designer"));
            escritorio.adicionarCliente(new Cliente("Carlos Lima", "11122233344", "(31) 1111-2222", "carlos@email.com", "Professor"));

            // CPF duplicado
            escritorio.adicionarCliente(new Cliente("Clone João", "12345678901", "(19) 9999-9999", "clone@email.com", "Arquiteto"));
        } catch (Exception e) {
            System.out.println("Erro esperado no cadastro de cliente: " + e.getMessage());
        }

        // --- Cadastro de Advogados ---
        System.out.println("\nCADASTRO DE ADVOGADOS");
        try {
            escritorio.adicionarAdvogado(new Advogado("Maria Souza", "55566677788", "(11) 8888-7777", "maria@email.com", "OAB/SP-12345"));
            escritorio.adicionarAdvogado(new Advogado("Pedro Ramos", "44455566677", "(11) 9999-1111", "pedro@email.com", "OAB/RJ-54321"));

            // OAB duplicada
            escritorio.adicionarAdvogado(new Advogado("Adv OAB Repetida", "33344455566", "(21) 2222-3333", "oab@email.com", "OAB/SP-12345"));
        } catch (Exception e) {
            System.out.println("Erro esperado no cadastro de advogado: " + e.getMessage());
        }

        // --- Criação de Processos ---
        System.out.println("\nCRIAÇÃO DE PROCESSOS");
        try {
            Cliente joao = escritorio.getClientePorCpf("12345678901");
            Cliente ana = escritorio.getClientePorCpf("98765432100");
            Cliente carlos = escritorio.getClientePorCpf("11122233344");
            Advogado maria = escritorio.getAdvogadoPorCpf("55566677788");

            escritorio.adicionarProcesso(new Processo("PROC-001", joao, maria, "Ação trabalhista", LocalDate.now().plusDays(15), Status.EM_ANDAMENTO));
            escritorio.adicionarProcesso(new Processo("PROC-002", ana, maria, "Divórcio litigioso", LocalDate.now().minusDays(10), Status.EM_ANDAMENTO)); // Deve ser arquivado
            escritorio.adicionarProcesso(new Processo("PROC-003", carlos, maria, "Inventário", LocalDate.now().plusDays(45), Status.EM_ANDAMENTO));

            // Processo com número duplicado
            escritorio.adicionarProcesso(new Processo("PROC-001", carlos, maria, "Duplicado", LocalDate.now().plusDays(5), Status.EM_ANDAMENTO));
        } catch (Exception e) {
            System.out.println("Erro esperado na criação de processo: " + e.getMessage());
        }

        try {
            // Processo com advogado não cadastrado
            Advogado fake = new Advogado("Advogado Falso", "00011122233", "(00) 0000-0000", "fake@adv.com", "OAB/AM-00001");
            Cliente ana = escritorio.getClientePorCpf("98765432100");
            escritorio.adicionarProcesso(new Processo("PROC-004", ana, fake, "Processo com advogado fake", LocalDate.now().plusDays(20), Status.EM_ANDAMENTO));
        } catch (Exception e) {
            System.out.println("Erro esperado: advogado não cadastrado. " + e.getMessage());
        }

        try {
            // Processo com cliente não cadastrado
            Advogado maria = escritorio.getAdvogadoPorCpf("55566677788");
            Cliente fakeCliente = new Cliente("Fake", "00099988877", "(99) 9999-9999", "fake@email.com", "Desconhecido");
            escritorio.adicionarProcesso(new Processo("PROC-005", fakeCliente, maria, "Processo com cliente fake", LocalDate.now().plusDays(10), Status.EM_ANDAMENTO));
        } catch (Exception e) {
            System.out.println("Erro esperado: cliente não cadastrado. " + e.getMessage());
        }

        // --- Notificação de prazos vencidos ---
        System.out.println("\n NOTIFICAÇÃO DE PRAZOS VENCIDOS");
        escritorio.notificarPrazosVencidos();

        // --- Listagem de processos por status ---
        System.out.println("\nLISTAGEM DE PROCESSOS EM ANDAMENTO");
        for (Processo processo : escritorio.listarProcessosPorStatus(Status.EM_ANDAMENTO)) {
            System.out.println(processo.resumoDoProcesso());
        }

        System.out.println("\nLISTAGEM DE PROCESSOS ARQUIVADOS");
        for (Processo processo : escritorio.listarProcessosPorStatus(Status.ARQUIVADO)) {
            System.out.println(processo.resumoDoProcesso());
        }
    }
}

