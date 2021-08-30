package br.edu.ifmt.fundamentosbd.Inicializador;

import br.edu.ifmt.fundamentosbd.modelo.Autor;
import br.edu.ifmt.fundamentosbd.modelo.Livro;
import br.edu.ifmt.fundamentosbd.repositorio.AutorRepositorio;
import br.edu.ifmt.fundamentosbd.repositorio.LivroRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializadorDados implements CommandLineRunner {

    private final LivroRepositorio livroRepositorio;
    private final AutorRepositorio autorRepositorio;

    public InicializadorDados(LivroRepositorio livroRepositorio, AutorRepositorio autorRepositorio){
        this.autorRepositorio = autorRepositorio;
        this.livroRepositorio = livroRepositorio;

    }
    @Override
    public void run(String... args) throws Exception {

        // LIVRO 1
        Livro livro1 = new Livro("Mano descobre a liberdade", "9788508147922");
        Autor autor1 = new Autor("Gilberto", "Dimenstein");

        livro1.getAutores().add(autor1);
        autor1.getLivros().add(livro1);

        autorRepositorio.save(autor1);
        livroRepositorio.save(livro1);



        //------------------------------------------------------------------------------------
        // LIVRO 2
        Livro livro2 = new Livro("A revolução dos bichos", "9780151002177");
        Autor autor2 = new Autor("George", "Orwell");

        livro2.getAutores().add(autor2);
        autor2.getLivros().add(livro2);

        autorRepositorio.save(autor2);
        livroRepositorio.save(livro2);




        //------------------------------------------------------------------------------------
        // LIVRO 3
        Livro livro3 = new Livro("A Moreninha", "9788508014729");
        Autor autor3 = new Autor("Joaquim Manoel", "Macedo");

        livro3.getAutores().add(autor3);
        autor3.getLivros().add(livro3);

        autorRepositorio.save(autor3);
        livroRepositorio.save(livro3);



        //------------------------------------------------------------------------------------

        // MOSTRAR LIVROS
        System.out.println("INICIALIZADOR DE DADOS OK");
        System.out.println("Numero de livros " +livroRepositorio.count());


        //--------------------------------------------------------------------------------------




    }
}
