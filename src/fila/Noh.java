/*
 * Projeto.: Lista Simplesmente Ligada
 * Autor...: Professor Dreco
 * Classe..: Noh
 * Objetivo: Criação do nó (elemento) da fila simplesmente encadeada
 */
package fila;

public class Noh
{
    private Integer id;
    private String  nome;
    private Integer sexo;
    private Noh     proximo;

    public Noh()
    {
        this.id = 0;
        this.nome = " ";
        this.sexo = 0;
        this.proximo = null;
    }

    public Noh(Integer id, String nome, Integer sexo, Noh proximo)
    {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.proximo = proximo;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setSexo(Integer sexo)
    {
        this.sexo = sexo;
    }

    public void setProximo(Noh proximo)
    {
        this.proximo = proximo;
    }

    public Integer getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public Integer getSexo()
    {
        return sexo;
    }

    public Noh getProximo()
    {
        return proximo;
    }

    public void mostra_noh(int posicao)
    {
        System.out.println();
        System.out.println("+---------+----------+--------------------------------+------+----------+--------------------------------+");
        System.out.println("| Posicao | Id       | Nome                           | Sexo | Próximo  | Nome do Próximo                |");
        System.out.println("+---------+----------+--------------------------------+------+----------+--------------------------------+");

        if (this.getProximo() == null)
        {
            System.out.format("| %7d | %8d | %-30s |   %1d  |     null | - - - - - - - - - - - - - - -  |",
                    posicao, this.getId(), this.getNome(), this.getSexo());
            System.out.println();
        }
        else
        {
            System.out.format("| %7d | %8d | %-30s |   %1d  | %8d | %-30s |",
                    posicao, this.getId(), this.getNome(), this.getSexo(),
                    this.getProximo().getId(), this.getProximo().getNome());
            System.out.println();
        }

        System.out.println("+---------+----------+--------------------------------+------+----------+--------------------------------+");
    }
}
