package gui;

public class ValidadorUtils {

    public static boolean validarCPF(String cpf) {
        // Exemplo simples de validação: verifica se o CPF tem 11 dígitos
        if (cpf == null || cpf.length() != 14) { // Considera o formato ###.###.###-##
            return false;
        }
        // Adicione aqui a lógica mais detalhada para validar o CPF se necessário
        return true;
    }

    // Método para validar telefone
    public static boolean validarTelefone(String telefone) {
        // Exemplo simples de validação: verifica se o telefone está no formato (XX) XXXX-XXXX
        if (telefone == null || !telefone.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}")) {
            return false;
        }
        // Adicione aqui a lógica mais detalhada para validar o telefone se necessário
        return true;
    }
}
