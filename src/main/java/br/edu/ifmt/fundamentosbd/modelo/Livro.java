package br.edu.ifmt.fundamentosbd.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Livro {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        public String titulo;
        public String isbn;

        @ManyToMany
        @JoinTable(name = "autores_livros", joinColumns = @JoinColumn(name = "livro_id"),
                inverseJoinColumns = @JoinColumn(name = "autor_id"))
        public Set<Autor> autores = new HashSet<>();

        public Livro(){}

        public Livro(String titulo, String isbn) {
                this.titulo = titulo;
                this.isbn = isbn;

        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getIsbn() {
                return isbn;
        }

        public void setIsbn(String isbn) {
                this.isbn = isbn;
        }

        public Set<Autor> getAutores() {
                return autores;
        }

        public void setAutores(Set<Autor> autores) {
                this.autores = autores;


        }

        @Override
        public String toString() {
                return "Livro{" +
                        "id=" + id +
                        ", titulo='" + titulo + '\'' +
                        ", isbn='" + isbn + '\'' +
                        ", autores=" + autores +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Livro livro = (Livro) o;
                return Objects.equals(id, livro.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }


}
