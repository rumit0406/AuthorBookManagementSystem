package com.training;

import com.training.DAO.*;
import com.training.api.Author;
import com.training.resources.AuthorResource;
import com.training.resources.BookResource;
import com.training.service_layer.ServiceLayer;
import com.training.service_layer.ServiceLayerImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        try {
            new App().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        ConnectionUtil connectionUtil = new ConnectionUtil(configuration.getUrl(), configuration.getUsername(),
                configuration.getPassword());

        AuthorDAO authorDAO = new AuthorDAOImpl(connectionUtil);
        BookDAO bookDAO = new BookDAOImpl(connectionUtil);

        ServiceLayer serviceLayer = new ServiceLayerImpl(authorDAO, bookDAO);

        AuthorResource authorResource = new AuthorResource(serviceLayer);
        BookResource bookResource = new BookResource(serviceLayer);

        environment.jersey().register(authorResource);
        environment.jersey().register(bookResource);
    }
}

//complete daoimpl for both author and book, just completed constructors of both
//then do jdbc mysql
//then do hibernate