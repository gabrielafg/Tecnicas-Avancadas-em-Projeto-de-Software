package modelo;

/**
 *
 * @author Gabriela Flores e Michelle Manzur
 */

public class Ubs {
    String senha = "ESTRUTURAS";

    public Ubs() {
        
    }
    
    public boolean verificarSenha(String senhaInf){
        boolean correta = false;
        if(!senhaInf.equals(this.senha)){
            System.out.println("Senha inválida!");
        }else{
            correta = true;
        }
        return correta;
    }           
    
    public boolean cpfValido(String cpf){
        if(cpf==null){
            System.out.println("O campo CPF não pode ficar vazio.");
            return false;
        }else
            if(cpf.matches("\\d{3}.\\d{3}.\\d{3}.\\d{2}")){
                return true;
            }else{
                System.out.println("CPF inválido. Formato correto: 333.333.333-22");
                return false;
            }
    }
    
    public boolean nomeValido(String nome){
        int espaco = 0;
        int erro = 0;
        if(nome==null){
            System.out.println("Os campo de nome não podem ficar vazios.");
            return false;
        }else
            if(nome.matches("[ A-Z]*")){
                for(int i = 1; nome.length()>i; i++){
                    if(nome.charAt(i)==' '){
                        espaco++;
                    }
                }
                if(espaco==0){
                    System.out.println("Digite o nome completo.");
                    return false;
                }else
                    if(erro!=0){
                        System.out.println("Digite apenas letras nos campos de nome.");
                        return false;
                    }else{
                        return true;
                    }
            }else{
                System.out.println("Nome inválido. Campo formado apenas por letras (nome e sobrenome)." + nome);
                return false;
            }
    }
    
    public boolean rgValido(long rg){
        if(rg<9999999999L && rg>1000000000){
            return true;
        }else{
            System.out.println("RG inválido.");
            return false;
        }
    }
    
    public boolean anoValido(int ano){
        if(ano<=2016 && ano>=1900){
            return true;
        }else{
            System.out.println("Ano inválido. Valores válidos: 1900-2016");
            return false;
        }
    }
    
    public boolean verificaDados(PacienteCadastro p){
        if(nomeValido(p.nome) && nomeValido(p.nomeDaMae) && rgValido(p.rg) && anoValido(p.anoDeNascimento)){
            return true;
        }else
            return false;
    }
}
