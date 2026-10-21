/*
 * Projeto.: Lista Simplesmente Ligada
 * Autor...: Professor Dreco
 * Classe..: Sfila / 2018-S2
 * Objetivo: Projeto fila Simplesmente Ligada
 */
package fila;

import static fila.Msg.msg_nl;

public class Main
{

    // Objetivo: método especial para a avaliação do momento 2
    //
    // Início da prova 2
    
    public static void prova_n2 (Lse fila_Geral, Lse fila_Masculino, Lse fila_Feminino )
    {
        Noh noh = null;
        Noh aux = null;
        int id = 1;
        int total = 0;
        int i = 0;
        Noh[] todos = null;

        while (!fila_Masculino.vazia() || !fila_Feminino.vazia())
        {
            if (fila_Feminino.vazia()
                    || (!fila_Masculino.vazia() && fila_Masculino.primeiro.getId() <= fila_Feminino.primeiro.getId()))
            {
                noh = fila_Masculino.primeiro;
                fila_Masculino.primeiro = noh.getProximo();

                if (fila_Masculino.primeiro == null)
                {
                    fila_Masculino.ultimo = null;
                }
            }
            else
            {
                noh = fila_Feminino.primeiro;
                fila_Feminino.primeiro = noh.getProximo();

                if (fila_Feminino.primeiro == null)
                {
                    fila_Feminino.ultimo = null;
                }
            }

            noh.setProximo(null);

            if (fila_Geral.vazia())
            {
                fila_Geral.primeiro = fila_Geral.ultimo = noh;
            }
            else if (noh.getId() <= fila_Geral.primeiro.getId())
            {
                noh.setProximo(fila_Geral.primeiro);
                fila_Geral.primeiro = noh;
            }
            else
            {
                aux = fila_Geral.primeiro;

                while (aux.getProximo() != null && aux.getProximo().getId() < noh.getId())
                {
                    aux = aux.getProximo();
                }

                if (aux.getProximo() == null)
                {
                    aux.setProximo(noh);
                    fila_Geral.ultimo = noh;
                }
                else
                {
                    noh.setProximo(aux.getProximo());
                    aux.setProximo(noh);
                }
            }
        }

        total = fila_Geral.tamanho();
        todos = new Noh[total];

        for (noh = fila_Geral.primeiro; noh != null; noh = noh.getProximo())
        {
            noh.setId(id++);
            todos[i++] = noh;
        }

        fila_Geral.primeiro = fila_Geral.ultimo = null;

        for (i = 0; i < total; i++)
        {
            noh = todos[i];
            noh.setProximo(null);

            if (noh.getSexo() == 1)
            {
                if (fila_Masculino.vazia())
                {
                    fila_Masculino.primeiro = fila_Masculino.ultimo = noh;
                }
                else
                {
                    fila_Masculino.ultimo.setProximo(noh);
                    fila_Masculino.ultimo = noh;
                }
            }
            else
            {
                if (fila_Feminino.vazia())
                {
                    fila_Feminino.primeiro = fila_Feminino.ultimo = noh;
                }
                else
                {
                    fila_Feminino.ultimo.setProximo(noh);
                    fila_Feminino.ultimo = noh;
                }
            }
        }

        for (i = 0; i < total; i++)
        {
            noh = new Noh(todos[i].getId(), todos[i].getNome(), todos[i].getSexo(), null);

            if (fila_Geral.vazia())
            {
                fila_Geral.primeiro = fila_Geral.ultimo = noh;
            }
            else
            {
                fila_Geral.ultimo.setProximo(noh);
                fila_Geral.ultimo = noh;
            }
        }
    }
    
    // Final da prova 2
    
    
    
    
    public static void listar_filas (Lse fila, Lse fila_masculino, Lse fila_feminino, int opc)
    {
        int t1 = fila.tamanho();
        int t2 = fila_masculino.tamanho();
        int t3 = fila_feminino.tamanho();
        
        Noh aux1 = fila.primeiro;
        Noh aux2 = fila_masculino.primeiro;
        Noh aux3 = fila_feminino.primeiro;
        
        int lim, i, flag1, flag2, flag3;

        lim   = 0;
        i     = 0;
        flag1 = 0;
        flag2 = 0;
        flag3 = 0;
        
        lim = t1;
        
        if (t2 > lim)
        {
            lim = t2;
        }
        
        if (t3 > lim)
        {
            lim = t3;
        }
        
        String nomeprox = "";
        String col_vazia = "|                                           |";

        System.out.println("+-------------------------------------------+---+-------------------------------------------+---+-------------------------------------------+");
        System.out.println("| FILA                                      | # | FILA MASCULINO                            | # | FILA FEMININO                             |");
        System.out.println("+-------------------------------------------+---+-------------------------------------------+---+-------------------------------------------+");

        for (i = 1; i <= lim; i++)
        {
            
            if ((i <= t1) && (opc != 7)) 
            {
                if (aux1.getProximo() == null)
                {
                    if (flag1 == 0)
                    {
                        nomeprox = "null";
                        flag1 = 1;
                    }
                    else
                    {
                        nomeprox = "";
                    }
                }
                else
                {
                    nomeprox = aux1.getProximo().getNome();
                }
                
                System.out.format ("| %2d | %2d | %-10s |   %1d  |  %-10s | # ",
                i, aux1.getId(), aux1.getNome(), aux1.getSexo(), nomeprox);

                aux1 =  aux1.getProximo();
            }
            else
            {
                System.out.print (col_vazia + " # ");
            }
            
            
            if ((i <= t2) && (opc != 8))
            {
                if (aux2.getProximo() == null)
                {
                    if (flag2 == 0)
                    {
                        nomeprox = "null";
                        flag2 = 1;
                    }
                    else
                    {
                        nomeprox = "";
                    }
                }
                else
                {
                    nomeprox = aux2.getProximo().getNome();
                }
                
                System.out.format ("| %2d | %2d | %-10s |   %1d  |  %-10s | # ",
                i, aux2.getId(), aux2.getNome(), aux2.getSexo(), nomeprox);

                aux2 =  aux2.getProximo();
            }
            else
            {
                System.out.print (col_vazia + " # ");
            }
            
            if ((i <= t3) && (opc != 8))
            {
                if (aux3.getProximo() == null)
                {
                    if (flag3 == 0)
                    {
                        nomeprox = "null";
                        flag3 = 1;
                    }
                    else
                    {
                        nomeprox = "";
                    }
                }
                else
                {
                    nomeprox = aux3.getProximo().getNome();
                }
                
                System.out.format ("| %2d | %2d | %-10s |   %1d  |  %-10s |",
                i, aux3.getId(), aux3.getNome(), aux3.getSexo(), nomeprox);

                aux3 =  aux3.getProximo();
            }
            else
            {
                System.out.print (col_vazia);
            }
            
            System.out.println();
        
        }

        System.out.println("+-------------------------------------------+---+-------------------------------------------+---+-------------------------------------------+");

    }
    
    public static void main(String[] args)
    {
        Lse fila_Geral     = new Lse();
        Lse fila_Masculino = new Lse();
        Lse fila_Feminino  = new Lse();

        fila_Masculino.inserir_noh(05, "Joao", 1);
        fila_Masculino.inserir_noh(19, "Antonio", 1);
        fila_Masculino.inserir_noh(88, "Elton", 1);
        fila_Masculino.inserir_noh(13, "Sergio", 1);
        fila_Masculino.inserir_noh(17, "Paulo", 1);
        fila_Masculino.inserir_noh(01, "Jose", 1);

        fila_Feminino.inserir_noh(28, "Maria", 2);
        fila_Feminino.inserir_noh(04, "Amanda", 2);
        fila_Feminino.inserir_noh(76, "Carla", 2);
        fila_Feminino.inserir_noh(98, "Lucia", 2);
        fila_Feminino.inserir_noh(10, "Mariana", 2);
        fila_Feminino.inserir_noh(02, "Erica", 2);
        fila_Feminino.inserir_noh(18, "Paula", 2);
        fila_Feminino.inserir_noh(99, "Rosa", 2);

        int    tamanho = 0;
        int    posicao = 0;
        int    conteudo_int = 0;
        String conteudo_str = " ";
        
        int opc = Msg.opcao_principal();

        while (opc != 0)
        {
            switch (opc)
            {
                case 1: // Inserção
                    Msg.limpatela();
                    
                    fila_Geral.inserir_final();
                    
                    Msg.enter();
                    break;

                case 2: // Remoção
                    Msg.limpatela();

                    if (fila_Geral.vazia())
                    {
                        Msg.msg_central ("A fila está vazia, remoção não processada!");
                    }
                    else
                    {
                        fila_Geral.remover_inicio();
                    }
                    Msg.enter();
                    break;

                case 3: // Consulta
                    Msg.limpatela();

                    if (fila_Geral.vazia())
                    {
                        Msg.msg_central ("A fila está vazia, consulta não processada!");
                        Msg.enter();
                    }
                    else
                    {
                        opc = Msg.opcao_consulta();

                        Msg.limpatela();

                        switch (opc)
                        {
                            case 1: // Consulta Geral
                                fila_Geral.consultar_geral();
                                Msg.enter();
                                break;

                            case 2: // Consulta Posição
                                posicao = Msg.solicita_posicao();

                                if (posicao < 1)
                                {
                                    Msg.msg_central ("Consulta nao realizada!");
                                }
                                else
                                {
                                    fila_Geral.consultar_posicao(posicao);
                                }
                                Msg.enter();
                                break;

                            case 3: // Consulta Conteúdo INT
                                conteudo_int = Msg.solicita_conteudo_int();

                                if (conteudo_int == 0)
                                {
                                    Msg.msg_central ("Consulta nao realizada!");
                                }
                                else
                                {
                                    fila_Geral.consultar_conteudo_int(conteudo_int);
                                }
                                Msg.enter();
                                break;

                            case 4: // Consulta Conteúdo STR
                                conteudo_str = Msg.solicita_conteudo_str();

                                if (conteudo_str.isEmpty())
                                {
                                    Msg.msg_central ("Consulta nao realizada!");
                                }
                                else
                                {
                                    fila_Geral.consultar_conteudo_str(conteudo_str);
                                }
                                Msg.enter();
                                break;
        
                            default:
                                Msg.limpatela();
                                Msg.msg_central ("Opção inválida, retornando...");
                                Msg.enter();
                        }
                    }
                    break;

                case 4: // Inicialização
                    Msg.limpatela();

                    if (fila_Geral.vazia())
                    {
                        Msg.msg_central ("A fila está vazia, inicialização não processada!");
                    }
                    else
                    {
                        fila_Geral.inicializar();
                    }
                    Msg.enter();
                    break;

                case 5: // Tamanho da Lista
                    Msg.limpatela();

                    if (fila_Geral.vazia())
                    {
                        Msg.msg_central(">> A lista está vazia.");
                    }
                    else
                    {
                        tamanho = fila_Geral.tamanho();

                        if (tamanho == 0)
                        {
                            Msg.msg_central (">> Aguarde a implementação do cálculo de tamanho!");
                        }
                        else
                        {
                            Msg.msg_central (">> O tamanho da deque é: ["+tamanho+"]\n\n");
                        }
                        
                        tamanho = 0;
                    }
                    
                    Msg.enter();
                    break;

                case 6: // Especial 06
                    
                    Msg.limpatela();
                    Msg.msg_central ("Prova N2");
                    
                    prova_n2(fila_Geral, fila_Masculino, fila_Feminino);

                    listar_filas(fila_Geral, fila_Masculino, fila_Feminino, 0);

                    Msg.enter();
                    
                    break;

                case 7: // Especial 07
                    
                    Msg.limpatela();
                    Msg.msg_central ("Listar todas as filas");

                    listar_filas(fila_Geral, fila_Masculino, fila_Feminino, 7);

                    Msg.enter();
                    break;

                case 8: // Especial 08
                    
                    Msg.limpatela();
                    Msg.msg_central ("Listar todas as filas");

                    listar_filas(fila_Geral, fila_Masculino, fila_Feminino, 8);

                    Msg.enter();
                    break;

                case 9: // Especial 09
                    
                    Msg.limpatela();
                    Msg.msg_central ("Listar todas as filas");

                    listar_filas(fila_Geral, fila_Masculino, fila_Feminino, 9);

                    Msg.enter();
                    break;

                case 0:
                    break;

                default:
                    Msg.limpatela();
                    Msg.msg_central ("Opção inválida, retornando...");
                    Msg.enter();
            }
            
            opc = Msg.opcao_principal();
        }
        Msg.limpatela();

        if (fila_Geral.vazia())
        {
           Msg.msg_central ("O programa encerrou com a fila vazia!");
        }
        else
        {
           Msg.msg_central ("Antes de encerrar, será apresentada a fila na situação atual.");

           listar_filas(fila_Geral, fila_Masculino, fila_Feminino, 0);
        }
    }    
}
