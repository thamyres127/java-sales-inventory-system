public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE VENDAS E ESTOQUE (BACKEND) ===");
        System.out.println("Status: Online e Pronto para Transações\n");

        // Simulação de um produto no banco de dados do sistema
        String produtoNome = "Smartphone Motorola Edge";
        double produtoPreco = 1800.00;
        int estoqueAtual = 3; // Quantidade disponível no estoque

        // Dados da tentativa de venda atual
        int quantidadeDesejada = 2;
        String formaPagamento = "PIX"; // Opções: PIX, BOLETO, CARTAO

        System.out.println(">> PROCESSANDO PEDIDO:");
        System.out.println("Produto: " + produtoNome);
        System.out.println("Quantidade solicitada: " + quantidadeDesejada);

        // REGRA DE NEGÓCIO 1: Validação de Estoque (Segurança da Transação)
        if (quantidadeDesejada <= estoqueAtual) {
            System.out.println("[SUCESSO]: Estoque disponível.");

            double valorTotalBruto = produtoPreco * quantidadeDesejada;
            double valorFinal;

            // REGRA DE NEGÓCIO 2: Processamento Financeiro e Descontos
            if (formaPagamento.equals("PIX")) {
                double desconto = valorTotalBruto * 0.10; // 10% de desconto no PIX
                valorFinal = valorTotalBruto - desconto;
                System.out.println("Forma de Pagamento: PIX (Desconto de 10% aplicado)");
            } else {
                valorFinal = valorTotalBruto;
                System.out.println("Forma de Pagamento: " + formaPagamento);
            }

            // Atualização fictícia do estoque após a venda
            int novoEstoque = estoqueAtual - quantidadeDesejada;

            // Exibição do Comprovante/Log do Sistema
            System.out.println("\n>> COMPROVANTE DA OPERAÇÃO:");
            System.out.println("Valor total bruto: R$ " + valorTotalBruto);
            System.out.println("Valor final a pagar: R$ " + valorFinal);
            System.out.println("Estoque atualizado da loja: " + novoEstoque + " unidades restantes.");
            System.out.println("\n[STATUS]: Venda aprovada e integrada com sucesso!");

        } else {
            // Tratamento de erro caso não haja estoque suficiente
            System.out.println("\n[ERRO TRANSAÇÃO]: Falha ao processar venda.");
            System.out.println("Motivo: Estoque insuficiente! Quantidade disponível: " + estoqueAtual);
        }
    }
}
