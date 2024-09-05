package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        //Ese example-unit es el mismo que el de persistence-unit del xml

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("los engranajes comienzan a girar...");

        try {
            entityManager.getTransaction().begin();

            //Creación de las entidades
                //Categorías
            Categoria cat1 = Categoria.builder()
                    .denominacion("Exóticos").build();
            Categoria cat2 = Categoria.builder()
                    .denominacion("Alimentos").build();
            Categoria cat3 = Categoria.builder()
                    .denominacion("Cocina").build();

                //Artículos
            Articulo articulo1 = Articulo.builder()
                    .cantidad(100)
                    .denominacion("Caparazón de tortuga marítima")
                    .precio(300).build();
            articulo1.getCategorias().add(cat1);
            Articulo articulo2 = Articulo.builder()
                    .cantidad(250)
                    .denominacion("Caviar")
                    .precio(100).build();
            articulo2.getCategorias().add(cat1);
            articulo2.getCategorias().add(cat2);
            Articulo articulo3 = Articulo.builder()
                    .cantidad(70)
                    .denominacion("Juguito Baggio")
                    .precio(20).build();
            articulo3.getCategorias().add(cat2);
            Articulo articulo4 = Articulo.builder()
                    .cantidad(120)
                    .denominacion("Fósforos tres patitos")
                    .precio(10).build();
            articulo4.getCategorias().add(cat3);

                // Domicilios
            Domicilio dom1 = Domicilio.builder()
                    .nombreCalle("Olavarría")
                    .numero(512).build();
            Domicilio dom2 = Domicilio.builder()
                    .nombreCalle("Olavarría")
                    .numero(512).build();

                // Clientes
            Cliente cli1 = Cliente.builder()
                    .dni(40654781)
                    .nombre("Carlos")
                    .apellido("Sainz").build();
            cli1.setDomicilio(dom1);

            Cliente cli2 = Cliente.builder()
                    .dni(28861720)
                    .nombre("Maria Jose")
                    .apellido("Estrada").build();
            cli2.setDomicilio(dom2);

                //Facturas y detalles de facturas
            Factura factura1 = Factura.builder()
                    .fecha("04-09-2024")
                    .total(350)
                    .numero(1)
                    .detalleFactura(DetalleFactura.builder()
                            .cantidad(1)
                            .articulo(articulo1)
                            .subtotal(300).build())
                    .detalleFactura(DetalleFactura.builder()
                            .cantidad(5)
                            .articulo(articulo4)
                            .subtotal(50).build())
                    .build();
            factura1.setCliente(cli1);
            for (DetalleFactura detFac : factura1.getDetalleFactura()){
                detFac.setFactura(factura1);
            }

            Factura factura2 = Factura.builder()
                    .fecha("03-09-2024")
                    .total(540)
                    .numero(2)
                    .detalleFactura(DetalleFactura.builder()
                            .cantidad(12)
                            .articulo(articulo3)
                            .subtotal(240).build())
                    .detalleFactura(DetalleFactura.builder()
                            .cantidad(3)
                            .articulo(articulo2)
                            .subtotal(300).build())
                    .build();
            factura2.setCliente(cli2);
            for (DetalleFactura detFac : factura2.getDetalleFactura()){
                detFac.setFactura(factura2);
            }

            //Persistencia de las entidades
            entityManager.persist(cat1);
            entityManager.persist(cat2);
            entityManager.persist(cat3);
            entityManager.persist(articulo1);
            entityManager.persist(articulo2);
            entityManager.persist(articulo3);
            entityManager.persist(articulo4);
            entityManager.persist(cli1);
            entityManager.persist(cli2);
            entityManager.persist(dom1);
            entityManager.persist(dom2);
            entityManager.persist(factura2);
            entityManager.persist(factura1);

            //Fin transacción
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println("Hubo un error en la persistencia");
            System.out.println("Error: "+ e.getMessage());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
