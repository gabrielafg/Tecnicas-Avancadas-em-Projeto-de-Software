package modelo;

import java.util.Calendar;

/**
 * @author Gabriela Flores e Michelle Manzur
 * @version 1.1
 */

public class UbsControle {
    static String senha = "ESTRUTURAS";
    static int ANOATUAL = Calendar.YEAR;

    public UbsControle() {
        
    }
    
    public boolean verificarSenha(String senhaInformada){
        boolean senhaCorreta;
        if(!senhaInformada.equals(SENHA)){
            System.out.println("Senha inválida!");
            senhaCorreta = false;
        }else{
            senhaCorreta = true;
        }
        return senhaCorreta;
    }           
    
    public boolean validarCpf(String cpf){
        String formatoValidoCpf = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";
        boolean cpfValido;
        
        if(cpf==null){
            System.out.println("O campo CPF não pode ficar vazio.");
            cpfValido = false;
        }else
            if(cpf.matches(formatoValidoCpf)){
                cpfValido = true;
            }else{
                System.out.println("CPF inválido. Formato correto: 333.333.333-22");
                cpfValido = false;
            }
        return cpfValido;
    }
    
    public boolean validarNome(String nome){
        int espaco = 0;
        String caracteresValidos = "[ A-Z]*";
        boolean nomeValido;
        
        if(nome==null){
            System.out.println("Os campo de nome não podem ficar vazios.");
            nomeValido = false;
        }else
            if(nome.matches(caracteresValidos)){
                for(int posicao = 1; nome.length()>posicao; posicao++){
                    if(nome.charAt(posicao)==' '){
                        espaco++;
                    }
                }
                if(espaco==0){
                    System.out.println("Digite o nome completo.");
                    nomeValido = false;
                }else
                    nomeValido = true;
            }else{
                System.out.println("Nome inválido. Campo formado apenas por letras (nome e sobrenome)." + nome);
                nomeValido = false;
            }
        return nomeValido;
    }
    
    public boolean valdiarRg(long rg){
        if(rg<9999999999L && rg>1000000000){
            return true;
        }else{
            System.out.println("RG inválido.");
            return false;
        }
    }
    
    public boolean validarAno(int ano){
        if(ano<=ANOVALIDO && ano>=1900){
            return true;
        }else{
            System.out.println("Ano inválido. Valores válidos: 1900" + ANOVALIDO);
            return false;
        }
    }
    
    public boolean verificaDados(PacienteCadastro p){
        boolean dadosValidos;
        if(validarNome(p.nome) && validarNome(p.nomeDaMae) && validarRg(p.rg) && validarAno(p.anoDeNascimento)){
            dadosValidos = true;
        }else
            dadosValidos = false;
        return dadosValidos;
    }
}
