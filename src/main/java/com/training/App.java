package com.training;

import com.training.DAO.*;
import com.training.api.Author;
import com.training.api.Book;
//import com.training.healthChecks.DatabaseHealthCheck;
import com.training.api.BookAuthor;
import com.training.resources.AuthorResource;
import com.training.resources.BookResource;
import com.training.service_layer.ServiceLayer;
import com.training.service_layer.ServiceLayerImpl;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        try {
            new App().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final HibernateBundle<AppConfiguration> hibernate = new HibernateBundle(Author.class, Book.class, BookAuthor.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(Object configuration) {
//            configuration = (AppConfiguration) configuration;
            return ((AppConfiguration) configuration).getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }
    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        AuthorDAO authorDAO = new AuthorDAOJpaImpl(hibernate.getSessionFactory());
        BookDAO bookDAO = new BookDAOJpaImpl(hibernate.getSessionFactory());

        ServiceLayer serviceLayer = new ServiceLayerImpl(authorDAO, bookDAO);

        AuthorResource authorResource = new AuthorResource(serviceLayer);
        BookResource bookResource = new BookResource(serviceLayer);

        environment.jersey().register(authorResource);
        environment.jersey().register(bookResource);
    }
}
