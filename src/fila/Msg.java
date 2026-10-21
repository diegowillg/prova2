/*
 * Projeto.: Lista Simplesmente Ligada
 * Autor...: Professor Dreco
 * Classe..: Msg 
 * Objetivo: Biblioteca para mensagens de interação com o usuário
 */
package fila;
import java.util.Scanner;

public class Msg
{
    public static String x_linha = "--------------------------------------------------------------------------------";
    public static int    t_linha = 80;

    // Objetivo: simular a limpeza da tela para despoluir a área
    //           de saída (resultados) dos projetos
    //
    public static void limpatela()
    {
        for (int i=0; i<50; i++)
        {
            msg_pl (" ");
        }
        msg_nl (x_linha);
        msg_nl (">>>>>>>>>>>>>>>>>>   Lista Simplesmente Ligada - Tipo FILA!   <<<<<<<<<<<<<<<<<<");
        msg_nl (x_linha);
    }
    
    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com salto de linha antes
    //
    public static void msg_pl (String mensagem)
    {
        System.out.println("\n"+mensagem);
    }

    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com salto de linha antes
    //
    public static void msg_nl (String mensagem)
    {
        System.out.println(mensagem);
    }

    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com layout central
    //
    public static void msg_central (String mensagem)
    {
        int t = mensagem.length();
        
        if (t < 80)
        {
            int d = (80 - t) / 2;
            int r = t % 2;

            for (int p = 1; p <= d; p++)
            {
                mensagem = " "+mensagem;
            }

            if (r == 1) 
            {
                mensagem = " "+mensagem;
            }
        }
        
        Msg.msg_nl(mensagem);
        Msg.msg_nl(x_linha);
    }

    // Objetivo: possibilitar uma ação interativa para com o usuário
    //           visando chamar a atenção para algumas mensagens
    //
    public static void enter ()
    {
        Scanner s = new Scanner(System.in);
        msg_central ("Pressione <enter> para prosseguir.");

        String tecla = s.nextLine();

        limpatela();
    }

    // Objetivo: menu padrão para as atividades de inserção/remoção nas
    //           extremidades para os deques
    //
    public static void menu_extremidade()
    {
        limpatela();
        msg_central("Menu Extremidade - Escolha a sua opcao");
        msg_nl("1. Início");
        msg_nl("2. Final");
        msg_nl("0. Retornar ao Menu Principal");
        msg_nl(x_linha);
    }

    // Objetivo: menu padrão para as atividades de consulta
    //           relacionadas às listas
    //
    public static void menu_consulta()
    {
        limpatela();
        msg_central("Menu Consulta - Escolha a sua opcao");
        msg_nl("1. Geral");
        msg_nl("2. Por posição");
        msg_nl("3. Por conteúdo INT");
        msg_nl("4. Por conteúdo STR");
        msg_nl("0. Retornar ao Menu Principal");
        msg_nl(x_linha);
    }

    // Objetivo: menu padrão para as atividades principais
    //           relacionadas às listas
    //
    public static void menu_principal()
    {
        limpatela();
        msg_central("Menu Principal - Escolha a sua opcao");
        msg_nl("           01. Inserir            06. Prova N2");
        msg_nl("           02. Remover            07. Listar todas as filas");
        msg_nl("           03. Consultar          ");
        msg_nl("           04. Inicializar        ");
        msg_nl("           05. Tamanho            ");
        msg_central(" 0. Finalizar");
    }

    // Objetivo: função para receber e tratar a opção em relação à extremidade
    //           de atividades de inserção/remoção nos deques
    //
    public static int opcao_extremidade()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_extremidade();
        msg_nl ("Digite a extremidade desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 2) && (erro != 1))
        {
            menu_extremidade();
            msg_nl ("Extremidade inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber e tratar a opção em relação às consultas
    //           
    //
    public static int opcao_consulta()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_consulta();
        msg_nl ("Digite a opção desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 4) && (erro != 1))
        {
            menu_consulta();
            msg_nl ("Opção inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber e tratar a opção em relação ao menu
    //           principal das atividades relacionadas às listas
    //
    public static int opcao_principal()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_principal();
        msg_nl ("Digite a opção desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 9) && (erro != 1))
        {
            menu_principal();
            msg_nl ("Opção inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber o valor de uma posição para
    //           as atividades relacionadas às listas que a requeiram
    //
    public static int solicita_posicao()
    {
        Scanner s = new Scanner(System.in);
        int posicao = 0;

        try
        {
            msg_nl ("Digite a posicao desejada ou zero para retornar: ");
            posicao = s.nextInt();
        }
        catch(Exception e)
        {
            posicao = 0;
        }
        return posicao;
    }

    // Objetivo: função para receber o valor de um conteúdo str para
    //           as atividades relacionadas às listas que o requeiram
    //
    public static String solicita_conteudo_str()
    {
        Scanner s = new Scanner(System.in);
        String conteudo = " ";

        try
        {
            msg_nl("Digite o conteudo a ser pesquisado ou tecle <enter> para retornar: ");
            conteudo = s.next();
        }
        catch(Exception e)
        {
            msg_nl ("Erro de digitação, retornando ao menu principal...");
            conteudo = " ";
        }
        return conteudo;
    }

    // Objetivo: função para receber o valor de um conteúdo int para
    //           as atividades relacionadas às listas que o requeiram
    //
    public static int solicita_conteudo_int()
    {
        Scanner s = new Scanner(System.in);
        int conteudo = 0;

        try
        {
            msg_nl ("Digite o conteudo inteiro desejada ou zero para retornar: ");
            conteudo = s.nextInt();
        }
        catch(Exception e)
        {
            conteudo = 0;
        }
        return conteudo;
    }
}
